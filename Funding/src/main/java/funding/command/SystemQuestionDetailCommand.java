package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;
import funding.dto.FDtoSystemQuestion;

public class SystemQuestionDetailCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("question_num");
		FDaoC dao = new FDaoC();
		FDtoSystemQuestion detail = dao.systemquestion_detail(num);
		
		request.setAttribute("dto", detail);
	}

}
