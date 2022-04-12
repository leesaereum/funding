package funding.command;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoC;
import funding.dao.FDaoS;
import funding.dto.FDtoFunding;
import funding.dto.FDtoSystemQuestion;

public class SMypageCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		FDaoS daoS = new FDaoS();
		FDaoC dao = new FDaoC();
		ArrayList<FDtoFunding> myopenlist = daoS.Mfunding_list(id);
		ArrayList<FDtoFunding> myfundinglist = dao.myfundinglist(id);		
		ArrayList<FDtoFunding> mylikelist = dao.mylikelist(id);
		ArrayList<FDtoSystemQuestion> myquestionlist = dao.myquestion_list(id);
		
		request.setAttribute("funding", myfundinglist);
		request.setAttribute("like", mylikelist);
		request.setAttribute("question", myquestionlist);
		request.setAttribute("Mfunding", myopenlist);
	}
}
