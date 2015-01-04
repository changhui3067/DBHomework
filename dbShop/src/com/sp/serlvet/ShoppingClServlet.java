package com.sp.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;
public class ShoppingClServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		//得到type值，判断用户是要进行怎样的操作
		String type=request.getParameter("type");
		//解决多个购物车问题
		
		//1.先试图从session中取出一个购车车
		MyCartBO mbo=(MyCartBO)request.getSession().getAttribute("mycart");
		
		if(mbo==null){
			
			//说明该用户第一次购物
			//创建一个购物车，并放入sesion
			mbo=new MyCartBO();
			request.getSession().setAttribute("mycart", mbo);
		}
		
		if(type.equals("addGoods")){
		
		
		//获得要购物的货物的id
		String goodsId=request.getParameter("goodsId");
		
		//调用MyCartBO[购物车],完成购物
		//MyCartBO mbo=new MyCartBO();//?????这样会造成有多个购物车!!![现在，我们必须想办法，保证始终只有一个购物车 ] [session???]
		
		
		
		
		//默认购买是1本书，以后可以修改
		mbo.addGoods(goodsId, "1");
		
		
		}else if(type.equals("delGoods")){
			
			
			//得到要删除的货物的id
			String goodsId=request.getParameter("goodsId");
			
			//从购物车中删除(从session中)
			mbo.delGoods(goodsId);
		}else if(type.equals("show")){
			//do nothing
		}else if(type.equals("delAll")){
			
			mbo.clear();
		}else if(type.equals("updateGoods")){
			
			//用户希望修改数量
			
			//怎样在servlet中得到货物的id,和新的数量
			
			//接收货物id 
			
			String goodsId[]=request.getParameterValues("goodsId");
			String newNums[]=request.getParameterValues("newNums");
			
			//测试一下看看是否得到新的修改值
			for(int i=0;i<goodsId.length;i++){
				
				System.out.println("id==="+goodsId[i]+"  数量="+newNums[i]);
				//修改
				mbo.upGoods(goodsId[i], newNums[i]);
			}
			
			
			
		}
		
		
		//把购物车的货物取出，准备在下一个页面显示
		
		ArrayList al=mbo.showMyCart();
		
		//放入到request
		request.setAttribute("mycartinfo", al);
		//跳转到
		request.getRequestDispatcher("showMycart.jsp").forward(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
