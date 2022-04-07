package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;

public class FindidCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name").trim();
		String phone = request.getParameter("phone1").trim()+"-"+request.getParameter("phone2").trim()+
				"-"+request.getParameter("phone3").trim();
		FDaoC dao = new FDaoC();
		String customer_id = dao.findId(name, phone);
		if(customer_id!=null) {
			request.setAttribute("customer_id", customer_id);
			request.setAttribute("customer_name", name);
			request.setAttribute("viewpage", "/pages/findId.jsp");
			
		}else request.setAttribute("viewpage", "/pages/findId_view.jsp?error=error");
	}

}
