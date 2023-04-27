<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	String file_name = "hi"; 
	//request.getParameter("title");
	response.setHeader("Content-Disposition", "attachment; filename="+file_name+".xls;");
	response.setHeader("Content-Description", "JSP Generated Data");
	String title = "hello";
			//request.getParameter("title");
%>
<html>
<head>
<meta charset="UTF-8">
<title>급여 명세서</title>
</head>
<body>
<table>
	<tr>
		<th colspan="3">4월 급여명세서</th>
	</tr>
	<tr>
		<th>이름</th>
		<th>직급</th>
		<th>급여(단위:만원)</th>
	</tr>
	<tr>
		<th>홍길동</th>
		<th>과장</th>
		<th>300</th>
	</tr>
	<tr>
		<th>홍길은</th>
		<th>부장</th>
		<th>200</th>
	</tr>
	<tr>
		<th>홍길금</th>
		<th>사원</th>
		<th>100</th>
	</tr>
</table>	
</body>
</html>