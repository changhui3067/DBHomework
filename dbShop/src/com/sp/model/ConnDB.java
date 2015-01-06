//����һ��model��
//��ɵõ�һ����ݿ�����
package com.sp.model;
import java.sql.*;

public class ConnDB {

	private Connection ct=null;
	
	public Connection getConn(){
		
		try {
			
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://127.0.0.1:3306/dbhomework";
//			String user = "root";
//			String pwd = "12345678";
//			ct=DriverManager.getConnection(url,user,pwd);
			
//			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//			ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=testdb3","sa","");
			
			// 1. 加载驱动， 
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// 2. 建立连接，指定url中包含数据源中数据库注册的名称    
			String url="jdbc:odbc:dbshop";
			ct = DriverManager.getConnection(url);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return ct;
	}
}
