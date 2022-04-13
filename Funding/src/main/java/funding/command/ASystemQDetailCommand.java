package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoA;
import funding.dto.FDtoSystemQuestion;

public class ASystemQDetailCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		String question_num = request.getParameter("question_num");
		FDaoA daoA = new FDaoA();
		ArrayList<FDtoSystemQuestion> dtos = daoA.SystemQuestionDetail(question_num);
		
		request.setAttribute("system_question_detail", dtos);
	}
		
	}
	
	


