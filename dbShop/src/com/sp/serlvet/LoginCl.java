package com.sp.serlvet;
import com.sp.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCl extends HttpServlet {

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
		
		
		//得到用户名和密码，验证用户是否合法
		
		String u=request.getParameter("username");
		
		String p=request.getParameter("password");
		
		//验证用户
		UserBeanBO ubb=new UserBeanBO();
		
		if(ubb.checkUser(u, p)){
			
			//用户合法
			
			//1.把成功登录的用户信息放入session【后面用到】
			
			UserBean ub=ubb.getUserBean(u);
			request.getSession().setAttribute("userInfo", ub);
			
			//2.把购物车的信息取出，准备下一个页面显示
			MyCartBO mcb=(MyCartBO)request.getSession().getAttribute("mycart");
			
			ArrayList al=mcb.showMyCart();
			
			//把al放入request
			request.setAttribute("mycartInfo", al);
			
			request.getRequestDispatcher("shopping3.jsp").forward(request, response);
		}else{
			
			//用户不合法
			
			request.getRequestDispatcher("shopping2.jsp").forward(request, response);
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
