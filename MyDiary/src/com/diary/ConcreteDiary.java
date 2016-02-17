package com.diary;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.domains.Diary;
import com.example.mydiary.R;
import com.tools.CommonTools;
import com.tools.DatabaseHelper;

public class ConcreteDiary extends Activity {

	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "MyDiary";
	private static final String TABLE_NAME = "diary";
	
	private static final String OPERATION_SUCCEED = "操作成功";
	private static final String OPERATION_FAILED = "操作失败";
	
	private Intent intent_received;
	private Diary diary;
	private EditText editText_title;
	private EditText editText_content;
	private DatabaseHelper dbHelper;
	
	public void buttonOk(View view) {
		
		String whereClause = "id=?";
		String[] whereArgs = {diary.getId()+""};
		
		ContentValues values = new ContentValues();
		values.put("title", editText_title.getText().toString());
		values.put("content", editText_content.getText().toString());
		values.put("time", CommonTools.getCurrentDateAndTime());
		
		dbHelper = new DatabaseHelper(ConcreteDiary.this, DB_NAME, null, DB_VERSION);
		dbHelper.insert(TABLE_NAME, values, whereClause, whereArgs);
		
		Toast.makeText(ConcreteDiary.this, OPERATION_SUCCEED, Toast.LENGTH_LONG).show();
		this.finish();
	}

	public void buttonBack(View view) {
		this.finish();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diary_show);

		intent_received = this.getIntent();
		diary = (Diary) intent_received.getSerializableExtra("obj");

		editText_title = (EditText) this
				.findViewById(R.id.diary_show_editText_title);
		editText_content = (EditText) this
				.findViewById(R.id.diary_show_editText_content);

		editText_title.setText(diary.getTitle());
		editText_content.setText(diary.getContent());
	}

	
}
