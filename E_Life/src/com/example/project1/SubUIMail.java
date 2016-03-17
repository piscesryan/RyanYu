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
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class SubUIMail extends Activity {

	private Button button_query;
	private Spinner spinner_company;
	private EditText editText_number;

	private WebView webView_result;
	private ClickListener listener;
	private SelectedListener s_listener;

	private String[] companyName = new String[] { "德邦", "dhl", "汇通", "联邦",
			"申通", "顺丰", "天天", "ups", "圆通", "韵达", "宅急送", "中通" };

	private ArrayAdapter<String> adapter;
	private String selectedCompany;
	
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch(msg.what){
			case 1:
				webView_result.getSettings().setJavaScriptEnabled(true);
				webView_result.getSettings()
						.setJavaScriptCanOpenWindowsAutomatically(true);
				webView_result.loadUrl(msg.getData().getString("path"));
			}
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_mail);
		
		s_listener = new SelectedListener();
		listener = new ClickListener();
		button_query = (Button) this
				.findViewById(R.id.subui_mail_button_query);
		spinner_company = (Spinner) this
				.findViewById(R.id.subui_mail_spinner_company);
		editText_number = (EditText) this
				.findViewById(R.id.subui_mail_editText_number);
		webView_result = (WebView) this
				.findViewById(R.id.subui_mail_webView_result);

		button_query.setOnClickListener(listener);
		
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,companyName);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_company.setAdapter(adapter);
		spinner_company.setOnItemSelectedListener(s_listener);
		spinner_company.setVisibility(View.VISIBLE);
	}
	
	private class SelectedListener implements OnItemSelectedListener{

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			selectedCompany = companyName[position];
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
		
	}

	private class HelloWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}

	private class ClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try {
				switch (v.getId()) {
				case R.id.subui_mail_button_query:

					new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								String number = editText_number.getText().toString();
								String code = ToolUtils.returnMailCode(selectedCompany);
								
								String path = "http://m.kuaidi100.com/index_all.html?type="+code+"&postid="+number+"#result";
								// String path = "http://www.51cto.com";

								URL url = new URL(path);
								HttpURLConnection conn = (HttpURLConnection) url
										.openConnection();
								conn.setReadTimeout(5000);
								conn.setRequestMethod("GET");
								Log.i("result", conn.getResponseCode() + "");
								if (conn.getResponseCode() == 200) {
									Message msg = new Message();
									msg.what = 1;
									msg.getData().putString("path",path);
									handler.sendMessage(msg);
								}
							}catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}).start();

					break;
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
