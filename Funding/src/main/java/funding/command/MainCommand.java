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
		String query = "";

		
		/*String sort = request.getParameter("sort");
		switch(sort) {
		case(""):
			break;
		}
		*/
		ArrayList<FDtoFunding> list = dao.mainlist(query);
		request.setAttribute("list", list);
		
	}

}
