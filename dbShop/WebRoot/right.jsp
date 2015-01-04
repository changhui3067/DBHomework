<%@ page language="java" import="java.util.*,com.sp.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//使用GoodsBeanBO ，完成分页(:大家也可走下serlvet)

GoodsBeanBO gbb=new GoodsBeanBO();

//接收pageNow
String s_pageNow=(String)request.getAttribute("abc");

int pageNow=1;
if(s_pageNow!=null){

	//string->int
	pageNow=Integer.parseInt(s_pageNow);
}
//默认显示第一页
ArrayList al=gbb.getGoodsByPage(6,pageNow);

//得到共有多少页
int pageCount=gbb.getPageCount(6);
%>

<table width="100%" border="1" cellpadding="0" cellspacing="0" class="abc">
  <tr>
    <td colspan="3" align="left"><img src="images/untitled.bmp" /></td>
  </tr>
  
  <%
  
  			
  			int time=0;
  			
  			for(int i=0;i<2;i++){
  			
  				//打印两大行(每行有三个【有可能不够显示!!】)
  				
  				%>
  				<tr>
  				<%
  				
  				//取出三个 al.size=3 time<=2
  				for(int j=0;j<3;j++){
  					
  					GoodsBean gb=new GoodsBean();
  					if(time>=al.size()){
  						
  						//不能再取
  						
  						//默认给一个goodsBean [荷花图片]
  						
  						gb.setGoodsId(0);
  						gb.setGoodsIntro("没有书了");
  						gb.setPhoto("none.jpg");
  						gb.setGoodsPrice(0.0f);
  						gb.setGoodsName("荷花图");
  						
  					}else{
  					
  					gb=(GoodsBean)al.get(time);
  					time++;
  					}
  					%>
  		<td width="33%" height="174" align="center"><table class="abc" width="100%" height="170" border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td width="32%" rowspan="3"><img src="images/<%=gb.getPhoto() %>" width="112" height="112" /></td>
        <td width="68%" height="51">&nbsp;</td>
      </tr>
      <tr>
        <td height="28" align="left" valign="top"><a href="ShowGoodsClServlet?type=showDetail&id=<%=gb.getGoodsId() %>"><%=gb.getGoodsName() %></a></td>
      </tr>
      <tr>
        <td height="27" align="left" valign="top">价格: $<%=gb.getGoodsPrice() %> </td>
      </tr>
      <tr>
        <td height="56" colspan="2" align="left" valign="top">简单介绍： <%=gb.getGoodsIntro() %> </td>
        </tr>
    </table></td>
  					<%
  				}
  			%>
  			</tr>
  			<%
  			
  			//判断是否第一大行结束
  			if(i==0){
  			
  				%>
  				<tr>
    <td colspan="3" height="10" align="center" bgcolor="#FFCCCC"></td>
  </tr>
  				<%
  			}
  			
  			}
   %>
 
  <tr>
    <td colspan="3" align="center">
    <%
    	for(int i=1;i<=pageCount;i++){
    		
    		%>
    		<a href="ShowGoodsClServlet?type=fenye&pageNow=<%=i %>">【<%=i %>】</a>
    		<%
    	}
    
     %>
    </td>
  </tr>
</table>