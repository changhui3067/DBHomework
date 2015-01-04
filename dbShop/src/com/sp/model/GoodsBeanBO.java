//这是model类，处理与goods表相关的业务逻辑
package com.sp.model;
import java.sql.*;
import java.util.ArrayList;
public class GoodsBeanBO {
	
	//定义一些变量[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
	
	/**
	 * 返回共有多少页
	 * 
	 */
	
	public int getPageCount(int pageSize){
		
		int pageCount=0;
		int rowCount=0;
		try {
			
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement("select count(*) from goods");
			
			//得到总有多少条记录
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				rowCount=rs.getInt(1);
					
			}
			
			if(rowCount%pageSize==0){
				
				pageCount=rowCount/pageSize;
			}else{
				
				pageCount=rowCount/pageSize+1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return pageCount;
	}
	
	
	/**
	 * 分页显示货物的信息
	 * @prameter int pageSize:每页显示几条记录
	 * @author 顺平
	 * @prameter int pageNow:显示第几页
	 * @return ArrayList 【就是要显示货物集合】
	 * ctrl+shift+m(可以引入包)
	 */
	public ArrayList getGoodsByPage(int pageSize,int pageNow){
		
		ArrayList al=new ArrayList();
		
		try {
			
			ct=new ConnDB().getConn();
			
			
			ps=ct.prepareStatement("select top "+pageSize
					+" * from goods where goodsId not in (select top "
					+(pageNow-1)*pageSize+" goodsId from goods)");
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				GoodsBean gb=new GoodsBean();
				gb.setGoodsId(rs.getInt(1));
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				gb.setGoodsPrice(rs.getFloat(4));
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				
				//加入到al
				
				al.add(gb);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return al;
	}
	
	//根据一个货物id,得到货物具体信息的函数
	public GoodsBean getGoodsBean(String id){
		
		
		GoodsBean gb=new GoodsBean();
		
		try {
			
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement("select * from goods where goodsId=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				
				//放入到gb
				gb.setGoodsId(rs.getInt(1));
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				gb.setGoodsPrice(rs.getFloat(4));
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			//关闭资源
			this.close();
		}
		
		return gb;
		
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
