package funding.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import funding.command.ACAWListCommand;
import funding.command.ACApproveCommand;
import funding.command.ACListCommand;
import funding.command.ACRejectCommand;
import funding.command.AFAWListCommand;
import funding.command.AFApproveCommand;
import funding.command.AFRejectCommand;
import funding.command.ALoginCommand;
import funding.command.ALogoutCommand;
import funding.command.ASQWListCommand;
import funding.command.ASQualifyCommand;
import funding.command.ASrejectCommand;
import funding.command.FCommand;
import funding.command.FindidCommand;
import funding.command.FindpwCommand;
import funding.command.FundingLikeCommand;
import funding.command.FundingListViewCommand;
import funding.command.FundingPaymentCommand;
import funding.command.FundingdetailCommand;
import funding.command.LoginCommand;
import funding.command.LogoutCommand;
import funding.command.MainCommand;
import funding.command.NoticeDetailCommand;
import funding.command.NoticeListCommand;
import funding.command.LoginCommand;
import funding.command.LogoutCommand;
import funding.command.MainCommand;
import funding.command.SFOApplyCommand;
import funding.command.SLoginCommand;
import funding.command.SLogoutCommand;
import funding.command.SMFDetailCommand;
import funding.command.SMFManageCommand;
import funding.command.SMypageCommand;
import funding.command.SQApplyCommand;
import funding.command.SSignUpCommand;
import funding.command.SearchCommand;
import funding.command.SignupCommand;

