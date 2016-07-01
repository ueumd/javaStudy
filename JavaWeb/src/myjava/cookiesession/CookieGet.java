package myjava.cookiesession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieGet
 */
@WebServlet("/CookieGet")
public class CookieGet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取
			/*	
			String name1=cookie1.getName();
			String value1=cookie1.getValue();
			System.out.println(name1+":"+value1);
			*/
			
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
