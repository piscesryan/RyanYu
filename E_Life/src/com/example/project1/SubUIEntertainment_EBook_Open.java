package com.example.project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.services.OpenSdCardDireatoty;
import com.tools.ToolUtils;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SubUIEntertainment_EBook_Open extends Activity {

	private File file;
	private String content;
	private String name;
	private String path;
	private TextView textView_bookContent;
	private TextView textView_bookName;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_entertainment_ebook_opennew);

		Intent get = this.getIntent();
		name = get.getStringExtra("name");
		path = get.getStringExtra("path");

		Log.i("result", name);
		
		//initial
		textView_bookContent = (TextView) this.findViewById(R.id.subui_entertainment_ebook_opennew_bookContent);
		textView_bookName = (TextView) this.findViewById(R.id.subui_entertainment_ebook_opennew_bookName);
		Log.i("result", "getTop="+textView_bookContent.getTop());
		Log.i("result", "getBaseline="+textView_bookContent.getBaseline());
		Log.i("result", "getLineCount="+textView_bookContent.getLineCount());
		//设置每行自动加下划线
		//textView_bookContent.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
		
		//得到电子书内容
		file = new File(path);
		try {
			//FileInputStream fis = new FileInputStream(file);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			content = ToolUtils.changeStreamToString(br);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Toast.makeText(SubUIEntertainment_EBook_Open.this, "打开失败", 1).show();
			e.printStackTrace();
		}
		
		textView_bookName.setText(name);
		textView_bookContent.setText(content);
		//textView_bookContent.getFocusables(1).ge
		textView_bookContent.setOnClickListener(new ClickListener());
	}
	
	private class ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Log.i("result","getBaseline="+v.getBaseline());
			Log.i("result","getBottom="+v.getBottom());
			Log.i("result","getWidth="+v.getWidth());
			Log.i("result","getLineCount="+((TextView) v).getLineCount());
			Log.i("result","getTop="+((TextView) v).getTop());
			 
		}
 

		
	}
}
