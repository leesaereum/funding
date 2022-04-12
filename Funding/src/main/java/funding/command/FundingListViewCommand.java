package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;
import funding.dto.FDtoFunding;
import funding.dto.FDtoSystemQuestion;

public class FundingListViewCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FDaoC dao = new FDaoC();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int countFunding = dao.countFunding();
		ArrayList<FDtoFunding> list = dao.fundinglistview(page);
		
		request.setAttribute("funding", list);
		request.setAttribute("countQuestion", countFunding);
	}

}
