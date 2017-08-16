<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>顧客管理システム</title>
</head>
<body>
	<h1>顧客管理システム</h1>
	<form:form modelAttribute="customerForm"
		action="${pageContext.request.contextPath}/save" method="post">
	姓:<form:input path="firstName" />
		<br>
	名:<form:input path="lastName" />
		<br>
		<input type="submit" value="作成" />
	</form:form>
	<br>
	<br>

	<table border="0">
		<tr>
			<td>ID</td>
			<td>姓</td>
			<td>名</td>
			<td>編集</td>
		</tr>

		<c:forEach var="customer" items="${customerList}">
			<tr>
				<td><c:out value="${customer.id}" /></td>
				<td><c:out value="${customer.firstName}" /></td>
				<td><c:out value="${customer.lastName}" /></td>

				<td>
					<form action="${pageContext.request.contextPath}/rename">
						<input type="submit" value="編集" />
					</form>
					<form action="${pageContext.request.contextPath}/delete">
						<input type="submit" value="削除" /> 
						<input type="hidden" name="id" value="<c:out value="${customer.id}"/>">
					</form>

				</td>
			</tr>
		</c:forEach>


	</table>
</body>
</html>