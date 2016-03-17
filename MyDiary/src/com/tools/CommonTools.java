package com.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class CommonTools {

	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "MyDiary";
	private static final String TABLE_NAME = "diary";
	private static final String OPERATION_SUCCEED = "�����ɹ�";
	private static final String OPERATION_FAILED = "����ʧ��";

	public static String getCurrentDateAndTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	public static boolean isSdCardExist(Context context) {
		boolean exist = false;
		exist = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);
		if (!exist) {
			Toast.makeText(context, "δ�ҵ�sd��", Toast.LENGTH_LONG).show();
		}
		return exist;
	}
	
	public static String getSdCardRootPath() {
		String path = "";
		
		File rootFile = Environment.getExternalStorageDirectory();
		path = rootFile.getAbsolutePath();
		
		return path;
	}
	
	public static boolean backToSdCard(Context context,String pathFrom,String pathTo){
		
		DatabaseHelper dbHelper = new DatabaseHelper(context, DB_NAME, null, DB_VERSION);

		InputStream is = null;
		OutputStream os = null;
		OutputStream os_txt = null;
		BufferedWriter bw = null;
		
		byte[] buffer = new byte[1024];
		int length = -1;
		boolean flag = false;
		String pathToTxt = "";
		List<HashMap<String,String>> data = dbHelper.showDiaryFromDB();
		
		try {
			
			File file = new File(pathTo);
			if(!file.exists()){
				file.mkdir();
			}
			
			//txt
			pathToTxt = pathTo+"/Diary.txt";			
	//Log.i("infoo", pathToTxt);		
			//���ݿ�
			pathTo = pathTo+"/MyDiary";
	//Log.i("infoo", pathTo);					
			is = new FileInputStream(pathFrom);
			os = new FileOutputStream(pathTo);
			
			bw = new BufferedWriter(new FileWriter(pathToTxt));
			for(int i=0;i<data.size();i++){
				HashMap each = data.get(i);
				
				bw.append("------------------����ʱ��:"+CommonTools.getCurrentDateAndTime()+"------------------"+"\r\n").
				append("����: "+each.get("title")+"\r\n").
				append("����: "+each.get("content")+"\r\n").
				append("ʱ��: "+each.get("time")+"\r\n").
				append("------------------------------------"+"\r\n");
			}
			
			while((length=is.read(buffer))!=-1){
				os.write(buffer, 0, length);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			flag = true;
		}
		return flag;
	}

	public static boolean restoreFromSdCard(Context context, String pathFrom,
			String pathTo) {
		DatabaseHelper dbHelper = new DatabaseHelper(context, DB_NAME, null,
				DB_VERSION);

		InputStream is = null;
		OutputStream os = null;

		byte[] buffer = new byte[1024];
		int length = -1;
		boolean flag = false;

		try {

			is = new FileInputStream(pathFrom);
			os = new FileOutputStream(pathTo);

			while ((length = is.read(buffer)) != -1) {
				os.write(buffer, 0, length);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			flag = true;
		}
		return flag;
	}
	
	public static void showToast(Context context,String info){
		Toast.makeText(context, info, Toast.LENGTH_LONG).show();
	}
}
