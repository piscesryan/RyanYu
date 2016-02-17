package com.example.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.services.ContactService;
import com.tools.ToolUtils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
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

public class SubUIContact extends Activity{

	private ListView lv;
	private ImageView imageView_zimu;
	private ImageButton imageButton_phone;
	private ImageButton imageButton_message;
	private TextView textView_name;
	private TextView textView_phone;
	private LinkedHashMap<String,String> hm;
	private List<Map<String,Object>> data;
	private SimpleAdapter adapter;
	private ArrayList phoneNumber;
	int times = 0;
	private ItemListener listener;
	
	private String[] from = new String[]{"icon","name","number"};
	private int[] to = new int[]{R.id.subui_contact_imageview_zimu,R.id.subui_contact_textview_name,R.id.subui_contact_textview_number};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_contact);
		
		//initial
		listener = new ItemListener();
		phoneNumber = new ArrayList();
		//imageButton_message = (ImageButton) this.findViewById(R.id.subui_contact_imagebutton_message);
		//imageButton_phone = (ImageButton) this.findViewById(R.id.subui_contact_imagebutton_phone);
		lv = (ListView) this.findViewById(R.id.lv_contact);
		data = new ArrayList<Map<String,Object>>();
		/*adapter = new SimpleAdapter(SubUIContact.this, data, R.layout.item_contact, from, to);
		lv.setAdapter(adapter);*/
		lv.setOnItemClickListener(listener);
		
		
		hm = ContactService.getContacts(this);
		for(Map.Entry<String, String> m: hm.entrySet()){
			HashMap each = new HashMap();
			each.put("name",m.getKey().toString());
			each.put("number",m.getValue().toString());
			each.put("icon", ContactService.returnIconIdByFirstName(ToolUtils.getCharByFirstName(m.getKey())));
			data.add(each);
	
			phoneNumber.add(times, m.getValue());
			times++;
		}
		//Log.i("result", data.size()+"---");
		data = ContactService.getSortedContacts(data);
		adapter = new SimpleAdapter(SubUIContact.this, data, R.layout.item_contact, from, to);
		lv.setAdapter(adapter);
	}
	
	private class ItemListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(SubUIContact.this,SubUIContact_Ask.class);
			intent.putExtra("number", phoneNumber.get(position)+"");
			startActivityForResult(intent, 200);
		}
	}
	 
 
}
