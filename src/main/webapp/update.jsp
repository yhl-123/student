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
    <title>编辑学生信息数据</title>
    <style type="text/css">
    a,b,big,body,dd,del,div,dl,dt,em,font,form,h1,h2,h3,h4,h5,h6,html,i,iframe,img,ins,label,li,ol,p,pre,small,span,strong,u,ul{margin:0;padding:0}
    .updata{font-size: 25px;color:orange;position:relative;top: 30px;left: 591px;}
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
   <div class="updata">
    	<p> 编辑学生信息</p>
    </div> 
    <br>
    <br>
    <br>
    <div align="center"><a href="${pageContext.request.contextPath }/queryServlet?currentPage=1">返回首页</a></div>
    <div align="center">
		<form action="${pageContext.request.contextPath }/addServlet?id=${requestScope.student.id }" method="post">
		
			<table width="50%" border="1" style="border-collapse: collapse;">
			
				<tr>
					<td>学生ID</td>
					<td><input type="text" name="id"  readonly="readonly" value="${requestScope.student.id}"></td>
				</tr>
				<tr>
					<td>学生姓名</td>
					<td><input type="text" name="name" value="${requestScope.student.name}"></td>
				</tr>
				<tr>
					<td>出生日期</td>
					<td><input type="text" name="birthday"  value="${requestScope.student.birthday}"></td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input type="text" name="description"  value="${requestScope.student.description}"></td>
				</tr>
				<tr>
					<td>平均分</td>
					<td><input type="text" name="avgscore"   value="${requestScope.student.avgscore}"></td>
				</tr>
				<tr align="center">
					<td>
						<input type="reset" value="重置数据">
					</td>
					<td>
						<input type="submit" value="保存编辑">
						
					</td>
					
				</tr>
			
				
			
			</table>
		</form>

  </body>
</html>
