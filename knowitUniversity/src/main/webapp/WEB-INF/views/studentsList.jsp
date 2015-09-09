<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link href="css/styles.css" rel="stylesheet"  type="text/css" />
</head>
<body>
	
	<h1>Tudengid</h1>
	<br>
	
	<table>
		<tr>
			<c:forEach items="${headers}" var="peal">
			<th>${peal}</th>
			</c:forEach>
		</tr>
		
		<c:forEach items="${students}" var="student">
		<tr>
			<td align="left">${student.lastName}</td>
			<td align="left">${student.firstName}</td>
			<td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${student.wavGrade}" /></td>
			<td align="left">
				<c:forEach items="${student.courses}" var="course">
				<nobr>${course.name}/ h: ${course.grade}/ EAP: ${course.eap}</nobr> 
				</c:forEach>
			</td>
		</tr>
		</c:forEach>
		
	</table>

</body>
</html>
