/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.76
 * Generated at: 2022-04-07 06:55:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class notice_005fdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>공지사항</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"/Funding/styles/init.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/Funding/styles/base.css\">\n");
      out.write("<style>\n");
      out.write(".notice__wrap {\n");
      out.write("	width: 960px;\n");
      out.write("	margin: 0 auto;\n");
      out.write("	padding: 51px 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".notice__header {\n");
      out.write("	width: 100%;\n");
      out.write("	display: flex;\n");
      out.write("	justify-content: space-between;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".notice__pageTitle {\n");
      out.write("	font-size: 21px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".notice__box {\n");
      out.write("	list-style: none;\n");
      out.write("	margin-top: 17px;\n");
      out.write("	border: 1px solid #eee;\n");
      out.write("	min-height: 300px;\n");
      out.write("}\n");
      out.write(".notice__header {\n");
      out.write("	padding: 18px 30px 19px 29px;\n");
      out.write("	border-bottom: 1px solid #eee;\n");
      out.write("	display: flex;\n");
      out.write("	justify-content: space-between;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".notice__content {\n");
      out.write("	padding: 30px 29px 34px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".notice__toList {\n");
      out.write("	display: block;\n");
      out.write("	width: 160px;\n");
      out.write("	margin: 30px auto 0;\n");
      out.write("	padding: 13px 0 12px;\n");
      out.write("	background-color: #828282;\n");
      out.write("	border: 1px solid rgba(0, 0, 0, .1);\n");
      out.write("	font-size: 16px;\n");
      out.write("	line-height: 1.19;\n");
      out.write("	color: #fff;\n");
      out.write("	text-align: center;\n");
      out.write("	cursor: pointer;\n");
      out.write("}\n");
      out.write(".notice__num{\n");
      out.write("	width: 50px;\n");
      out.write("	text-align: center;\n");
      out.write("}\n");
      out.write(".notice__name{\n");
      out.write("	width: 170px;\n");
      out.write("}\n");
      out.write(".notice__date{\n");
      out.write("	width: 120px;\n");
      out.write("}\n");
      out.write(".notice__title{\n");
      out.write("	width: calc(100% - 400px);\n");
      out.write("	overflow: hidden;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script src=\"/Funding/libraries/jQuery.js\"></script>\n");
      out.write("<script src=\"/Funding/libraries/moment.js\"></script>\n");
      out.write("<script>\n");
      out.write("	let hello = moment(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.notice_At}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\").format(\"YYYY-MM-DD\")\n");
      out.write("	$(document).ready(function(){\n");
      out.write("		$(\".notice__date\").html(hello)\n");
      out.write("	})\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/components/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("	<div class=\"notice__wrap\">\n");
      out.write("		<div class=\"notice__header\">\n");
      out.write("			<h1 class=\"notice__pageTitle\">공지사항</h1>\n");
      out.write("		</div>\n");
      out.write("		<div class=\"notice__box\">\n");
      out.write("			<div class=\"notice__header\">\n");
      out.write("				<p class=\"notice__num\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.notice_num }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("				<p class=\"notice__title\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.notice_title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("				<p class=\"notice__name\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.notice_admin }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("				<p class=\"notice__date\"></p>\n");
      out.write("			</div>\n");
      out.write("			<div class=\"notice__content\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.notice_content }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("		</div>\n");
      out.write("		<a href=\"notice_list.do\" class=\"notice__toList\">목록</a>\n");
      out.write("	</div>\n");
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
