<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入jstl核心标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>学生信息数据添加</title>
    <style type="text/css">
    a,b,big,body,dd,del,div,dl,dt,em,font,form,h1,h2,h3,h4,h5,h6,html,i,iframe,img,ins,label,li,ol,p,pre,small,span,strong,u,ul{margin:0;padding:0}
    .add{font-size: 25px;color:red;position:relative;top: 30px;left: 591px;}
    </style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="add">
    	<p> 添加学生信息</p>
    </div> 
    <br>
    <br>
    <br>
    <div align="center"><a href="${pageContext.request.contextPath }/queryServlet?currentPage=1">返回首页</a></div>
    <div align="center">
		<form action="${pageContext.request.contextPath }/addServlet" method="post">
		
			<table width="50%" border="1" style="border-collapse: collapse;">
			
				<tr>
					<td>学生ID</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>学生姓名</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>出生日期</td>
					<td><input type="text" name="birthday"></td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input type="text" name="description"></td>
				</tr>
				<tr>
					<td>平均分</td>
					<td><input type="text" name="avgscore"></td>
				</tr>
				<tr align="center">
					<td>
						<input type="reset" value="重置数据">
					</td>
					<td>
						<input type="submit" value="提交数据">
						
					</td>
					
				</tr>
			</table>
		</form>

  </body>
</html>
