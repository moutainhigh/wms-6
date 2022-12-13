/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: LtpaTokenUtil.java
 * Author:   v_leihong
 * Date:     2013年11月19日 上午10:59:05
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dx.common.constant.UtilsConstant;
import com.dx.common.fileUpload.utils.FileUtil;
import com.dx.common.utils.CertificateCoder;

/**
 * token工具类<br>
 * 生成token以及对token进行校验
 * 
 * @author v_leihong
 */
@Service
public class LtpaTokenUtil {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LtpaTokenUtil.class);

    /**
     * charset
     */
    private static final String CHARSET = "Cp850";

    /**
     * 过期时间
     */
    @Value("${wms.sso.key.tokendurationMinutes}")
    private int durationMinutes;

    /**
     * password
     */
    @Value("${wms.sso.key.password}")
    private String password;

    /**
     * key alias
     */
    @Value("${wms.sso.key.alias}")
    private String alias;

    /**
     * key store path
     */
    @Value("${wms.sso.key.keyStorePath}")
    private String keyStorePath;

    /**
     * key address
     */
    @Value("${wms.sso.key.tokenKeyPath}")
    private String keyAddress;

    /**
     * 
     * 功能描述:get key
     * 
     * @return key string
     */
    private String getKey() {

        byte[] content = FileUtil.getContent(keyAddress);

        String secretKey = new String(CertificateCoder.decryptByPrivateKey(content, keyStorePath, alias, password));

        return secretKey;
    }

    /**
     * 
     * 
     * 根据用户名生成token
     * 
     * @param userid user id
     * @param ip ip address
     * @param createTime create time
     * @return token string
     * @see
     * @since 1.0
     */
    public String createToken(String userid, String ip, GregorianCalendar createTime) {

        String tokenVersion = "0123";
        String userInfo = userid; // = + ip
        byte[] version = tokenVersion.getBytes();

        String creationStr = Integer.toHexString((int) (createTime.getTimeInMillis() / UtilsConstant.THOUSAND));

        byte[] creation = creationStr.getBytes();

        // 获得过期时间，过期时间=当前时间+到期时间(分钟)
        GregorianCalendar expirationDate = (GregorianCalendar) createTime.clone();
        expirationDate.add(Calendar.MINUTE, durationMinutes);

        String expirationStr = Integer.toHexString((int) (expirationDate.getTimeInMillis() / UtilsConstant.THOUSAND));

        byte[] expiration = expirationStr.getBytes();

        byte[] userInfoByte = userInfo.getBytes();

        byte[] secretByte = getKey().getBytes();

        byte[] workingBuffer = new byte[UtilsConstant.PRE_USER_LENGTH + userInfoByte.length + secretByte.length];

        System.arraycopy(version, 0, workingBuffer, 0, version.length);
        System.arraycopy(creation, 0, workingBuffer, version.length, creation.length);
        System.arraycopy(expiration, 0, workingBuffer, version.length + creation.length, expiration.length);
        System.arraycopy(userInfoByte, 0, workingBuffer, UtilsConstant.PRE_USER_LENGTH, userInfoByte.length);
        System.arraycopy(secretByte, 0, workingBuffer, UtilsConstant.PRE_USER_LENGTH + userInfoByte.length,
                secretByte.length);

        // 进行 SHA-1 校验和

        MessageDigest md = null;

        try {

            md = MessageDigest.getInstance("SHA-1");

            md.reset();

        } catch (NoSuchAlgorithmException e) {

            LOGGER.info("Message digest exception", e);
        }

        byte[] hash = null;
        if (md != null) {
            hash = md.digest(workingBuffer);
        }
        byte[] outputBuffer = null;
        if (hash != null) {
            outputBuffer = new byte[UtilsConstant.PRE_USER_LENGTH + userInfoByte.length + hash.length];

            System.arraycopy(workingBuffer, 0, outputBuffer, 0, UtilsConstant.PRE_USER_LENGTH + userInfoByte.length);
            System.arraycopy(hash, 0, outputBuffer, UtilsConstant.PRE_USER_LENGTH + userInfoByte.length, hash.length);
        }
        return new String(Base64.encodeBase64URLSafe(outputBuffer));

    }

    /**
     * 
     * 功能描述: validate token
     * 
     * @param token token string
     * @param ip ip address
     * @return userid if token valid else null
     */
    public String validateToken(String token, String ip) {

        boolean result = true;
        byte[] ltpa = Base64.decodeBase64(token.getBytes());
        byte[] sha = new byte[UtilsConstant.PRE_USER_LENGTH];

        int userInfoLength = ltpa.length - UtilsConstant.PRE_LENGTH;
        byte[] header = new byte[UtilsConstant.FOUR];
        byte[] creation = new byte[UtilsConstant.EIGHT];
        byte[] expires = new byte[UtilsConstant.EIGHT];
        byte[] userInfo = new byte[userInfoLength];

        ByteArrayInputStream stream = new ByteArrayInputStream(ltpa);

        // 读取版本号

        stream.read(header, 0, UtilsConstant.FOUR);

        if (header[0] != '0' || header[1] != '1' || header[2] != '2' || header[UtilsConstant.INDEX_THR] != '3') {
            result = false;
        }
        // 读取开始时间
        stream.read(creation, 0, UtilsConstant.EIGHT);

        // 读取到期时间
        stream.read(expires, 0, UtilsConstant.EIGHT);
        // 校验到期时间,过期时间小于当前时间,则过期
        String expiresStr = new String(expires);
        int ex = Integer.valueOf(expiresStr, UtilsConstant.HEX);
        int now = (int) ((new GregorianCalendar()).getTimeInMillis()) / UtilsConstant.THOUSAND;
        if (ex < now) {
            // 过期
            result = false;
        }
        // 读取用户信息
        stream.read(userInfo, 0, userInfoLength);
        char[] characters = new char[userInfoLength];

        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new ByteArrayInputStream(userInfo), CHARSET);
            isr.read(characters);
        } catch (UnsupportedEncodingException e1) {
            LOGGER.info("validite token unsupportedcodingException", e1);
        } catch (IOException e) {
            LOGGER.info("validite token ioexception", e);
        }

        String userid = new String(characters);

        if (!result) {
            return null;
        }
        // 读取SHA校验和
        stream.read(sha, 0, UtilsConstant.PRE_USER_LENGTH);

        // 创建LTPA Token
        ByteArrayOutputStream ostream = new ByteArrayOutputStream();

        try {
            // Token版本号
            ostream.write(header);
            // 创建时间
            ostream.write(creation);
            // 过期时间
            ostream.write(expires);
            // user
            ostream.write(userInfo);
            //
            ostream.write(getKey().getBytes());
            ostream.close();
        } catch (IOException e) {
            LOGGER.info("validite token ostream ioexception", e);
        }

        // 进行 SHA-1 校验和
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            md.reset();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.info("validite token occur nosuch algorithm exception", e);
        }

        byte[] digest = null;
        boolean valid = false;
        if (md != null) {
            digest = md.digest(ostream.toByteArray());
            valid = MessageDigest.isEqual(digest, sha);
        }

        if (valid) {
            return userid;
        } else {
            return null;
        }

    }

}
