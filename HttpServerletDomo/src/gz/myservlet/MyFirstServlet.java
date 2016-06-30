package gz.myservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */

@WebServlet("/MyFirstServlet") //加上此句就不用在web.xml里配置了
public class MyFirstServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public MyFirstServlet(){
		super();
	}
	/*
	 1、tomcat服务器接收到浏览器发送的请求数据，然后封装到HttpServetRequest对象
	 2、tomcat服务器调用doGet方法，然后把request对象传入到servlet中。
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		response.getWriter().write("this is my first serlvet");
	}
}
