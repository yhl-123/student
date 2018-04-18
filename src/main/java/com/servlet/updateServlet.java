package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Students;
import com.util.SerializationUtil;

import redis.clients.jedis.Jedis;

public class updateServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//Jedis jedis =new Jedis("localhost",6379);
		String id=request.getParameter("id");
		String key = "user1"; 
		Jedis jedis =new Jedis("172.18.214.100",6379);
		jedis.auth("123456");
		 byte[] bs = jedis.get(key.getBytes());
		 Map<String,Students> map = (Map<String, Students>) SerializationUtil.deserialize(bs);
		Students student=map.get(id);
		request.setAttribute("student", student);

	System.out.println("编辑"+student);
        //设置3秒钟跳转  
       // response.setHeader("refresh", "3;url="+request.getContextPath()+"/queryServlet"); 
	
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	
}
