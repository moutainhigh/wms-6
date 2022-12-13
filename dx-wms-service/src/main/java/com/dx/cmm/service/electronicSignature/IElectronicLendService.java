package com.dx.cmm.service.electronicSignature;



public interface IElectronicLendService {
	
    /**
     * 
     * 功能描述:电子签章 <br>
     * 〈功能详细描述〉
     *
     * @param protocolFileName 文件名
     * @param path 生成pdf文件路径
     * @return String 生成签章pdf文件的路径
     */
    String generateElectronicLend(String protocolFileName,String path);

}
