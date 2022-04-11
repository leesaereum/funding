package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;
import funding.dto.FDtoSystemQuestion;

public class SystemQuestionSearchCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("question_search");
		FDaoC dao = new FDaoC();
		ArrayList<FDtoSystemQuestion> list = dao.systemquestion_search(search);
		
		request.setAttribute("question", list);
	}

}
