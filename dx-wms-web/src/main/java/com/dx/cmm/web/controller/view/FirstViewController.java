package com.dx.cmm.web.controller.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dx.cmm.service.view.FirstViewResult;
import com.dx.cmm.service.view.IMatchViewService;

@Controller("firstViewController")
@RequestMapping("/match/view/first")
public class FirstViewController extends MatchViewController {
	
	/**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(FirstViewController.class);
    
    
//    /**
//     * 下载文件临时目录
//     */
//    @Value("${wms.web.temppath}")
//    private String tempPath = "";
//    
//    /***view/first/report***/
//    private static final String FTL = "/view/first/reportTemplate";
//
//    /***model 数据***/
//    private static final String REPORT = "report";
//    
//    /***压缩文件名称***/
//    private static final String ZIPFILENAME = "匹配协议";
//
//    @Autowired
//    private IMatchViewService<FirstViewResult> firstTransView;

//     @Autowired
//     private PdfFile<FirstViewResult> firstPdfFile;

//    @RequestMapping("/init.json")
//    public String init(String lenderCode, Model model) {
//    	FirstViewResult firstViewResult = firstTransView.query(lenderCode);
//    	firstViewResult.setIsView(true);
//        model.addAttribute(REPORT, firstViewResult);
//        return FTL;
//    }

//    @RequestMapping("/pdf.json")
//    @ResponseBody
//    public Map<String, Object> pdf(HttpServletRequest request,@RequestBody ProcessResultVo processResultVo) throws IOException {
//    	LOG.info("****pdf() processResult={}****", new Gson().toJson(processResultVo.getProcessResult()));
//    	Map<String, Object> result = result();
//        List<String> pdfPaths = new ArrayList<String>();
//        String pdfPath = tempPath + File.separator +"pdfTemp";
//        try {
//        	for(ProcessResultVo process:processResultVo.getProcessResult()){
//        		FirstViewResult firstViewResult = firstTransView.query(process.getLenderCode());
//        		firstViewResult.setProtocolFileName(process.getProtocolFileName());
////        		pdfPaths.add(firstPdfFile.create(firstViewResult,pdfPath));
//        	}
//        	LOG.info("***pdfPaths***",new Gson().toJson(pdfPaths));
//    		ZipFile zipFile = new ZipFile();
//    		//打成zip包
//    		String path = zipFile.getZip(pdfPaths,tempPath,ZIPFILENAME+getDate());
//    		//清空pdfPath文件夹下的所有文件
////    		FileUtils.deleteQuietly(new File(pdfPath));
//    		result.put("path", path);
//        } catch (PdfException e) {
//            error(result, e);
//        }
//        return result;
//    }
//    
//    @RequestMapping("download.json")
//	public void fileDownload(HttpServletRequest request,HttpServletResponse response) {
//		String path = "";
//		try {
//			path = new String(request.getParameter("path").getBytes("ISO8859-1"),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			throw new BaseException("资源路径获取失败");
//		}
//		FileDownLoad downLoad = new FileDownLoad();
//		// 下载
//		downLoad.fileDownload(response, path,ZIPFILENAME);
//		// 下载完成,删除临时文件
////		FileUtils.deleteQuietly(new File(path));
//	}
    
//    private String getDate(){
//    	return DateUtils.format(new Date(),"yyyyMMddHHmmss");
//    }
}
