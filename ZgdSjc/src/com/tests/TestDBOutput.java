package com.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domains.domains.Sjtg.Contents_Sjtg;
import com.opensymphony.xwork2.ActionContext;
import com.tools.SqlTools;
import com.tools.ToolUtils;

public class TestDBOutput {

	public static void main(String[] args) {
		
		testDB();
		 //System.out.println(ToolUtils.getDownloadFileName("abcdefg11111111111111.doc"));
		//System.out.println(ToolUtils.changeStringToChinese("???¨¨??????¡§????.doc"));
		 
	}
	
	public static void testDB(){
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;

		SqlTools sqlTools = new SqlTools();
		sqlTools.ConnectDB();

		String path = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ZgdSjc";
		String user = "sa";
		String password = "19930312";

		  int pageNow = 1;
		  int pageSize = 10;
		  int indexPageSize = 5;
		  ArrayList contentResult_Gzdt;
		  ArrayList contentResult_Sjgk;
		  ArrayList contentResult_sjxw;
		  ArrayList contentResult_sjtg;
			  String table1 = "gzdt";
			  String table2 = "sjgk";
			  String table3 = "sjxw";
			  String table4 = "sjtg";
		
		try {
			Class.forName(path);
			conn = DriverManager.getConnection(connectDB, user, password);
			
			sqlTools = new SqlTools();
			sqlTools.ConnectDB();
			//request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			contentResult_Gzdt = sqlTools.getContentsByPageNow(table1, pageNow, indexPageSize);
			contentResult_Sjgk = sqlTools.getContentsByPageNow(table2, pageNow, indexPageSize);
			contentResult_sjxw = sqlTools.getContentsByPageNow(table3, pageNow, indexPageSize);
			contentResult_sjtg = sqlTools.getContentsByPageNow(table4, pageNow, indexPageSize);
			
			 
			
			for(int i=0;i<5;i++){
				Contents_Sjtg each = (Contents_Sjtg)contentResult_Gzdt.get(i);
				Contents_Sjtg each1 = (Contents_Sjtg)contentResult_Sjgk.get(i);
				Contents_Sjtg each2 = (Contents_Sjtg)contentResult_sjxw.get(i);
				Contents_Sjtg each3 = (Contents_Sjtg)contentResult_sjtg.get(i);
				
				System.out.println("gzdt="+each.getTilte());
				System.out.println("Sjgk="+each1.getTilte());
				System.out.println("sjxw="+each2.getTilte());
				System.out.println("sjtg="+each3.getTilte());
				System.out.println("-------------------------");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
