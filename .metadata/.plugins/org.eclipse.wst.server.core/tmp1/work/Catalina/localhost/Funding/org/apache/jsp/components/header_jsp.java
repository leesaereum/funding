/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.76
 * Generated at: 2022-04-07 06:10:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.components;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<style>\n");
      out.write("header {\n");
      out.write("	width: 100%;\n");
      out.write("	height: 72px;\n");
      out.write("	border-bottom: 1px solid #f0f0f0;\n");
      out.write("	box-sizing: border-box;\n");
      out.write("}\n");
      out.write(".header.drop {\n");
      out.write("  position: fixed;\n");
      out.write("  animation: dropHeader 0.3s;\n");
      out.write("  background-color: white;\n");
      out.write("  z-index: 999;\n");
      out.write("}\n");
      out.write("\n");
      out.write("@keyframes dropHeader {\n");
      out.write("  0% {\n");
      out.write("    top: -5rem;\n");
      out.write("  }\n");
      out.write("  100% {\n");
      out.write("    top: 0;\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("\n");
      out.write(".header__wrap {\n");
      out.write("	width: 1080px;\n");
      out.write("	margin: 0 auto;\n");
      out.write("	display: flex;\n");
      out.write("	justify-content: space-between;\n");
      out.write("	line-height: 71px;\n");
      out.write("}\n");
      out.write(".header__wrap h1{\n");
      out.write("	font-size: 28px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".header__wrap ul{\n");
      out.write("	display: flex;\n");
      out.write("	justify-content: space-around;\n");
      out.write("	width: 480px;\n");
      out.write("	font-size: 18px;\n");
      out.write("}\n");
      out.write(".header__wrap li{\n");
      out.write("	cursor: pointer;\n");
      out.write("}\n");
      out.write(".signedIn_email{\n");
      out.write("	padding-right: 12px;\n");
      out.write("	margin-top: 20px;\n");
      out.write("	margin-right:12px;\n");
      out.write("	border-right: 1px solid #eee;\n");
      out.write("	height: 30px;\n");
      out.write("	line-height: 32px;\n");
      out.write("}\n");
      out.write(".makeFunding{\n");
      out.write("	height: 30px;\n");
      out.write("	margin-top: 20px;\n");
      out.write("	margin-left: 12px;\n");
      out.write("	padding-left: 12px;\n");
      out.write("	border-left: 1px solid #eee;\n");
      out.write("	line-height: 31px !important;\n");
      out.write("	cursor: pointer;\n");
      out.write("	color: #0091ff;\n");
      out.write("	\n");
      out.write("}\n");
      out.write("#loginZone{\n");
      out.write("	width: 320px;\n");
      out.write("	display: flex;\n");
      out.write("	justify-content: right;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<header class=\"header\">\n");
      out.write("	<div class=\"header__wrap\">\n");
      out.write("		<h1 class=\"font-color-main\" onclick=\"goHome()\">해피펀딩</h1>\n");
      out.write("		<nav>\n");
      out.write("			<ul>\n");
      out.write("				<li><a href=\"funding_listview.do\">펀딩</a></li>\n");
      out.write("				<li><a href=\"notice_list.do\">공지사항</a></li>\n");
      out.write("				<li><a href=\"/Funding/pages/systemQnADo.jsp\">Q&A</a></li>\n");
      out.write("			</ul>\n");
      out.write("		</nav>\n");
      out.write("		<div id=\"loginZone\">\n");
      out.write("			<div class=\"loginButton\">로그인</div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("\n");
      out.write("</header>\n");
      out.write("<script src=\"/Funding/libraries/jQuery.js\"></script>\n");
      out.write("<script>\n");
      out.write("let header = document.querySelector(\".header\");\n");
      out.write("let headerHeight = 72;\n");
      out.write("let email = \"");
      out.print(session.getAttribute("email"));
      out.write("\";\n");
      out.write("if(email == \"null\"){\n");
      out.write("	document.getElementById(\"loginZone\").innerHTML = '<div class=\"loginButton\">로그인</div>';\n");
      out.write("}else{\n");
      out.write("	document.getElementById(\"loginZone\").innerHTML = '<p class=\"signedIn_email\" onclick=\"goMyPage()\">'+email.split(\"@\")[0]+' 님</p><div class=\"logoutButton\">로그아웃</div>';\n");
      out.write("}\n");
      out.write("let isSeller = \"");
      out.print(session.getAttribute("isSeller"));
      out.write("\";\n");
      out.write("if(isSeller != \"null\"){\n");
      out.write("	let txt = document.getElementById(\"loginZone\").innerHTML;\n");
      out.write("	txt += '<div class=\"makeFunding\">펀딩 만들기</div>';\n");
      out.write("	document.getElementById(\"loginZone\").innerHTML = txt;\n");
      out.write("}\n");
      out.write("window.onscroll = function () {\n");
      out.write("  if(window.innerHeight > 1200){\n");
      out.write("	  let windowTop = window.scrollY;\n");
      out.write("	  	// 스크롤 세로값이 헤더높이보다 크거나 같으면 \n");
      out.write("		// 헤더에 클래스 'drop'을 추가한다\n");
      out.write("	  if (windowTop >= headerHeight) {\n");
      out.write("	    header.classList.add(\"drop\");\n");
      out.write("	  } \n");
      out.write("	  // 아니면 클래스 'drop'을 제거\n");
      out.write("	  else {\n");
      out.write("	    header.classList.remove(\"drop\");\n");
      out.write("	  }\n");
      out.write("  }\n");
      out.write("  \n");
      out.write("};\n");
      out.write("function goHome(){\n");
      out.write("	//todo: 작성하던 내용이 사라집니다.\n");
      out.write("	location.href = \"/Funding/main.jsp\"\n");
      out.write("}\n");
      out.write("$(document).on(\"click\", \".loginButton\", function(e){\n");
      out.write("	e.stopPropagation();\n");
      out.write("	localStorage.setItem(\"pastURL\", location.href);\n");
      out.write("	location.href = \"/Funding/pages/login.jsp\";\n");
      out.write("})\n");
      out.write("$(document).on(\"click\", \".logoutButton\", function(e){\n");
      out.write("	e.stopPropagation();\n");
      out.write("	localStorage.setItem(\"pastURL\", location.href);\n");
      out.write("	location.href = \"/Funding/tempLogoutDo.jsp\";\n");
      out.write("})\n");
      out.write("$(document).on(\"click\", \".makeFunding\", function(e){\n");
      out.write("	e.stopPropagation();\n");
      out.write("	location.href = \"/Funding/pages/makeFunding.jsp\";\n");
      out.write("})\n");
      out.write("\n");
      out.write("function goMyPage(){\n");
      out.write("	location.href = \"/Funding/pages/mypage.jsp\"\n");
      out.write("}\n");
      out.write("</script>");
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
