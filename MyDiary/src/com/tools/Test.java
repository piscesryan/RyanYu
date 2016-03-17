package com.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

public class Test extends TestCase {

	public static String getCurrentDateAndTime(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		return format.format(new Date());
	}
}
