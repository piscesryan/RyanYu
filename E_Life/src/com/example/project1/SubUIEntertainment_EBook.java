package com.example.project1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.services.OpenSdCardDireatoty;
import com.services.SdCardService;
import com.services.sqlite.SQLiteService;
import com.tools.ToolUtils;

public class SubUIEntertainment_EBook extends Activity {

	private ClickListener listener;
	private TextView textView_openNew;
	private TextView textView_lastRead;
	private TextView textView_readRecord;
	private HashMap hm;
	private ArrayList bookList = new ArrayList();
	//private ArrayList bookList;
	private Set storeBookList;
	private SimpleDateFormat sdf;
	private SQLiteService sqlService;
	
	
/*	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		sqlService = new SQLiteService(SubUIEntertainment_EBook.this);
		bookList = sqlService.readBookRecods();
		if(bookList==null){
			bookList = new ArrayList();
		}
	}*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_entertainment_ebook);

		//读取数据库
		sqlService = new SQLiteService(SubUIEntertainment_EBook.this);
		bookList = sqlService.readBookRecods();
		if(bookList==null){
			bookList = new ArrayList();
		}
		
		
		// initial
		listener = new ClickListener();
		textView_openNew = (TextView) this
				.findViewById(R.id.subui_entertainment_ebook_openBook);
		textView_lastRead = (TextView) this
				.findViewById(R.id.subui_entertainment_ebook_lastRead);
		textView_readRecord = (TextView) this
				.findViewById(R.id.subui_entertainment_ebook_readRecord);

		textView_openNew.setOnClickListener(listener);
		textView_lastRead.setOnClickListener(listener);
		textView_readRecord.setOnClickListener(listener);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		String type = "";
		
		if(!data.getStringExtra("isChoose").equals("no")){
			type = data.getStringExtra("returnType");
		}

		if ("openNew".equals(type)) {

			 
			String time = ToolUtils.getTimeFromMillSec(System.currentTimeMillis(), "yyyy.MM.dd-HH:mm:ss");

			String absolutePath = data.getStringExtra("absolutePath");
			String name = data.getStringExtra("name");

			// 把书装进bookList里
			hm = new HashMap();
			hm.put("name", name);
			hm.put("time", time);
			bookList.add(hm);

			Intent intent = new Intent(SubUIEntertainment_EBook.this,
					SubUIEntertainment_EBook_Open.class);
			intent.putExtra("path", absolutePath);
			intent.putExtra("name", name);
			startActivity(intent);

		}
	}

	private class ClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.subui_entertainment_ebook_openBook:
				if(SdCardService.isSdCardExist()){
					Intent intent = new Intent(SubUIEntertainment_EBook.this,
							OpenSdCardDireatoty.class);
					intent.putExtra("type", "book");
					intent.putExtra("path", "com.example.project1.SubUIEntertainment_EBook");
					startActivityForResult(intent, 200);
				}else{
					Toast.makeText(SubUIEntertainment_EBook.this, "未检测到Sd卡", 1).show();
				}
				break;
			case R.id.subui_entertainment_ebook_lastRead:

				break;
			case R.id.subui_entertainment_ebook_readRecord:
				Intent intent1 = new Intent(SubUIEntertainment_EBook.this,
						SubUIEntertainment_EBook_ReadRecord.class);
				intent1.putStringArrayListExtra("bookList", bookList);
				startActivity(intent1);
				break;
			}
		}

	}

	
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();Log.i("result", "onStop");
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		if (bookList.size()!=0) {
			sqlService = new SQLiteService(
					SubUIEntertainment_EBook.this);
			sqlService.saveBookRecords(bookList);
		}
	}

}
