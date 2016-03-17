package com.tools;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.domains.domains.Sjtg.ContentDownload;
import com.domains.domains.Sjtg.ContentGwzz;
import com.domains.domains.Sjtg.ContentsFeedback;
import com.domains.domains.Sjtg.Contents_Sjtg;

public class SqlTools {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private int totalCounts = 0;
	private int totalPages = 0;
	private int pageSize = 10;
	
	//更新指定的记录
	public boolean updateRecord(String contentName,Object obj){
		
		int result = 2;
		boolean flag = false; 
		String sql = null;
		
		if("gwzz".equals(contentName)){
			ContentGwzz each = (ContentGwzz) obj;
			sql = "update "+contentName+" set jobname='"+each.getJobname()+"',name='"+each.getName()+"',duty='"+each.getDuty()+"',addrContent='"+each.getAddrContent()+"' where id="+each.getId()+"";
		}else if("download".equals(contentName)){
			ContentDownload each = (ContentDownload) obj;
			sql = "update "+contentName+" set type='"+each.getType()+"' where id="+each.getId()+"";
		}else{
			Contents_Sjtg each = (Contents_Sjtg) obj;
			sql = "update "+contentName+" set title='"+each.getTilte()+"',writetime='"+each.getTime()+"',content='"+each.getContent()+"' where id="+each.getId()+"";
		}
		try {
			ps = conn.prepareStatement(sql);			
			result = ps.executeUpdate();
			if(result==1){
				flag = true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuery();
		}
		return flag;
	}
	
	//向数据库中存入一条记录
	public boolean insertRecordToDB(String contentName,Object obj){
		
		String sql = null;
		int result = 2;
		boolean flag = false; 

		if("xsjb".equals(contentName)){
			ContentsFeedback obj1 = (ContentsFeedback) obj;
			sql = "insert into xsjb values('"+obj1.getName()+"','"+obj1.getContactWay()+"','"+obj1.getSubjects()+"','"+obj1.getContent()+"',GETDATE())";
		}else if("download".equals(contentName)){
			ContentDownload obj1 = (ContentDownload) obj;
			sql = "insert into download values('"+obj1.getFileName()+"','"+obj1.getType()+"')";
		}else if("gwzz".equals(contentName)){
			ContentGwzz obj1 = (ContentGwzz) obj;
			sql = "insert into gwzz values('"+obj1.getJobname()+"','"+obj1.getName()+"','"+obj1.getDuty()+"','"+obj1.getAddrContent()+"')";
		}else{
			Contents_Sjtg obj1 = (Contents_Sjtg) obj;
			sql = "insert into "+contentName+"(title,writetime,content) values('"+obj1.getTilte()+"','"+obj1.getTime()+"','"+obj1.getContent()+"')";
		}
		try {
			ps = conn.prepareStatement(sql);			
			result = ps.executeUpdate();
			if(result==1){
				flag = true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuery();
		}
		return flag;
	}
	
	//删除指定页的内容
	public boolean deleteTargentContent(String contentName,Integer id){
		
		boolean flag = true;
		int result = 1;
		
		String sql = "delete from "+contentName+" where id="+id.toString()+" ";
		
		try {
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuery();
		}
		if(result==2){
			flag = false;
		}
		return flag;
	}
	
	//获取下载列表第x页的内容
	public ArrayList getDownloadContentsByPageNow(String contentName,int pageNow,int pageSize,int TYPE){
		
		getTotalPages(contentName,TYPE);
		
		ArrayList al = new ArrayList();
		
		try {
			String sql = "";
			//String sql = "select top("+pageSize+") * from "+contentName+" where id not in (select top("+pageSize*(pageNow-1)+") id from "+contentName+") ";
			if(TYPE==1){
				sql = "select top("+pageSize+") * from "+contentName+" where id not in (select top("+pageSize*(pageNow-1)+") id from "+contentName+" where type='sj' order by id desc) and type='sj'  order by id desc";
			}else{
				sql = "select top("+pageSize+") * from "+contentName+" where id not in (select top("+pageSize*(pageNow-1)+") id from "+contentName+" where type='gc' order by id desc) and type='gc'  order by id desc";
			}
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(!rs.next()){
				al = null;
			}else{
				do{
					ContentDownload each = new ContentDownload();
					
					each.setId(rs.getInt("id"));
					each.setFileName(rs.getString("filename"));
					each.setType(rs.getString("type"));
					
					al.add(each);
					
				}while(rs.next());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuery();
		}
		//System.out.println("SqlTools-57:"+al.size());
		return al;
	}
	
	//取得下载文件列表
	public ArrayList getDownloadContents(String contentName,int pageSize_download){
		
		ArrayList al = new ArrayList();
		
		try {
			
			//String sql = "select top("+pageSize+") * from "+contentName+" where id not in (select top("+pageSize*(pageNow-1)+") id from "+contentName+") ";
			String sql = "select top("+pageSize_download+") * from "+contentName+" order by id desc";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(!rs.next()){
				al = null;
			}else{
				do{
					ContentDownload each = new ContentDownload();
					
					each.setId(rs.getInt("id"));
					each.setFileName(rs.getString("filename"));
					
					al.add(each);
					
				}while(rs.next());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuery();
		}
		//System.out.println("SqlTools-53:"+al.size());
		return al;
	}
	
	//查询第x页要显示的记录
	public ArrayList getContentsByPageNow(String contentName,int pageNow){
		
		getTotalPages(contentName);
		
		ArrayList al = new ArrayList();
		
		try {
			String sql = "";
			//String sql = "select top("+pageSize+") * from "+contentName+" where id not in (select top("+pageSize*(pageNow-1)+") id from "+contentName+") ";
			//String sql = "select top("+pageSize+") * from "+contentName+" where id not in (select top("+pageSize*(pageNow-1)+") id from "+contentName+" order by id desc) order by id desc";
			if("gwzz".equals(contentName)){
				sql = "select top("+pageSize+") * from "+contentName+" where id not in (select top("+pageSize*(pageNow-1)+") id from "+contentName+")";
			}else{
				sql = "select top("+pageSize+") * from "+contentName+" where id not in (select top("+pageSize*(pageNow-1)+") id from "+contentName+" order by id desc) order by id desc";
			}
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(!rs.next()){
				al = null;
			}else{
				do{
					if("download".equals(contentName)){
						ContentDownload each = new ContentDownload();
						
						each.setId(rs.getInt("id"));
						each.setFileName(rs.getString("filename"));
						each.setType(rs.getString("type"));
						
						al.add(each);
					}else if("xsjb".equals(contentName)){
						ContentsFeedback each = new ContentsFeedback();
						
						each.setId(rs.getInt("id"));
						each.setContactWay(rs.getString("contactWay"));
						each.setContent(rs.getString("content"));
						each.setName(rs.getString("name"));
						each.setSubjects(rs.getString("subjects"));
						each.setWritetime(rs.getString("writetime"));
						
						al.add(each);
					}else if("gwzz".equals(contentName)){
						ContentGwzz each = new ContentGwzz();
						
						each.setAddrContent(rs.getString("addrContent"));
						each.setDuty(rs.getString("duty"));
						each.setId(rs.getInt("id"));
						each.setJobname(rs.getString("jobname"));
						each.setName(rs.getString("name"));
						
						al.add(each);
						
					}else{				
						Contents_Sjtg each = new Contents_Sjtg();
						
						each.setId(rs.getInt("id"));
						each.setTilte(rs.getString("title"));
						each.setSubTilte(rs.getString("subtitle"));
						each.setContent(rs.getString("content"));
						each.setTime(rs.getString("writetime"));
						
						al.add(each);
					}
				}while(rs.next());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuery();
		}
		return al;
	}
	
	//查询第x页要显示的记录
	public ArrayList getContentsByPageNow(String contentName,int pageNow,int indexPageSize){
		
		getTotalPages(contentName);
		
		ArrayList al = new ArrayList();
		
		try {
			
			//String sql = "select top("+pageSize+") * from "+contentName+" where id not in (select top("+pageSize*(pageNow-1)+") id from "+contentName+") ";
			String sql = "select top("+indexPageSize+") * from "+contentName+" where id not in (select top("+indexPageSize*(pageNow-1)+") id from "+contentName+" order by id desc) order by id desc";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(!rs.next()){
				al = null;
			}else{
				do{
					if("download".equals(contentName)){
						ContentDownload each = new ContentDownload();
						
						each.setId(rs.getInt("id"));
						each.setFileName(rs.getString("filename"));
						
						al.add(each);
					}else if("xsjb".equals(contentName)){
						ContentsFeedback each = new ContentsFeedback();
						
						each.setId(rs.getInt("id"));
						each.setContactWay(rs.getString("contactWay"));
						each.setContent(rs.getString("content"));
						each.setName(rs.getString("name"));
						each.setSubjects(rs.getString("subjects"));
						each.setWritetime(rs.getString("writetime"));
						
						al.add(each);
					}else{				
						Contents_Sjtg each = new Contents_Sjtg();
						
						each.setId(rs.getInt("id"));
						each.setTilte(rs.getString("title"));
						each.setSubTilte(rs.getString("subtitle"));
						each.setContent(rs.getString("content"));
						each.setTime(rs.getString("writetime"));
						
						al.add(each);
					}
				}while(rs.next());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuery();
		}
		return al;
	}
	
	//得到所有页数
	public int getTotalPages(String contentName){
		
		getTotalCounts(contentName);
		if(totalCounts%pageSize==0){
			totalPages = (totalCounts)/pageSize;
		}else{
			totalPages = (totalCounts)/pageSize+1;
		}
		return totalPages;
	}
	public int getTotalPages(String contentName,int TYPE){
		
		getTotalCounts(contentName,TYPE);
		if(totalCounts%pageSize==0){
			totalPages = (totalCounts)/pageSize;
		}else{
			totalPages = (totalCounts)/pageSize+1;
		}
		return totalPages;
	}
	 
	//得到总共记录数，private，用在getTotalPages方法里
	private int getTotalCounts(String contentName){
		
		try {
			ps = conn.prepareStatement("select count(*) total from "+contentName+"");
			rs = ps.executeQuery();
			
			if(!rs.next()){
				totalCounts = -1;
			}else{
				totalCounts = rs.getInt("total");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuery();
		}
		return totalCounts;
	}
	
	private int getTotalCounts(String contentName,int TYPE){
		
		try {
			
			String sql = "";
			//String sql = "select top("+pageSize+") * from "+contentName+" where id not in (select top("+pageSize*(pageNow-1)+") id from "+contentName+") ";
			if(TYPE==1){
				sql = "select count(*) total from "+contentName+" where type='sj'";
			}else{
				sql = "select count(*) total from "+contentName+" where type='gc'";;
			}
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(!rs.next()){
				totalCounts = -1;
			}else{
				totalCounts = rs.getInt("total");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuery();
		}
		return totalCounts;
	}
	
	
	//关闭数据库
	public void closeDB(){
		try {
			closeQuery();
			if(!conn.isClosed()){
				conn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//关闭查询链接
	public void closeQuery(){
		
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//链接数据库
	public boolean ConnectDB(){
		
		boolean flag = false;
		
		String path = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ZgdSjc";
		String user = "sa";
		String password = "19930312";
		
		try {
			Class.forName(path);
			conn = DriverManager.getConnection(connectDB,user,password);
			//System.out.println("SqlTools-130:链接数据库成功");//-----------------------------------
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	//查询所有记录
	public ArrayList getContents(String contentName,Integer id){
		
		ArrayList al = new ArrayList();
		
		String sql = "";
		if(id==null){
			sql = "select * from "+contentName+"";
		}else{
			sql = "select * from "+contentName+" where id="+id.toString()+"";
		}
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(!rs.next()){
				al = null;
			}else{
				do{
					
					if("xsjb".equals(contentName)){
						ContentsFeedback each = new ContentsFeedback();
						
						each.setId(rs.getInt("id"));
						each.setName(rs.getString("name"));
						each.setContactWay(rs.getString("contactWay"));
						each.setSubjects(rs.getString("subjects"));
						each.setContent(rs.getString("content"));
						each.setWritetime(rs.getString("writetime"));
						
						al.add(each);
						
					}else if("gwzz".equals(contentName)){
						ContentGwzz each = new ContentGwzz();
						
						each.setAddrContent(rs.getString("addrContent"));
						each.setDuty(rs.getString("duty"));
						each.setId(rs.getInt("id"));
						each.setJobname(rs.getString("jobname"));
						each.setName(rs.getString("name"));
						
						al.add(each);
						
					}else{
						
						Contents_Sjtg each = new Contents_Sjtg();
						
						each.setId(rs.getInt("id"));
						each.setTilte(rs.getString("title"));
						each.setSubTilte(rs.getString("subtitle"));
						each.setContent(rs.getString("content"));
						each.setTime(rs.getString("writetime"));
					
						al.add(each);
					}
					
					
				}while(rs.next());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuery();
		}
		//System.out.println("SqlTools-178:"+al.size());
		return al;
	}
}
