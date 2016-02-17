package com.services.sqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLiteService {

	private SQLiteInitial openDBHelper;
	private Context context;

	public SQLiteService(Context context) {
		super();
		this.context = context;
		openDBHelper = new SQLiteInitial(context);
	}

	public void saveBookRecords(ArrayList books) {

		SQLiteDatabase db = openDBHelper.getWritableDatabase();

		// 储存前清除原有记录，防止重复记录
		String sql_delete = "delete from bookrecords";
		db.execSQL(sql_delete);

		for (int i = 0; i < books.size(); i++) {

			HashMap<String, String> hm = (HashMap<String, String>) books.get(i);

			String sql = "insert into bookrecords values(?,?)";
			Object[] bindArgs = { hm.get("name"), hm.get("time") };
			db.execSQL(sql, bindArgs);
			Log.i("result",
					"save==name=" + hm.get("name") + "...time="
							+ hm.get("time"));
		}
		db.close();
	}

	public ArrayList readBookRecods() {

		ArrayList bookList = new ArrayList();
		HashMap hm;

		SQLiteDatabase db = openDBHelper.getReadableDatabase();
		String sql = "select * from bookrecords";
		Cursor cursor = db.rawQuery(sql, null);

		if (cursor.moveToFirst()) {
			do {
				hm = new HashMap();
				hm.put("name", cursor.getString(cursor.getColumnIndex("name")));
				hm.put("time", cursor.getString(cursor.getColumnIndex("time")));
				bookList.add(hm);
				Log.i("result",
						"read==="
								+ cursor.getString(cursor
										.getColumnIndex("name"))
								+ "..."
								+ cursor.getString(cursor
										.getColumnIndex("time")));
			} while (cursor.moveToNext());
		} else {
			bookList = null;
		}
		cursor.close();
		db.close();
		return bookList;
	}

	public ArrayList readVideoRecords() {
		ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
		HashMap hm;

		SQLiteDatabase db = openDBHelper.getReadableDatabase();

		String sql = "select * from videorecords";
		Cursor cursor = db.rawQuery(sql, null);

		if (cursor.moveToFirst()) {
			do {
				String name = cursor.getString(cursor.getColumnIndex("name"));
				String time = cursor.getString(cursor.getColumnIndex("time"));
				hm = new HashMap<String, String>();
				hm.put("name", name);
				hm.put("time", time);
				data.add(hm);
			} while (cursor.moveToNext());
		} else {
			data = null;
		}
		return data;
	}

	public void saveVideoRecords(ArrayList videos) {
		SQLiteDatabase db = openDBHelper.getWritableDatabase();

		// 储存前清除原有记录，防止重复记录
		String sql_delete = "delete from videorecords";
		db.execSQL(sql_delete);

		for (int i = 0; i < videos.size(); i++) {

			HashMap<String, String> hm = (HashMap<String, String>) videos
					.get(i);

			String sql = "insert into videorecords values(?,?)";
			Object[] bindArgs = { hm.get("name"), hm.get("time") };
			db.execSQL(sql, bindArgs);
			Log.i("result",
					"save==name=" + hm.get("name") + "...time="
							+ hm.get("time"));

		}
		db.close();
	}
	
	public void saveMyNote(String content){
		
		SQLiteDatabase db = openDBHelper.getWritableDatabase();
		
		// 储存前清除原有记录，防止重复记录
		String sql_delete = "delete from videorecords";
		db.execSQL(sql_delete);
	
		String sql = "insert into mynote values(?)";
		Object[] bindArgs = {content};
		db.execSQL(sql, bindArgs);
		
		db.close();
	}
	
	public String readMyNote(){
		
		SQLiteDatabase db = openDBHelper.getReadableDatabase();
		
		String content = null;
		
		String sql = "select * from mynote";
		Cursor cursor = db.rawQuery(sql, null);
		
		if(cursor.moveToFirst()){
			content = cursor.getString(cursor.getColumnIndex("content"));
		}
		
		db.close();
		
		return content;
	}
}
