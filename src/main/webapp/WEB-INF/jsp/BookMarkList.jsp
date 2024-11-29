<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ランダムWikipedia - ブックマーク</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap Icons -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&family=Lobster&display=swap"
	rel="stylesheet">
<style>
body {
	background-color: #f8f9fa; /* 明るい背景 */
}

.card {
	transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.card:hover {
	transform: scale(1.03);
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
}
</style>
</head>
<body>
	<!-- コンテンツ -->
	<div class="container mt-4">
		<!-- ログイン中のメッセージ -->
		<c:if test="${not empty account}">
			<div class="alert alert-info">
				アカウント <strong><c:out value="${account.userId}" /></strong> でログイン中
			</div>

			<!-- お気に入り一覧 -->
			<div class="card">
				<div class="card-header">
					<h5>お気に入り記事</h5>
				</div>
				<div class="card-body">
					<c:forEach var="wage" items="${bookmarks}">
						<p>
							<a href="${wage.url}" target="_blank"
								class="text-decoration-none"> <i class="bi bi-bookmark"></i>
								<strong>${wage.title}</strong> - Wikipedia
							</a> <span class="text-muted">(${wage.timestamp})</span>
							<c:if test="${not empty account}">
								<a href="RemoveBMServlet?action=${wage.title}"
									class="btn btn-sm btn-outline-danger ms-2"> <i
									class="bi bi-bookmark-dash"></i> 外す
								</a>
							</c:if>
						</p>
					</c:forEach>

				</div>
			</div>
		</c:if>

		<!-- メインページリンク -->
		<c:if test="${not empty account}">
			<div class="mt-3">
				<a href="index.jsp" class="btn btn-primary"> <i
					class="bi bi-house-door"></i> メインページへ戻る
				</a>
			</div>
		</c:if>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
