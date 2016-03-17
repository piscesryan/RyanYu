package com.example.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class SubUIEntertainment extends Activity{

	private ListView lv;
	private SimpleAdapter adapter;
	private String[] from = {"pic","name"};
	private int[] to = {R.id.item_entertainment_imageView,R.id.item_entertainment_textView};
	private List<HashMap<String,Object>> data;
	private int[] picId = {R.drawable.mp3,R.drawable.mp4,R.drawable.ebook};
	private String[] name = {"mp3","mp4","ebook"};
	private ItemClickListener listener;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_entertainment);
		
		listener = new ItemClickListener();
		lv = (ListView) this.findViewById(R.id.subui_entertainment_listView);
		data = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<3;i++){
			HashMap hm = new HashMap();
			hm.put("pic", picId[i]);
			hm.put("name", name[i]);
			data.add(hm);
		}
		adapter = new SimpleAdapter(SubUIEntertainment.this, data, R.layout.item_entertainment, from, to);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(listener);
	}

	private class ItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			switch(position){
			case 0:
				Intent intent = new Intent(SubUIEntertainment.this,SubUIEntertainment_Mp3.class);
				startActivity(intent);
				finish();
				break;
			case 1:
				Intent intent2 = new Intent(SubUIEntertainment.this,SubUIEntertainment_Mp4.class);
				startActivity(intent2);
				finish();
				break;
			case 2:
				Intent intent1 = new Intent(SubUIEntertainment.this,SubUIEntertainment_EBook.class);
				startActivity(intent1);
				finish();
				break;
			
			}
		}
		
	}

	
}
