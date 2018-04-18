package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.entity.Students;
import com.util.SerializationUtil;

import redis.clients.jedis.Jedis;

public class addServlet extends HttpServlet {

	private static Map<String,Students> student=new HashMap<String,Students>();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//Jedis jedis =new Jedis("localhost",6379);
		 Jedis jedis =new Jedis("172.18.214.100",6379);
		    jedis.auth("123456");
		Students students=new Students();
		
		students.setId(request.getParameter("id"));
		students.setName(request.getParameter("name"));
		students.setBirthday(request.getParameter("birthday"));
		students.setDescription(request.getParameter("description"));
		students.setAvgscore(request.getParameter("avgscore"));
		student.put(request.getParameter("id"), students);
		String key = "user1"; 
		jedis.set(key.getBytes(), SerializationUtil.serialize(student));
	//	response.getWriter().write("添加成功！3秒钟跳到回到主页");  
        //设置3秒钟跳转  
        //response.setHeader("refresh", "3;url="+request.getContextPath()+"/queryServlet"); 
        getServletConfig().getServletContext().getRequestDispatcher("/queryServlet?currentPage=1").forward(request, response);
	      
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
