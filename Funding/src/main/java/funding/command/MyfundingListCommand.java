package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoC;
import funding.dto.FDtoFunding;

public class MyfundingListCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesstion = request.getSession();
		String id = (String) sesstion.getAttribute("customer_id");
		
		FDaoC dao = new FDaoC();
		ArrayList<FDtoFunding> list = dao.myfundinglist(id);
		
		request.setAttribute("funding", list);
	}

}
