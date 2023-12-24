-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:3308
-- 產生時間： 2023-12-24 17:48:02
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
-- 資料表結構 `users`
--

CREATE TABLE `users` (
  `user_id` varchar(20) NOT NULL,
  `case_number` int(13) NOT NULL,
  `name` varchar(30) NOT NULL,
  `user_address` varchar(255) NOT NULL,
  `user_birth` date NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_gender` tinyint(1) NOT NULL,
  `user_phone` varchar(20) NOT NULL,
  `residence_tel` varchar(20) NOT NULL,
  `blood` varchar(10) NOT NULL,
  `height` float NOT NULL,
  `weight` float NOT NULL,
  `allergy_history` varchar(255) NOT NULL,
  `serverill_history` varchar(255) NOT NULL,
  `contact_name` varchar(30) NOT NULL,
  `contact_rel` varchar(10) NOT NULL,
  `contact_tel` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `users`
--

INSERT INTO `users` (`user_id`, `case_number`, `name`, `user_address`, `user_birth`, `user_email`, `user_gender`, `user_phone`, `residence_tel`, `blood`, `height`, `weight`, `allergy_history`, `serverill_history`, `contact_name`, `contact_rel`, `contact_tel`) VALUES
('A101149730', 1, '黃嘉誠', '404台中市北區崇德路一段577-17號', '1966-12-07', 'jiacheng@gmail.com', 1, '022760633', '0934626926', 'A', 177.4, 62.5, '無', '急性心肌梗塞', '肖淑芬', '妻子', '0935253126'),
('D254641099', 4, '李琦珊', '600嘉義市西區北興街301號', '1993-01-12', 'shan57@gamil.com', 0, '0930955343', '06928109', 'O', 158.7, 45.1, '花生敏感', '無', '李祥', '父女', '0972917489'),
('E165790119', 6, '吳剛', '510彰化縣員林市141縣道444號', '1992-07-15', 'gang943@gamil.com', 1, '0963370185', '022757343', 'O', 172.5, 66.3, '無', '無', '吳晗', '兄弟', '0934517070'),
('G266422856', 5, '張欣怡', '632雲林縣虎尾鎮中正路195-5號', '2001-02-11', 'yi32yun@gamil.com', 0, '0968695172', '028750430', 'AB', 162.3, 50.2, '牛奶過敏', '前十字韌帶撕脫性骨折', '鄭子琪', '母女', '0919172640'),
('N130494478', 7, '王浩宇', '521彰化縣北斗鎮復興路170號', '2002-06-26', 'yu329h@gmail.com', 1, '0938957981', '028777880', 'B', 182.2, 72.7, '鷄蛋過敏', '腸胃炎', '王佳芬', '母子', '0961884154'),
('Y289297096', 8, '徐珍', '807高雄市三民區建工路710號', '1966-03-20', 'zhengx34@gamil.com', 0, '0935292126', '043097918', 'A', 166.2, 59.8, '無', '無', '徐嬌', '姐妹', '0958257253');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `case_number` (`case_number`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `users`
--
ALTER TABLE `users`
  MODIFY `case_number` int(13) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
