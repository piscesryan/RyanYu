package com.example.project1;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class SubUIEntertainment_EBook_ReadRecord extends Activity {

	private TextView textView_readTime;
	private TextView textView_bookName;
	private SimpleAdapter adapter;
	private String[] from;
	private int[] to;
	private List data;
	private ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_entertainment_ebook_readrecord);

		from = new String[]{"name","time"};
		to = new int[]{R.id.subui_entertainment_ebook_readrecord_bookName,R.id.subui_entertainment_ebook_readrecord_readTime};
		
		Intent get = this.getIntent();
		data = get.getStringArrayListExtra("bookList");
		
/*		for(int i=0;i<data.size();i++){
			
			HashMap hm = (HashMap) data.get(i);
			
			Iterator iterator = hm.keySet().iterator();
			while(iterator.hasNext()){
				String name = (String) iterator.next();
				Log.i("result", name+" : "+hm.get(name).toString());
			}
		}*/
		lv = (ListView) this.findViewById(R.id.subui_entertainment_ebook_rearRecord_lv);
		adapter = new SimpleAdapter(SubUIEntertainment_EBook_ReadRecord.this, data, R.layout.item_readrecord, from, to);
		lv.setAdapter(adapter);
	}
	
	private class ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 
			 
		}
		
	}
}
