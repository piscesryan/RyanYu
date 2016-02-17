package com.tests;

import java.util.ArrayList;

import com.domains.domains.Sjtg.ContentDownload;
import com.tools.SqlTools;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestDB extends TestCase {

	public void testDB(){
		SqlTools sqlTools = new SqlTools();
		sqlTools.ConnectDB();
	
		  String table1 = "gzdt";
		  String table2 = "sjgk";
		  String table3 = "sjxw";
		  String table4 = "sjtg";
		  
		  int pageNow = 1;
		  int pageSize = 10;
		  int indexPageSize = 5;
		  ArrayList contentResult_Gzdt;
		  ArrayList contentResult_Sjgk;
		  ArrayList contentResult_sjxw;
		  ArrayList contentResult_sjtg;
		
		  contentResult_Gzdt = sqlTools.getContentsByPageNow(table1, pageNow, indexPageSize);
			contentResult_Sjgk = sqlTools.getContentsByPageNow(table2, pageNow, indexPageSize);
			contentResult_sjxw = sqlTools.getContentsByPageNow(table3, pageNow, indexPageSize);
			contentResult_sjtg = sqlTools.getContentsByPageNow(table4, pageNow, indexPageSize);
			
	 
	}
}
