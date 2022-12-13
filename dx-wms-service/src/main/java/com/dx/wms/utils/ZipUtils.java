package com.dx.wms.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.common.service.utils.Assert;
import com.dx.wms.utils.enums.Compress;
import com.dx.wms.utils.exection.ConvertException;
import com.google.gson.Gson;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 压缩指定的文件
 *
 * @author zhuyiwei
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ZipUtils {

	private static final Logger LOG = LoggerFactory.getLogger(ZipUtils.class);

	/**
	 * zip文件路径
	 */
	private static String zipPath = "";
	
	/*
	 * 缓冲数组
	 */
	private static byte[] BUFS = new byte[1024 * 10];
	
	/*
	 * 缓冲区数组
	 */
	private static byte[] BUF = new byte[1024 * 80];
	
	/**
	 * @param sourcePath 资源路径集合(支持文件夹和单文件)
	 * @param compressPath 压缩目录地址
	 * @param fileName	压缩文件名	
	 * @param compreeType 压缩类型
	 * @return
	 * @throws ConvertException
	 */
	private static  String compress(List<String> sourcePath, String compressPath,
			String fileName, Integer compreeType) throws ConvertException{
		Assert.notNull("**compress() sourcePath compressPath fileName or compreeType is can not be null",
				sourcePath, compressPath, fileName, compreeType);
		LOG.info("**compress() sourcePath={},compressPath={},fileName={},compreeType={}",
				sourcePath, compressPath, fileName, compreeType.toString());
		checkParam(sourcePath,compressPath,fileName,compreeType);
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ZipOutputStream zos = null;
		zipPath = getPath(compressPath,fileName,compreeType);
		LOG.info("**compress() zipPath={}", zipPath);
		File zipFile = new File(zipPath);
		 if (zipFile.exists()) {
			 return zipPath;
		 }
		try {
			fos = new FileOutputStream(zipFile);
		} catch (FileNotFoundException e) {
			LOG.error("流初始化异常",e);
			throw new ConvertException("2","流初始化异常",e);
		}
		bos = new BufferedOutputStream(fos);
		zos = new ZipOutputStream(bos);
		//设置输出编码为系统编码
		zos.setEncoding(System.getProperty("sun.jnu.encoding"));
		execute(sourcePath,zos);
		CommUtils.close("2",zos);
		return zipPath;
	}
	
	
	private static void execute(List<String> sourcePath,ZipOutputStream zos)throws ConvertException{
		for(String source : sourcePath){
			File sourceFile = new File(source);
			if(sourceFile.isFile()){
				zips(zos, sourceFile, "");
			}else{
				directory(zos, sourceFile,sourceFile.getName()+File.separator);
			}
		}
	}
	
	
	//拼接zip文件路径
	private static  String getPath(String compressPath,
			String fileName, Integer compreeType){
		return compressPath + File.separatorChar + fileName+ Compress.getInfo(compreeType);
	}
	
	/*
	 * 检查文件夹路径是否存在,不存在则创建
	 */
	private static void checkDir(String filePath) {
		File file = new File(filePath);
		checkDir(file);
	}

	private static void checkDir(File file) {
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	private static void checkFile(File file) throws ConvertException {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				LOG.error("解压处理失败",e);
				throw new ConvertException("4", "解压处理失败",e);
			}
		}
	}
	
	private static void checkType(String fileName, Compress compress)
			throws ConvertException {
		File file = new File(fileName);
		if (!file.exists()) {
			throw new ConvertException("4", "待解压文件不存在");
		}
		if (!fileName.toLowerCase().endsWith(compress.getInfo())) {
			throw new ConvertException("4", "不支持的解压类型");
		}
	}
	
	/*
	 * 检测源文件是否存在,压缩文件生成路径是否存存在
	 */
	private static  void checkParam(List<String> sourcePath, String compressPath,
			String fileName, Integer compreeType) throws ConvertException{
		for (String string : sourcePath) {
			if(!new File(string).exists()){
				throw new ConvertException("2","预压缩文件或文件夹不存在");
			}
		}
		checkDir(compressPath);
	}

	/**
	 * 
	 * @param zos zip输出流
	 * @param sourceFile 需要处理的文件夹对象
	 * @param path 对应的相对zip文件下的路径
	 * @throws ConvertException
	 */
	private static  void directory(ZipOutputStream zos, File sourceFile,
			String path) throws ConvertException{
			File[] sourceFiles = sourceFile.listFiles();
			if (sourceFiles.length > 0) {
				for (File file : sourceFiles) {
					if (file.isDirectory()) {
						directory(zos, file, path + file.getName() + File.separator);
					} else {
						zips(zos, file, path);
					}
				}
			} else {
				ZipEntry ze = new ZipEntry(path);
				// ze.setUnixMode(755);
				try {
					zos.putNextEntry(ze);
				} catch (IOException e) {
					LOG.error("流定位异常",e);
					CommUtils.exection(zipPath,"2", "流定位异常",e);
				}
			}
	}
	
	/**
	 * @param zos zip输出流
	 * @param file 需写入zip的文件对象
	 * @param path	对应的相对zip文件下的路径
	 * @throws ConvertException
	 */
	private static  void zips(ZipOutputStream zos, File file, String path) throws ConvertException{
		ZipEntry zipEntry = new ZipEntry(path + file.getName());
		// zipEntry.setUnixMode(644);
		try {
			zos.putNextEntry(zipEntry);
		} catch (IOException e) {
			LOG.error("流定位异常",e);
			CommUtils.exection(zipPath,"2", "流定位异常",e);
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			LOG.error("流初始化异常",e);
			CommUtils.exection(zipPath,"2","流初始化异常",e);
		}
		BufferedInputStream bis = new BufferedInputStream(fis,BUF.length);
		int read = 0;
		try {
			while ((read = bis.read(BUFS, 0, BUFS.length)) != -1) {
				zos.write(BUFS, 0, read);
			}
		} catch (IOException e) {
			LOG.error("写入进程异常",e);
			CommUtils.exection(zipPath,"2","写入进程异常",e);
		}
		CommUtils.close("2",bis);
	}
	
	/**
	 * 
	 * 功能描述: <br>
	 * 		传入指定的压缩包路径,和指定的解压地址,解压成功返回解压地址(只能解压此工具打包的压缩包,其他可能有乱码问题)
	 *		<Apache zip>
	 * @param zipFileName zip源地址
	 * @param unzipDir 解压地址
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@SuppressWarnings("resource")
	public static String unZip(String zipFileName, String unzipDir)
			throws ConvertException {
		try {
			checkType(zipFileName, Compress.ZIP);
			checkDir(unzipDir);
			// 获得zip文件,设置编码(根据系统编码决定)
			ZipFile zipFile = new ZipFile(zipFileName,
					System.getProperty("sun.jnu.encoding"));
			Enumeration<ZipEntry> e = zipFile.getEntries();
			ZipEntry zipEntry = null;
			while (e.hasMoreElements()) {
				zipEntry = e.nextElement();
				BufferedOutputStream bos = process(unzipDir,
						zipEntry.getName(), zipEntry.isDirectory());
				if (bos != null) {
					InputStream in = zipFile.getInputStream(zipEntry);
					int index = 0;
					while ((index = in.read(BUFS, 0, BUFS.length)) != -1) {
						bos.write(BUFS, 0, index);
					}
					bos.flush();
					CommUtils.close("2",in, bos);
				}
			}
		} catch (Exception ex) {
			LOG.error("解压文件失败",ex);
			throw new ConvertException("4", "解压文件失败",ex);
		}
		return unzipDir;
	}
	
	private static BufferedOutputStream process(String dirPath,
			String fileName, Boolean isDir) throws ConvertException {
		try {
			File file = new File(dirPath + File.separator + fileName);
			if (isDir) {
				checkDir(file);
				return null;
			}
			checkFile(file);
			checkDir(file.getParentFile());
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(file),BUF.length);
			return bos;
		} catch (Exception e) {
			LOG.error("解压处理失败",e);
			throw new ConvertException("4", "解压处理失败",e);
		}
	}
	
	
	/**
	 * 
	 * 功能描述: <br>
	 *		传入待压缩的文件路径集合,在指定路径下,生成指定文件名的指定压缩类型的压缩包
	 *
	 * @param urls 资源路径集合(支持文件夹和单文件)
	 * @param compressPath 压缩目录地址
	 * @param fileName 压缩文件名
	 * @param CompreeType 压缩类型 (1-rar/2-zip)
	 * @return
	 * @throws ConvertException
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public static String zip(List<String> urls, String compressPath,
			String fileName, Integer CompreeType) throws ConvertException{
		return compress(urls, compressPath, fileName,CompreeType);
	}
	
	/**
	 * 
	 * 功能描述: <br>
	 *		传入待压缩的文件路径集合,在指定路径下,生成指定文件名的zip压缩包
	 *
	 * @param urls 资源路径集合(支持文件夹和单文件)
	 * @param compressPath 压缩目录地址
	 * @param fileName 压缩文件名
	 * @return
	 * @throws ConvertException
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public static String zip(List<String> urls, String compressPath,String fileName) throws ConvertException{
		LOG.info("getZip() fileName={},urls={}", fileName,
				 new Gson().toJson(urls));
		return zip(urls, compressPath, fileName, 2);
	}
}
