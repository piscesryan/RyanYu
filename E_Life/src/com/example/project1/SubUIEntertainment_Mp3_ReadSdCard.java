package com.example.project1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.tools.ToolUtils;

public class SubUIEntertainment_Mp3_ReadSdCard extends Activity {

	private ListView lv;
	private TextView tv1;
	private TextView tv2;
	private SimpleAdapter adapter;
	private File root;
	private File file;
	private File currentFile;
	private File[] currentFiles;
	private ItemListener listener;

	String[] from = new String[] { "name", "time", "icon" };
	int[] to = new int[] { R.id.tv1, R.id.tv2, R.id.image };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_entertainment_mp3_readsdcard);

		listener = new ItemListener();

		lv = (ListView) this.findViewById(R.id.lv1);
		lv.setOnItemClickListener(listener);

		file = new File("/mnt/sdcard");
		root = file;
		currentFiles = file.listFiles();
		fillListView(currentFiles);

	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if (KeyEvent.KEYCODE_BACK == event.getKeyCode()) {
			Log.i("result", keyCode + "");
			try {
				if (!currentFile.getCanonicalPath().equals("/mnt/sdcard")) {
					currentFile = currentFile.getParentFile();
					fillListView(currentFile.listFiles());
					currentFiles = currentFile.listFiles();
				}
				/*****************************************************************************
				 * 这里返回到主界面，不知道怎么返回*********************************************
				 *****************************************************************************/
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Log.i("result", e.toString());
				e.printStackTrace();
			}

		}
		return super.onKeyDown(keyCode, event);
	}

	public void fillListView(File[] files) {

		String[] from = new String[] { "name", "time", "icon" };
		int[] to = new int[] { R.id.tv1, R.id.tv2, R.id.image };

		List<LinkedHashMap<String, Object>> data = new ArrayList<LinkedHashMap<String, Object>>();
		for (int i = 0; i < files.length; i++) {
			LinkedHashMap hm = new LinkedHashMap<String, Object>();
			hm.put("name", files[i].getName());
			hm.put("time",
					ToolUtils.getTimeFromMillSec(files[i].lastModified(),"yyyy.MM.dd-hh:mm:ss"));
			if (files[i].isDirectory()) {
				hm.put("icon", R.drawable.folder);
			} else {
				hm.put("icon", R.drawable.file);
			}
			data.add(hm);
		}

		adapter = new SimpleAdapter(SubUIEntertainment_Mp3_ReadSdCard.this, data, R.layout.item_sdcard,
				from, to);
		lv.setAdapter(adapter);
	}

	private class ItemListener implements OnItemClickListener {

		HashMap hm = new HashMap();
		String absolutePath = "";
		String name = "";

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub

			currentFile = currentFiles[position];
			if (currentFile.isDirectory()) {
				fillListView(currentFile.listFiles());
				currentFiles = currentFile.listFiles();
			} else if (currentFile.isFile()) {
				absolutePath = currentFiles[position].getAbsolutePath();
				name = currentFiles[position].getName();
				String result = name.substring(name.length()-4, name.length());
				if(".mp3".equals(result)){
					//hm.put("absolutePath", absolutePath);
					//hm.put("name", name);
					Intent intent = new Intent(SubUIEntertainment_Mp3_ReadSdCard.this,SubUIEntertainment_Mp3.class);
					intent.putExtra("absolutePath", absolutePath);
					intent.putExtra("name", name);
					//intent.putExtra("name", name);
					//startActivity(intent);
					setResult(100, intent);
					SubUIEntertainment_Mp3_ReadSdCard.this.finish();
				}else{
					Toast.makeText(SubUIEntertainment_Mp3_ReadSdCard.this, "类型错误", 1).show();
				}
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
