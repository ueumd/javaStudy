package myjava.cookiesession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionGet")
public class SessionGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession(false);
		
		if(session==null){
			System.out.println("没有找到session");
		}else{
			//得到session编号
			System.out.println("id="+session.getId());
			
			String username=(String)session.getAttribute("username");
			System.out.println("username:"+username);
			
			//手动销毁
			session.invalidate();
			
		}
		
	
	}

}
