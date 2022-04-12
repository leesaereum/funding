package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoA;

public class ASystemQAnswerInsertCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		
		String question_answer = request.getParameter("question_answer");
		String question_num =  request.getParameter("question_num");

		FDaoA daoA = new FDaoA();
		
		daoA.SystemQAnswerInsert(question_answer, question_num);
	}

}
