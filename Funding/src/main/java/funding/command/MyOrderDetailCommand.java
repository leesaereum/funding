package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoC;
import funding.dto.FDtoFunding;
import funding.dto.FDtoOrder;

public class MyOrderDetailCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String funding_num = request.getParameter("funding_num");
		FDaoC dao = new FDaoC();
		FDtoFunding dto = dao.myorder_funding(funding_num);
		ArrayList<FDtoOrder> list = dao.myorder_ordering(funding_num, id);
		
		request.setAttribute("funding", dto);
		request.setAttribute("ordering", list);
	}

}
