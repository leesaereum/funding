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
import funding.command.AFADetailCommand;
import funding.command.AFAWListCommand;
import funding.command.AFApproveCommand;
import funding.command.AFListCommand;
import funding.command.AFRejectCommand;
import funding.command.ALoginCommand;
import funding.command.ALogoutCommand;
import funding.command.ANContentCommand;
import funding.command.ANCreateCommand;
import funding.command.ANListCommand;
import funding.command.ANModifyCommand;
import funding.command.ANRemoveCommand;
import funding.command.ASQDetailCommand;
import funding.command.ASQWListCommand;
import funding.command.ASQualifyCommand;
import funding.command.ASrejectCommand;
import funding.command.ASystemQAnswerInsertCommand;
import funding.command.ASystemQDetailCommand;
import funding.command.ASystemQuestionRemoveCommand;
import funding.command.FCommand;
import funding.command.FindidCommand;
import funding.command.FindpwCommand;
import funding.command.FundingLikeCommand;
import funding.command.FundingListViewCommand;
import funding.command.FundingPaymentCommand;
import funding.command.FundingQuestionCommand;
import funding.command.FundingUnlikeCommand;
import funding.command.FundingdetailCommand;
import funding.command.LeaveCommand;
import funding.command.LoginCommand;
import funding.command.LogoutCommand;
import funding.command.MainCommand;
import funding.command.MyOrderDetailCommand;
import funding.command.MyinformationModifyCommand;
import funding.command.MypageCommand;
import funding.command.NoticeDetailCommand;
import funding.command.NoticeListCommand;
import funding.command.SFADetailCommand;
import funding.command.SFAnswerCommand;
import funding.command.NoticeSearchCommand;
import funding.command.SFOApplyCommand;
import funding.command.SLoginCommand;
import funding.command.SLogoutCommand;
import funding.command.SMFCApplyCommand;
import funding.command.SMFDetailCommand;
import funding.command.SMFDetailDeleteCommand;
import funding.command.SMFDetailModifyCommand;
import funding.command.SMFManageCommand;
import funding.command.SMyinformationModifyCommand;
import funding.command.SMypageCommand;
import funding.command.SSignUpCommand;
import funding.command.SearchCommand;
import funding.command.SignupCommand;
import funding.command.SocialLoginCommand;
import funding.command.SystemQuestionCommand;
import funding.command.SystemQuestionDetailCommand;
import funding.command.SystemQuestionSearchCommand;
import funding.command.SystemQuestionlistCommand;

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

		// customer용 switch
		switch (path) {
		case ("/login.do"):
			command = new LoginCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case ("/socialLogin.do"):
			command = new SocialLoginCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case ("/logout.do"):
			command = new LogoutCommand();
			command.execute(request, response);
			viewpage = "main.do?sort=all";
			break;
		case ("/leave.do"):
			command = new LeaveCommand();
			command.execute(request, response);
			viewpage = "main.do?sort=all";
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
		case ("/fundingContent_view.do"):
			command = new FundingdetailCommand();
			command.execute(request, response);
			viewpage = "/pages/detail.jsp";
			break;
		case ("/fundingLike.do"):
			command = new FundingLikeCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case ("/fundingUnLike.do"):
			command = new FundingUnlikeCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case ("/fundingOrder.do"):
			command = new FundingPaymentCommand();
			command.execute(request, response);
			viewpage = "fundingOrder.jsp";
			break;
		case ("/fundingQuestion.do"):
			command = new FundingQuestionCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case ("/systemQuestion_list.do"):
			command = new SystemQuestionlistCommand();
			command.execute(request, response);
			viewpage = "/pages/systemquestion_list.jsp";
			break;
		case ("/systemQuestion_search.do"):
			command = new SystemQuestionSearchCommand();
			command.execute(request, response);
			viewpage = "/pages/systemquestion_list.jsp";
			break;
		case ("/systemQuestion.do"):
			command = new SystemQuestionCommand();
			command.execute(request, response);
			viewpage = "systemQuestion_list.do";
			break;
		case ("/systemQuestion_detail.do"):
			command = new SystemQuestionDetailCommand();
			command.execute(request, response);
			viewpage = "/pages/systemquestion_detail.jsp";
			break;
		case ("/notice_list.do"):
			command = new NoticeListCommand();
			command.execute(request, response);
			viewpage = "/pages/notice.jsp";
			break;
		case ("/notice_search.do"):
			command = new NoticeSearchCommand();
			command.execute(request, response);
			viewpage = "/pages/notice.jsp";
			break;
		case ("/notice_detail.do"):
			command = new NoticeDetailCommand();
			command.execute(request, response);
			viewpage = "/pages/notice_detail.jsp";
			break;
		case ("/mypage.do"):
			command = new MypageCommand();
			command.execute(request, response);
			viewpage = "/pages/mypage.jsp";
			break;
		case ("/myorder_detail.do"):
			command = new MyOrderDetailCommand();
			command.execute(request, response);
			viewpage = "/pages/myorder_detail.jsp";
			break;
		case ("/myinformation_modify.do"):
			command = new MyinformationModifyCommand();
			command.execute(request, response);
			viewpage = "logout.do?change=pw";
			break;
		}// customer

		// seller용 switch
		switch (path) {
		case ("/slogin.do"):
			command = new SLoginCommand();
			command.execute(request, response);
			viewpage = (String) request.getAttribute("viewpage");
			break;
		case ("/slogOut.do"):
			command = new SLogoutCommand();
			command.execute(request, response);
			viewpage = "/pages/slogin.jsp";
			break;
		case ("/ssignUp.do"):
			command = new SSignUpCommand();
			command.execute(request, response);
			viewpage = "/pages/slogin.jsp";
			break;
//		case("/sFODetail.do"):
//			viewpage="/pages/makeFunding.jsp";
//			break;
		case ("/sFOApply.do"):
			command = new SFOApplyCommand();
			command.execute(request, response);
			viewpage = "main.do?sort=all";
			break;
		case ("/sQApply_view.do"):
			command = new SFOApplyCommand();
			command.execute(request, response);
			viewpage = "sQApply_view.jsp";
			break;
		case ("/sQApply.do"):
			viewpage = "main.do?sort=all";
			break;
		case ("/SFOApply.do"):
			viewpage = "";
			break;
		case ("/sMypage.do"):
			command = new SMypageCommand();
			command.execute(request, response);
			viewpage = "/pages/Smypage.jsp";
			break;
//		case ("/sMFManage.do"):
//			command = new SMFManageCommand();
//			command.execute(request, response);
//			viewpage = "sMFManage.jsp";
//			break; 삭제하기
		case ("/sMFDetail.do"):
			command = new SMFDetailCommand();
			command.execute(request, response);
			viewpage = "/pages/sMFDetail.jsp";
			break;
		case ("/sMFModify.do"):
			command = new SMFDetailModifyCommand();
			command.execute(request, response);
			viewpage = "sMFManage.do";
			break;
		case ("/sMFDDelete.do"):
			command = new SMFDetailDeleteCommand();
			command.execute(request, response);
			viewpage = "sMFDDelete.jsp";
			break;
		case ("/sMFCApply.do"):
			command = new SMFCApplyCommand();
			command.execute(request, response);
			viewpage = "sMFCApply.jsp";
			break;
		case ("/sFADetail.do")://디테일입장
			command = new SFADetailCommand();
			command.execute(request, response);
			viewpage = "sFAnswer.jsp";
			break;
		case ("/sFAnswer.do")://등록하기
			command = new SFAnswerCommand();
			command.execute(request, response);
			viewpage =(String)request.getAttribute("viewpage");
			break;
		case ("/sDManage.do"):
			viewpage = "";
			break;
		case ("/Funding/smyinformation_modify.do"):
			command = new SMyinformationModifyCommand();
			command.execute(request, response);
			viewpage = "sMypage.do";
			break;
		case ("/movemycal.do"):
			command = new SMFCApplyCommand();
			command.execute(request, response);
			viewpage = "/pages/mycal.jsp";
			break;
		}// seller

		// admin용 switch
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
		case ("/aCAWList.do"):
			command = new ACAWListCommand();
			command.execute(request, response);
			viewpage = "aCAWList.jsp";
			break;
