package com.diary;

import com.example.mydiary.R;
import com.example.mydiary.R.id;
import com.example.mydiary.R.layout;
import com.tools.CommonTools;
import com.tools.DatabaseHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DiaryWrite extends Activity {

	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "MyDiary";
	private static final String TABLE_NAME = "diary";
	private static final String OPERATION_SUCCEED = "操作成功";
	private static final String OPERATION_FAILED = "操作失败";
	
	private EditText editText_content;
	private EditText editText_title;
	private DatabaseHelper dbHelper;
	private SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diary_write);
	}

	public void buttonOk(View view) {
		editText_content = (EditText) this.findViewById(R.id.diary_write_textView_content);
		editText_title = (EditText) this.findViewById(R.id.diary_write_textView_title);
		
		dbHelper = new DatabaseHelper(DiaryWrite.this, DB_NAME, null, DB_VERSION);
		db = dbHelper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("title", editText_title.getText().toString());
		values.put("content", editText_content.getText().toString());
		values.put("time", CommonTools.getCurrentDateAndTime());
		
		db.insert(TABLE_NAME, null, values);
		db.close();
		
		Toast.makeText(DiaryWrite.this, OPERATION_SUCCEED, Toast.LENGTH_LONG).show();
		
		closeSelf();
	}

	public void buttonBack(View view) {
		closeSelf();
	}
	
	public void closeSelf(){
		DiaryWrite.this.finish();
	}
}
