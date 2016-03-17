package test.com.bby.ants;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


import net.sf.json.JSONArray;

public class TestGenerate {

	@Test
	public void testTime1(){
		String str1="2016-01-25 20:42:58";
		String str2="2016-01-25 20:42:38";
		System.out.println(str1.compareTo(str2));
	}
	
	//@Test
	public void generateId(){
		DateFormat   df   =   new   SimpleDateFormat("HH:mm:ss");  
		//String d="20";
		String d1=df.format(new  Date());
		String d2=df.format(new Date().getTime()+30000);
		//String d2=String.valueOf((int)(Math.random()*9000+1000));
		//System.out.println(Long.parseLong(d+d1+d2));
		System.out.println(d1);
		System.out.println(d2);
		
	}
	//@Test
	public void generateId1(){
		DateFormat   df   =   new   SimpleDateFormat("HH:mm");  
		//String d="20";
		String d1=df.format(new  Date());
		String d2=df.format(new Date().getTime()+30000);
		//String d2=String.valueOf((int)(Math.random()*9000+1000));
		//System.out.println(Long.parseLong(d+d1+d2));
		boolean b1 = d1.equals("10");
		boolean b2 = d1.equals("20");
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(b1);
		System.out.println(b2);
		
	}
	//@Test
	public void testTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:00");
		DateFormat   dft   =   new   SimpleDateFormat("HH:mm:ss"); 
		Date now=new Date();
		String dat = sdf.format(new Date());
		Date date = null;
		try {
			date = dft.parse(dat);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date);
		Long time=date.getTime();
		time=time-30000;
		String en=dft.format(new Date(time));
		System.out.println(en);

		//System.out.println(new Date().getTime());
	}
	
	//@Test
	public void testTime2(){
		System.out.println(new Date().after(null));		
	}
//	@Test
	public void testByte(){
		byte a = 0;
		int b = 0;
		if(a==b){
			System.out.println(true);
		}
	}
	
	//@Test
	public void test1(){
		String name = "count_1_1448371650268_0.jpg";
		String imgName = name.substring(0,name.lastIndexOf("_"));
		
			System.out.println(imgName);
		
	}
    @Test
		public void test2(){
			//JSONArray jsonArr = new JSONArray();
    	
    	//BigDecimal bg = new BigDecimal(f);  
    	Double f1 = new BigDecimal((double) 90).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
         
			Double[] arr = new Double[4];
			Double nco2=new BigDecimal((double) 90).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
			Double nwd=new BigDecimal((double) 20).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			Double nsd=new BigDecimal((double) 30).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			Double ngz=new BigDecimal(10.1120).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			arr[0]= nco2*1000+1;
			arr[1]= nwd*1000+2;
			arr[2]= nsd*1000+3;
			arr[3]= ngz*1000+4;
			Arrays.sort(arr);
			
			int a1=(int) (arr[0]%10);
			int a2=(int) (arr[1]%10);
			int a3=(int) (arr[2]%10);
			int a4=(int) (arr[3]%10);
			Map map = new HashMap();
			map.put(1, "co2");
			map.put(2, "温度");
			map.put(3, "湿度");
			map.put(4, "光照");
			String stra1 = map.get(a1).toString();
			String stra2 = map.get(a2).toString();
			String stra3 = map.get(a3).toString();
			String stra4 = map.get(a4).toString();
			
			
			System.out.println(stra1+","+stra2+","+stra3+","+stra4);
			
			
			arr[0]=(arr[0]-a1)/1000;
			System.out.println(a1+","+a2+","+a3+","+a4);
				System.out.println(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]);
			
		}
		
		
		
	
	
	
	
}
