package com.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class ParseXML {

	public static String getNumberInfo(InputStream is) throws Exception {

		String result = "";

		XmlPullParser parser = Xml.newPullParser();
		parser.setInput(is, "UTF-8");

		int eventType = parser.getEventType();

		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
			case XmlPullParser.START_TAG:
				if ("string".equals(parser.getName())) {
					result = parser.nextText();
				}
				break;
			}
			eventType = parser.next();
		}
		return result;
	}

	private static final class ParserHandler extends DefaultHandler {

		public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		String flag = "";
		String result = "";

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			// TODO Auto-generated method stub
			super.startElement(uri, localName, qName, attributes);
			flag = qName;
			System.out.println("qName=" + qName);
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			// TODO Auto-generated method stub
			super.characters(ch, start, length);
			if ("string".equals(flag)) {
				result = new String(ch, start, length);
			}
		}

	}

	public static String getNumberInfo1(InputStream is) throws Exception,
			Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		ParserHandler handler = new ParserHandler();
		parser.parse(is, handler);
		return handler.getResult();
	}

	public static Map getWeather(InputStream is) throws Throwable, Exception {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		ParserWeatherHandler handler = new ParserWeatherHandler();
		parser.parse(is, handler);

		return handler.weacherInfo;
	}

	private static class ParserWeatherHandler extends DefaultHandler {

		private Map<String, String> weacherInfo;
		private String tag;

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			// TODO Auto-generated method stub
			super.characters(ch, start, length);
			/*
			 * if(tag.equals("city")){ weacherInfo.put("city", new String(ch));
			 * }else if(tag.equals("status1")){ weacherInfo.put("weather_night",
			 * new String(ch)); }
			 */
			if (tag != null && !tag.equals("Profiles")
					&& !tag.equals("Weather")) {
				// System.out.println(tag+"->"+new String(ch,start,length));
				weacherInfo.put(tag, new String(ch, start, length));
			}
		}

		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.endDocument();
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);
			tag = null;
		}

		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.startDocument();
			weacherInfo = new LinkedHashMap();
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			// TODO Auto-generated method stub
			// super.startElement(uri, localName, qName, attributes);
			if (qName != null) {
				tag = qName;
			}
		}

	}

}
