-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- ホスト: 127.0.0.1
-- 生成日時: 2024-11-30 01:42:34
-- サーバのバージョン： 10.4.32-MariaDB
-- PHP のバージョン: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- データベース: `randomwikipedia`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `accounts`
--

CREATE TABLE `accounts` (
  `USER_ID` varchar(10) NOT NULL,
  `MAIL` varchar(100) NOT NULL,
  `PASS` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- テーブルのデータのダンプ `accounts`
--

INSERT INTO `accounts` (`USER_ID`, `MAIL`, `PASS`) VALUES
('democat', 'democ@t', 'd3m0d3m0c4t'),
('useruser', 'user@user', 'useruser');

-- --------------------------------------------------------

--
-- テーブルの構造 `bookmarks`
--

CREATE TABLE `bookmarks` (
  `user_id` varchar(10) NOT NULL,
  `title` varchar(300) NOT NULL,
  `timestamp` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- テーブルのデータのダンプ `bookmarks`
--

INSERT INTO `bookmarks` (`user_id`, `title`, `timestamp`) VALUES
('useruser', '専属マネジメント契約', '2024年11月22日 11時29分41秒'),
('useruser', 'モナド', '2024年11月25日 09時58分59秒'),
('useruser', 'ケーリー＝ディクソンの構成法', '2024年11月25日 10時19分17秒'),
('useruser', '日本とバルバドスの関係', '2024年11月27日 09時48分54秒'),
('useruser', '犯罪都市', '2024年11月27日 10時03分04秒');

--
-- ダンプしたテーブルのインデックス
--

--
-- テーブルのインデックス `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`USER_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
