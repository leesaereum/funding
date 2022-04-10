package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoC;
import funding.dto.FDtoSystemQuestion;

public class MyquestionListCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesstion = request.getSession();
		String id = (String) sesstion.getAttribute("customer_id");
		FDaoC dao = new FDaoC();
		ArrayList<FDtoSystemQuestion> list = dao.myquestion_list(id);
		request.setAttribute("question", list);
	}

}
