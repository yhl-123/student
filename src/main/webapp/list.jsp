<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入jstl核心标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <style type="text/css">
    a,b,big,body,dd,del,div,dl,dt,em,font,form,h1,h2,h3,h4,h5,h6,html,i,iframe,img,ins,label,li,ol,p,pre,small,span,strong,u,ul{margin:0;padding:0}
.list{font-size: 30px;color:blue;position:relative;top: 30px;left: 591px;}
   </style>
  <head>
    
    <title>学生信息数据</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    <div class="list">
    	<p> 学生管理系统</p>
    </div>                                   
  	<br>
    <br>
    <br>
  	<table border="1" width="80%" align="center" cellpadding="5" cellspacing="0">
  		<tr>
  			
  			<td>学生ID</td>
  			<td>学生姓名</td>
  			<td>出生日期</td>
  			<td>备注</td>
  			<td>平均分</td>
  			<td>操作</td>
  		</tr>
  		<!-- 迭代数据 -->
  		<c:choose>
  			<c:when test="${not empty requestScope.map}">
  				<c:forEach var="emp" items="${requestScope.map}" varStatus="vs">
  					<tr>
  						<td>${emp.value.id }</td>
  						<td>${emp.value.name }</td>
  						<td>${emp.value.birthday }</td>
  						<td>${emp.value.description }</td>
  						<td>${emp.value.avgscore }</td>
  						<td><a href="${pageContext.request.contextPath }/updateServlet?id=${emp.value.id }" >编辑</a>
  						<a href="${pageContext.request.contextPath }/deleteServlet?id=${emp.value.id }">删除</a></td>
  					</tr>
  				</c:forEach>
  			</c:when>
  			<c:otherwise>
  				<tr>
  					<td colspan="6" align="center">对不起，当前并无学生信息数据。</td>
  				</tr>
  			</c:otherwise>
  		</c:choose>
  		
  		<tr>
  			<td colspan="6" align="center">
  				当前${requestScope.currentPage }/${requestScope.totalPage }页     &nbsp;&nbsp;
  				
  				<a href="${pageContext.request.contextPath }/queryServlet?currentPage=1">首页</a>
  				<a href="${pageContext.request.contextPath }/queryServlet?currentPage=${requestScope.currentPage-1}">上一页 </a>
  				<a href="${pageContext.request.contextPath }/queryServlet?currentPage=${requestScope.currentPage+1}">下一页 </a>
  				<a href="${pageContext.request.contextPath }/queryServlet?currentPage=${requestScope.totalPage}">末页</a>  &nbsp;&nbsp;&nbsp;&nbsp;
                         跳转至<input id='pages' name='pages' type='text' size='1'></input>页  <input type='button' value='确定' onclick='page_separate(-5)'></input>
  			</td>
  		</tr>
  	</table>
  	<br>
  	<br>
  	<div align="right" ><a href="${pageContext.request.contextPath }/add.jsp"  >添加学生信息</a></div>
  </body>
</html>









