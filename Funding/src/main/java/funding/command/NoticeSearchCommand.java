package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;
import funding.dto.FDtoNotice;

public class NoticeSearchCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("notice_search");
		FDaoC dao = new FDaoC();
		ArrayList<FDtoNotice> list = dao.notice_search(search);
		
		request.setAttribute("notice", list);
	}

}
