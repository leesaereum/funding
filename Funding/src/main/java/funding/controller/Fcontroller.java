package funding.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.command.FCommand;

@WebServlet("/Fcontroller")
public class Fcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Fcontroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		actiondo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actiondo(request, response);
	}

	private void actiondo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FCommand command = null;
		String uri = request.getRequestURI();
		String copath = request.getContextPath();
		String path = uri.substring(copath.length());
		String viewpage = null;
		
		//customer용 switch
		switch(path){
		case("/logIn.do"):
			viewpage="";
			break;
		case("/logOut.do"):
			viewpage="";
			break;
		case("/main.do"):
			viewpage="";
			break;
		case("/signUp_view.do"):
			viewpage="";
			break;
		case("/signUp.do"):
			viewpage="";
			break;
		case("/findId_view.do"):
			viewpage="";
			break;
		case("/findId.do"):
			viewpage="";
			break;
		case("/findPw_view.do"):
			viewpage="";
			break;
		case("/findPw.do"):
			viewpage="";
			break;
		case("/finding_list.do"):
			viewpage="";
			break;
		case("/fundingContent_view.do"):
			viewpage="";
			break;
		case("/fundingOrder_view.do"):
			viewpage="";
			break;
		case("/fundigOrder.do"):
			viewpage="";
			break;
		case("/fundingPayment_view.do"):
			viewpage="";
		break;
		case("/fundingPayment.do"):
			viewpage="";
		break;
		case("/fundingaddress.do"):
			viewpage="";
		break;
		case("/fundingQuestionList.do"):
			viewpage="";
		break;
		case("/fundingQuestion_view.do"):
			viewpage="";
			break;
		case("/fundingQuestion.do"):
			viewpage="";
			break;
		case("/fundingReview_list.do"):
			viewpage="";
			break;
		case("/fundingReview_view.do"):
			viewpage="";
			break;
		case("/fundingReview.do"):
			viewpage="";
			break;
		case("/systemQuestion_list.do"):
			viewpage="";
			break;
		case("/systemQuestion_view.do"):
			viewpage="";
			break;
		case("/systemQuestion.do"):
			viewpage="";
			break;
		case("/systemQuestion_detail.do"):
			viewpage="";
			break;
		case("/fundingSearch_view.do"):
			viewpage="";
			break;
		case("/fundingSearch.do"):
			viewpage="";
			break;
		case("/orderList.do"):
			viewpage="";
			break;
		case("/notice_list.do"):
			viewpage="";
			break;
		case("/notice_detail.do"):
			viewpage="";
			break;
		case("/mypage.do"):
			viewpage="";
			break;
		case("/myfunding.do"):
			viewpage="";
			break;
		}//customer
		
		//seller용 switch
		switch(path){
		case("/.do"):
			viewpage="";
			break;
		}//seller
		
		//admin용 switch
		switch(path){
		case("/aLogin.do"):
			viewpage="";
		break;
		case("/aLogout.do"):
			viewpage="";
			break;
		case("/aSAList.do"):
			viewpage="";
			break;
		case("/aSACreate.do"):
			viewpage="";
			break;
		case("/aFList.do"):
			viewpage="";
			break;
		case("/aFDetail.do"):
			viewpage="";
			break;
		case("/aFstateChange.do"):
			viewpage="";
			break;
		case("/notice_list.do"):
			viewpage="";
			break;
		case("/ncreate_view.do"):
			viewpage="";
			break;
		case("/ncreate.do"):
			viewpage="";
			break;
		case("/nmodify.do"):
			viewpage="";
			break;
		case("/nremove.do"):
			viewpage="";
			break;
		case("/aSreject.do"):
			viewpage="";
			break;
		case("/aFAWList.do"):
			viewpage="";
			break;
		case("/aFADetail.do"):
			viewpage="";
			break;
		case("/.do"):
			viewpage="";
			break;
		}//admin
		
		RequestDispatcher rd = request.getRequestDispatcher(viewpage);
		rd.forward(request, response);
		
	}

}
