package gz.my.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyRequestDemo
 */
@WebServlet("/MyRequestDemo")
public class MyRequestDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		
		//从request对象取出请求数据
		t1(request);
		
		//请求头
		t2(request);
		
	}

	private void t2(HttpServletRequest request) {
		String host=request.getHeader("Host");
		System.out.println("Host："+host);//请求方法
		Enumeration<String> enums=request.getHeaderNames();
		while(enums.hasMoreElements()){
			String headerName=enums.nextElement();
			String headerValue=request.getHeader(headerName);
			System.out.println(headerName+":"+headerValue);
		}
	}

	private void t1(HttpServletRequest request) {
		System.out.println("请求方式："+request.getMethod());//请求方法
		System.out.println("URI："+request.getRequestURI());//请求资源
		System.out.println("URL："+request.getRequestURL());//请求资源
		System.out.println("http协议："+request.getProtocol());//http协议
	}
	

}
