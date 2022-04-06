package funding.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.command.ACListCommand;
import funding.command.ALoginCommand;
import funding.command.ALogoutCommand;
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
		case("/fundingLike.do"):
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
		case("/myfunding_list.do"):
			viewpage="";
			break;
		case("/myfunding_detail.do"):
			viewpage="";
			break;
		case("/myquestion_list.do"):
			viewpage="";
			break;
		case("/myquestion_detail.do"):
			viewpage="";
			break;
		case("/myinformation_view.do"):
			viewpage="";
			break;
		case("/myinfomation_modify.do"):
			viewpage="";
			break;
		case("/mysocial_view.do"):
			viewpage="";
			break;
		case("/mysocial_modify.do"):
			viewpage="";
			break;
		case("/mylike_list.do"):
			viewpage="";
			break;
		case("/mylike_movw.do"):
			viewpage="";
			break;
		}//customer
		
		//seller용 switch
		switch(path){
		case("/sFODetail.do"):
			viewpage="";
			break;
		case("/sFOApply.do"):
			viewpage="";
			break;
		case("/sQApply_detail.do"):
			viewpage="";
			break;
		case("/SFOApply.do"):
			viewpage="";
			break;
		case("/sMypage.do"):
			viewpage="";
			break;
		case("/sMFDetail.do"):
			viewpage="";
		break;
		case("/sMFManage.do"):
			viewpage="";
			break;
		case("/sMFCApply.do"):
			viewpage="";
			break;
		case("/sFADetail.do"):
			viewpage="";
			break;
		case("/sFAnswer.do"):
			viewpage="";
			break;
		case("/sRAnswer.do"):
			viewpage="";
			break;
		case("/sDManage.do"):
			viewpage="";
			break;
		}//seller
		
		//admin용 switch
		switch(path){
		case("/aLogin.do"):
			command = new ALoginCommand();
			command.execute(request, response);
			viewpage= (String) request.getAttribute("viewPage");
			break;
		case("/aLogout.do"):
			command = new ALogoutCommand();
			command.execute(request, response);
			viewpage="aLogin.jsp";
			break;
		case("/aCList.do"):
			command = new ACListCommand();
			command.execute(request, response);
			viewpage="aCList.jsp";
			break;
		case("/aCAWList.do"):
			viewpage="";
			break;	
		case("/aCADetail.do"):
			viewpage="";
			break;
		case("/aCApprove.do"):
			viewpage="";
			break;
		case("/aCReject.do"):
			viewpage="";
			break;
		case("/aSQWList.do"):
			viewpage="";
			break;
		case("/aSQDetail.do"):
			viewpage="";
			break;
		case("/aSQualify.do"):
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
		case("/aFApprove.do"):
			viewpage="";
			break;
		case("/aFreject.do"):
			viewpage="";
			break;
		case("/aSAList.do"):
			viewpage="";
			break;
		case("/aSAListDetail.do"):
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
		}//admin.
		
		RequestDispatcher rd = request.getRequestDispatcher(viewpage);
		rd.forward(request, response);
		
	}

}
