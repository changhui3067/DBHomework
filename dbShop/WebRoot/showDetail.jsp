<%@ page language="java" import="java.util.*,com.sp.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//取出要显示的信息(goodsBean)
GoodsBean gb=(GoodsBean)request.getAttribute("goodsInfo");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	<script type="text/javascript">
	
	<!--
		//响应点击返回购物大厅的事件
		
		function returnHall(){
			
			//默认open函数，是打开一个新页面
			//如果在后面加入一个_self
			window.open("index.jsp","_self");
		}
		
		//响应点击购买货物的事件
		function addGoods(goodsId){
		
			
			//看看是否得到货物id
			//向ShoppingClServlet请求添加货物
			window.open("ShoppingClServlet?type=addGoods&goodsId="+goodsId,"_self");
		}
	
	-->
	</script>
  </head>
  
  <body topmargin="0" background="images/bg.bmp">
   <center>
   <table width="80%" class="abc" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table class="abc" width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td height="15" colspan="2">&nbsp;</td>
        </tr>
      <tr>
        <td width="25%" rowspan="8"><img src="images/<%=gb.getPhoto() %>" width="136" height="169" /></td>
        <td align="center"><%=gb.getGoodsName() %></td>
      </tr>
      <tr>
        <td>价格：¥<%=gb.getGoodsPrice() %></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>ISBN：<%=gb.getGoodsId() %></td>
      </tr>
      <tr>
        <td>类型：<%=gb.getType() %></td>
      </tr>
      <tr>
        <td>出版商：<%=gb.getPublisher() %></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="76" align="left" valign="top"><%=gb.getGoodsIntro() %></td>
      </tr>
      <tr>
        <td height="23" colspan="2"><input type="button" onclick="addGoods(<%=gb.getGoodsId() %>)" name="Submit" value="购买" />
          <input name="Submit2" type="button" onclick="returnHall();" value="返回购物大厅" /></td>
        </tr>
      <tr>
        <td height="15" colspan="2">&nbsp;</td>
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
