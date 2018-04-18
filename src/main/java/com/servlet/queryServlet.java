package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Students;
import com.util.SerializationUtil;

import redis.clients.jedis.Jedis;

public class queryServlet extends HttpServlet {
	private Integer currentPage=1;//当前页
	private Integer max_page=10;//最大显示记录数
	private Integer totalPage;//末页数
	private Integer count;//总记录数
	private String ref=null;//当前记录

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//Jedis jedis =new Jedis("localhost",6379);
            Jedis jedis =new Jedis("172.18.214.100",6379);
		    jedis.auth("123456");
			String key = "user1"; 
			//获取存入的map对象
			 byte[] bs = jedis.get(key.getBytes());
			 Map<String,Students> map = (Map<String, Students>) SerializationUtil.deserialize(bs);
			 Iterator<Map.Entry<String, Students>> it = map.entrySet().iterator();
			  while (it.hasNext()) {
				  	Map.Entry<String, Students> entry = it.next();
			   		System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			   }
			  count=map.size();
			  if((count%max_page)==0){
				  totalPage=(count/max_page);
			  }else{
				  totalPage=(count/max_page)+1;
			  }
			  System.out.println(count);

			 if(currentPage!=null){
			      currentPage=Integer.valueOf(request.getParameter("currentPage"));
			      System.out.println("currentPage2"+currentPage);
			       if(currentPage<1){
					     currentPage=1;
					}if(currentPage>totalPage){
						currentPage=1;
			 }
		}
			 
			  Map<String,Students> newmap=new HashMap<String, Students>();
			  if(map.size()>max_page){
				  	
				  	for(int i=1;i<=max_page;i++){
				  			ref=String.valueOf(max_page*(currentPage-1)+i);
				  			newmap.put(ref, map.get(ref));
				  			System.out.println("newmap"+newmap);
				  	}
				  	
				  	request.setAttribute("map", newmap);
				  	System.out.println("走newmap");
				}else{
					request.setAttribute("map", map);
					System.out.println("走map");
				}
			  request.setAttribute("currentPage", currentPage);
			  request.setAttribute("totalPage", totalPage);
			  request.getRequestDispatcher("/list.jsp").forward(request, response);
		
			 }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
