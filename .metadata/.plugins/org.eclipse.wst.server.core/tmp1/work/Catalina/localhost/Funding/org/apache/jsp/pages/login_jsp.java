/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.76
 * Generated at: 2022-04-07 07:12:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>해피펀딩 로그인</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"../styles/init.css\">\n");
      out.write("<style type=\"text/css\">\n");
      out.write("html {\n");
      out.write("	height: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write("body {\n");
      out.write("	margin: 0;\n");
      out.write("	padding: 0;\n");
      out.write("	height: 100%;\n");
      out.write("	z-index: 1;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__wrap {\n");
      out.write("	z-index: 1;\n");
      out.write("	width: 100%;\n");
      out.write("	height: 100%;\n");
      out.write("	display: flex;\n");
      out.write("	justify-content: center;\n");
      out.write("	align-items: center;\n");
      out.write("	background: linear-gradient(-45deg, #00d63f, #c2ffd4);\n");
      out.write("	background-size: 400% 400%;\n");
      out.write("	animation: gradientBG 15s ease infinite;\n");
      out.write("}\n");
      out.write("\n");
      out.write("@\n");
      out.write("keyframes gradientBG { 0% {\n");
      out.write("	background-position: 0% 50%;\n");
      out.write("}\n");
      out.write("\n");
      out.write("50\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("%\n");
      out.write("{\n");
      out.write("background-position\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(":\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("100\n");
      out.write("\n");
      out.write("\n");
      out.write("%\n");
      out.write("50\n");
      out.write("\n");
      out.write("\n");
      out.write("%;\n");
      out.write("}\n");
      out.write("100\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("%\n");
      out.write("{\n");
      out.write("background-position\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(":\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("0\n");
      out.write("\n");
      out.write("\n");
      out.write("%\n");
      out.write("50\n");
      out.write("\n");
      out.write("\n");
      out.write("%;\n");
      out.write("}\n");
      out.write("}\n");
      out.write(".signIn__content {\n");
      out.write("	width: 340px;\n");
      out.write("	padding: 30px;\n");
      out.write("	background-color: white;\n");
      out.write("	border-radius: 16px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__title {\n");
      out.write("	margin: 12px 0 16px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__description {\n");
      out.write("	color: #555;\n");
      out.write("	margin: 0 0 24px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__subTitle {\n");
      out.write("	font-size: 14px;\n");
      out.write("	font-weight: bold;\n");
      out.write("	margin: 4px 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__input {\n");
      out.write("	width: 280px;\n");
      out.write("	height: 40px;\n");
      out.write("	box-sizing: border-box;\n");
      out.write("	border-radius: 32px;\n");
      out.write("	border: 1px solid #aaa;\n");
      out.write("	padding: 8px 16px;\n");
      out.write("	line-height: 24px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__warning {\n");
      out.write("	margin: 4px 4px 16px;\n");
      out.write("	font-size: 13px;\n");
      out.write("	color: red;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__submit {\n");
      out.write("	width: 280px;\n");
      out.write("	background-color: royalblue;\n");
      out.write("	color: white;\n");
      out.write("	height: 44px;\n");
      out.write("	margin: 24px 0;\n");
      out.write("	border-radius: 32px;\n");
      out.write("	cursor: pointer;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__submit:hover {\n");
      out.write("	filter: brightness(105%);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__submit:disabled {\n");
      out.write("	background-color: #aaa;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__submit:active {\n");
      out.write("	filter: brightness(95%);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__info {\n");
      out.write("	margin: 0;\n");
      out.write("	font-size: 14px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".signIn__divider {\n");
      out.write("	padding-bottom: 20px;\n");
      out.write("	border-bottom: 1px solid #ddd;\n");
      out.write("	margin-bottom: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#toast {\n");
      out.write("	position: fixed;\n");
      out.write("	bottom: 30px;\n");
      out.write("	left: 50%;\n");
      out.write("	padding: 15px 20px;\n");
      out.write("	transform: translate(-50%, 10px);\n");
      out.write("	border-radius: 30px;\n");
      out.write("	overflow: hidden;\n");
      out.write("	opacity: 0;\n");
      out.write("	visibility: hidden;\n");
      out.write("	transition: opacity .5s, visibility .5s, transform .5s;\n");
      out.write("	background: rgba(0, 0, 0, .35);\n");
      out.write("	color: #fff;\n");
      out.write("	z-index: 5;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#toast.reveal {\n");
      out.write("	opacity: 1;\n");
      out.write("	visibility: visible;\n");
      out.write("	transform: translate(-50%, 0)\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("	let emailPattern = /^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$/;\n");
      out.write("	window.onload = function(){\n");
      out.write("		let errorCode = \"");
      out.print(request.getParameter("error"));
      out.write("\"\n");
      out.write("		console.log(errorCode)\n");
      out.write("		if(errorCode !== \"null\"){\n");
      out.write("			toast(\"로그인 정보를 확인해주세요\")\n");
      out.write("		}\n");
      out.write("		if(localStorage.getItem(\"id\")){\n");
      out.write("			document.getElementById('id').value = localStorage.getItem(\"id\");\n");
      out.write("			document.getElementById(\"rememberMe\").checked = true;\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("\n");
      out.write("	function validate(){\n");
      out.write("		const id = document.getElementById('id').value\n");
      out.write("		const pw = document.getElementById('pw').value\n");
      out.write("		\n");
      out.write("		if(id.match(emailPattern) && pw.length >= 4){\n");
      out.write("			document.getElementById('submit').disabled = false;\n");
      out.write("		}else{\n");
      out.write("			document.getElementById('submit').disabled = true;\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	function idFocus(){\n");
      out.write("		document.getElementById('idValidate').innerHTML = ''\n");
      out.write("	}\n");
      out.write("	function pwFocus(){\n");
      out.write("		document.getElementById('pwValidate').innerHTML = ''\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	function idValidate(){\n");
      out.write("		const id = document.getElementById('id').value\n");
      out.write("		if(!id.match(emailPattern)){\n");
      out.write("			document.getElementById('idValidate').innerHTML = '아이디는 이메일 형식으로 입력해야 합니다'\n");
      out.write("		}else{\n");
      out.write("\n");
      out.write("			document.getElementById('idValidate').innerHTML = ''\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	function pwValidate(){\n");
      out.write("		const pw = document.getElementById('pw').value\n");
      out.write("		if(pw.length < 4){\n");
      out.write("			document.getElementById('pwValidate').innerHTML = '4자 이상의 패스워드를 입력해주세요'\n");
      out.write("		}else{\n");
      out.write("			document.getElementById('pwValidate').innerHTML = ''\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	function checkCheck(){\n");
      out.write("		const check = document.getElementById(\"rememberMe\");\n");
      out.write("		if(check.checked){\n");
      out.write("			localStorage.setItem('id', document.getElementById('id').value);\n");
      out.write("		}else{\n");
      out.write("			localStorage.setItem('id', \"\");\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	function toast(string) {\n");
      out.write("	    const toast = document.getElementById(\"toast\");\n");
      out.write("\n");
      out.write("	    toast.classList.contains(\"reveal\") ?\n");
      out.write("	        (clearTimeout(removeToast), removeToast = setTimeout(function () {\n");
      out.write("	            document.getElementById(\"toast\").classList.remove(\"reveal\")\n");
      out.write("	        }, 3000)) :\n");
      out.write("	        removeToast = setTimeout(function () {\n");
      out.write("	            document.getElementById(\"toast\").classList.remove(\"reveal\")\n");
      out.write("	        }, 3000)\n");
      out.write("	    toast.classList.add(\"reveal\"),\n");
      out.write("	        toast.innerText = string\n");
      out.write("	}\n");
      out.write("</script>\n");
      out.write("<body>\n");
      out.write("	<div class=\"signIn__wrap\">\n");
      out.write("		<div class=\"signIn__content\">\n");
      out.write("			<h1 class=\"signIn__title\">로그인</h1>\n");
      out.write("			");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/apis/socialLogin/kakaoLogin.jsp", out, false);
      out.write("\n");
      out.write("			");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/apis/socialLogin/naverLogin.jsp", out, false);
      out.write("\n");
      out.write("			<div class=\"signIn__divider\"></div>\n");
      out.write("			<form action=\"/Funding/login.do\" name=\"signInForm\" method=\"post\"\n");
      out.write("				onsubmit=\"checkCheck()\">\n");
      out.write("				<div class=\"signIn__liner\">\n");
      out.write("					<p class=\"signIn__subTitle\">아이디</p>\n");
      out.write("					<input class=\"signIn__input\" id=\"id\" name=\"customer_id\"\n");
      out.write("						placeholder=\"example@mail.com\" onkeyup=\"validate()\"\n");
      out.write("						onfocus=\"idFocus()\" onblur=\"idValidate()\">\n");
      out.write("					<p id=\"idValidate\" class=\"signIn__warning\"></p>\n");
      out.write("				</div>\n");
      out.write("				<div class=\"signIn__liner\">\n");
      out.write("					<p class=\"signIn__subTitle\">패스워드</p>\n");
      out.write("					<input class=\"signIn__input\" id=\"pw\" type=\"password\"\n");
      out.write("						name=\"customer_pw\" onkeyup=\"validate()\" onfocus=\"pwFocus()\"\n");
      out.write("						onblur=\"pwValidate()\">\n");
      out.write("					<p id=\"pwValidate\" class=\"signIn__warning\"></p>\n");
      out.write("				</div>\n");
      out.write("				<div class=\"signIn__rememberLiner\">\n");
      out.write("					<input type=\"checkbox\" name=\"rememberMe\" id=\"rememberMe\"> <label\n");
      out.write("						for=\"rememberMe\">아이디 저장</label>\n");
      out.write("				</div>\n");
      out.write("				<input class=\"signIn__submit\" id=\"submit\" type=\"submit\" value=\"로그인\"\n");
      out.write("					disabled>\n");
      out.write("			</form>\n");
      out.write("			<div>\n");
      out.write("				<a href=\"\" target=\"popup\"\n");
      out.write("					onclick=\"window.open('/Funding/findId_view.do','popup','width=300,height=200'); return false;\">아이디찾기</a>\n");
      out.write("			</div>\n");
      out.write("			<div>\n");
      out.write("				<a href=\"\" target=\"popup\"\n");
      out.write("					onclick=\"window.open('/Funding/findPw_view.do','popup','width=300,height=400'); return false;\">비밀번호 찾기</a>\n");
      out.write("			</div>\n");
      out.write("			<div class=\"signIn__infoBox\">\n");
      out.write("				<p class=\"signIn__info\">\n");
      out.write("					아직 가입하지 않으셨나요? <a href=\"SignUp.jsp\">가입하러 가기</a>\n");
      out.write("				</p>\n");
      out.write("\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("	<div id=\"toast\"></div>\n");
      out.write("	<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("$(document).on(\"click\", \".findIdwButton\", function(e){\n");
      out.write("	e.stopPropagation();\n");
      out.write("	localStorage.setItem(\"pastURL\", location.href);\n");
      out.write("	location.href = \"/Funding/findId_view.do\";\n");
      out.write("})</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
