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

public class deleteServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    //Jedis jedis =new Jedis("localhost",6379);
		 Jedis jedis =new Jedis("172.18.214.100",6379);
		    jedis.auth("123456");
			String id=request.getParameter("id");
			String key = "user1"; 
			response.setContentType("text/html;charset=UTF-8");
			 byte[] bs = jedis.get(key.getBytes());
			 
			 Map<String,Students> map = (Map<String, Students>) SerializationUtil.deserialize(bs);
			 map.remove(id);
			 jedis.set(key.getBytes(), SerializationUtil.serialize(map));
			 //response.getWriter().write("删除成功！3秒钟跳到回到主页");  
		        //设置3秒钟跳转  
		       // response.setHeader("refresh", "3;url="+request.getContextPath()+"/queryServlet"); 
			 getServletConfig().getServletContext().getRequestDispatcher("/queryServlet?currentPage=1").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}
}


