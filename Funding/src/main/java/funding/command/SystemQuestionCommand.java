package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoC;
import funding.dto.FDtoSystemQuestion;

public class SystemQuestionCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = null;
		HttpSession session = request.getSession();
		String customer_id = (String) session.getAttribute("customer_id");
		String seller_id = (String) session.getAttribute("seller_id");
		if(customer_id == null) {
			id = seller_id;
		}
		else id = customer_id;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(id);
		System.out.println(title);
		System.out.println(content);
		FDaoC dao = new FDaoC();
		dao.create_systemQuestion(id, title, content);
	}

}
