package com.bby.ants.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtil {

    public static String xmlChangeString(String fileName){
        try {
            SAXReader saxReader = new SAXReader();
            saxReader.setEncoding("UTF-8");
            Document tempDocument = saxReader.read(new File(fileName));
            return tempDocument.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
        } 
        return null;
    }
    
    public static void strChangeXML(String str,String path, String siteName) throws IOException {
           SAXReader saxReader = new SAXReader();
           saxReader.setEncoding("UTF-8");
           Document document;
           try {
            document = saxReader.read(new ByteArrayInputStream(str.getBytes("UTF-8")));
            changeSiteAttribute(document,siteName);
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            /** 将document中的内容写入文件中 */
            XMLWriter writer = new XMLWriter(new FileWriter(new File(path)),format);
            writer.write(document);
            writer.close();
           } catch (DocumentException e) {
            e.printStackTrace();
           }

   }
    
    public  static void changeSiteAttribute(Document doc, String siteName)
    {
        @SuppressWarnings("unchecked")
		List<Attribute> attrList = doc.selectNodes("beans/site/@name");  
        Iterator<Attribute> i = attrList.iterator();  
        while (i.hasNext())  
        {  
            Attribute attribute = i.next();  
            //if (attribute.getValue().equalsIgnoreCase("yes"))  
            {  
                attribute.setValue(siteName);  
            }  
        }  
    }
    
    
}