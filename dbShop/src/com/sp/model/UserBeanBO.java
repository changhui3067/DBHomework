/**
 * 这是一个model(处理与users表相关的业务逻辑)
 */
package com.sp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserBeanBO {
	
	//	定义一些变量[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;

	/**
	 * 根据用户名返回该用户的全部信息
	 * @param u：用户名
	 * @return userbean
	 */
	
	public UserBean getUserBean(String u){
		
		UserBean ub=new UserBean();
		try {
			
			
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select top 1 * from users where username=?");
			ps.setString(1, u);
			rs=ps.executeQuery();
			if(rs.next()){
				
				ub.setUserid(rs.getLong(1));
				ub.setUsername(rs.getString(2));
				ub.setTruename(rs.getString(3));
				ub.setPasswd(rs.getString(4));
				ub.setEmail(rs.getString(5));
				ub.setPhone(rs.getString(6));
				ub.setAddress(rs.getString(7));
				ub.setPostcode(rs.getString(8));
				ub.setGrade(rs.getInt(9));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		
		return ub;
	}
	
	/**
	 * 验证用户是否合法
	 * @param u
	 * @param p
	 * @return
	 */
	public boolean checkUser(String u,String p){
		
		
		boolean b=false;
		
		
		try {
			
			//sql注入漏洞
			
			ct=new ConnDB().getConn();
			
			//top 1表示查到一条记录就返回，提高查询速度
			ps=ct.prepareStatement("select top 1 passwd from users where username=?");
			
			ps.setString(1, u);
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				//取出数据库的密码
				String dbPasswd=rs.getString(1);
				
				if(dbPasswd.equals(p)){
					
					b=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			//关闭资源
			this.close();
		}
		
		return b;
		
	}
//关闭函数
	
	public void close(){
		
		try {
			
			if(rs!=null){
				
				rs.close();
				rs=null;//
			}
			if(ps!=null){
				
				ps.close();
				ps=null;
			}
			
			if(!ct.isClosed()){
				
				ct.close();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
