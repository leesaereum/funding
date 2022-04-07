package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;
import funding.dto.FDtoFunding;

public class SearchCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String search = request.getParameter("funding_search");
		FDaoC dao = new FDaoC();
		ArrayList<FDtoFunding> list = dao.fundingsearch(search);
		request.setAttribute("funding", list);
	}

}
