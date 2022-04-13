package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoC;

public class FundingQuestionCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String question_content = request.getParameter("question_content");
		String question_funding = request.getParameter("question_funding");
		FDaoC dao = new FDaoC();
		dao.question_create(question_funding, id, question_content);
		String viewpage = "fundingContent_view.do?fid="+question_funding+"&tab=3";
		request.setAttribute("viewpage", viewpage);
	}

}
