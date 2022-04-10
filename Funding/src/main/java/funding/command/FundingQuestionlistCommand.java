package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;
import funding.dto.FDtoFundingQuestion;

public class FundingQuestionlistCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FDaoS daoS = new FDaoS();
		ArrayList<FDtoFundingQuestion> dtosFQ = daoS.list();
		request.setAttribute("FQlist", dtosFQ);
	}

}
