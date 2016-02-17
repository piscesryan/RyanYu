package com.example.project1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.tools.ToolUtils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubUINumberAdd extends Activity {

	private static final int SET_RESULT = 1;
	private EditText editText_number;
	private Button button_submit;
	//private Button button_back;
	private TextView textView_type;
	private TextView textView_number;
	private TextView textView_from;
	private TextView textView_result;
	private ClickListener listener;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);

			switch (msg.what) {
			case SET_RESULT:
				String from = msg.getData().getString("from");
				String mobile_number = msg.getData().getString("mobile_number");
				String type = msg.getData().getString("type");
Log.i("result", from+":"+mobile_number+":"+type);
				textView_from.setText(from);
				textView_number.setText(mobile_number+"");
				textView_type.setText(type);

				textView_from.setTextColor(Color.BLACK);
				textView_number.setTextColor(Color.BLACK);
				textView_type.setTextColor(Color.BLACK);
				//textView_result.setText(Color.BLACK);
				break;
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_numberadd);

		editText_number = (EditText) this
				.findViewById(R.id.subui_numberadd_editText_number);
		button_submit = (Button) this
				.findViewById(R.id.subui_numberadd_button_query);
		/*button_back = (Button) this
				.findViewById(R.id.subui_numberadd_button_back);*/
		textView_type = (TextView) this
				.findViewById(R.id.subui_numberAdd_textView_type);
		textView_number = (TextView) this
				.findViewById(R.id.subui_numberAdd_textView_number);
		textView_from = (TextView) this
				.findViewById(R.id.subui_numberAdd_textView_from);
		textView_result = (TextView) SubUINumberAdd.this
				.findViewById(R.id.subui_numberAdd_textView_getresult);
		listener = new ClickListener();

		//button_back.setOnClickListener(listener);
		button_submit.setOnClickListener(listener);
	}

	private class ClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try {
				switch (v.getId()) {
				case R.id.subui_numberadd_button_query:

					new Thread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								String number = editText_number.getText()
										.toString();
								String path = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo?mobileCode="
										+ number + "&userID=";
								URL url = new URL(path);
								HttpURLConnection conn = (HttpURLConnection) url
										.openConnection();
								conn.setRequestMethod("GET");
								conn.setReadTimeout(5 * 1000);

								if (conn.getResponseCode() == 200) {
									InputStream is = conn.getInputStream();
									String result = com.tools.ParseXML
											.getNumberInfo1(is);
									// System.out.println(ParseXML.changeStreamToString(is));
									String[] each = ToolUtils
											.splitStringByCharacter(result, " ");
									String[] each1 = ToolUtils
											.splitStringByCharacter(each[0],
													"£∫");
									String mobile_number = each1[0];
									String from = each1[1] + " " + each[1];
									String type = each[2];

									Message msg = new Message();
									msg.what = SET_RESULT;
									msg.getData().putString("mobile_number",
											mobile_number+"");
									msg.getData().putString("from", from);
									msg.getData().putString("type", type);
									handler.sendMessage(msg);
								} else {
									/*Toast.makeText(SubUINumberAdd.this,
											"«ÎºÏ≤ÈÕ¯¬Á", 1).show();*/
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								Log.i("result", e.toString());
								/*Toast.makeText(SubUINumberAdd.this, "≥ˆ¥Ì¡À£¨«Î÷ÿ ‘",
										1).show();*/
							}
						}
					}).start();

					break;
				/*case R.id.subui_numberadd_button_back:
					Intent intent1 = new Intent(SubUINumberAdd.this,
							UIMain.class);
					startActivity(intent1);
					finish();
					break;*/
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
