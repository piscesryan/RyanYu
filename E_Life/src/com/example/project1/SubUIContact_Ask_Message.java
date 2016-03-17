package com.example.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

 
import com.services.ContactService;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SubUIContact_Ask_Message extends Activity{
	
	private EditText editText_content;
	private EditText editText_number;
	private Button button_submit;
	private Button button_back;
	private ClickListener listener;
	private String number;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_contact_ask_message);
		
		listener = new ClickListener();
		editText_number = (EditText) this
				.findViewById(R.id.subui_contact_ask_message_editText_number);
		editText_content = (EditText) this
				.findViewById(R.id.subui_contact_ask_message_editText_content);
		button_submit = (Button) this
				.findViewById(R.id.subui_contact_ask_message_button_submit);
		button_back = (Button) this
				.findViewById(R.id.subui_contact_ask_message_button_return);
		button_submit.setOnClickListener(listener);
		button_back.setOnClickListener(listener);
		
		Intent get = this.getIntent();
		number = get.getStringExtra("number");
		editText_number.setText(number);
	}

	 private final class ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.subui_contact_ask_message_button_submit:
				SmsManager sms = SmsManager.getDefault();
				String content = editText_content.getText().toString();
				ArrayList<String> contents = sms.divideMessage(content);
				for(String text :contents){
					sms.sendTextMessage(editText_number.getText().toString(), null, text, null, null);
				}
				break;
			case R.id.subui_contact_ask_message_button_return:
				Intent intent = new Intent(SubUIContact_Ask_Message.this,SubUIContact.class);
				startActivity(intent);
				finish();
				break;
			}
		}
		 
	 }
 
}
