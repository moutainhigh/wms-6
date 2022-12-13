/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ContentsManageController.java
 * Author:   黄健
 * Date:     2015年7月19日 下午2:03:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.dx.ccs.service.IAMService;
import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.UserVo;
import com.dx.cms.constant.CMSConstants;
import com.dx.cms.dto.Condition;
import com.dx.cms.dto.ContentDto;
import com.dx.cms.dto.FileQueryDto;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.dto.FileValidationDto;
import com.dx.cms.dto.FolderResultDto;
import com.dx.cms.enums.ResKey;
import com.dx.cms.exception.FileException;
import com.dx.cms.service.IFileService;
import com.dx.cms.web.vo.ConditionsVo;
import com.dx.cms.web.vo.FileVo;
import com.dx.cms.web.vo.FolderVo;
import com.dx.common.service.utils.Assert;
import com.dx.common.utils.JavaEnvUtil;
import com.dx.wms.utils.FileInspectUtil;
import com.dx.wms.utils.UploadUtil;
import com.google.gson.Gson;

/**
 * 影像管理controller
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/contentManage")
public class ContentsManageController {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(ContentsManageController.class);

    @Value("${wms.web.destPath}")
    private String destPath = "";

    /**
     * 文件上传导入的临时目录
     */
    @Value("${wms.web.temppath}")
    private String tempPath = "";

    /**
     * RAR解压缩密码
     */
    @Value("${wms.web.rarpwd}")
    private String rarPwd = "";

    @Value("${wms.file.ipAddress}")
    private String ipAdress = "";

    private static final String CODE = "code";

    private static final String MSG = "msg";

    private static final String CM_ACTION = "cmAction";

    @Autowired
    private IFileService fileService;

    /**
     * 权限服务
     */
    @Autowired
    private IAMService amService;

    @RequestMapping(value = "/list.htm")
    public String initPage(ModelMap model, HttpServletRequest request) {
        return "/contents/file_show";
    }

    /**
     * 功能描述: 上传文件<br>
     *
     * @param file 上传文件
     * @param resKey 资源标示
     * @param appCode 系统编码
     * @param userUniqueId 用户编号
     * @param cmAction 用户操作标志
     * @param fianCode 用户理财序号
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "upload.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> fileUpload(@RequestParam("file") CommonsMultipartFile file,
            @RequestParam("resKey") String resKey, @RequestParam("appCode") String appCode,
            @RequestParam("userUniqueId") Long userUniqueId, @RequestParam("cmAction") String cmAction,
            @RequestParam("lenderUniqueId") Long lenderUniqueId, @RequestParam("lenderCode") String lenderCode,
            @RequestParam("lenderCustCode") String lenderCustCode, HttpServletRequest request) {
        // 上传文件基本信息
        LOG.info("**start**ContentsManageController**fileUpload()");
        LOG.info("fileUpload() file name={}/type={}/size={}", file.getName(), file.getContentType(), file.getSize());
        LOG.info(
                "fileUpload() param OriginalFilename={}/resKey={}/appCode={}/userUniqueId={}/lenderUniqueId={}/cmAction={}",
                file.getOriginalFilename(), resKey, appCode, userUniqueId, lenderUniqueId, cmAction);
        Map<String, Object> result = new HashMap<String, Object>();

        HttpSession session = (HttpSession) request.getSession();
        UserVo user = (UserVo) session.getAttribute("user");
        OrgVo orgVo = amService.queryOrgByUserId(user.getUserId());

        // 文件大小不能超过20兆
        if (file.getSize() > 20971520) {
            result.put(CODE, false);
            result.put(MSG, "您上传的文件过大,请重新选择");
            return result;
        }

        File rarFile = null;
        try {
            // 临时目录
            File dir = new File(tempPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            CommonsMultipartResolver mutilpartResolver = new CommonsMultipartResolver(
                    request.getSession().getServletContext());
            if (mutilpartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                Iterator<String> it = multiRequest.getFileNames();
                while (it.hasNext()) {
                    MultipartFile fileDetail = multiRequest.getFile(it.next());
                    if (fileDetail != null) {
                        String path = tempPath + fileDetail.getOriginalFilename();
                        rarFile = new File(path);
                        file.transferTo(rarFile);

                        Map<String, Object> paramMap = new HashMap<String, Object>();
                        paramMap.put(CM_ACTION, cmAction);
                        FileQueryDto fileQueryDto = new FileQueryDto();
                        fileQueryDto.setAppCode(appCode);
                        fileQueryDto.setDestPath(destPath);
                        fileQueryDto.setResKey(resKey);
                        // 压缩包解压密码
                        fileQueryDto.setIsWin(isWindow());
                        fileQueryDto.setTempPath(fileDetail.getOriginalFilename());
                        fileQueryDto.setPassword(rarPwd);
                        fileQueryDto.setFile(rarFile);
                        fileQueryDto.setLenderCustId(userUniqueId);
                        fileQueryDto.setLenderId(lenderUniqueId);
                        fileQueryDto.setOrgName(orgVo.getOrgId() + CMSConstants.EMPTY_STRING);
                        fileQueryDto.setUserId(user.getUserId());
                        if (Assert.checkParam(userUniqueId)) {
                            fileQueryDto.setLenderCustCode(lenderCustCode);
                        }
                        if (Assert.checkParam(lenderUniqueId)) {
                            fileQueryDto.setLenderCode(lenderCode);
                        }
                        // 校验上传文件是否符合规则
                        FileValidationDto fileValidationDto = FileInspectUtil.inspectFile(rarFile, rarPwd,
                                fileDetail.getOriginalFilename());
                        if (!"201".equals(fileValidationDto.getActionCode())) { // 校验失败
                            result.put(CODE, false);
                            result.put(MSG, "上传文件出现异常,上传失败");
                        }
                        fileQueryDto.setFileValidationDto(fileValidationDto);
                        LOG.info("***fileQueryDto** param={}", new Gson().toJson(fileQueryDto));
                        ContentDto contentDto = fileService.uploadFiles(fileQueryDto);
                        LOG.info("***fileQueryDto** contentDto={}", new Gson().toJson(contentDto));
                        if (Assert.equals(contentDto.getFileValidationDto().getActionCode(), "201")) {
                            String uploadcode = UploadUtil.uploadAction(contentDto);
                            LOG.info("***fileQueryDto** uploadcode={}", uploadcode);
                            if (Assert.equals("101", uploadcode)) {
                                LOG.info("***FileInsert**  contentDto={}", new Gson().toJson(contentDto));
                                contentDto.getFileValidationDto().setActionCode(fileService.FileInsert(contentDto));
                            } else {
                                contentDto.getFileValidationDto().setActionCode(uploadcode);
                            }
                        }
                        if (StringUtils.isBlank(contentDto.getFileValidationDto().getActionCode())) {
                            result.put(CODE, false);
                            result.put(MSG, "上传文件出现异常,上传失败");
                        } else {
                            if (Assert.equals("101", contentDto.getFileValidationDto().getActionCode())) {
                                result.put(CODE, true);
                                result.put(MSG, "上传文件成功");
                            } else if (Assert.equals("109", contentDto.getFileValidationDto().getActionCode())) {
                                result.put(CODE, false);
                                result.put(MSG, "上传重复文件,请先检查并删除重复文件,再上传");
                            } else if (Assert.equals("110", contentDto.getFileValidationDto().getActionCode())) {
                                result.put(CODE, false);
                                result.put(MSG, "压缩包中存在重复文件,请先检查压缩包文件,再上传");
                            } else if (Assert.equals("105", contentDto.getFileValidationDto().getActionCode())) {
                                result.put(CODE, false);
                                result.put(MSG, "请遵循影像文件命名规则，重新上传文件");
                            } else {
                                result.put(CODE, false);
                                result.put(MSG, "上传文件失败");
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rarFile != null) {
                rarFile.delete();
            }
        }
        LOG.info("**end**ContentsManageController**fileUpload() result={}", result);
        return result;
    }

    /**
     * 页面加载文件夹
     *
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "getFolders.json")
    @ResponseBody
    public List<FolderVo> queryFolders(@RequestBody ConditionsVo conditions, HttpServletRequest request) {
        LOG.info("**start**ContentsManageController**queryFolders()");
        if (null == conditions || null == conditions.getResKey()) {
            return new ArrayList<FolderVo>();
        }
        Condition condition = parse(conditions);
        List<FolderVo> resList = new ArrayList<FolderVo>();
        if (Assert.checkParam(condition.getCustAccountId())
                && !Assert.checkParam(condition.getLenderCustCode())) {
            condition.setLenderCustCode(conditions.getLenderCustCode());
        }
        if (Assert.checkParam(condition.getLenderApplyId()) && !Assert.checkParam(condition.getLenderCode())) {
            condition.setLenderCode(conditions.getLenderCode());
        }
        LOG.info("***queryFolders conditions={} ****", new Gson().toJson(condition));
        List<FolderResultDto> result = fileService.queryFolders(condition);

        if (Assert.checkParam(result)) {
            FolderVo vo = null;
            for (FolderResultDto dto : result) {
                vo = new FolderVo();
                vo.setFolderCode(dto.getFileDirKey());
                vo.setFolderName(dto.getFileDirName());
                vo.setIsEdit(dto.getIsEdit() + CMSConstants.EMPTY_STRING);
                vo.setFileDirId(dto.getFileDirId() + CMSConstants.EMPTY_STRING);
                if (null == dto.getFileNumber()) {
                    vo.setSunFileNumber("0");
                } else {
                    vo.setSunFileNumber(dto.getFileNumber() + CMSConstants.EMPTY_STRING);
                }
                resList.add(vo);
            }
        }
        LOG.info("**end**ContentsManageController**queryFolders()");
        return resList;
    }

    private Condition parse(ConditionsVo vo) {
        Condition dto = new Condition();
        BeanUtils.copyProperties(vo, dto);
        dto.setRes(ResKey.get(vo.getResKey()));
        return dto;
    }

    /**
     * 展开文件夹，查询文件夹的文件
     *
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "queryFiles.json")
    @ResponseBody
    public List<FileVo> queryFiles(@RequestBody ConditionsVo conditionVo, HttpServletRequest request) {
        if (!Assert.checkParam(conditionVo)) {
            return new ArrayList<FileVo>();
        }
        Condition dto = parse(conditionVo);
        LOG.info("***queryFiles****  conditions={}", new Gson().toJson(dto));
        List<FileResultDto> result = fileService.folderContain(dto);
        List<FileVo> resList = new ArrayList<FileVo>();
        for (int i = 0; i < result.size(); i++) {
            FileVo vo = new FileVo(result.get(i), destPath);
            vo.setFileNum(String.valueOf(result.size()));
            resList.add(vo);
        }
        return resList;
    }

    /**
     * 删除文件
     *
     * @param request
     * @return true -- 删除成功 false -- 删除失败
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "deleteFiles.json")
    @ResponseBody
    public boolean deleteFiles(@RequestBody ConditionsVo conditions, HttpServletRequest request) {
        LOG.info("**start**ContentsManageController**deleteFiles()");
        if (null == conditions) {
            return false;
        }
        Condition conditionsDto = new Condition();
        BeanUtils.copyProperties(conditions, conditionsDto);

        HttpSession session = (HttpSession) request.getSession();
        UserVo user = (UserVo) session.getAttribute("user");

        if (!Assert.checkParam(conditionsDto.getFileId()) || StringUtils.isBlank(conditionsDto.getCmAction())
                || !Assert.checkParam(conditionsDto.getFileDirId())
                || StringUtils.isBlank(conditionsDto.getAppCode())) {
            LOG.info("**end**ContentsManageController**deleteFiles()**false");
            return false;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("conditionsDto", conditionsDto);
        paramMap.put("userId", user.getUserId());// 当前登陆用户
        try {
            LOG.info("****deleteFiles()***  param={}", new Gson().toJson(conditionsDto));
            fileService.delete(conditionsDto, user.getUserId());
        } catch (FileException e) {
            return false;
        }
        LOG.info("**end**ContentsManageController**deleteFiles()**true");
        return true;
    }

    @RequestMapping(value = "makeFilesEffective.json")
    @ResponseBody
    public boolean makeFilesEffective(@RequestBody ConditionsVo conditions, HttpServletRequest request) {
        LOG.info("**start**ContentsManageController**makeFilesEffective() conditions={}",
                new Gson().toJson(conditions));

        if (null == conditions) {
            return false;
        }
        Condition conditionsDto = new Condition();
        BeanUtils.copyProperties(conditions, conditionsDto);

        HttpSession session = (HttpSession) request.getSession();
        UserVo user = (UserVo) session.getAttribute("user");

        Boolean flag = fileService.effectiveFiles(conditionsDto, user.getUserId());
        if (!flag) {
            LOG.info("**end**ContentsManageController**makeFilesEffective()**false");
            return false;
        }

        LOG.info("**end**ContentsManageController**makeFilesEffective()**true");
        return true;
    }

    /**
     * 判断当前系统是否是Windows
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Boolean isWindow() {
        return StringUtils.startsWith(JavaEnvUtil.getEnvOsVersion(), "Windows");
    }

}
