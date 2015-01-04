<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 只把table引入即可 -->
<table width="101%" border="1" cellpadding="0" cellspacing="0" class="abc">
  <tr>
    <td height="10" colspan="3" bgcolor="#FFCCCC"></td>
  </tr>
  <tr>
    <td width="20%"><img src="images/logo.gif" width="128" height="49" /></td>
    <td width="65%"><img src="images/test.gif" width="500" height="90" /></td>
    <td width="15%">
    	<p><img src="images/account.gif" width="20" height="15" /><a href="shopping2.jsp">【我的账号】</a></p>
    	<p><img src="images/cart.gif" width="20" height="15" /><a href="ShoppingClServlet?type=show">【我的购物车】</a></p>
    </td>
  </tr>
  <tr>
    <td colspan="3" height="10" bgcolor="#FFCCCC"></td>
  </tr>
  <tr>
    <td colspan="3"><table width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">首页</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">香港电影</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">大陆电影</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">关于我们</td>
        <td width="11%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>