package com.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import android.util.Log;

public class ToolUtils {

	public static String getTimeFromMillSec(long time, String type) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(type);

		/*
		 * char[] getTime = sdf.format(new Date(time)).toCharArray(); Integer
		 * value = Integer.parseInt(getTime[1] + "") - 8; Character charValue =
		 * Character.forDigit(value, 10);
		 * System.out.println("Integer value="+value);
		 * System.out.println("charValuee="+charValue);
		 * 
		 * getTime[1] = charValue;
		 * 
		 * result = new String(String.valueOf(getTime).getBytes(), "UTF-8");
		 */
		if ("yyyy.MM.dd-HH:mm:ss".equals(type)) {
			result = sdf.format(new Date(time));
		} else {
			String temp = result = sdf.format(new Date(time));
			String sub = result.substring(0, 2);
			int value = Integer.parseInt(sub) - 12;

			result = value + "" + temp.subSequence(2, result.length());
		}
		return result;
	}

	public static String returnSinaWeatherChineseName(String code) {

		if ("city".equals(code)) {
			return "城市";
		} else if ("status1".equals(code)) {
			return "白天天气";
		} else if ("status2".equals(code)) {
			return "夜晚天气";
		} else if ("direction1".equals(code)) {
			return "白天风向";
		} else if ("direction2".equals(code)) {
			return "夜晚风向";
		} else if ("power1".equals(code)) {
			return "白天风力";
		} else if ("power2".equals(code)) {
			return "夜晚风力";
		} else if ("temperature1".equals(code)) {
			return "白天温度";
		} else if ("temperature2".equals(code)) {
			return "夜晚温度";
		} else if ("tgd1".equals(code)) {
			return "白天体感度指数";
		} else if ("tgd2".equals(code)) {
			return "夜晚体感度指数";
		} else if ("zwx".equals(code)) {
			return "紫外线指数";
		} else if ("ktk".equals(code)) {
			return "空调指数";
		} else if ("pollution".equals(code)) {
			return "污染指数";
		} else if ("xcz".equals(code)) {
			return "洗车指数";
		} else if ("chy".equals(code)) {
			return "穿衣指数";
		} else if ("pollution_l".equals(code)) {
			return "污染程度";
		} else if ("zwx_l".equals(code)) {
			return "紫外线程度";
		} else if ("chy_l".equals(code)) {
			return "穿衣建议";
		} else if ("ktk_l".equals(code)) {
			return "空调建议";
		} else if ("yd_l".equals(code)) {
			return "运动适宜度";
		} else if ("yd_s".equals(code)) {
			return "运动建议";
		} else if ("yd_s".equals(code)) {
			return "运动建议";
		} else if ("gm_l".equals(code)) {
			return "易感冒程度";
		} else if ("gm_s".equals(code)) {
			return "预防感冒建议";
		} else if ("ssd_s".equals(code)) {
			return "出门建议";
		} else {
			return null;
		}
	}

	public static String changeStreamToString(BufferedReader br)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		char[] buffer = new char[1024];
		//ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		StringWriter sw = new StringWriter(1024);
		
		int length = 0;

		while ((length = br.read(buffer)) != -1) {
			sw.write(buffer,0,length);
			//sb.append(new String(buffer,0,length));
			sw.flush();
			sb.append(sw.toString());
			sw.flush();
		}
		sw.close();
		return sb.toString();
	}

	public static String[] splitStringByCharacter(String from, String by) {
		String[] result = from.split(by);
		return result;
	}

	public static String returnMailCode(String name) {

		String codeResult = "";

		String[] code = new String[] { "debangwuliu", "dhl", "huitongkuaidi",
				"lianb", "shentong", "shunfeng", "tiantian", "ups", "yuantong",
				"yunda", "zhaijisong", "zhongtong" };
		String[] companyName = new String[] { "德邦", "dhl", "汇通", "联邦", "申通",
				"顺丰", "天天", "ups", "圆通", "韵达", "宅急送", "中通" };

		for (int i = 0; i < companyName.length; i++) {
			if (companyName[i].equals(name)) {
				codeResult = code[i];
				break;
			}
			if (i == companyName.length - 1) {
				codeResult = null;
			}
		}
		return codeResult;
	}

	public static char getCharByFirstName(String sName) {

		char name = sName.charAt(0);

		HanyuPinyinOutputFormat hanyuPinyin = new HanyuPinyinOutputFormat();
		hanyuPinyin.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		hanyuPinyin.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		hanyuPinyin.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
		String[] pinyinArray = null;
		try {
			// 是否在汉字范围内
			if (name >= 0x4e00 && name <= 0x9fa5) {
				pinyinArray = PinyinHelper.toHanyuPinyinStringArray(name,
						hanyuPinyin);
				name = pinyinArray[0].charAt(0);
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}

		// 将获取到的拼音返回
		return name;
	}

	public static String getCharsByFirstName(String sName) {

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < sName.length(); i++) {
			char name = sName.charAt(i);

			HanyuPinyinOutputFormat hanyuPinyin = new HanyuPinyinOutputFormat();
			hanyuPinyin.setCaseType(HanyuPinyinCaseType.LOWERCASE);
			hanyuPinyin.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			hanyuPinyin.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
			String[] pinyinArray = null;
			try {
				// 是否在汉字范围内
				if (name >= 0x4e00 && name <= 0x9fa5) {
					pinyinArray = PinyinHelper.toHanyuPinyinStringArray(name,
							hanyuPinyin);
					result.append(pinyinArray[0].charAt(0));
				} else {
					result.append(name);
				}
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}

			// 将获取到的拼音返回

		}
		return result.toString();
	}

}
