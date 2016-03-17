package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class SubUIInfo_AboutApp extends Activity {

	private TextView textView_appinfo;
	private TextView textView_author;
	private TextView textView_checkNew;
	private TextView textView_feedBack;
	private ClickListener listener_click;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subuiinfo_aboutapp);
	
		listener_click = new ClickListener();
		
		textView_appinfo = (TextView) this.findViewById(R.id.subuiinfo_aboutapp_textView_appInfo);
		textView_author = (TextView) this.findViewById(R.id.subuiinfo_aboutapp_textView_author);
		textView_checkNew = (TextView) this.findViewById(R.id.subuiinfo_aboutapp_textView_checkNew);
		textView_feedBack = (TextView) this.findViewById(R.id.subuiinfo_aboutapp_textview_feedback);
		
		textView_appinfo.setOnClickListener(listener_click);
		textView_author.setOnClickListener(listener_click);
		textView_checkNew.setOnClickListener(listener_click);
		textView_feedBack.setOnClickListener(listener_click);
		
	}

	private class ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.subuiinfo_aboutapp_textView_appInfo:
				Intent intent1 = new Intent(SubUIInfo_AboutApp.this,SubUIInfo_AboutApp_AppInfo.class);
				startActivity(intent1);
				break;
			case R.id.subuiinfo_aboutapp_textView_author:
				Intent intent2 = new Intent(SubUIInfo_AboutApp.this,SubUIInfo_AboutApp_Author.class);
				startActivity(intent2);
				break;
			case R.id.subuiinfo_aboutapp_textView_checkNew:
				Toast.makeText(SubUIInfo_AboutApp.this,"当前已是最新版本", 1).show();
				break;
			case R.id.subuiinfo_aboutapp_textview_feedback:
				Intent intent = new Intent(SubUIInfo_AboutApp.this,SubUIAboutApp_Feedback.class);
				startActivity(intent);
				break;
			}
		}
		
	}
}
