/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.76
 * Generated at: 2022-04-07 02:48:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class findId_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>아이디 찾기</title>\n");
      out.write("<style>\n");
      out.write(".signUp__warning {\n");
      out.write("	margin: 4px 4px 16px;\n");
      out.write("	font-size: 13px;\n");
      out.write("	color: red;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("	let namePattern = /^[ㄱ-ㅎ|가-힣|a-z|A-Z]+$/;\n");
      out.write("	let phonePatern = /^[0-9]+$/;\n");
      out.write("	window.onload = function(){\n");
      out.write("		let errorCode = \"");
      out.print(request.getParameter("error"));
      out.write("\"\n");
      out.write("		console.log(errorCode)\n");
      out.write("		if(errorCode !== \"null\"){\n");
      out.write("			alert(\"입력하신 정보에 대한 아이다가 없습니다. 다시 확인해주세요\")\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	function validate() {\n");
      out.write("	const name = document.getElementById('name').value\n");
      out.write("	const phone2 = document.getElementById('phone2').value\n");
      out.write("	const phone3 = document.getElementById('phone3').value\n");
      out.write("		if (name.match(namePattern)) {\n");
      out.write("			document.getElementById('submit').disabled = false;\n");
      out.write("		} else {\n");
      out.write("			document.getElementById('submit').disabled = true;\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	function nameFocus() {\n");
      out.write("		document.getElementById('nameValidate').innerHTML = ''\n");
      out.write("	}\n");
      out.write("	function phoneFocus() {\n");
      out.write("		document.getElementById('phoneValidate').innerHTML = ''\n");
      out.write("	}\n");
      out.write("	function nameValidate() {\n");
      out.write("		const name = document.getElementById('name').value\n");
      out.write("		if (!name.match(namePattern)) {\n");
      out.write("			document.getElementById('nameValidate').innerHTML = '이름은 한글이나 영어로 입력해주세요'\n");
      out.write("		} else if (name.length <1 || name.length > 45) {			\n");
      out.write("			document.getElementById('nameValidate').innerHTML = '이름은 1~45자 이내로 입력해주세요'\n");
      out.write("		}\n");
      out.write("		else {\n");
      out.write("			document.getElementById('nameValidate').innerHTML = ''\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	function phoneValidate() {\n");
      out.write("		const phone2 = document.getElementById('phone2').value\n");
      out.write("		const phone3 = document.getElementById('phone3').value\n");
      out.write("		if (!phone2.match(phonePattern) || !phone3.match(phonePattern)) {\n");
      out.write("			document.getElementById('phoneValidate').innerHTML = '전화번호는 숫자로만 입력해주세요'\n");
      out.write("		} else {\n");
      out.write("\n");
      out.write("			document.getElementById('phoneValidate').innerHTML = ''\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("</script>\n");
      out.write("	<form name=\"findId\" action=\"/Funding/findId.do\" method=\"post\">\n");
      out.write("		<div>\n");
      out.write("			이름 <input id=\"name\" type=\"text\" name=\"name\" onkeyup=\"validate()\"\n");
      out.write("				onfocus=\"nameFocus()\" onblur=\"nameValidate()\">\n");
      out.write("			<p id=\"nameValidate\" class=\"signUp__warning\"></p>\n");
      out.write("		</div>\n");
      out.write("		<div>\n");
      out.write("			전화번호 <select name=\"phone1\">\n");
      out.write("				<option selected=\"selected\">010</option>\n");
      out.write("				<option>011</option>\n");
      out.write("				<option>016</option>\n");
      out.write("				<option>017</option>\n");
      out.write("				<option>019</option>\n");
      out.write("			</select> - <input id=\"phone2\" type=\"text\" name=\"phone2\" size=\"5\"\n");
      out.write("				onkeyup=\"validate()\" onfocus=\"phoneFocus()\" onblur=\"phoneValidate()\">\n");
      out.write("			- <input id=\"phone3\" type=\"text\" name=\"phone3\" size=\"5\"\n");
      out.write("				onkeyup=\"validate()\" onfocus=\"phoneFocus()\" onblur=\"phoneValidate()\">\n");
      out.write("			<p id=\"phoneValidate\" class=\"signUp__warning\"></p>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("		<input id=\"submit\" type=\"submit\" value=\"확인\" disabled>\n");
      out.write("	</form>\n");
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