package com.bby.ants.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties dataProp;
	
	public static Properties getDataProp() {
		try {
			if(dataProp==null) {
				dataProp = new Properties();
				dataProp.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("data.properties"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataProp;
	}
}
