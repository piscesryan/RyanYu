package com.example.project1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import com.tools.ParseXML;
import com.tools.ToolUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubUIWeather extends Activity {

	private Button button_query;
	private EditText editText_city;
	private TextView textView_result;
	private ClickListener listener;
	
	private String city;
	private String city_code;
	private String path;
	
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch(msg.what){
			case 1:
				textView_result.setText(msg.getData().getString("content"));
			}
		}
		
	};

	//--------------------------------------------
	//不可见时调用on什么方法关闭
	//--------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_weather);

		listener = new ClickListener();
		button_query = (Button) this
				.findViewById(R.id.subui_weather_button_query);
		editText_city = (EditText) this
				.findViewById(R.id.subui_weather_editText_city);
		textView_result = (TextView) this
				.findViewById(R.id.subui_weather_textView_result);

		button_query.setOnClickListener(listener);
	}

	private class ClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try {
				switch (v.getId()) {
				case R.id.subui_weather_button_query:
					city = editText_city.getText().toString();
					city_code = URLEncoder.encode(city, "GB2312");
					path = "http://php.weather.sina.com.cn/xml.php?city="
							+ city_code + "&password=DJOYnieT8234jlsK&day=0";
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								URL url = new URL(path);
								HttpURLConnection conn = (HttpURLConnection) url
										.openConnection();
								conn.setReadTimeout(5000);
								conn.setRequestMethod("GET");
								if (conn.getResponseCode() == 200) {
									InputStream is = conn.getInputStream();
									Map<String, String> hm = ParseXML.getWeather(is);
									StringBuilder content = new StringBuilder(); 
									for(Map.Entry<String, String> e:hm.entrySet()){
										String chineseName = ToolUtils.returnSinaWeatherChineseName(e.getKey());
										if(chineseName!=null){
											content.append(chineseName+":"+e.getValue()+"\n");	
										}
									}
									Message msg = new Message();
									msg.what = 1;
									msg.getData().putString("content", content.toString());
									handler.sendMessage(msg);
									
								}
							}catch (Throwable e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}).start();
					break;
				}
			}catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
