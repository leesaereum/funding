/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.76
 * Generated at: 2022-04-06 07:19:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.apis.addressSearch;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addressPopup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
 
	request.setCharacterEncoding("UTF-8");  //한글깨지면 주석제거
	String inputYn = request.getParameter("inputYn"); 
	String roadFullAddr = request.getParameter("roadFullAddr"); 
	String roadAddrPart1 = request.getParameter("roadAddrPart1"); 
	String roadAddrPart2 = request.getParameter("roadAddrPart2"); 
	String engAddr = request.getParameter("engAddr"); 
	String jibunAddr = request.getParameter("jibunAddr"); 
	String zipNo = request.getParameter("zipNo"); 
	String addrDetail = request.getParameter("addrDetail"); 
	String admCd    = request.getParameter("admCd");
	String rnMgtSn = request.getParameter("rnMgtSn");
	String bdMgtSn  = request.getParameter("bdMgtSn");
	/** API 서비스 제공항목 확대 (2017.02) **/
	String detBdNmList  = request.getParameter("detBdNmList");
	String bdNm  = request.getParameter("bdNm");
	String bdKdcd  = request.getParameter("bdKdcd");
	String siNm  = request.getParameter("siNm");
	String sggNm  = request.getParameter("sggNm");
	String emdNm  = request.getParameter("emdNm");
	String liNm  = request.getParameter("liNm");
	String rn  = request.getParameter("rn");
	String udrtYn  = request.getParameter("udrtYn");
	String buldMnnm  = request.getParameter("buldMnnm");
	String buldSlno  = request.getParameter("buldSlno");
	String mtYn  = request.getParameter("mtYn");
	String lnbrMnnm  = request.getParameter("lnbrMnnm");
	String lnbrSlno  = request.getParameter("lnbrSlno");
	String emdNo  = request.getParameter("emdNo");

      out.write("\n");
      out.write("</head>\n");
      out.write("<script language=\"javascript\">\n");
      out.write("//opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. (\"주소입력화면 소스\"도 동일하게 적용시켜야 합니다.)\n");
      out.write("//document.domain = \"abc.go.kr\";\n");
      out.write("\n");
      out.write("function init(){\n");
      out.write("	var url = location.href;\n");
      out.write("	var confmKey = \"devU01TX0FVVEgyMDIyMDMzMTE2MDIwNzExMjQwNjA=\";//승인키\n");
      out.write("	// resultType항목 추가(2016.10.06)\n");
      out.write("	var resultType = \"4\"; // 도로명주소 검색결과 화면 출력유형, 1 : 도로명, 2 : 도로명+지번+상세보기(관련지번, 관할주민센터), 3 : 도로명+상세보기(상세건물명), 4 : 도로명+지번+상세보기(관련지번, 관할주민센터, 상세건물명)\n");
      out.write("	var inputYn= \"");
      out.print(inputYn);
      out.write("\";\n");
      out.write("	if(inputYn != \"Y\"){\n");
      out.write("		document.form.confmKey.value = confmKey;\n");
      out.write("		document.form.returnUrl.value = url;\n");
      out.write("		document.form.resultType.value = resultType; // resultType항목 추가(2016.10.06)\n");
      out.write("		document.form.action=\"https://www.juso.go.kr/addrlink/addrLinkUrl.do\"; // 인터넷망\n");
      out.write("		//document.form.action=\"https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do\"; //모바일 웹인 경우, 인터넷망\n");
      out.write("		document.form.submit();\n");
      out.write("	}else{\n");
      out.write("		/** API 서비스 제공항목 확대 (2017.02) **/\n");
      out.write("		opener.jusoCallBack(\"");
      out.print(roadFullAddr);
      out.write('"');
      out.write(',');
      out.write('"');
      out.print(roadAddrPart1);
      out.write('"');
      out.write(',');
      out.write('"');
      out.print(addrDetail);
      out.write("\", \"");
      out.print(roadAddrPart2);
      out.write('"');
      out.write(',');
      out.write('"');
      out.print(engAddr);
      out.write("\"\n");
      out.write("			, \"");
      out.print(jibunAddr);
      out.write('"');
      out.write(',');
      out.write('"');
      out.print(zipNo);
      out.write("\", \"");
      out.print(admCd);
      out.write("\", \"");
      out.print(rnMgtSn);
      out.write("\", \"");
      out.print(bdMgtSn);
      out.write("\", \"");
      out.print(detBdNmList);
      out.write("\"\n");
      out.write("			, \"");
      out.print(bdNm);
      out.write("\", \"");
      out.print(bdKdcd);
      out.write("\", \"");
      out.print(siNm);
      out.write("\", \"");
      out.print(sggNm);
      out.write("\", \"");
      out.print(emdNm);
      out.write("\", \"");
      out.print(liNm);
      out.write("\", \"");
      out.print(rn);
      out.write("\", \"");
      out.print(udrtYn);
      out.write("\"\n");
      out.write("			, \"");
      out.print(buldMnnm);
      out.write("\", \"");
      out.print(buldSlno);
      out.write("\", \"");
      out.print(mtYn);
      out.write("\", \"");
      out.print(lnbrMnnm);
      out.write("\", \"");
      out.print(lnbrSlno);
      out.write("\", \"");
      out.print(emdNo);
      out.write("\");\n");
      out.write("		window.close();\n");
      out.write("	}\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("<body onload=\"init();\">\n");
      out.write("	<form id=\"form\" name=\"form\" method=\"post\">\n");
      out.write("		<input type=\"hidden\" id=\"confmKey\" name=\"confmKey\" value=\"\"/>\n");
      out.write("		<input type=\"hidden\" id=\"returnUrl\" name=\"returnUrl\" value=\"\"/>\n");
      out.write("		<input type=\"hidden\" id=\"resultType\" name=\"resultType\" value=\"\"/>\n");
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
