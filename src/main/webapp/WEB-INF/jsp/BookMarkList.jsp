<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランダムWikipedia</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
	<c:if test="${not empty account}">
		<p>
			アカウント
			<c:out value="${account.userId}" />
			でログイン中
		</p>
		<p>
			<a href="index.jsp">メインページへ戻る</a>
		</p>
		<c:forEach var="wage" items="${bookmarks}">
			<p>
				<a href="${wage.url}" target="_blank">${wage.title} - Wikipedia</a>(${wage.timestamp})
				<c:if test="${not empty account}">
					<a href="RemoveBMServlet?action=${wage.title}">お気に入りを外す</a>
				</c:if>
			</p>
		</c:forEach>
	</c:if>
</body>
</html>