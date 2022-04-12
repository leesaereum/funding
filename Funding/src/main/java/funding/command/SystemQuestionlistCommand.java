package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;
import funding.dto.FDtoSystemQuestion;

public class SystemQuestionlistCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FDaoC dao = new FDaoC();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int countQuestion = dao.countQuestion();
		ArrayList<FDtoSystemQuestion> list = dao.systemquestion_view(page);
		
		request.setAttribute("question", list);
		request.setAttribute("countQuestion", countQuestion);

	}

}
