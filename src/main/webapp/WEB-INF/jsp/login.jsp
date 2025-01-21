<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="includes/header.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ランダムWikipedia - ログイン</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap Icons -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<!-- コンテナ -->
	<div class="container mt-5">
		<!-- ログインフォームカード -->
		<div class="card shadow-sm mx-auto" style="max-width: 400px;">
			<div class="card-body">
				<h2 class="card-title text-center mb-4">ログイン</h2>
				<p>ダミーアカウントがあります。下記を使用すれば未登録でもログイン可能です</p>
				<p>ユーザーID: democat</p>
				<p>メールアドレス: democ@t</p>
				<p>パスワード: d3m0d3m0c4t</p>

				<!-- ログイン失敗メッセージ -->
				<c:if test="${wasFailLogin}">
					<div class="alert alert-danger text-center" role="alert">
						ログインに失敗しました。ユーザーIDかパスワードを再確認してください。</div>
				</c:if>

				<!-- ログインフォーム -->
				<form action="LoginServlet" method="post">
					<div class="mb-3">
						<label for="authString" class="form-label">ユーザーID または
							メールアドレス</label> <input type="text" class="form-control" id="authString"
							name="authString" placeholder="ユーザーIDまたはメール">
					</div>
					<div class="mb-3">
						<label for="pass" class="form-label">パスワード</label> <input
							type="password" class="form-control" id="pass" name="pass"
							placeholder="パスワード">
					</div>
					<div class="d-grid">
						<button type="submit" class="btn btn-primary">ログイン</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
