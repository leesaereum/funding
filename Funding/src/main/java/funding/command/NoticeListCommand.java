package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;
import funding.dto.FDtoNotice;


public class NoticeListCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FDaoC dao = new FDaoC();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int countNotice = dao.countNotice();
		ArrayList<FDtoNotice> list = dao.notice_list(page);
		
		request.setAttribute("notice", list);
		request.setAttribute("countNotice", countNotice);
	}

}
