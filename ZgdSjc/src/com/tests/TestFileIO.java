package com.tests;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import com.tools.ToolUtils;

public class TestFileIO {

	public static void main(String[] args) throws IOException {
		//System.out.println(TestFileIO.class.getResource("/files").getPath());
		//InputStream fis = TestFileIO.class.getClassLoader().getResourceAsStream("/files");
		/*File file = new File("e:/");
		File files = new File(file,  "1111.txt");
		files.createNewFile();
		System.out.println("ok");*/
		 
		if(new File("e:/Reports/10.0.0.0 's Report.txt").exists()){
			 System.out.println("yes");
		}else{
			new File("e:/Reports/10.0.0.0 's Report.txt").createNewFile();
			System.out.println("create");
		}
	}
}
