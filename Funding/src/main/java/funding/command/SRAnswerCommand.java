package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;
import funding.dto.FDtoFundingReview;

public class SRAnswerCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FDaoS daoS = new FDaoS();
		System.out.println("command hello");
		ArrayList<FDtoFundingReview> dtosFR = daoS.FReview_list();
		request.setAttribute("FReview", dtosFR);
	}

}