@WebServlet("*.do")
public class Fcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Fcontroller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actiondo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actiondo(request, response);
	}

	private void actiondo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		FCommand command = null;
		String uri = request.getRequestURI();
		String copath = request.getContextPath();
		String path = uri.substring(copath.length());
		String viewpage = null;

		// customer�슜 switch
		switch (path) {
		case ("/login.do"):
			command = new LoginCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;

		case ("/sociallogin.do"):
			command = new LogoutCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case ("/logout.do"):
			command = new LogoutCommand();
			command.execute(request, response);
			viewpage = "main.jsp";
			break;
		case ("/main.do"):
			command = new MainCommand();
			command.execute(request, response);
			viewpage = "main.jsp";
			break;
		case ("/signUp.do"):
			command = new SignupCommand();
			command.execute(request, response);
			viewpage = "/pages/login.jsp";
			break;
		case ("/findId_view.do"):
			viewpage = "/pages/findId_view.jsp";
			break;
		case ("/findId.do"):
			command = new FindidCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case ("/findPw_view.do"):
			viewpage = "/pages/findpw_view.jsp";
			break;
		case ("/findPw.do"):
			command = new FindpwCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case ("/funding_list_view.do"):
			command = new FundingListViewCommand();
			command.execute(request, response);
			viewpage = "/pages/funding_list_view.jsp";
			break;
		case ("/fundingSearch.do"):
			command = new SearchCommand();
			command.execute(request, response);
			viewpage = "/pages/funding_list_view.jsp";
		break;
		case("/fundingContent_view.do"):
			System.out.println(path);
			command = new FundingdetailCommand();
			command.execute(request, response);
			viewpage="/pages/detail.jsp";
			break;
		case("/fundingLike.do"):
			command = new FundingLikeCommand();
			command.execute(request, response);
			viewpage= "detailtest.jsp";
			break;
		case("/fundingOrder.do"):
			command = new FundingPaymentCommand();
			command.execute(request, response);
			viewpage="fundingOrder.jsp";
			break;
		case ("/fundingPayment_view.do"):
			viewpage = "";
			break;
		case ("/fundingPayment.do"):
			viewpage = "";
			break;
		case ("/fundingaddress.do"):
			viewpage = "";
			break;
		case ("/fundingQuestionList.do"):
			viewpage = "";
			break;
		case ("/fundingQuestion_view.do"):
			viewpage = "";
			break;
		case ("/fundingQuestion.do"):
			viewpage = "";
			break;
		case ("/fundingReview_list.do"):
			viewpage = "";
			break;
		case ("/fundingReview_view.do"):
			viewpage = "";
			break;
		case ("/fundingReview.do"):
			viewpage = "";
			break;
		case ("/systemQuestion_list.do"):
			viewpage = "";
			break;
		case ("/systemQuestion_view.do"):
			viewpage = "";
			break;
		case ("/systemQuestion.do"):
			viewpage = "";
			break;
		case ("/systemQuestion_detail.do"):
			viewpage = "";
			break;
		case ("/orderList.do"):
			viewpage = "";
			break;
		case ("/notice_list.do"):
			command = new NoticeListCommand();
			command.execute(request, response);
			viewpage = "/pages/notice.jsp";
			break;
		case ("/notice_detail.do"):
			command = new NoticeDetailCommand();
			command.execute(request, response);
			viewpage = "/pages/notice_detail.jsp";
			break;
		case ("/mypage.do"):
			viewpage = "/pages/mypage.jsp";
			break;
		case ("/myfunding_list.do"):
			viewpage = "";
			break;
		case ("/myfunding_detail.do"):
			viewpage = "";
			break;
		case ("/myquestion_list.do"):
			viewpage = "";
			break;
		case ("/myquestion_detail.do"):
			viewpage = "";
			break;
		case ("/myinformation_view.do"):
			viewpage = "";
			break;
		case ("/myinfomation_modify.do"):
			viewpage = "";
			break;
		case ("/mysocial_view.do"):
			viewpage = "";
			break;
		case ("/mysocial_modify.do"):
			viewpage = "";
			break;
		case ("/mylike_list.do"):
			viewpage = "";
			break;
		case ("/mylike_movw.do"):
			viewpage = "";
			break;
		}// customer

		// seller�슜 switch
		switch (path) {
		case ("/slogin.do"):
			command = new SLoginCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case ("/slogOut.do"):
			command = new SLogoutCommand();
			command.execute(request, response);
			viewpage = "slogin.jsp";
			break;
		case ("/ssignUp.do"):
			command = new SSignUpCommand();
			command.execute(request, response);
			viewpage = "slogin.jsp";
			break;
//		case("/sFODetail.do"):
//			viewpage="/pages/makeFunding.jsp";
//			break;
		case("/sFOApply.do"):
			command = new SFOApplyCommand();
			command.execute(request, response);
			viewpage="main.jsp";
			break;
		case ("/sQApply_detail.do"):
			viewpage = "";
		case("/sQApply_view.do"):
			command=new SQApplyCommand();
			command.execute(request, response);
			viewpage="sQApply_view.jsp";
			break;
		case("/sQApply.do"):
			viewpage="main.do";
			break;
//		case ("/SFOApply.do"):
//			viewpage = "";
//			break;
		case ("/sMypage.do"):
			command = new SMypageCommand();
			command.execute(request, response);
			viewpage = "sMypage.jsp";
		case ("/sMFManage.do"):
			command = new SMFManageCommand();
			command.execute(request, response);
			viewpage = "sMFManage.jsp";
			break;
		case ("/sMFDetail.do"):
			command = new SMFDetailCommand();
		command.execute(request, response);
		viewpage = "sMFDetail.jsp";
		break;
		case ("/sMFCApply.do"):
			viewpage = "sMFCApply.jsp";
			break;
		case ("/sFADetail.do"):
			viewpage = "";
			break;
		case ("/sFAnswer.do"):
			viewpage = "";
			break;
		case ("/sRAnswer.do"):
			viewpage = "";
			break;
		case ("/sDManage.do"):
			viewpage = "";
			break;
		}// seller

		// admin�슜 switch
		switch (path) {
		case ("/aLogin.do"):
			command = new ALoginCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewPage");
			break;
		case ("/aLogout.do"):
			command = new ALogoutCommand();
			command.execute(request, response);
			viewpage = "aLogin.jsp";
			break;
		case ("/aCList.do"):
			command = new ACListCommand();
			command.execute(request, response);
			viewpage = "aCList.jsp";
			break;

		case("/aCAWList.do"):
			command = new ACAWListCommand();
			command.execute(request, response);
			viewpage="aCAWList.jsp";
			break;
		case("/aCADetail.do"):
			viewpage="";
			break;
		case("/aCApprove.do"):
			command = new ACApproveCommand();
			command.execute(request, response);
			viewpage="aCAWList.do";
			break;
		case("/aCReject.do"):
			command = new ACRejectCommand();
			command.execute(request, response);
			viewpage="aCAWList.do";
			break;
		case ("/aSQWList.do"):
			command = new ASQWListCommand();
			command.execute(request, response);
			viewpage = "aSQWList.jsp";
			break;
		case ("/aSQDetail.do"):
			viewpage = "";
			break;
		case("/aSQualify.do"):
			command = new ASQualifyCommand();
			command.execute(request, response);
			viewpage="aSQWList.do";
			break;
		case("/aSreject.do"):
			command = new ASrejectCommand();
			command.execute(request, response);
			viewpage="aSQWList.do";
			break;
		case("/aFAWList.do"):
			command = new AFAWListCommand();
			command.execute(request, response);
			viewpage="aFAWList.jsp";
			break;
		case("/aFADetail.do"):
			viewpage="";
		break;
		case("/aFApprove.do"):
			command = new AFApproveCommand();
			command.execute(request, response);
			viewpage="aFAWList.do";
			break;
		case("/aFreject.do"):
			command = new AFRejectCommand();
			command.execute(request, response);
			viewpage="aFAWList.do";
			break;
		case ("/aSAList.do"):
			viewpage = "";
			break;
		case ("/aSAListDetail.do"):
			viewpage = "";
			break;
		case ("/aSACreate.do"):
			viewpage = "";
			break;
		case ("/aFList.do"):
			viewpage = "";
			break;
		case ("/aFDetail.do"):
			viewpage = "";
			break;
		case ("/aFstateChange.do"):
			viewpage = "";
			break;
		case ("/anotice_list.do"):
			viewpage = "";
			break;
		case ("/ncreate_view.do"):
			viewpage = "";
			break;
		case ("/ncreate.do"):
			viewpage = "";
			break;
		case ("/nmodify.do"):
			viewpage = "";
			break;
		case ("/nremove.do"):
			viewpage = "";
			break;
		}// admin.

		RequestDispatcher rd = request.getRequestDispatcher(viewpage);
		rd.forward(request, response);

	}

}
