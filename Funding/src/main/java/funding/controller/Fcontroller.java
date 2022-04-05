package funding.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.command.FCommand;
import funding.command.FindidCommand;
import funding.command.FindpwCommand;
import funding.command.LoginCommand;
import funding.command.LogoutCommand;
import funding.command.MainCommand;
import funding.command.SignupCommand;

@WebServlet("*.do")
public class Fcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Fcontroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actiondo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actiondo(request, response);
	}

	private void actiondo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		FCommand command = null;
		String uri = request.getRequestURI();
		String copath = request.getContextPath();
		String path = uri.substring(copath.length());
		String viewpage = null;

		//customer용 switch
		switch(path){
		case("/login.do"):
			command = new LoginCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case("/sociallogin.do"):
			command = new LogoutCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case("/logOut.do"):
			command = new LogoutCommand();
			command.execute(request, response);
			viewpage="signIn.jsp";
			break;
		case("/main.do"):
			command = new MainCommand();
			command.execute(request, response);
			viewpage="main.jsp";
			break;
		case("/signUp.do"):
			command = new SignupCommand();
			command.execute(request, response);
			viewpage="/pages/login.jsp";
			break;
		case("/findId_view.do"):
			viewpage="findId_view.jsp";
			break;
		case("/findId.do"):
			command = new FindidCommand();
			command.execute(request, response);
			viewpage="signIn.jsp";
			break;
		case("/findPw_view.do"):
			viewpage="findPw_view.jsp";
			break;
		case("/findPw.do"):
			command = new FindpwCommand();
			command.execute(request, response);
			viewpage="signIn.jsp";
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
		case("/ssignUp_view.do"):
			viewpage="";
		break;
		case("/ssignUp.do"):
			command = new SignupCommand();
			command.execute(request, response);
			viewpage="ssignIn.jsp";
			break;
		case("/slogin.do"):
			command = new LoginCommand();
			command.execute(request, response);
			viewpage= "main.jsp";
			break;
		case("/slogOut.do"):
			command = new LogoutCommand();
			command.execute(request, response);
			viewpage="ssignIn.jsp";
			break;
			
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
			viewpage="";
		break;
		case("/aLogout.do"):
			viewpage="";
			break;
		case("/aCList.do"):
			viewpage="";
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
