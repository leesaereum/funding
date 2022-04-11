package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;
import funding.dto.FDtoFundingQuestion;

public class SFAnswerCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String num = request.getParameter("question_num");
		FDaoS daoS = new FDaoS();
		
		String answer = request.getParameter("answer_content");
		System.out.println("answercontent" + answer);
		daoS.FAnswer_Update(num, answer);
	}

}
