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
			return "����";
		} else if ("status1".equals(code)) {
			return "��������";
		} else if ("status2".equals(code)) {
			return "ҹ������";
		} else if ("direction1".equals(code)) {
			return "�������";
		} else if ("direction2".equals(code)) {
			return "ҹ�����";
		} else if ("power1".equals(code)) {
			return "�������";
		} else if ("power2".equals(code)) {
			return "ҹ�����";
		} else if ("temperature1".equals(code)) {
			return "�����¶�";
		} else if ("temperature2".equals(code)) {
			return "ҹ���¶�";
		} else if ("tgd1".equals(code)) {
			return "������ж�ָ��";
		} else if ("tgd2".equals(code)) {
			return "ҹ����ж�ָ��";
		} else if ("zwx".equals(code)) {
			return "������ָ��";
		} else if ("ktk".equals(code)) {
			return "�յ�ָ��";
		} else if ("pollution".equals(code)) {
			return "��Ⱦָ��";
		} else if ("xcz".equals(code)) {
			return "ϴ��ָ��";
		} else if ("chy".equals(code)) {
			return "����ָ��";
		} else if ("pollution_l".equals(code)) {
			return "��Ⱦ�̶�";
		} else if ("zwx_l".equals(code)) {
			return "�����̶߳�";
		} else if ("chy_l".equals(code)) {
			return "���½���";
		} else if ("ktk_l".equals(code)) {
			return "�յ�����";
		} else if ("yd_l".equals(code)) {
			return "�˶����˶�";
		} else if ("yd_s".equals(code)) {
			return "�˶�����";
		} else if ("yd_s".equals(code)) {
			return "�˶�����";
		} else if ("gm_l".equals(code)) {
			return "�׸�ð�̶�";
		} else if ("gm_s".equals(code)) {
			return "Ԥ����ð����";
		} else if ("ssd_s".equals(code)) {
			return "���Ž���";
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
		String[] companyName = new String[] { "�°�", "dhl", "��ͨ", "����", "��ͨ",
				"˳��", "����", "ups", "Բͨ", "�ϴ�", "լ����", "��ͨ" };

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
			// �Ƿ��ں��ַ�Χ��
			if (name >= 0x4e00 && name <= 0x9fa5) {
				pinyinArray = PinyinHelper.toHanyuPinyinStringArray(name,
						hanyuPinyin);
				name = pinyinArray[0].charAt(0);
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}

		// ����ȡ����ƴ������
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
				// �Ƿ��ں��ַ�Χ��
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

			// ����ȡ����ƴ������

		}
		return result.toString();
	}

}
