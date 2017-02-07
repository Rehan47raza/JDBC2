package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class TestProcedure {
	
	
	
	public static HashMap<Integer, Book> getMapbybookId(DbTransaction db) 
	{
		HashMap<Integer, Book> hm = new HashMap<Integer,Book>();
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try
		{
			cn=db.getConnection();
			st=cn.createStatement();
			String sql="SELECT * FROM " +db.getTableName();
			
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				Book b = new Book();
			//	b.setBook_id(rs.getInt("BOOK_ID"));
				b.setBook_id(rs.getInt(1));
				b.setPages(rs.getInt("PAGES"));
				b.setPrice(rs.getDouble("PRICE"));
				b.setTitle(rs.getString("TITLE"));
				System.out.println(b.getBook_id());
				
				hm.put(b.getBook_id(), b);
			//	System.out.println(hm.get(b.getBook_id()).getBook_id());
			}
			
			return hm;
		}catch (Exception e) {
			return null;
		}
		
	}
}
