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
	<ul>
	<li>ユーザー IDは10文字以下の半角英数字とアンダーバー(_)のみを入力してください。
	<li>パスワードは8文字以上、	20文字以下で次の記号が使用可能です。@#$%^&*!?_
	<li>パスワードの再設定機能が現状ないので管理に注意してください。
	</ul>
	
	<c:if test="${isValidUserId == false}">
		<p class="redText">ユーザーIDが条件を満たしていません。</p>
	</c:if>
	<c:if test="${isValidPassword == false}">
		<p class="redText">パスワードが条件を満たしていません。</p>
	</c:if>
	<c:if test="${isResisteredUserId == true}">
		<p class="redText">既に存在するユーザーIDです。</p>
	</c:if>
	<c:if test="${isResisteredMail == true}">
		<p class="redText">既に登録されているメールアドレスです。</p>
	</c:if>
	
	<form action="ResisterServlet" method="post">
		ユーザーID:<input text="text" name="userId" pattern="[A-Za-z0-9_]{1,10}" 
		title="半角英数字と _ の記号のみ、10文字以下で入力してください" required><br> 
		
		メールアドレス:<input type="email" name="mail" required><br>
		
		パスワード:<input type="text" name="pass" pattern="[A-Za-z0-9@#$%^&*!?_]{8,20}" 
		title="半角英数字と @#$%^&*!?_ の記号のみ、8文字以上20文字以下で入力してください" required><br> 
		<input type="submit" value="登録">
	</form>
</body>
</html>