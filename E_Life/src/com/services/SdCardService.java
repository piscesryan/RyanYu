package com.services;

import android.os.Environment;

public class SdCardService {

	public static boolean isSdCardExist() {
		boolean flag = false;

		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			flag = true;
		}
		return flag;
	}
}