//		case("/aCADetail.do"):
//			viewpage="";
//			break;
		case ("/aCApprove.do"):
			command = new ACApproveCommand();
			command.execute(request, response);
			viewpage = "aCAWList.do";
			break;
		case ("/aCReject.do"):
			command = new ACRejectCommand();
			command.execute(request, response);
			viewpage = "aCAWList.do";
			break;
		case ("/aSQWList.do"):
			command = new ASQWListCommand();
			command.execute(request, response);
			viewpage = "aSQWList.jsp";
			break;
		case ("/aSQDetail.do"):
			command = new ASQDetailCommand();
			command.execute(request, response);
			viewpage = "aSQDetail.jsp";
			break;
		case ("/aSQualify.do"):
			command = new ASQualifyCommand();
			command.execute(request, response);
			viewpage = "aSQWList.do";
			break;
		case ("/aSreject.do"):
			command = new ASrejectCommand();
			command.execute(request, response);
			viewpage = "aSQWList.do";
			break;
		case ("/aFAWList.do"):
			command = new AFAWListCommand();
			command.execute(request, response);
			viewpage = "aFAWList.jsp";
			break;
		case ("/aFADetail.do"):
			command = new AFADetailCommand();
			command.execute(request, response);
			viewpage = "aFADetail.jsp";
			break;
		case ("/aFApprove.do"):
			command = new AFApproveCommand();
			command.execute(request, response);
			viewpage = "aFAWList.do";
			break;
		case ("/aFreject.do"):
			command = new AFRejectCommand();
			command.execute(request, response);
			viewpage = "aFAWList.do";
			break;
		case ("/aSAList.do"):
			command = new SystemQuestionlistCommand();
			command.execute(request, response);
			viewpage = "aSAList.jsp";
			break;
		case ("/aSAListDetail.do"):
			viewpage = "aSQAnswer.jsp";
			break;
