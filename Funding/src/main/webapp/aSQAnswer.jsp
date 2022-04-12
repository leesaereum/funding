<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Login - SB Admin</title>
        <link href="/Funding/boot/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">시스템 문의 답변하기</h3></div>
                                    <div class="card-body">
                                    
                                        <form method="post" action="aSystemQAnswerInsert.do">
                                    			
                                                <div class="container">
                                                
                                                <c:forEach items="${system_question_detail }" var="dto01">
                                                <input type="hidden" name="question_num" value="${dto01.question_num}">
                                                	<h5>시스템 문의</h5>
                                                	
													<textarea  readonly class="form-control col-sm-5" rows="1" >${dto01.question_title }</textarea>
							
												<br>
													<textarea  readonly class="form-control col-sm-5" rows="10">${dto01.question_content }</textarea>
														<br>
													      <h5>문의 답변</h5>
													     
                                          			<textarea class="form-control col-sm-5" rows="" name = "question_answer">${dto01.question_answer }</textarea>
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                      
                                                &nbsp;<input class="btn btn-primary" type="submit" value="답변하기">&nbsp;
                                                <a class="btn btn-primary" href="systemQuestionRemove.do?question_num=${dto01.question_num }">답변삭제</a>&nbsp;
                                                <a class="btn btn-primary" href="aSAList.do">목록으로</a>&nbsp;
                                             </c:forEach>
                                            </div>
												</div>
												
                                        
                                        </form>
                                    </div>
                             
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2022</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>