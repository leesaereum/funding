package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoA;
import funding.dto.FDtoSeller;

public class ASQDetailCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		String sellerId = request.getParameter("sellerId");
		FDaoA daoA = new FDaoA();
		ArrayList<FDtoSeller> dtos = daoA.sellerdetail(sellerId);
		request.setAttribute("sellerdetail", dtos);
	}

}