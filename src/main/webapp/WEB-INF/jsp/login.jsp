<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
.redText {
	color: red;
}
</style>
<title>ランダムWikipedia</title>
</head>
<body>
	<c:if test="${wasFailLogin}">
		<p class="redText">ログインに失敗しました。ユーザーIDかパスワードを再確認してください </p>
	</c:if>
	<form action="LoginServlet" method="post">
		ユーザーID または メールアドレス:<input text="text" name="authString"><br> 
		パスワード:<input type="password" name="pass"><br> 
		<input type="submit" value="ログイン">
	</form>
</body>
</html>