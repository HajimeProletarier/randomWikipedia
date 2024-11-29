<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="servlet.*" import="model.*"
	import="java.net.URLEncoder"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>ランダムWikipedia</title>

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">ランダム Wikipedia</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${empty account}">
						<li><a href="LoginServlet"><span class="glyphicon glyphicon-user"></span>
								登録</a></li>
						<li><a href="ResisterServlet"><span class="glyphicon glyphicon-log-in"></span>
								ログイン</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
		<c:if test="${not empty account}">
			<p>
				アカウント
				<c:out value="${account.userId}" />
				でログイン中
			</p>
			<p>
				<a href="LogoutServlet">ログアウト</a>
			</p>
		</c:if>

		<h2>
			<a href="Main">取得ボタン</a>
		</h2>

		<ul>
			<li>このページでは Wikipedia のランダムなページへのリンクを取得できます。
			<li>取得ボタンを押すと、履歴の最後尾に新しいリンクが追加されます。
			<li>履歴の上限数は<c:out value="${maxPageNum}" />です。
		</ul>
		<h3>
			履歴 <a href="RefleshServlet">履歴のクリア</a>
			<c:if test="${not empty account}">
				<a href="BookMarkListServlet">ブックマークの一覧</a>
			</c:if>
			</h2>
			<c:forEach var="wage" items="${pageArchive}">
				<p>
					<a href="${wage.url}" target="_blank">${wage.title} - Wikipedia</a>(${wage.timestamp})
					<c:if test="${not empty account}">
						<a href="BookMarkServlet?action=${wage.title}">お気に入りする</a>
					</c:if>
				</p>
			</c:forEach>
		</h3>
	</div>

</body>
</html>