package myjava.cookiesession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie局限
 * 1、只能是字符串类型，不能存对象
 * 2、只能非中文
 * 3、1个cookie的容量不超过4KB
 */
@WebServlet("/CookieSet")
public class CookieSet extends HttpServlet {
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建Cookie对象 每个站点20个 size=>4kb
		Cookie cookie1=new Cookie("city","ShangHai");
		
		cookie1.setMaxAge(0);//删除cookie
		
		Cookie cookie2=new Cookie("email","sh@qq.com");
		
		//发送cookie数据到浏览器
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		//时间
		cookie1.setMaxAge(-1);//浏览器关闭cookie失效
		cookie2.setMaxAge(-1);
		
	}

	

}
