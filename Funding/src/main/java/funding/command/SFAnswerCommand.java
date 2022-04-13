package funding.command;

import java.io.IOException;
import java.util.ArrayList;

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
		String answer_content = request.getParameter("answer_content");
		String question_num = request.getParameter("question_num");
		
		FDaoS dao = new FDaoS();
		dao.FAnswer_Update(question_num, answer_content);
		
		String viewpage = "sFADetail.do?question_num="+question_num;
		request.setAttribute("viewpage", viewpage);
	}

}
