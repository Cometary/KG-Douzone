<%@page import="memberone.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
StudentDAO dao = StudentDAO.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<%
String id = (String) session.getAttribute("loginID");
String pass = request.getParameter("pass");
int check = dao.deleteCheckMember(id, pass);
if(check == 1){
	check = dao.deleteMember(id);
}
if (check == 1) {
	session.invalidate();
%>
<meta http-equiv="Refresh" content="3;url=login.jsp">
<body>
	<div align="center">
		<font size="5" face="바탕체"> 회원정보가 삭제되었습니다<br></br> 안녕히 가세요 ! ㅠ.ㅠ<br></br>
		3초후에 로그인 페이지로 이동합니다
		</font>
	</div>>
	<%
	} else {
	%>
	<script>
		alert("비밀번호가 맞지 않습니다");
		history.go(-1);
	</script>
	<%
	}
	%>
</body>
</html>