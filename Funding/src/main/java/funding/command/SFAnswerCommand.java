package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoS;
import funding.dto.FDtoFundingQuestion;

public class SFAnswerCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Object num = session.getAttribute("question_num");
		String q_num = (String)num;
		FDaoS daoS = new FDaoS();
		
		String answer = request.getParameter("question_answer");
		System.out.println("answercontent" + answer);
		//FDtoFundingQuestion dtoFA = daoS.FAnswer_detail(q_num);
		//request.setAttribute("FAnswer_detail",dtoFA);
		
		daoS.FAnswer_Update(q_num, answer);
	}

}
