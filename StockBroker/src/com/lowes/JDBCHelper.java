package com.lowes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCHelper {

	public static void close(ResultSet x)
	{
		try
		{
			if(x!=null)
				x.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void close(Statement x)
	{
		try
		{
			if(x!=null)
				x.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void close(Connection x)
	{
		try
		{
			if(x!=null)
				x.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection()
	{
		Connection con = null;
		try
		{
			
			Class.forName(Constants.DRIVER);
			con = DriverManager.getConnection(Constants.URL,Constants.UID,Constants.PWD);
			System.out.println(con);
			return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
}
