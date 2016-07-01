package myjava.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/MyResponse")
public class MyResponse extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("<h1>这里是上海</h1>");
		
		//设置响应头
		response.setStatus(200);
		response.setHeader("server", "JBoss");
		
		//设置实体内容 浏览能直接看到
		
		response.getWriter().write("这里是上海");//字符内容
		//response.getOutputStream().write("02 Hello world".getBytes());//字节内容
		
		//请求重定向写法
		//response.sendRedirect("/HttpServerletDomo/adv.html");
		
		//定时刷新 每隔5秒刷新一次
		//response.setHeader("refresh","5;url=/HttpServerletDomo/adv.html");
		
	}
}
