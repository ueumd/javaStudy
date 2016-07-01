package gz.my.response;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/MyResponse")
public class MyResponse extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		//设置响应头
		response.setStatus(200);
		response.setHeader("server", "JBoss");
		
		//设置实体内容 浏览能直接看到
		
		response.getWriter().write("01 Hello world");//字符内容
		//response.getOutputStream().write("02 Hello world".getBytes());//字节内容
		
	}
}
