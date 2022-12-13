/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: HRFileServiceImpl.java
 * Author:   黄健
 * Date:     2016年1月19日 下午7:03:24
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.hr.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.hr.enums.InfoType;
import com.dx.hr.service.dto.EmployeeEntryDto;
import com.dx.hr.service.dto.EmployeeVideoDto;
import com.dx.hr.service.dto.HandleResultDto;
import com.dx.wms.service.ICommonService;
import com.dx.wms.utils.MapResultUtil;
import com.dx.wms.web.hr.service.IHRFileService;

/**
 * 人事影像管理service
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class HRFileServiceImpl implements IHRFileService {

    @Autowired
    private ICommonService commonService;

    @Override
    public Map<String, Object> upload(Map<String, Object> params) {
        // LOG.info("** upload params={}", params);
        // Assert.notNull("param cannot be null", params);
        // Long userId = (Long) params.get("userId");
        // String orgName = (String) params.get("orgName");
        // Long employeeId = (Long) params.get("employeeId");
        // Assert.notNull("** upload() orgName/userId/employeeId 不能为空", orgName, userId, employeeId);
        // File file = (File) params.get("file");
        // if (null == file || !file.exists() || !file.isFile()) {
        // return MapResultUtil.getMapResult("102", "上传文件不存在");
        // }
        // String password = (String) params.get("password");
        // // 校验上传文件是否符合规则
        // Map<String, Object> uploadRarStatus = FileInspectUtil.inspectFile(file, password);
        // String inspectResult = (String) uploadRarStatus.get(CMSConstants.ACTION_CODE);
        // if (!"201".equals(inspectResult)) { // 校验失败
        // return uploadRarStatus;
        // }
        // @SuppressWarnings("unchecked")
        // List<FileDto> fileDtoes = (List<FileDto>) uploadRarStatus.get(FileInspectUtil.FILEDTOES);
        // FileDto uploadFile = (FileDto) uploadRarStatus.get(FileInspectUtil.UPLOAD_FILE);
        // // 获取解压目标路径
        // String destDirName = FileSavePathUtil.getHrPath(orgName, DEST_PATH);
        // File dir = new File(destDirName);
        // if (!dir.exists() || !dir.isDirectory()) {
        // dir.mkdirs();
        // }
        // Map<String, String> fileSaveNames = new HashMap<String, String>();
        // for (FileDto fileDto : fileDtoes) {
        // fileDto.setSavePath(destDirName);
        // fileDto.setSaveName(UUID.randomUUID().toString());
        // fileSaveNames.put(fileDto.getFullName(), fileDto.getSaveName());
        // }
        // if (AllowFileTypes.checkFileType(AllowFileTypes.RAR_FILE_TYPES, uploadFile.getType())) {
        // // 解压上传的压缩包
        // Map<String, Object> operationStatus = UnzipFileUtil.unrar(file, password, destDirName, fileSaveNames);
        // String resultCode = (String) operationStatus.get(CMSConstants.ACTION_CODE);
        // if (!"101".equals(resultCode)) {
        // return operationStatus;
        // }
        // // 文件格式转换
        // operationStatus = FileConvertUtil.convertFiles(fileDtoes);
        // resultCode = (String) operationStatus.get(CMSConstants.ACTION_CODE);
        // if (!"301".equals(resultCode)) {
        // return operationStatus;
        // }
        // } else {
        // // 上传文件保存名
        // String saveFileName = fileSaveNames.get(uploadFile.getFullName());
        // // 文件复制生成的新文件 路径+新文件名称+文件类型
        // String targetUrl = new StringBuffer().append(destDirName).append(saveFileName).append(CMSConstants.POINT)
        // .append(uploadFile.getType()).toString();
        // // 生成新的影像文件
        // FileMoveUtil.moveFile(file.getPath(), targetUrl);
        // // 影像文件类型转换 文件物理保存
        // Map<String, Object> convertFilesResult = FileConvertUtils.convertFileType(destDirName, saveFileName,
        // uploadFile.getType());
        // String convertKey = (String) convertFilesResult.get(CMSConstants.ACTION_CODE);
        // if (!"301".equals(convertKey)) {
        // // 文件类型转换过程出现错误或异常
        // return convertFilesResult;
        // }
        // }
        // List<EmployeeVideoDto> videoes = new ArrayList<EmployeeVideoDto>();
        // EmployeeVideoDto dto = null;
        // for (FileDto fileDto : fileDtoes) {
        // dto = new EmployeeVideoDto();
        // dto.setSourceFileName(fileDto.getName());
        // dto.setFileType(fileDto.getType());
        // dto.setSaveFileName(fileSaveNames.get(fileDto.getFullName()));
        // dto.setFilePath(StringUtils.remove(destDirName, CMSConstants.HR_FILE_PATH));
        // videoes.add(dto);
        // }
        // EmployeeEntryDto employeeEntryDto = new EmployeeEntryDto();
        // employeeEntryDto.setEmployeeVideoDtos(videoes);
        // employeeEntryDto.setStep(3);// 保存影像件信息
        // employeeEntryDto.setUserId(userId);
        // EmployeeDto employeeDto = new EmployeeDto();
        // employeeDto.setEmployeeId(employeeId);
        // employeeEntryDto.setEmployeeDto(employeeDto);
        // EmployeeEntryResultDTO ret = commonService.saveHrInfo(employeeEntryDto);
        // Assert.notNull("result cannot be null", ret);
        // if (ret.getIsSuccess().compareTo(1) == 0) {// success
        // Map<String, Object> result = MapResultUtil.getMapResult("101", "上传文件成功");
        // result.put("result", query(employeeId));
        // return result;
        // } else {
        // return MapResultUtil.getMapResult("108", ret.getMsg());
        // }
        return null;
    }

    @Override
    public Map<String, Object> delete(Long userId, Long employeeId, Long employeeVideoId) {
        Assert.notNull("conditions miss.", userId, employeeId, employeeVideoId);
        HandleResultDto resultDto = commonService.deleteVideo(employeeVideoId, userId, InfoType.VIDEO.getCode());
        Assert.notNull("result cannot be null", resultDto);
        Map<String, Object> result = MapResultUtil.getMapResult("" + resultDto.getIsSuccess(), resultDto.getMsg());
        result.put("result", query(employeeId));// 所有的影像数据
        return result;
    }

    @Override
    public List<EmployeeVideoDto> query(Long employeeId) {
        Assert.notNull("conditions miss.", employeeId);
        EmployeeEntryDto detail = commonService.queryEmployeeDetailByEmployeeId(employeeId);
        Assert.notNull("EmployeeDetailInfoDto cannot be null", detail);
        return detail.getEmployeeVideoDtos();
    }

}
