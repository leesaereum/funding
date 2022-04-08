package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoA;
import funding.dto.FDtoFunding;
import funding.dto.FDtoSeller;

public class AFAWListCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		FDaoA daoA = new FDaoA();
		ArrayList<FDtoFunding> dtos = daoA.fapprovewaitlist();
		request.setAttribute("fapprovewaitlist", dtos);
	
	}

}
