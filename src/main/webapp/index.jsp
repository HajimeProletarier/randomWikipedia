<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlet.*" import="model.*"
    import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="WEB-INF/jsp/includes/header.jsp" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ランダムWikipedia(βテスト版)</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
    <div class="container-fluid">
        <!-- メインコンテンツ -->
        <div class="container mt-4">
            <!-- 説明 -->
            <div class="mb-3">
                <h2>使い方</h2>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">このページでは Wikipedia のランダムなページへのリンクを取得できます。</li>
                    <li class="list-group-item">取得ボタンを押すと、履歴の最後尾に新しいリンクが追加されます。</li>
                    <li class="list-group-item">履歴の上限数は <c:out value="${maxPageNum}" /> です。</li>
                </ul>
            </div>

            <!-- リンク取得とクリア -->
            <div class="mb-3">
                <a href="Main" class="btn btn-primary me-2">
                    <i class="bi bi-arrow-repeat"></i> 取得
                </a>
                <a href="RefleshServlet" class="btn btn-danger">
                    <i class="bi bi-trash"></i> クリア
                </a>
            </div>

            <!-- ブックマークリンク -->
            <c:if test="${not empty account}">
                <div class="mb-3">
                    <h2>ブックマーク</h2>
                    <a href="BookMarkListServlet" class="btn btn-secondary">
                        <i class="bi bi-bookmark"></i> ブックマーク一覧を見る
                    </a>
                </div>
            </c:if>

            <!-- 履歴 -->
            <div>
                <h2><i class="bi bi-clock-history"></i> 履歴</h2>
                <c:forEach var="wage" items="${pageArchive}">
                    <div class="border-bottom py-2">
                        <a href="${wage.url}" target="_blank" class="text-decoration-none">
                            <i class="bi bi-book"></i> ${wage.title}
                        </a>
                        <span class="text-muted">(${wage.timestamp})</span>
                        <c:if test="${not empty account}">
                            <a href="BookMarkServlet?action=${wage.title}" class="btn btn-outline-secondary btn-sm ms-2">
                                <i class="bi bi-bookmark-plus"></i> お気に入りに追加
                            </a>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
