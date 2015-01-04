package com.sp.serlvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;
public class OrderClServlet extends HttpServlet {

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
		
		//处理完成订单(把订单写入数据库)
		//该任务将会交给OrderBeanBO
		
		OrderBeanBO obb=new OrderBeanBO();
		
		//得到购物车
		MyCartBO mcb=(MyCartBO)request.getSession().getAttribute("mycart");
		//用户id
		long userId=((UserBean)request.getSession().getAttribute("userInfo")).getUserid();
		OrderInfoBean oib=obb.addOrder(mcb, userId+"");
		if(oib!=null){
			
			//添加ok
			//准备显示订单的详细信息的数据,给下个页面shopping4.jsp
			
			request.setAttribute("detailbean", oib);
			request.getRequestDispatcher("shopping4.jsp").forward(request, response);
		}else{
			//添加订单失败
			request.getRequestDispatcher("shopping3.jsp").forward(request, response);
		}
		
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
