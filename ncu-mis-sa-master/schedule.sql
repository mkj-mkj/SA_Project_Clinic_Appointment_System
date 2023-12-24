-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:3308
-- 產生時間： 2023-12-24 17:48:09
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

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`schedule_seq`),
  ADD KEY `schedule_ibfk_1` (`doctor_id`),
  ADD KEY `clinic_id` (`clinic_id`),
  ADD KEY `clinic_id_2` (`clinic_id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `schedule`
--
ALTER TABLE `schedule`
  MODIFY `schedule_seq` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- 已傾印資料表的限制式
--

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
