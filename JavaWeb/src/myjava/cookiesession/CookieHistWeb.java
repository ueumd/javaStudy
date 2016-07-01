package myjava.cookiesession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HistWeb
 */
@WebServlet("/CookieHistWeb")
public class CookieHistWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String curTime=format.format(new Date());
		
		Cookie[] cookies=request.getCookies();
		String lastTime=null;
		//第N次访问
		if(cookies!=null){
			for(Cookie c:cookies){
				if(c.getName().equals("lastTime")){//如果有lastTime表示已经访问过
					lastTime=c.getValue();//上次访问的时间
					
					response.getWriter().write("欢迎回你  上次访问网站时间是："+lastTime+" &nbsp;&nbsp;&nbsp;&nbsp;当前时间是："+curTime);
					
					//更新cookie
					c.setValue(curTime);
					response.addCookie(c);
					break;
				}
			}
		}
		
		
		//第一次访问
		if(cookies==null && lastTime==null){
			response.getWriter().write("你是首次访问网站 当前时间是："+curTime);
			Cookie ck=new Cookie("lastTime",curTime);
			response.addCookie(ck);
		}
	}

}
