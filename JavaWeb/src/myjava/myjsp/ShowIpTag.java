package myjava.myjsp;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 标签处理类
 * @author Administrator
 * 类写好后要写.tld
 */
public class ShowIpTag extends SimpleTagSupport {
	/*
	 //接收
	private JspContext context;
	
	@Override
	public void setJspContext(JspContext pc){
		this.context=pc;
	}*/
	
	@Override
	public void doTag() throws JspException,IOException{
		//向浏览器输出IP地址
		//PageContext可以拿到8个JSP内置对象
		PageContext pageContext=(PageContext)this.getJspContext();
		
		HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
		
		String ip=request.getRemoteHost();
		
		JspWriter out=pageContext.getOut();
		out.write("使用自定义标签输出客户IP地址："+ip);
		
		/*JspFragment jspBody=this.getJspBody();
		jspBody.invoke(null);*/
		
		
	}
}
