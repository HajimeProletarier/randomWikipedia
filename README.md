# これは何？

- 「ランダム Wikipedia」は Wikipedia のランダムなページにアクセスし、そのリンクをブックマークできる Web アプリケーションです。
- 複数のユーザーで使用することが想定されており、アカウント登録とログイン機能があります。

# 実際に動いているもの
[ランダムWikipedia(βテスト版)](https://randomwikipedia-gxhzafhde7crf8hd.japanwest-01.azurewebsites.net/)
![スクリーンショット](https://github.com/user-attachments/assets/526cf6a9-4d5e-40e1-8854-1e6349b33922)

- Azure Web アプリにデプロイしました。
- DB も Azure の MySQL サーバーを使用しました。
- ドメイン名は買っていません。高いので。

# ローカル動作環境

- OS: Windows 10 Pro
    - 未検証ですが、下記が実行できれば他の OS でも問題ないはずです。
- サーバー: Pleiades All in One - Eclipse
    - Apache Tomcat で Web アプリケーションを実行するために使用します。
    - Eclipse 2022 と Eclipse 2024 で動作検証済みです。
    - Apache Tomcat_10 Java 17 と Apache Tomcat_10 Java 21 で実行の動作検証済です。
- サーバー: XAMPP
    - MariaDB を使うために使用します。

# 環境構築

## Eclipse のセットアップ

- こちらを参照してください。
- https://sukkiri.jp/technologies/ides/pleiades_install_win.html

## Git のクローン

- 本リポジトリをクローンしてください。
- Eclipse のインポート機能を利用して、**動的 Webプロジェクト**として Eclipse のワークスペースに追加してください。

## XAMPP のセットアップ

- こちらから対応する OS の XAMPP をインストールしてください。
- https://www.apachefriends.org/jp/download.html
- XAMPP 側で、必要なテーブルを用意する必要があります。以下、手順。
    - XAMPP Control Panel を起動する
    - Apache と MySQL を起動する
    - MySQL Admin を起動する
    - phpMyAdmin で下記操作を実行する
    - SQL 文を本リポジトリからダウンロード
    - ダウンロードした SQL 文をインポート
- XAMPP の root ユーザーはデフォルトだとパスワードが設定されていません。認証情報を変える必要があります。
    - ユーザー名 root 、ホスト名 [localhost](http://localhost) のユーザーのパスワードを root に変更します。
        - これは脆弱なパスワードなので、任意のものに設定した方が良いです。
        - ただし、パスワードを書き換えると Apache Tomcat から DB への接続設定にも書き換えの必要が生まれます。
    - 下記のページを参照して、`config.inc.php` のパスワードを書き換えてください。
    - https://www.javadrive.jp/xampp/mysql/index3.html
- コネクションプーリングの設定をしている `context.xml`ファイルで MariaDB へのログイン情報を設定したパスワードに書き換える必要があります。
    - `src/main/webapp/META-INF` 下の `context.xml` ファイルを開いてください。
    - `password` の値を設定したパスワードに変更してください。

# 実装について

- Java で書かれています。
    - MVC モデルで設計されています。
    - コントローラークラスは Servlet で書かれています。
        - Servlet で頑張るのは大変なので Spring で書き直したいです。
    - ビューは JSP で書かれています。
        - JSP には JSTL といったタグライブラリをインクルードしています。
        - CSS を気持ちよくするために Bootstrap 5 を使用しています。
        - この辺も Thymeleaf + Bootstrap にする予定です。
- データベースへの接続について。
    - コネクションプーリング方式を採用しています。
    - DAO クラスパターンを採用しています。
- ランダムなページアクセスについて。
    - Wikipedia の API を使用してランダムなページにアクセスしています。
    - jsoup という Java の Web スクレイピングライブラリを使用して、アクセス先のページのデータ取得しています。

# 今後の展望

- Servlet&JSP から Spring を使用した実装に全体をアップデートする。
    - フレームワークを使用していないので、すべてが車輪の再発明になっている。
- ランダムな探索の範囲を任意に狭める機能を実装する。つまり、フィルターをかける機能を実装する。
    - たとえば、「量子力学」のハッシュタグがついている記事の中からランダムに探索する、「国」という単語を含む記事に限定してランダム探索する、など。
- パスワードの復旧機能を作成する。
- セキュリティ面を強化する。(権限の管理が弱い)
- ブックマークにフォルダ作成機能を実装する。
- 他のユーザーのブックマークを閲覧したり、ユーザー間のお気に入りが相互作用するような機能をつける。
