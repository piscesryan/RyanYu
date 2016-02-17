package com.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ToolUtils {

	public static String changeToUTF(String content){
		
		String result = "";
		
		try {
			result = new String(content.getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static String getListItemName(String name){
		String[] result = name.split("\\.");
		return result[0];
	}
	
	public static String getItemName(String contentName){
		
		String result = "";
		
		if("gzdt".equals(contentName)){
			result = "工作动态";
		}else if("sjxw".equals(contentName)){
			result = "审计新闻";
		}else if("gzzz".equals(contentName)){
			result = "工作职责";
		}else if("fgzd_gjfg".equals(contentName)){
			result = "法规制度_国家法规";
		}else if("fgzd_zjfg".equals(contentName)){
			result = "法规制度_浙江法规";
		}else if("fgzd_xxzd".equals(contentName)){
			result = "法规制度_学校制度";
		}else if("sjcx".equals(contentName)){
			result = "审计程序";
		}else if("sjgk".equals(contentName)){
			result = "审计公开";
		}else if("sjtg".equals(contentName)){
			result = "审计通告";
		}else if("nsyd".equals(contentName)){
			result = "内审园地";
		}else{
			result = "表格下载";
		}
		return result;
	}
	
	public static String readFromTxt(String path){
		
		FileReader fr = null;
		char[] buffer = new char[1024];
		int length = -1;
		StringBuilder sb = new StringBuilder();
		
		try {
			fr = new FileReader(path);
			while((length=fr.read(buffer))!=-1){
				sb.append(new String(buffer,0,length));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	public static boolean writeToLocal(String content,String path){
		
		boolean flag = false;
		BufferedWriter br = null;
		String fileContent = ""; 
		
		try {
			if(new File(path).exists()){
				fileContent = readFromTxt(path);
			}
			br = new BufferedWriter(new OutputStreamWriter(                        
                    new FileOutputStream(path)));
			br.write(content+fileContent);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static String changeStringToChinese(String name){
		String result = "";
		try {
			result = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static String getDownloadFileName(String content){
		String[] splict = content.split("\\.");
		String fileName = "";
		if(splict[0].length()>9){
			fileName = splict[0].substring(0, 8);
			fileName+="··";
		}else{
			fileName = splict[0];
		}
		return fileName;
	}
	
	public static String getHomeItemName(String content){
		String fileName = "";
		if(content.length()>21){
			fileName = content.substring(0, 20);
			fileName+="··";
		}else{
			fileName = content;
		}
		return fileName;
	}
	
	public static String  changeTextToHtml(String content){
		String str1 = content.replace(" ", "&nbsp;");
		String result = str1.replace("\r", "<br>");
		return result;
	}
	
	public static void downloadFiles(InputStream is,OutputStream os){
		try {
			
			byte[] buffer = new byte[1024];
			int length = 0;
			
			while((length=is.read(buffer))!=-1){
				os.write(buffer, 0, length);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("下载时可忽略的异常");
		}finally{
			 
			try {
				os.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList getInvertedArrayList(ArrayList al){
		
		ArrayList result = new ArrayList();
		
		for(int i=al.size()-1;i>=0;i--){
			result.add(al.get(i));
		}
		
		return result;
	}
}
