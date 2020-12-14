<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gamadi</title>
</head>
<body bgcolor ="cyan">
		<!--tag za deklaraciju,sve sto se nalazi u clasi,iznad service methode-->
		<%!
		
		%>
		<!--tag za service method servleta sve izmedju zove se scriptlet-->
		<% 
		int number1 = Integer.parseInt(request.getParameter("num1"));
		int number2 = Integer.parseInt(request.getParameter("num2"));
		int sum = number1 + number2 ;


		
		out.print("Result is: " + sum); 
		%>
</body>
</html>