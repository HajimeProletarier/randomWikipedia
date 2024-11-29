<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="includes/header.jsp" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ランダムWikipedia - 登録</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body class="bg-light">
    <!-- コンテナ -->
    <div class="container mt-5">
        <div class="card shadow-sm mx-auto" style="max-width: 500px;">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">ユーザー登録</h2>

                <!-- ガイドライン -->
                <ul class="list-group list-group-flush mb-4">
                    <li class="list-group-item">ユーザーIDは10文字以下の半角英数字とアンダーバー (_) のみを入力してください。</li>
                    <li class="list-group-item">パスワードは8文字以上、20文字以下で次の記号が使用可能です: <code>@#$%^&*!?_</code></li>
                    <li class="list-group-item">パスワードの再設定機能が現状ないので管理に注意してください。</li>
                    <li class="list-group-item">メールアドレスは使用しません、メールアドレスの形式であれば適当で問題ありません。</li>
                </ul>

                <!-- エラーメッセージ -->
                <c:if test="${isValidUserId == false}">
                    <div class="alert alert-danger" role="alert">ユーザーIDが条件を満たしていません。</div>
                </c:if>
                <c:if test="${isValidPassword == false}">
                    <div class="alert alert-danger" role="alert">パスワードが条件を満たしていません。</div>
                </c:if>
                <c:if test="${isResisteredUserId == true}">
                    <div class="alert alert-danger" role="alert">既に存在するユーザーIDです。</div>
                </c:if>
                <c:if test="${isResisteredMail == true}">
                    <div class="alert alert-danger" role="alert">既に登録されているメールアドレスです。</div>
                </c:if>

                <!-- 登録フォーム -->
                <form action="ResisterServlet" method="post">
                    <div class="mb-3">
                        <label for="userId" class="form-label">ユーザーID</label>
                        <input type="text" class="form-control" id="userId" name="userId" 
                            pattern="[A-Za-z0-9_]{1,10}" 
                            title="半角英数字と _ の記号のみ、10文字以下で入力してください" 
                            required>
                    </div>
                    <div class="mb-3">
                        <label for="mail" class="form-label">メールアドレス</label>
                        <input type="email" class="form-control" id="mail" name="mail" required>
                    </div>
                    <div class="mb-3">
                        <label for="pass" class="form-label">パスワード</label>
                        <input type="password" class="form-control" id="pass" name="pass" 
                            pattern="[A-Za-z0-9@#$%^&*!?_]{8,20}" 
                            title="半角英数字と @#$%^&*!?_ の記号のみ、8文字以上20文字以下で入力してください" 
                            required>
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">登録</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
