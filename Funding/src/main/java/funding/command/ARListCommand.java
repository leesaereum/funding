package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoA;
import funding.dto.FDtoC;

public class ARListCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		String queryName =request.getParameter("query");
		String queryContent =request.getParameter("lContent");
		System.out.println(queryName);
		System.out.println(queryContent);
		
		FDaoA daoA = new FDaoA();
		
		//판매자 승인 대기 리스트
		//ArrayList<FDtoC> dtos = daoA.clist(adminId);
		
		//펀딩 승인 대기 리스트
		ArrayList<FDtoC> dtos = daoA.clist(adminId);
		
		//정산 승인 대기 리스트
		//ArrayList<FDtoC> dtos = daoA.clist(adminId);
		request.setAttribute("clist", dtos);
		
		
		

	}

}
