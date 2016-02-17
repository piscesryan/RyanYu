package com.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.diary.ConcreteDiary;
import com.domains.Diary;
import com.example.mydiary.R;
import com.tools.DatabaseHelper;

public class FindDiaryResult extends Activity{
	
	private static final String OPERATION_SUCCEED = "操作成功";
	private static final String OPERATION_FAILED = "操作失败";
	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "MyDiary";
	private static final String TABLE_NAME = "diary";
	
	private Intent intent;
	private ListView lv;
	private SimpleAdapter adpater;
	private String[] from;
	private int[] to;
	private List<HashMap<String,String>> data;
	private DatabaseHelper dbHelper;
	private String title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manage_find_result);
		 
		dbHelper = new DatabaseHelper(FindDiaryResult.this, DB_NAME, null, DB_VERSION);
		
		title = this.getIntent().getStringExtra("title");
		
		data = dbHelper.showDiaryFromDB(DB_NAME, null, "title=?", new String[]{title}, null, null, "time desc");
		lv = (ListView) this.findViewById(R.id.manage_find_result_listView);
		from = new String[]{"title","time"};
		to = new int[]{R.id.manage_find_item_textView_title,R.id.manage_find_item_textView_time};
		
		adpater = new SimpleAdapter(FindDiaryResult.this, data, R.layout.manage_find_item, from, to);
		
		lv.setAdapter(adpater);
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			int whichOne = 0;
			android.app.AlertDialog.Builder temp_builder = new AlertDialog.Builder(
					FindDiaryResult.this);
			AlertDialog temp_alertDialog;
			int target_position;

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				target_position = position;

				OnClickListener temp_onclickListener = new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						switch (v.getId()) {

						case R.id.diary_choose_linearlayout_openOrUpdate:
							whichOne = R.id.diary_choose_linearlayout_openOrUpdate;
							Log.i("info", "查看or打开");
							// 查看操作-----------------------------------------
							HashMap temp = data.get(target_position);
							int id_temp = Integer.parseInt(temp.get("id") + "");
							String title_temp = (String) temp.get("title");
							String content_temp = (String) temp.get("content");
							String time_temp = (String) temp.get("time");
							Diary diary = new Diary(id_temp, title_temp,
									content_temp, time_temp);

							Intent intent = new Intent(FindDiaryResult.this,
									ConcreteDiary.class);
							intent.putExtra("obj", diary);

							startActivity(intent);
							// 查看操作-----------------------------------------
							temp_alertDialog.dismiss();
							break;
						case R.id.diary_choose_linearlayout_delete:
							whichOne = R.id.diary_choose_linearlayout_delete;
							Log.i("info", "删除");
							// 删除操作-----------------------------------------
							HashMap temp1 = data.get(target_position);
							int id_temp1 = Integer.parseInt(temp1.get("id")
									+ "");
							String whereClause = "id=?";
							dbHelper = new DatabaseHelper(FindDiaryResult.this,
									DB_NAME, null, DB_VERSION);
							dbHelper.delete(TABLE_NAME, "id=?",
									new String[] { id_temp1 + "" });
							// 删除操作-----------------------------------------
							initialDiary();
							temp_alertDialog.dismiss();
							Toast.makeText(FindDiaryResult.this,
									OPERATION_SUCCEED, Toast.LENGTH_LONG)
									.show();
							break;
						case R.id.diary_choose_linearlayout_back:
							whichOne = R.id.diary_choose_linearlayout_back;
							Log.i("info", "返回");
							temp_alertDialog.dismiss();
							break;
						}
					}
				};

				View temp_view = LayoutInflater.from(FindDiaryResult.this)
						.inflate(R.layout.diary_choose, null);
				LinearLayout temp_ll_open = (LinearLayout) temp_view
						.findViewById(R.id.diary_choose_linearlayout_openOrUpdate);
				LinearLayout temp_ll_delete = (LinearLayout) temp_view
						.findViewById(R.id.diary_choose_linearlayout_delete);
				LinearLayout temp_ll_back = (LinearLayout) temp_view
						.findViewById(R.id.diary_choose_linearlayout_back);

				temp_ll_open.setOnClickListener(temp_onclickListener);
				temp_ll_delete.setOnClickListener(temp_onclickListener);
				temp_ll_back.setOnClickListener(temp_onclickListener);

				temp_builder.setTitle("您想做什么");
				temp_builder.setView(temp_view);

				temp_alertDialog = temp_builder.show();

			}
		});

	}
	
	public void initialDiary() {

		lv = (ListView) this.findViewById(R.id.manage_find_result_listView);
		data = new ArrayList<HashMap<String, String>>();
//只要查指定名字的即可
 		dbHelper = new DatabaseHelper(FindDiaryResult.this, DB_NAME, null,
				DB_VERSION);
		data = dbHelper.showDiaryFromDB(DB_NAME, null, "title=?", new String[]{title}, null, null, "time desc");

		from = new String[] { "title", "time" };
		to = new int[]{R.id.manage_find_item_textView_title,R.id.manage_find_item_textView_time};
 
		SimpleAdapter adpater1 = new SimpleAdapter(FindDiaryResult.this, data, R.layout.manage_find_item, from, to);
		

		lv = (ListView) this.findViewById(R.id.manage_find_result_listView);
		lv.setAdapter(adpater1);

		lv.setOnItemClickListener(new OnItemClickListener() {
			int whichOne = 0;
			android.app.AlertDialog.Builder temp_builder = new AlertDialog.Builder(
					FindDiaryResult.this);
			AlertDialog temp_alertDialog;
			int target_position;

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				target_position = position;

				OnClickListener temp_onclickListener = new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						switch (v.getId()) {

						case R.id.diary_choose_linearlayout_openOrUpdate:
							whichOne = R.id.diary_choose_linearlayout_openOrUpdate;
							Log.i("info", "查看or打开");
							// 查看操作-----------------------------------------
							HashMap temp = data.get(target_position);
							int id_temp = Integer.parseInt(temp.get("id") + "");
							String title_temp = (String) temp.get("title");
							String content_temp = (String) temp.get("content");
							String time_temp = (String) temp.get("time");
							Diary diary = new Diary(id_temp, title_temp,
									content_temp, time_temp);

							Intent intent = new Intent(FindDiaryResult.this,
									ConcreteDiary.class);
							intent.putExtra("obj", diary);

							startActivity(intent);
							// 查看操作-----------------------------------------
							temp_alertDialog.dismiss();
							break;
						case R.id.diary_choose_linearlayout_delete:
							whichOne = R.id.diary_choose_linearlayout_delete;
							Log.i("info", "删除");
							// 删除操作-----------------------------------------
							HashMap temp1 = data.get(target_position);
							int id_temp1 = Integer.parseInt(temp1.get("id")
									+ "");
							String whereClause = "id=?";
							dbHelper = new DatabaseHelper(FindDiaryResult.this,
									DB_NAME, null, DB_VERSION);
							dbHelper.delete(TABLE_NAME, "id=?",
									new String[] { id_temp1 + "" });
							// 删除操作-----------------------------------------
							initialDiary();
							temp_alertDialog.dismiss();
							Toast.makeText(FindDiaryResult.this,
									OPERATION_SUCCEED, Toast.LENGTH_LONG)
									.show();
							break;
						case R.id.diary_choose_linearlayout_back:
							whichOne = R.id.diary_choose_linearlayout_back;
							Log.i("info", "返回");
							temp_alertDialog.dismiss();
							break;
						}
					}
				};

				View temp_view = LayoutInflater.from(FindDiaryResult.this)
						.inflate(R.layout.diary_choose, null);
				LinearLayout temp_ll_open = (LinearLayout) temp_view
						.findViewById(R.id.diary_choose_linearlayout_openOrUpdate);
				LinearLayout temp_ll_delete = (LinearLayout) temp_view
						.findViewById(R.id.diary_choose_linearlayout_delete);
				LinearLayout temp_ll_back = (LinearLayout) temp_view
						.findViewById(R.id.diary_choose_linearlayout_back);

				temp_ll_open.setOnClickListener(temp_onclickListener);
				temp_ll_delete.setOnClickListener(temp_onclickListener);
				temp_ll_back.setOnClickListener(temp_onclickListener);

				temp_builder.setTitle("您想做什么");
				temp_builder.setView(temp_view);

				temp_alertDialog = temp_builder.show();

			}
		});

	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		initialDiary();
	}
	
	public void buttonBack(View view){
		this.finish();
	}
}
