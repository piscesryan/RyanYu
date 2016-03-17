package com.example.mydiary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TabHost;

public class Welcome extends Activity {

	private LayoutInflater inflater;
	private View view;
	private RelativeLayout rl_welcome;
	private Animation animation;
	private Animation animation1;
	private Animation animation_in;
	private Animation animation_out;
	private Button button;
	private RelativeLayout rl_main;
	private RadioButton[] radioButton;
	private TabHost th;
	private RadioGroup radioGroup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		boolean isFirst = true;

		SharedPreferences preference = this.getSharedPreferences("isFirst",
				Context.MODE_PRIVATE);
		isFirst = preference.getBoolean("isFirst", true);
		Editor editor = preference.edit();
		

		if (isFirst) {
			firstUse(savedInstanceState);
			editor.putBoolean("isFirst", false);
			editor.commit();
			
		} else {
			Intent intent = new Intent(Welcome.this,MainActivity.class);
			startActivity(intent);
			this.finish();
		}
	}
	
	private void firstUse(Bundle savedInstanceState) {
		// 首次使用，进入欢迎界面
		// 初始化
		inflater = this.getLayoutInflater();
		view = inflater.inflate(R.layout.welcome, null);
		animation = AnimationUtils.loadAnimation(this, R.anim.anim_welcome);
		animation1 = AnimationUtils.loadAnimation(this,
				R.anim.anim_welcome_button_translate_and_rotate);

		super.onCreate(savedInstanceState);
		setContentView(view);
		
		// 首次使用
		rl_welcome = (RelativeLayout) this
				.findViewById(R.id.welcome_relativeLayout_one);
		rl_welcome.setAnimation(animation);
		button = (Button) this.findViewById(R.id.welcome_button_one);
		button.setAnimation(animation1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Welcome.this,MainActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out);
				Welcome.this.finish();
			}
		});
	}
}
