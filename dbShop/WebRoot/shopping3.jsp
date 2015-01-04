<%@ page language="java" import="java.util.*,com.sp.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//得到用户信息
UserBean ub=(UserBean)session.getAttribute("userInfo");
//得到购物车的内容
ArrayList al=(ArrayList)request.getAttribute("mycartInfo");

//得到购物车
MyCartBO mcb=(MyCartBO)session.getAttribute("mycart");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shopping3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	

  </head>
  
  <body topmargin="0" background="images/bg.bmp">
    <center>
    <table width="80%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td align="center"><img src="images/cartnavi-3.gif" width="599" height="49" /></td>
      </tr>
      <tr>
        <td align="center"><table width="70%" border="1" cellpadding="0" cellspacing="0" class="abc">
          <tr>
            <td colspan="2" align="center">购买人的信息</td>
            </tr>
          <tr>
            <td width="50%" align="right">用 户 名：</td>
            <td width="50%"><input type="text" name="textfield" value="<%=ub.getUsername() %>" /></td>
          </tr>
          <tr>
            <td align="right">*真实姓名：</td>
            <td><input type="text" name="textfield2" value="<%=ub.getTruename() %>" /></td>
          </tr>
          <tr>
            <td align="right">*家庭住址：</td>
            <td><input type="text" name="textfield3" value="<%=ub.getAddress() %>" /></td>
          </tr>
          <tr>
            <td align="right">*联系电话：</td>
            <td><input type="text" name="textfield4" value="<%=ub.getPhone() %>" /></td>
          </tr>
          <tr>
            <td align="right">*电子邮件：</td>
            <td><input type="text" name="textfield5" value="<%=ub.getEmail() %>" /></td>
          </tr>
          <tr>
            <td align="right">*邮　　编：</td>
            <td><input type="text" name="textfield6" value="<%=ub.getPostcode() %>" /></td>
          </tr>
          <tr>
            <td align="right"><input type="submit" name="Submit" value="完成订单" /></td>
            <td><input type="submit" name="Submit2" value="修改个人信息" /></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center"><table width="70%" border="1" cellpadding="0" cellspacing="0" class="abc">
          <tr>
            <td colspan="4" align="center">我的购物车情况</td>
            </tr>
          <tr>
            <td align="center">编号</td>
            <td align="center">商品名称</td>
            <td>单价</td>
            <td>数量</td>
          </tr>
          <%
          //循环显示购物车的内容
          	for(int i=0;i<al.size();i++){
          		GoodsBean gb=(GoodsBean)al.get(i);
          		%>
          		<tr>
            <td align="center"><%=gb.getGoodsId() %></td>
            <td align="center"><%=gb.getGoodsName() %></td>
            <td><%=gb.getGoodsPrice() %></td>
            <td><%=mcb.getGoodsNumById(gb.getGoodsId()+"") %></td>
          </tr>
          		<%
          	}
           %>
          <tr>
            <td colspan="4">您共选择了价值¥<%=mcb.getAllPrice() %>的商品。</td>
            </tr>
          <tr>
            <td colspan="4" align="center"><input type="submit" name="Submit3" value="返回修改我的购物车" /></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td align="right"><img src="images/cartpre.gif" width="87" height="19" /><a href="OrderClServlet"><img border="0" src="images/cartnext.gif" width="87" height="19" /></a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
    <jsp:include flush="true" page="tail.jsp"></jsp:include>
    </td>
  </tr>
</table>
    </center>
  </body>
</html>
