package myjava.cookiesession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo1
 */
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建Cookie对象
		Cookie cookie1=new Cookie("city","ShangHai");
		Cookie cookie2=new Cookie("email","sh@qq.com");
		
		//发送cookie数据到浏览器
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
	
		//获取
		String name1=cookie1.getName();
		String value1=cookie1.getValue();
		System.out.println(name1+":"+value1);
		
		//获取所有cookie
		Cookie[] cookies=request.getCookies();
		
		if(cookies!=null){
			for(Cookie c:cookies){
				String name=c.getName();
				String value=c.getValue();
				
				System.out.println(name+": "+value);
			}
		}else{
			System.out.println("没有接收到cookie");
		}
		
		
	}

	

}
