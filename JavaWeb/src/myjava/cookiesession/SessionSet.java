package myjava.cookiesession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 1、第一次访问创建session对象，并给session对象分配一个维一的ID叫JSESSIONID
 * 2、JSESSIONID作为cookie的值发送给浏览器保存
 * 3、第二次访问的时候，浏览器带着SESSIONID的cookie访问服务器  Cookie:JSESSIONID=C3DF7295A01179B1843DA5012941D0F7
 * 4、服务器得到JSESSIONID，在服务的内存中搜索是否存放对应编号的session对象
 * 5、找到直接返回session对象
 * 6、找不到对应的编号，创建新session，继续走1的流程
 * 
 * getSession(true) 创建
 * getSession(false)得到
 * 
 * 
 * session销毁时间
 * 1、默认情况30分钟服务器自动回收
 * 2、修改session有效时间
 * 3、全局修改session有效时间 web.xml
 * 
 * 4、手动销毁
 * 
 */
@WebServlet("/SessionSet")
public class SessionSet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		
		//得到session编号
		System.out.println("id="+session.getId());
		
		session.setAttribute("username", "张在");
		
		//有效时间
		session.setMaxInactiveInterval(10);//10秒
		
		
	}

}
