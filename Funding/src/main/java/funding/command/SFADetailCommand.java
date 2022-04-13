package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;
import funding.dto.FDtoFundingQuestion;

public class SFADetailCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question_num = request.getParameter("question_num");
		FDaoS daoS = new FDaoS();
		FDtoFundingQuestion dtosFQ = daoS.FQuestion_list(question_num);
		request.setAttribute("FAnswer_detail", dtosFQ);
	}

}
