package com.bby.ants.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * @author 蔡政滦
 * @version 2015年7月23日
 */
public class XmlUtils {
	
	/**
	* 根据Map组装xml消息体，值对象仅支持基本数据类型、String、BigInteger、BigDecimal，以及包含元素为上述支持数据类型的Map
	* 
	* @param vo
	* @param rootElement
	* @return
	* @author 蔡政滦 modify by 2015-6-5
	*/
	public static String map2xmlBody(Map<String, Object> vo, String rootElement,String xmlPath) {
		org.dom4j.Document doc = DocumentHelper.createDocument();
		Element body = DocumentHelper.createElement(rootElement);
		doc.add(body);
		__buildMap2xmlBody(body, vo);
		   try {  
	            /*直接通过write方法输出，如下，此时输出的xml文件中为默认的UTF-8编码，没有格式，空格也没有去除，实际上就是一个字符串；*/  
	            Writer fileWriter=new FileWriter(xmlPath);  
//	          XMLWriter xmlWriter=new XMLWriter(fileWriter);      
	               
	            /* 用XMLWriter类中的write方法，此时可以自行设置输出格式，比如紧凑型、缩减型：此时输出的xml文件中为gb2312编码，缩减型格式，但是多余的空格已经被清除：*/  
	             OutputFormat format = OutputFormat.createPrettyPrint();//缩减型格式  
	             //OutputFormat format = OutputFormat.createCompactFormat();//紧凑型格式  
	             format.setEncoding("UTF-8");//设置编码  
	             //format.setTrimText(false);//设置text中是否要删除其中多余的空格  
	             XMLWriter xmlWriter=new XMLWriter(fileWriter,format);  
	               
	             /*如果想要对xml文件的输出格式进行设置，就必须用XMLWriter类，但是我们又需要保留其中的空格，此时我们就需要对format进行设置，也就是加上一句format.setTrimText(false); 
	这样就可以既保持xml文件的输出格式，也可以保留其中的空格;element中attribute中的值如果有空格的话在任何情况下是都不会去除空格的；*/  
	             xmlWriter.write(doc);  
	             xmlWriter.close();   
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }   
		return doc.asXML();
	}
	
	@SuppressWarnings("unchecked")
	private static void __buildMap2xmlBody(Element body, Map<String, Object> vo) {
		if (vo != null) {
			Iterator<String> it = vo.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				if (StringUtils.isNotEmpty(key)) {
					Object obj = vo.get(key);
					Element element = DocumentHelper.createElement(key);
					if (obj != null) {
						if (obj instanceof java.lang.String) {
							element.setText((String) obj);
						} else {
							if (obj instanceof java.lang.Character || obj instanceof java.lang.Boolean || obj instanceof java.lang.Number
									|| obj instanceof java.math.BigInteger || obj instanceof java.math.BigDecimal) {
								org.dom4j.Attribute attr = DocumentHelper.createAttribute(element, "type", obj.getClass().getCanonicalName());
								element.add(attr);
								element.setText(String.valueOf(obj));
							} else if (obj instanceof java.util.Map) {
								org.dom4j.Attribute attr = DocumentHelper.createAttribute(element, "type", java.util.Map.class.getCanonicalName());
								element.add(attr);
								__buildMap2xmlBody(element, (Map<String, Object>) obj);
							} else {
							}
						}
					}
					body.add(element);
				}
			}
		}
	}
	
	/**
	 * 根据xml消息体转化为Map
	 * 
	 * @param xml
	 * @param rootElement
	 * @return
	 * @throws DocumentException
	 * @author 蔡政滦 modify by 2015-6-5
	 */
	@SuppressWarnings("rawtypes")
	public static Map xmlBody2map(String xml, String rootElement) throws DocumentException {
		org.dom4j.Document doc = DocumentHelper.parseText(xml);
		Element body = (Element) doc.selectSingleNode("/" + rootElement);
		Map vo = __buildXmlBody2map(body);
		return vo;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Map __buildXmlBody2map(Element body) {
		Map vo = new HashMap();
		if (body != null) {
			List<Element> elements = body.elements();
			for (Element element : elements) {
				String key = element.getName();
				if (StringUtils.isNotEmpty(key)) {
					String type = element.attributeValue("type", "java.lang.String");
					String text = element.getText().trim();
					Object value = null;
					if (java.lang.String.class.getCanonicalName().equals(type)) {
						value = text;
					} else if (java.lang.Character.class.getCanonicalName().equals(type)) {
						value = new java.lang.Character(text.charAt(0));
					} else if (java.lang.Boolean.class.getCanonicalName().equals(type)) {
						value = new java.lang.Boolean(text);
					} else if (java.lang.Short.class.getCanonicalName().equals(type)) {
						value = java.lang.Short.parseShort(text);
					} else if (java.lang.Integer.class.getCanonicalName().equals(type)) {
						value = java.lang.Integer.parseInt(text);
					} else if (java.lang.Long.class.getCanonicalName().equals(type)) {
						value = java.lang.Long.parseLong(text);
					} else if (java.lang.Float.class.getCanonicalName().equals(type)) {
						value = java.lang.Float.parseFloat(text);
					} else if (java.lang.Double.class.getCanonicalName().equals(type)) {
						value = java.lang.Double.parseDouble(text);
					} else if (java.math.BigInteger.class.getCanonicalName().equals(type)) {
						value = new java.math.BigInteger(text);
					} else if (java.math.BigDecimal.class.getCanonicalName().equals(type)) {
						value = new java.math.BigDecimal(text);
					} else if (java.util.Map.class.getCanonicalName().equals(type)) {
						value = __buildXmlBody2map(element);
					} else {
					}
					vo.put(key, value);
				}
			}
		}
		return vo;
	}
	
}
