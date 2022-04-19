package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoS;
import funding.dto.FDtoCalculate;

public class SMFCApplyDetailCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String seller = (String) session.getAttribute("id");
		String fNum = request.getParameter("calculate_funding");
		
		FDaoS daoS = new FDaoS();
		
		FDtoCalculate dtos = daoS.list(fNum, seller);
		request.setAttribute("list", dtos);
		request.setAttribute("fNum", fNum);

	}

}
