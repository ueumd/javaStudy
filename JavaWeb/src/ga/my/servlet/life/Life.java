package ga.my.servlet.life;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Life")
public class Life extends HttpServlet {
	/*
	 * servlet生命周期 4步
	 * 
	 * 
	 * 
	 * */
	
	public Life(){
		System.out.println("1、servlet对象被创建了");
	}
	
	@Override
	public void init(){
		System.out.println("2、init方法被调用");
	}
	
	@Override
	public void service(ServletRequest req,ServletResponse res){
		System.out.println("3、service方法被调用");
	}
	@Override
	public void destroy(){
		System.out.println("4、servlet对象销毁了");
	}
}
