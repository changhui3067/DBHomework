//这是一个BO(model)
//用于处理与购物相关的业务逻辑(可把它看做是一个购物车)
package com.sp.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class MyCartBO {

	//定义一个hashmap集合，用于存放书的id和书的数量
	
	HashMap<String,String> hm=new HashMap<String,String>();
	
//	定义一些变量[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
	
	//购物车的总价
	
	private float allPrice=0.0f;
	
	/**
	 * 返回总价
	 * @return
	 */
	public float getAllPrice(){
		
		return this.allPrice;
	}
	
	
	/**
	 * 根据id返回货物的数量
	 * @param goodsId:货物id
	 * @return 货物的数量
	 */
	
	
	public String getGoodsNumById(String goodsId){
		
		return (String)hm.get(goodsId);
	}
	
	//1.添加货物
	public void addGoods(String goodsId,String goodsNum){
		
		hm.put(goodsId, goodsNum);
	}
	
	//2.删除货物
	public void delGoods(String goodsId){
		
		hm.remove(goodsId);
	}
	
	
	//3.清空货物
	
	public void clear(){
		
		hm.clear();
	}
	
	//4.修改货物数量
	public void upGoods(String goodsId,String newNum){
		
		hm.put(goodsId, newNum);
	}
	
	//5.显示购物车(有点难)
	public ArrayList showMyCart(){
		
		//泛型jdk5.0
		ArrayList <GoodsBean> al=new ArrayList <GoodsBean>();
		
		try {
			
			//组织 sql
			
			String sql="select * from goods where goodsId in";//(1,4)
			
			//使用迭代器完成从hm中取出货物id的 要求(为了让大家听明了，我举一个简单案例)
			
			Iterator it=hm.keySet().iterator();
			
			String sub="(";
			while(it.hasNext()){
				
				//取出goodsId
				String goodsId=(String)it.next();
				//判断goodsId是不是最后id
				if(it.hasNext()){
				sub+=goodsId+",";
				}else{
					
					sub+=goodsId+")";
				}
			}
			
			sql+=sub;
			
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			//把总价清空
			this.allPrice=0.0f;
			while(rs.next()){
				
				
				GoodsBean gb=new GoodsBean();
				int goodsId=rs.getInt(1);
				gb.setGoodsId(goodsId);
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				float unit=rs.getFloat(4);
				gb.setGoodsPrice(unit);
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				
				this.allPrice=this.allPrice+unit*Integer.parseInt(this.getGoodsNumById(goodsId+""));
				
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
