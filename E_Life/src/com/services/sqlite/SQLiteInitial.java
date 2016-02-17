package com.services.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteInitial extends SQLiteOpenHelper{

	private static String dbName = "Records.db";
	private static final int VERSION = 1;
	
	public SQLiteInitial(Context context) {
		super(context, dbName, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.beginTransaction();
		
		db.execSQL("create table bookrecords (name nvarchar(40),time nvarchar(80))");
		db.execSQL("create table videorecords (name nvarchar(40),time nvarchar(80))");
		db.execSQL("create table mynote (content)");
		
		db.setTransactionSuccessful();
		db.endTransaction();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
