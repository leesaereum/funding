package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;
import funding.dto.FDtoFunding;

public class MainCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FDaoC dao = new FDaoC();
		String query = null;
		String sort = request.getParameter("sort");
		if(request.getParameter("sort")==null) sort = "all";
		switch(sort) {
		case(""):
			query = "where funding_state = '진행'";
			break;
		case("all"):
			query = "where funding_state = '진행'";
		break;
		case("hits"):
			query = "where funding_state = '진행' order by funding_hits desc";
			break;
		case("achievement"):
			query = "where funding_state = '진행' order by achievement desc";
		break;
		case("closeAt"):
			query = "where funding_state = '진행' order by funding_closeAt";
		break;
		case("end"):
			query = "where funding_state != '진행'";
		break;
		}
		
		ArrayList<FDtoFunding> list = dao.mainlist(query);
		request.setAttribute("list", list);
	}

}
