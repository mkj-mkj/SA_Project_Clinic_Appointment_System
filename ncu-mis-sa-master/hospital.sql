-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:3308
-- 產生時間： 2023-12-24 14:03:50
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
-- 資料庫： `saproject`
--

-- --------------------------------------------------------

--
-- 資料表結構 `administrator`
--

CREATE TABLE `administrator` (
  `admin_id` int(11) NOT NULL,
  `adimn_name` varchar(30) NOT NULL,
  `adimn_mail` varchar(30) NOT NULL,
  `admin_password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `administrator`
--

INSERT INTO `administrator` (`admin_id`, `adimn_name`, `adimn_mail`, `admin_password`) VALUES
(1, '張興', 'xing21@gmail.com', '51264shn'),
(2, '李安琪', 'annnqi68@gmail.com', '105479fow'),
(3, '吳啓明', 'qishen90@gmail.com', '78410wism'),
(4, '王韻月', 'suyue208@gmail.com', 'suenf47610');

-- --------------------------------------------------------

--
-- 資料表結構 `announcement`
--

CREATE TABLE `announcement` (
  `annouce_seq` int(11) NOT NULL,
  `announce_title` varchar(200) NOT NULL,
  `announce_content` longtext NOT NULL,
  `announce_update` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `announcement`
--

INSERT INTO `announcement` (`annouce_seq`, `announce_title`, `announce_content`, `announce_update`) VALUES
(1, '112年12月門診時間表公告', '請點選圖片觀看', '2023-11-30 20:10:43'),
(2, '夏病冬治《三九貼》，預防改善過敏好時機', '今年度三九貼將於112年12月至113年1月提供貼敷服務', '2023-12-17 13:10:43'),
(3, '職場反暴力聲明', '全院同仁及工作者均有責任協助並確保免於職場暴力工作環境，為保障所有員工在執行職務過程中，免於遭受身體或精神不法侵害，特公開宣導「職場反暴力聲明」及反暴力海報來宣示「職場暴力零容忍」。', '2023-11-28 20:14:12'),
(4, '112年10月四癌篩檢活動場次公告', '112年10月份篩檢活動場次\r\n活動日期/時間：10/11 (三)　09:00-12:00 上午\r\n地點：醫療大樓一樓，篩檢服務站\r\n篩檢項目：口腔黏膜檢查\r\n\r\n備註：\r\n(1)前往篩檢活動請佩帶口罩及健保卡。\r\n(2)其他四大癌症篩檢相關問題，請洽癌症篩檢分機(04)22052121轉14823、14825，或LINE@洽詢。\r\n(3)如遇臺中市政府宣布停班停課或中央疫情指揮中心指示，該活動即取消!不便之處敬請見諒!\r\n \r\n\r\n \r\n\r\n \r\n\r\n ', '2023-10-01 20:14:12');

-- --------------------------------------------------------

--
-- 資料表結構 `appointment`
--

CREATE TABLE `appointment` (
  `appointment_seq` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `reserve_time` datetime NOT NULL,
  `appointment` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `appointment`
--

INSERT INTO `appointment` (`appointment_seq`, `doctor_id`, `user_id`, `reserve_time`, `appointment`) VALUES
(1, 1, 'A101149730', '2023-12-20 19:59:33', 1011),
(2, 6, 'Y289297096', '2023-12-18 19:59:33', 1012),
(3, 6, 'G266422856', '2023-12-17 13:02:24', 1013),
(4, 2, 'E165790119', '2023-12-20 20:02:24', 1015),
(5, 1, 'D254641099', '2023-12-13 20:03:34', 1016),
(6, 4, 'N130494478', '2023-12-17 16:03:34', 1018);

-- --------------------------------------------------------

--
-- 資料表結構 `clinic`
--

CREATE TABLE `clinic` (
  `clinic_id` int(11) NOT NULL,
  `clinic_name` varchar(80) NOT NULL,
  `dept_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `clinic`
--

INSERT INTO `clinic` (`clinic_id`, `clinic_name`, `dept_id`) VALUES
(7120, '心臟血管科', 2),
(7123, '胸腔外科', 2),
(7411, '神經科', 1),
(7421, '感染科', 1),
(7710, '耳科', 3),
(7755, '鼻科', 3);

-- --------------------------------------------------------

--
-- 資料表結構 `department`
--

CREATE TABLE `department` (
  `dept_id` int(11) NOT NULL,
  `dept_name` varchar(80) NOT NULL,
  `dept_info` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `department`
--

INSERT INTO `department` (`dept_id`, `dept_name`, `dept_info`) VALUES
(1, '内科\r\n', '咳嗽、發燒、高血壓、身體不適、常見疾病的預防與診治。'),
(2, '外科', '肝膽手術、微創膽囊切除、微創膽道取石、甲狀腺、副甲狀腺手術、乳房各種手術及乳房腫瘤治療。'),
(3, '耳鼻喉科', '感冒、咳嗽、聲音沙啞、吞嚥困難、鼻炎、鼻瘜肉、耳鳴、中耳炎、顏面神經麻痺、顳顎關節痛、打鼾、臉部/頸部/舌部/口咽腫瘤、聽力/語言/味覺/嗅覺/睡眠障礙。');

-- --------------------------------------------------------

--
-- 資料表結構 `doctor`
--

CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL,
  `doctor_name` varchar(250) NOT NULL,
  `dept_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `doctor`
--

INSERT INTO `doctor` (`doctor_id`, `doctor_name`, `dept_id`) VALUES
(1, '周勝', 1),
(2, '汪涵', 1),
(3, '黃文浩', 2),
(4, '彭城元', 3),
(5, '李健鵬', 2),
(6, '馮易慶', 3),
(7, '謝欣怡', 2),
(8, '陳益民', 2),
(9, '戴哲銘', 2),
(10, '董子昀', 2),
(11, '劉晏俊', 2),
(12, '溫奕誠', 2),
(13, '唐善志', 2),
(14, '李智凱', 1),
(15, '高家祥', 1),
(16, '林毅', 1),
(17, '吳以程', 1),
(18, '胡家璇', 1),
(19, '阮瑞權', 1),
(20, '任俊森', 1);

-- --------------------------------------------------------

--
-- 資料表結構 `room`
--

CREATE TABLE `room` (
  `room_id` int(11) NOT NULL,
  `room_num` varchar(10) NOT NULL,
  `clinic_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `room`
--

INSERT INTO `room` (`room_id`, `room_num`, `clinic_id`) VALUES
(1001, '1', 7120),
(1002, '2', 7421),
(1101, '1', 7411),
(1102, '2', 7411),
(1401, '1', 7710),
(1501, '1', 7755),
(1701, '1', 7123);

-- --------------------------------------------------------

--
-- 資料表結構 `schedule`
--

CREATE TABLE `schedule` (
  `schedule_seq` int(5) NOT NULL,
  `datetime` date NOT NULL,
  `clinic_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `MaxCapacity` int(5) NOT NULL DEFAULT 25,
  `CurrentRegistrations` int(5) NOT NULL DEFAULT 0,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `schedule`
--

INSERT INTO `schedule` (`schedule_seq`, `datetime`, `clinic_id`, `doctor_id`, `MaxCapacity`, `CurrentRegistrations`, `time`) VALUES
(1, '2024-01-09', 7411, 14, 25, 2, 'noon'),
(2, '2024-01-01', 7411, 1, 25, 5, 'noon'),
(3, '2023-12-30', 7411, 16, 25, 7, 'noon'),
(4, '2024-01-09', 7411, 2, 25, 0, 'morning'),
(5, '2023-12-31', 7411, 17, 25, 1, 'noon'),
(6, '2024-01-02', 7411, 2, 25, 10, 'morning'),
(7, '2024-01-08', 7411, 1, 25, 5, 'night'),
(8, '2024-01-01', 7411, 1, 25, 0, 'night'),
(9, '2024-01-03', 7411, 2, 25, 8, 'morning'),
(10, '2024-01-03', 7411, 14, 25, 7, 'noon'),
(11, '2024-01-02', 7411, 14, 25, 8, 'noon'),
(12, '2024-01-04', 7411, 15, 25, 8, 'noon'),
(13, '2024-01-04', 7411, 15, 25, 8, 'morning'),
(14, '2024-01-05', 7411, 16, 25, 8, 'morning'),
(15, '2024-01-08', 7411, 1, 25, 5, 'noon'),
(16, '2024-01-05', 7411, 17, 25, 2, 'noon'),
(17, '2024-01-06', 7411, 16, 25, 7, 'noon'),
(18, '2024-01-07', 7411, 17, 25, 1, 'noon'),
(19, '2024-01-10', 7411, 14, 25, 5, 'noon'),
(20, '2024-01-10', 7411, 2, 25, 5, 'morning'),
(21, '2024-01-11', 7411, 15, 25, 9, 'noon'),
(22, '2024-01-11', 7411, 15, 25, 3, 'morning'),
(23, '2024-01-12', 7411, 16, 25, 4, 'morning'),
(24, '2024-01-12', 7411, 17, 25, 25, 'noon'),
(25, '2023-12-30', 7123, 8, 25, 18, 'morning'),
(26, '2023-12-30', 7123, 8, 25, 19, 'noon'),
(27, '2023-12-31', 7123, 8, 25, 13, 'noon'),
(28, '2024-01-01', 7123, 3, 25, 14, 'noon'),
(29, '2024-01-01', 7123, 3, 25, 14, 'night'),
(31, '2024-01-02', 7123, 5, 25, 20, 'morning'),
(32, '2024-01-02', 7123, 5, 25, 20, 'noon'),
(33, '2024-01-03', 7123, 3, 25, 12, 'morning'),
(34, '2024-01-03', 7123, 3, 25, 23, 'noon'),
(35, '2024-01-03', 7123, 7, 25, 23, 'night'),
(36, '2024-01-04', 7123, 8, 25, 2, 'noon'),
(37, '2024-01-05', 7123, 5, 25, 24, 'morning'),
(38, '2024-01-05', 7123, 5, 25, 2, 'noon'),
(39, '2024-01-05', 7123, 7, 25, 4, 'night'),
(40, '2024-01-06', 7123, 8, 25, 7, 'morning'),
(41, '2024-01-06', 7123, 8, 25, 6, 'noon'),
(42, '2024-01-07', 7123, 8, 25, 3, 'noon'),
(43, '2024-01-08', 7123, 3, 25, 4, 'noon'),
(44, '2024-01-08', 7123, 3, 25, 8, 'night'),
(45, '2024-01-09', 7123, 5, 25, 8, 'morning'),
(46, '2024-01-09', 7123, 5, 25, 5, 'noon'),
(47, '2024-01-10', 7123, 3, 25, 5, 'morning'),
(48, '2024-01-10', 7123, 3, 25, 5, 'noon'),
(49, '2024-01-10', 7123, 7, 25, 3, 'night'),
(50, '2024-01-11', 7123, 8, 25, 4, 'noon'),
(51, '2024-01-12', 7123, 5, 25, 2, 'morning'),
(52, '2024-01-12', 7123, 5, 25, 1, 'noon'),
(53, '2024-01-12', 7123, 7, 25, 5, 'night'),
(54, '2023-12-30', 7421, 18, 25, 23, 'night'),
(55, '2023-12-31', 7421, 20, 25, 2, 'night'),
(56, '2024-01-01', 7421, 18, 25, 24, 'night'),
(57, '2024-01-02', 7421, 19, 25, 2, 'noon'),
(58, '2024-01-03', 7421, 18, 25, 4, 'morning'),
(59, '2024-01-03', 7421, 19, 25, 7, 'noon'),
(60, '2024-01-04', 7421, 19, 25, 6, 'night'),
(61, '2024-01-05', 7421, 20, 25, 3, 'morning'),
(62, '2024-01-05', 7421, 20, 25, 4, 'morning'),
(63, '2024-01-06', 7421, 18, 25, 8, 'night'),
(64, '2024-01-07', 7421, 20, 25, 8, 'night'),
(65, '2024-01-08', 7421, 18, 25, 5, 'night'),
(66, '2024-01-09', 7421, 19, 25, 5, 'noon'),
(67, '2024-01-10', 7421, 18, 25, 5, 'morning'),
(68, '2024-01-10', 7421, 19, 25, 3, 'noon'),
(69, '2024-01-11', 7421, 19, 25, 4, 'noon'),
(70, '2024-01-12', 7421, 20, 25, 2, 'morning'),
(71, '2024-01-12', 7421, 20, 25, 1, 'noon');

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
-- 資料表索引 `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`admin_id`);

--
-- 資料表索引 `announcement`
--
ALTER TABLE `announcement`
  ADD PRIMARY KEY (`annouce_seq`);

--
-- 資料表索引 `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`appointment_seq`),
  ADD KEY `doctor_id` (`doctor_id`),
  ADD KEY `user_id` (`user_id`);

--
-- 資料表索引 `clinic`
--
ALTER TABLE `clinic`
  ADD PRIMARY KEY (`clinic_id`),
  ADD KEY `dept_id` (`dept_id`);

--
-- 資料表索引 `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dept_id`);

--
-- 資料表索引 `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctor_id`),
  ADD KEY `dept_id` (`dept_id`);

--
-- 資料表索引 `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`room_id`),
  ADD KEY `clinic_id` (`clinic_id`);

--
-- 資料表索引 `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`schedule_seq`),
  ADD KEY `schedule_ibfk_1` (`doctor_id`),
  ADD KEY `clinic_id` (`clinic_id`),
  ADD KEY `clinic_id_2` (`clinic_id`);

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
-- 使用資料表自動遞增(AUTO_INCREMENT) `administrator`
--
ALTER TABLE `administrator`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `announcement`
--
ALTER TABLE `announcement`
  MODIFY `annouce_seq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `appointment`
--
ALTER TABLE `appointment`
  MODIFY `appointment_seq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `doctor`
--
ALTER TABLE `doctor`
  MODIFY `doctor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `schedule`
--
ALTER TABLE `schedule`
  MODIFY `schedule_seq` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `users`
--
ALTER TABLE `users`
  MODIFY `case_number` int(13) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- 資料表的限制式 `clinic`
--
ALTER TABLE `clinic`
  ADD CONSTRAINT `clinic_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 資料表的限制式 `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 資料表的限制式 `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`clinic_id`) REFERENCES `clinic` (`clinic_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 資料表的限制式 `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`clinic_id`) REFERENCES `clinic` (`clinic_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
