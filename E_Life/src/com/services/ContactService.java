package com.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.example.project1.R;
import com.tools.ToolUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.util.Log;

public class ContactService {

	public static LinkedHashMap<String, String> getContacts(Context context) {

		LinkedHashMap hm = new LinkedHashMap();

		Uri uri = ContactsContract.Contacts.CONTENT_URI;
		ContentResolver resolver = context.getContentResolver();
		Cursor cursor = resolver.query(uri, null, null, null, null);
		if (cursor != null) {
			while (cursor.moveToNext()) {
				String id = cursor.getString(cursor
						.getColumnIndex(ContactsContract.Contacts._ID));
				String name = cursor
						.getString(cursor
								.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				String number = "";
				Log.i("result", name);
				Cursor phones = resolver.query(
						ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID
								+ "=" + id, null, null);

				while (phones.moveToNext()) {
					number = phones
							.getString(phones
									.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
					hm.put(name, number);

				}
				phones.close();
			}
		}
		cursor.close();
//Ã»¹Ø±Õcursor
		return hm;
	}

	public static int returnIconIdByFirstName(char name) {

		int id = -1;

		switch (name) {
		case 'a':
			id = R.drawable.a;
			break;
		case 'b':
			id = R.drawable.b;
			break;
		case 'c':
			id = R.drawable.c;
			break;
		case 'd':
			id = R.drawable.d;
			break;
		case 'e':
			id = R.drawable.e;
			break;
		case 'f':
			id = R.drawable.f;
			break;
		case 'g':
			id = R.drawable.g;
			break;
		case 'h':
			id = R.drawable.h;
			break;
		case 'i':
			id = R.drawable.i;
			break;
		case 'j':
			id = R.drawable.j;
			break;
		case 'k':
			id = R.drawable.k;
			break;
		case 'l':
			id = R.drawable.l;
			break;
		case 'm':
			id = R.drawable.m;
			break;
		case 'n':
			id = R.drawable.n;
			break;
		case 'o':
			id = R.drawable.o;
			break;
		case 'p':
			id = R.drawable.p;
			break;
		case 'q':
			id = R.drawable.q;
			break;
		case 'r':
			id = R.drawable.r;
			break;
		case 's':
			id = R.drawable.s;
			break;
		case 't':
			id = R.drawable.t;
			break;
		case 'u':
			id = R.drawable.u;
			break;
		case 'v':
			id = R.drawable.v;
			break;
		case 'w':
			id = R.drawable.w;
			break;
		case 'x':
			id = R.drawable.x;
			break;
		case 'y':
			id = R.drawable.y;
			break;
		case 'z':
			id = R.drawable.z;
			break;
		default:
			id = R.drawable.otheralphabet;
		}
		return id;
	}

	public static List<Map<String, Object>> getSortedContacts(
			List<Map<String, Object>> data) {

		Collections.sort(data, new Comparator<Map<String, Object>>() {

			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				// TODO Auto-generated method stub
				// return
				// (ToolUtils.getCharsByFirstName(o1.getKey()).toString()).compareTo(ToolUtils.getCharsByFirstName(o2.getKey()).toString());
				return ToolUtils.getCharsByFirstName(o1.get("name").toString())
						.compareTo(
								ToolUtils.getCharsByFirstName(o2.get("name")
										.toString()));

			}
		});

		return data;
	}
}