//		case("/aSACreate.do"):
//			viewpage="";
//			break;
		case ("/aFList.do"):
			command = new AFListCommand();
			command.execute(request, response);
			viewpage = "aFList.jsp";
			break;
//		case("/aFDetail.do"):
//			viewpage="";
//			break;
//		case("/aFstateChange.do"):
//			viewpage="";
//			break;
		case ("/anotice_list.do"):
			command = new ANListCommand();
			command.execute(request, response);
			viewpage = "aNoticeList.jsp";
			break;
		case ("/anoticeCreate_view.do"):
			viewpage = "aNoticeCreate.jsp";
			break;
		case ("/anoticeCreate.do"):
			command = new ANCreateCommand();
			command.execute(request, response);
			viewpage = "anotice_list.do";
			break;
		case ("/anoticeContent_view.do"):
			command = new ANContentCommand();
			command.execute(request, response);
			viewpage = "aNContentView.jsp";
			break;
		case ("/anoticeModify.do"):
			command = new ANModifyCommand();
			command.execute(request, response);
			viewpage = "anotice_list.do";
			break;
		case ("/anoticeRemove.do"):
			command = new ANRemoveCommand();
			command.execute(request, response);
			viewpage = "anotice_list.do";
			break;
		case ("/asystemqDetail.do"):
			command = new ASystemQDetailCommand();
			command.execute(request, response);
			viewpage = "aSQAnswer.jsp";
			break;

		case ("/systemQuestionRemove.do"):
			command = new ASystemQuestionRemoveCommand();
			command.execute(request, response);
			viewpage = "asystemqDetail.do";
			break;
		case ("/aSystemQAnswerInsert.do"):
			command = new ASystemQAnswerInsertCommand();
			command.execute(request, response);
			viewpage = "asystemqDetail.do";
			break;
		}// admin.

		RequestDispatcher rd = request.getRequestDispatcher(viewpage);
		rd.forward(request, response);

	}

}
