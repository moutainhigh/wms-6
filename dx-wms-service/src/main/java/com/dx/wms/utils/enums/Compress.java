package com.dx.wms.utils.enums;

import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 压缩类型
 *
 * @author zhuyiwei 
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum Compress {
	
	RAR(1,".rar"),
	
	ZIP(2,".zip");
	
	
	private Compress(Integer code, String info) {
		this.code = code;
		this.info = info;
	}

	private Integer code;
	
	private String info;

	public Integer getCode() {
		return code;
	}

	public String getInfo() {
		return info;
	}
	
	public static Compress getEunm(Integer code){
        if (!Assert.checkParam(code)) {
            throw new BaseException("not found code");
        }
        for(Compress type : Compress.values()){
            if(type.getCode() == code){
                return type;
            }
        }
        throw new BaseException("not found code");
    }
    
    public static String getInfo(Integer code){
    	return getEunm(code).getInfo();
    }
	
}
