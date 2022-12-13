package com.dx.cmm.test.task;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.common.collect.Lists;

public class HttpClientSB {



	public static void main(String[] args){
		 String url = "https://www.juxinli.com/api/access_social_insurance_raw_data";
		    //JSONObject jsonResult = null;
		 HttpResponse response = null;
		 DefaultHttpClient client = new DefaultHttpClient();   
		 List<NameValuePair> params = Lists.newArrayList();  
		 params.add(new BasicNameValuePair("client_secret", "b4c4cebe0a0e4ceba57ff02179dc0f33"));
		 params.add(new BasicNameValuePair("access_token", "039ab45f25464243a34e4e37808039d8"));
		 params.add(new BasicNameValuePair("token", "d8637da320744588a32ef7bc10086ce5"));
		 String str = "";
		 try {  
			str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8)); 	
		    //发送get请求      
		    HttpGet request = new HttpGet(url+"?"+str);      
		    request.setHeader("Content-type", "application/x-www-form-urlencoded");
		    
		    response = client.execute(request);       
		    /**请求发送成功，并得到响应**/     
		    if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {        
		    /**读取服务器返回过来的json字符串数据**/       
		    String strResult = EntityUtils.toString(response.getEntity());        
		    /**把json字符串转换成json对象**/       
		    System.out.println("-----------"+strResult);
		    url = URLDecoder.decode(url, "UTF-8");      
			} else {            
			    
			    }    
	    } catch (IOException e) {      
		    	e.printStackTrace();
	    }
	}




}
