package com.example.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.services.ContactService;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SubUIContact_Ask extends Activity{

	private TextView tv1;
	private TextView tv2;
	private ListView lv;
	private SimpleAdapter adapter;
	private ItemListener listener;
	private ArrayList<Map<String,Object>> data;
	//
	private String[] from = new String[]{"icon","name"};
	private int[] to = new int[]{R.id.subui_contact_ask_imageview_pic,R.id.subui_contact_ask_textview_name};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_contact_ask);
		
		//initial
		listener = new ItemListener();

		
		lv = (ListView) this.findViewById(R.id.lv_contact_ask);
		data = new ArrayList<Map<String,Object>>();
		
		
		lv.setOnItemClickListener(listener);
		
		HashMap hm = new HashMap();
		hm.put("icon", R.drawable.phone);
		hm.put("name", "电话");
		
		HashMap hm1 = new HashMap();
		hm1.put("icon", R.drawable.message);
		hm1.put("name", "信息");
		
		data.add(hm);
		data.add(hm1);
		
		adapter = new SimpleAdapter(SubUIContact_Ask.this, data, R.layout.item_contact_ask, from, to);
		lv.setAdapter(adapter);

		
	}
	
	private class ItemListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			
			Intent get = SubUIContact_Ask.this.getIntent();
			String number = get.getStringExtra("number");
			
			switch(position){
			case 0:
				Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+number));
				startActivity(intent);
				finish();
				break;
			case 1:
				Intent intent1 = new Intent(SubUIContact_Ask.this,SubUIContact_Ask_Message.class);
				intent1.putExtra("number", number);
				startActivityForResult(intent1, 10);
				finish();
			}
		}
	}
	 
 
}
