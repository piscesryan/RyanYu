package com.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.mydiary.MainActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "MyDiary";
	private static final String TABLE_NAME = "diary";
	private SQLiteDatabase db;
	private Cursor cursor;
	private Context context;

	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	private void getDB() {
		db = this.getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		this.db = db;
		String sql = "create table diary (	id integer primary key autoincrement,	title nvarchar(60) not NULL,	content text not NULL,	time VARCHAR(19) not NULL)";
		db.execSQL(sql);
		Log.i("db oncreate", "db oncreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public List showDiaryFromDB(String table, String[] columns,
			String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy) {

		List<HashMap<String, String>> temp = new ArrayList<HashMap<String, String>>();

		getDB();
		cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null,
				null, orderBy);
		while (cursor.moveToNext()) {
			String title = cursor.getString(cursor.getColumnIndex("title"));
			String content = cursor.getString(cursor.getColumnIndex("content"));
			String time = cursor.getString(cursor.getColumnIndex("time"));
			int id = cursor.getInt(cursor.getColumnIndex("id"));

			HashMap each = new HashMap<String, String>();
			each.put("id", id);
			each.put("title", title);
			each.put("content", content);
			each.put("time", time);

			temp.add(each);
		}
		cursor.close();
		db.close();

		return temp;
	}
	
	public List showDiaryFromDB() {
		 
		List<HashMap<String, String>> temp = new ArrayList<HashMap<String, String>>();
		 
		getDB();
		cursor = db.query(TABLE_NAME,
				new String[] { "id","title", "content", "time" }, null, null, null,
				null, "time desc");
		while (cursor.moveToNext()) {
			String title = cursor.getString(cursor.getColumnIndex("title"));
			String content = cursor.getString(cursor.getColumnIndex("content"));
			String time = cursor.getString(cursor.getColumnIndex("time"));
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			
			HashMap each = new HashMap<String, String>();
/*	for(int i=0;i<cursor.getColumnCount();i++)
	Log.i("info", "i="+i+" name="+cursor.getColumnName(i));*/		
			each.put("id", id);
			each.put("title", title);
			each.put("content", content);
			each.put("time", time);

			temp.add(each);
		}
		cursor.close();
		db.close();
		
		return temp;
	}
	
	public void insert(String table, ContentValues values, String whereClause, String[] whereArgs){
		getDB();
		db.update(table, values, whereClause, whereArgs);
		db.close();
	}

	public void delete(String table, String whereClause, String[] whereArgs){
		getDB();
		db.delete(table, whereClause, whereArgs);
		db.close();
	}
}
