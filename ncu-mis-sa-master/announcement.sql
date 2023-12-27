-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:3308
-- 產生時間： 2023-12-24 17:48:46
-- 伺服器版本： 10.4.32-MariaDB
-- PHP 版本： 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `hospital`
--

-- --------------------------------------------------------

--
-- 資料表結構 `announcement`
--

CREATE TABLE `announcement` (
  `announce_seq` int(11) NOT NULL,
  `announce_title` varchar(200) NOT NULL,
  `announce_content` longtext NOT NULL,
  `announce_update` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `announcement`
--

INSERT INTO `announcement` (`announce_seq`, `announce_title`, `announce_content`, `announce_update`) VALUES
(1, '112年12月門診時間表公告', '請點選圖片觀看', '2023-11-30 20:10:43'),
(2, '夏病冬治《三九貼》，預防改善過敏好時機', '今年度三九貼將於112年12月至113年1月提供貼敷服務', '2023-12-17 13:10:43'),
(3, '職場反暴力聲明', '全院同仁及工作者均有責任協助並確保免於職場暴力工作環境，為保障所有員工在執行職務過程中，免於遭受身體或精神不法侵害，特公開宣導「職場反暴力聲明」及反暴力海報來宣示「職場暴力零容忍」。', '2023-11-28 20:14:12'),
(4, '112年10月四癌篩檢活動場次公告', '112年10月份篩檢活動場次\r\n活動日期/時間：10/11 (三)　09:00-12:00 上午\r\n地點：醫療大樓一樓，篩檢服務站\r\n篩檢項目：口腔黏膜檢查\r\n\r\n備註：\r\n(1)前往篩檢活動請佩帶口罩及健保卡。\r\n(2)其他四大癌症篩檢相關問題，請洽癌症篩檢分機(04)22052121轉14823、14825，或LINE@洽詢。\r\n(3)如遇臺中市政府宣布停班停課或中央疫情指揮中心指示，該活動即取消!不便之處敬請見諒!\r\n \r\n\r\n \r\n\r\n \r\n\r\n ', '2023-10-01 20:14:12');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `announcement`
--
ALTER TABLE `announcement`
  ADD PRIMARY KEY (`announce_seq`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `announcement`
--
ALTER TABLE `announcement`
  MODIFY `announce_seq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
