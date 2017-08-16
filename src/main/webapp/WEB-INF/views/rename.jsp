<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>名前の編集</title>
</head>
<body>
	<form:form modelAttribute="customerForm"
		action="${pageContext.request.contextPath}/save">
		
		姓:<form:input path="firstName"
			placeholder="${renameCustomer.firstName}" />
		<br>
		名:<form:input path="lastName" placeholder="${renameCustomer.lastName}" />
		<br>
		<input type="hidden" name="id"
			value="<c:out value="${renameCustomer.id}"/>">
		<%-- 		<c:out value="${renameCustomer.firstName}"/><br> --%>
		<%-- 		<c:out value="${renameCustomer.lastName}"/><br> --%>

		<input type="submit" value="更新">
		<br>
	</form:form>

	<form action="${pageContext.request.contextPath}/" method="post">
		<input type="submit" value="戻る">
	</form>

</body>
</html>