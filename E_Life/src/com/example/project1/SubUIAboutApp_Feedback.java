package com.example.project1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubUIAboutApp_Feedback extends Activity {

	private EditText editText_content;
	private Button button_submit;
	private Button button_back;
	private ClickListener listener;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
			case 1:
				if (msg.getData().getInt("responseCode") == 200) {
					Toast.makeText(SubUIAboutApp_Feedback.this, "提交成功", 1)
							.show();
				} else {
					Toast.makeText(SubUIAboutApp_Feedback.this, "提交失败,请检查网络", 1)
							.show();
				}
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_aboutapp_feedback);

		listener = new ClickListener();
		editText_content = (EditText) this
				.findViewById(R.id.subui_aboutapp_editText_content);
		button_submit = (Button) this
				.findViewById(R.id.subui_aboutapp_button_submit);
		button_back = (Button) this
				.findViewById(R.id.subui_aboutapp_button_return);
		button_submit.setOnClickListener(listener);
		button_back.setOnClickListener(listener);
	}

	private class ClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try {
				switch (v.getId()) {
				case R.id.subui_aboutapp_button_submit:

					new Thread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								String content = editText_content.getText()
										.toString();
								content = "content=" + content;

								String path = "http://192.168.56.1:8080/Android_ELife/infoDeal.do";

								URL url = new URL(path);
								HttpURLConnection conn = (HttpURLConnection) url
										.openConnection();
								conn.setReadTimeout(5 * 1000);
								conn.setRequestMethod("POST");
								conn.setRequestProperty("Content-Type",
										"application/x-www-form-urlencoded");
								conn.setRequestProperty(
										"Content-Length",
										String.valueOf(content.getBytes().length));
								conn.setDoOutput(true);

								OutputStream ops = conn.getOutputStream();
								ops.write(content.getBytes());

								Message msg = new Message();
								msg.what = 1;
								msg.getData().putInt("responseCode",
										conn.getResponseCode());
								handler.sendMessage(msg);
								/*
								 * if(conn.getResponseCode()==200){
								 * Toast.makeText(SubUIAboutApp_Feedback.this,
								 * "提交成功", 1).show(); }else{
								 * Toast.makeText(SubUIAboutApp_Feedback.this,
								 * "提交失败", 1).show(); }
								 */
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}).start();

					break;
				case R.id.subui_aboutapp_button_return:
					Intent intent = new Intent(SubUIAboutApp_Feedback.this,
							UIMain.class);
					startActivity(intent);
					finish();
					break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
