package com.example.project1;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class UIMain extends TabActivity{

	private ClickListener listener;
	private LinearLayout linearLayout_contact;
	private LinearLayout linearLayout_weatherReport;
	private LinearLayout linearLayout_compass;
	private LinearLayout linearLayout_numberAdd;
	private LinearLayout linearLayout_mail;
	private LinearLayout linearLayout_entertainment;
	private LinearLayout linearLayout_aboutMe;
	private LinearLayout linearLayout_aboutApp;
	private TextView textView_feedback;
	private TabHost _tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_ui);
		
		//initial
		listener = new ClickListener();
		linearLayout_contact = (LinearLayout) this.findViewById(R.id.linearlayout_contact);
		linearLayout_weatherReport = (LinearLayout) this.findViewById(R.id.linearlayout_weatherReport);
		linearLayout_compass = (LinearLayout) this.findViewById(R.id.linearlayout_compass);
		linearLayout_numberAdd = (LinearLayout) this.findViewById(R.id.linearLayout_numberAdd);
		linearLayout_mail = (LinearLayout) this.findViewById(R.id.linearlayout_mail);
		linearLayout_entertainment = (LinearLayout) this.findViewById(R.id.linearlayout_entertainment);
		/*linearLayout_aboutMe = (LinearLayout) this.findViewById(R.id.linearlayout_aboutMe);
		linearLayout_aboutApp = (LinearLayout) this.findViewById(R.id.linearlayout_aboutApp);
		textView_feedback = (TextView)this.findViewById(R.id.textView_feedback);*/
		
		//register listener
		linearLayout_contact.setOnClickListener(listener);
		linearLayout_weatherReport.setOnClickListener(listener);
		linearLayout_compass.setOnClickListener(listener);
		linearLayout_numberAdd.setOnClickListener(listener);
		linearLayout_mail.setOnClickListener(listener);
		linearLayout_entertainment.setOnClickListener(listener);
		//linearLayout_aboutMe.setOnClickListener(listener);
		//linearLayout_aboutApp.setOnClickListener(listener);
		//textView_feedback.setOnClickListener(listener);
		
		_tabHost = getTabHost();
		AddTabPage1();       
        AddTabPage2();      
       
	}
	
	private void AddTabPage1() {
        // TODO Auto-generated method stub
        
        Intent internt1 = new Intent();
        internt1.setClass(this,SubUIInfo_AboutMe.class);
        
        TabSpec tabSpec = _tabHost.newTabSpec("act1");
       
        //指定选项卡的显示名称
        tabSpec.setIndicator("随手记");
        //指定跳转方向
        tabSpec.setContent(internt1);
        _tabHost.addTab(tabSpec);
    }
    
    private void AddTabPage2() {
        // TODO Auto-generated method stub
        
        Intent internt1 = new Intent();
        internt1.setClass(this,SubUIInfo_AboutApp.class);
        
        TabSpec tabSpec = _tabHost.newTabSpec("act2");
        tabSpec.setIndicator("产品");
        tabSpec.setContent(internt1);          
        _tabHost.addTab(tabSpec);
    }


	private final class ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.linearlayout_contact:
				
				break;
			case R.id.linearlayout_weatherReport:
				Intent intent3 = new Intent(UIMain.this,SubUIWeather.class);
				startActivity(intent3);
				break;
			case R.id.linearlayout_compass:
				Intent intent6 = new Intent(UIMain.this,SubUICompass.class);
				startActivity(intent6);
				break;
			case R.id.linearLayout_numberAdd:
				Intent intent2 = new Intent(UIMain.this,SubUINumberAdd.class);
				startActivity(intent2);
				break;
			case R.id.linearlayout_mail:
				Intent intent4 = new Intent(UIMain.this,SubUIMail.class);
				startActivity(intent4);
				break;
			case R.id.linearlayout_entertainment:
				Intent intent = new Intent(UIMain.this,SubUIEntertainment.class);
				startActivity(intent);
				break;
			/*case R.id.linearlayout_aboutMe:
				break;
			case R.id.linearlayout_aboutApp:
				break;
			case R.id.textView_feedback:
				Intent intent1 = new Intent(UIMain.this,SubUIAboutApp_Feedback.class);
				startActivity(intent1);*/
			}
 
			 
		}
 
		
	}
	
}
