<!-- header.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- ナビゲーションバー -->
<nav class="navbar navbar-dark bg-dark border-bottom">
    <div class="container-fluid">
        <!-- メインページへのリンク -->
        <a href="<c:url value='/index.jsp' />" class="navbar-brand mb-0 h1">
            <i class="bi bi-house"></i> ランダムWikipedia
        </a>
        <div>
            <!-- ログインと登録リンク -->
            <c:if test="${empty account}">
                <a href="<c:url value='/ResisterServlet' />" class="btn btn-outline-light btn-sm me-2">
                    <i class="bi bi-person-plus"></i> 登録
                </a>
                <a href="<c:url value='/LoginServlet' />" class="btn btn-outline-light btn-sm">
                    <i class="bi bi-box-arrow-in-right"></i> ログイン
                </a>
            </c:if>
            <c:if test="${not empty account}">
                <span class="text-light">こんにちは、<c:out value="${account.userId}" /> さん</span>
                <a href="<c:url value='/LogoutServlet' />" class="btn btn-outline-light btn-sm ms-3">
                    <i class="bi bi-box-arrow-right"></i> ログアウト
                </a>
            </c:if>
        </div>
    </div>
</nav>
