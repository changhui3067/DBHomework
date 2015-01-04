package com.sp.serlvet;
import com.sp.model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShoppingCl2 extends HttpServlet {

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
		//处理乱码
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//这个控制器，用于去检测用户是否登录过，如果没有登录就进入登录界面
		//如果登录过，就直接进入显示用户信息和购物车情况的页面
		
		//1看看session中是否有用户登录的信息
		
		UserBean ub=(UserBean)request.getSession().getAttribute("userInfo");
		
		if(ub==null){
			
			//说明用户没有登录过
			//就跳转到shopping2.jsp,
			request.getRequestDispatcher("shopping2.jsp").forward(request, response);
			
		}else{
			//说明登录过
			//就跳转到shopping3.jsp
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
