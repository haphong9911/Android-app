-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 22, 2021 lúc 01:55 PM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `apptruyen`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `admin`
--

CREATE TABLE `admin` (
  `IDadmin` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `admin`
--

INSERT INTO `admin` (`IDadmin`, `fullname`, `email`, `password`, `created_at`, `updated_at`) VALUES
(1, 'Thuy', 'Thuy@gmail.com', '25d55ad283aa400af464c76d713c07ad', '2021-01-20 14:14:16', '2021-01-20 14:14:16'),
(2, 'Nho', 'vannho@gmail.com', '25d55ad283aa400af464c76d713c07ad', '2021-01-21 02:38:21', '2021-01-21 02:38:21'),
(3, 'Nho', 'vannho@gmail.com', '25d55ad283aa400af464c76d713c07ad', '2021-01-21 02:43:16', '2021-01-21 02:43:16');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `IDtheloai` int(10) NOT NULL,
  `tentheloai` varchar(255) NOT NULL,
  `hinhtheloai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`IDtheloai`, `tentheloai`, `hinhtheloai`) VALUES
(2, 'dasadasdasdasd333', 'sadasd2222333'),
(4, 'Xuyen Khong', 'xuyenkhong.jpg'),
(5, 'Dam my', 'dammy.jpg'),
(9, 'Ngon Tinh', 'ngontinh.jpg'),
(10, 'Bach hop', 'https://cdn.vietnammoi.vn/171464242508312576/2020/7/14/bd70e799e48a9754d87836fdde8c9376-1557747742982100756118-15947203770381809180629.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chuong`
--

CREATE TABLE `chuong` (
  `IDchuong` int(11) NOT NULL,
  `IDtruyen` int(10) NOT NULL,
  `tenchuong` varchar(255) NOT NULL,
  `noidung` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chuong`
--

INSERT INTO `chuong` (`IDchuong`, `IDtruyen`, `tenchuong`, `noidung`, `created_at`, `updated_at`) VALUES
(1, 3, 'adncbf', '<p>sfsdfsdgfsdfsdfsdfs</p>\r\n', '2021-01-22 12:45:53', '2021-01-22 12:45:53'),
(2, 3, 'adncbf', '<p>&aacute;Ä‘&aacute;</p>\r\n', '2021-01-22 12:47:17', '2021-01-22 12:47:17'),
(3, 3, 'sdáº¥dÃ¡Ä‘Ã¢sÄ‘asad', '<p>&aacute;Ä‘&acirc;sÄ‘asad</p>\r\n', '2021-01-22 12:48:35', '2021-01-22 12:48:35'),
(4, 3, 'sdáº¥dÃ¡Ä‘Ã¢sÄ‘asad', '<p>&aacute;Ä‘&acirc;sÄ‘asad</p>\r\n', '2021-01-22 12:49:16', '2021-01-22 12:49:16'),
(5, 3, 'scÄ‘Ã¢sÄ‘Ã¢sd', '<p>&aacute;Ä‘&acirc;sÄ‘&acirc;sd</p>\r\n', '2021-01-22 12:49:28', '2021-01-22 12:49:28'),
(6, 3, 'Ã¡Ä‘Ã¢sÄ‘áº¥', '<p>sadáº§df&aacute;df&aacute;dc&aacute;df</p>\r\n', '2021-01-22 12:52:30', '2021-01-22 12:52:30');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `docganday`
--

CREATE TABLE `docganday` (
  `IDdocganday` int(10) NOT NULL,
  `IDuser` int(10) NOT NULL,
  `IDtruyen` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `downloadbook`
--

CREATE TABLE `downloadbook` (
  `IDtaitruyen` int(11) NOT NULL,
  `IDtruyen` int(10) NOT NULL,
  `IDuser` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `story`
--

CREATE TABLE `story` (
  `IDtruyen` int(10) NOT NULL,
  `IDtheloai` int(10) NOT NULL,
  `tentruyen` varchar(255) NOT NULL,
  `tacgia` int(10) NOT NULL,
  `hinhanhtruyen` varchar(255) NOT NULL,
  `tomtat` text NOT NULL,
  `status` int(1) NOT NULL,
  `chuong` int(10) NOT NULL,
  `luotxem` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `story`
--

INSERT INTO `story` (`IDtruyen`, `IDtheloai`, `tentruyen`, `tacgia`, `hinhanhtruyen`, `tomtat`, `status`, `chuong`, `luotxem`, `created_at`, `updated_at`) VALUES
(1, 2, 'ahihi', 0, '', '', 0, 0, 0, '2021-01-21 17:14:38', '2021-01-21 17:14:38'),
(2, 4, 'adsadasd', 2, '', '', 1, 0, 0, '2021-01-21 17:17:29', '2021-01-21 17:17:29'),
(3, 5, 'dÃ¢fasdsds', 3, 'https://cdn.vietnammoi.vn/171464242508312', '<p>asdasdasd</p>\r\n', 0, 6, 0, '2021-01-22 02:41:46', '2021-01-22 02:41:46'),
(4, 9, 'as', 3, 'ngontinh.jpg', '', 1, 0, 0, '2021-01-22 02:47:37', '2021-01-22 02:47:37'),
(5, 9, 'aÃ¢', 3, 'truyenteen.jpg', '', 0, 0, 0, '2021-01-22 03:46:03', '2021-01-22 03:46:03'),
(6, 2, 'aaa', 3, 'ngontinh.jpg', '<p>saÄ‘&acirc;sd</p>\r\n', 0, 0, 0, '2021-01-22 03:52:31', '2021-01-22 03:52:31'),
(7, 2, 'asadsd', 3, '', '<p>sfasfdasde</p>\r\n', 0, 0, 0, '2021-01-22 06:31:17', '2021-01-22 06:31:17'),
(8, 4, 'sfsfsd', 3, '', '<p>dasdasd</p>\r\n', 0, 0, 0, '2021-01-22 06:33:46', '2021-01-22 06:33:46'),
(9, 2, 'asdsds', 3, '', '<p>sadas</p>\r\n', 0, 0, 0, '2021-01-22 06:34:27', '2021-01-22 06:34:27'),
(10, 2, 'asdasd', 3, '', '<p>asdasdasd</p>\r\n', 0, 0, 0, '2021-01-22 06:36:22', '2021-01-22 06:36:22'),
(11, 2, 'https://img2.thuthuatphanmem.vn/uploads/2019/01/19/that-tich-khong-mua-lau-vu-tinh_022918959.jpg', 3, 'truyenteen.jpg', '<p>sasas</p>\r\n', 0, 0, 0, '2021-01-22 07:04:50', '2021-01-22 07:04:50'),
(12, 2, 'sdasd', 3, 'https://img2.thuthuatphanmem.vn/uploads/2019/01/19/that-tich-khong-mua-lau-vu-tinh_022918959.jpg', '<p>asdasd</p>\r\n', 0, 0, 0, '2021-01-22 07:07:32', '2021-01-22 07:07:32');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblauthors`
--

CREATE TABLE `tblauthors` (
  `id_author` int(11) NOT NULL,
  `authorName` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `tblauthors`
--

INSERT INTO `tblauthors` (`id_author`, `authorName`, `created_at`, `updated_at`) VALUES
(3, 'Dang Thanh Thuy', '2021-01-22 02:41:23', '2021-01-22 02:41:23');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `IDuser` int(10) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `tendangnhap` varchar(255) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `ngaysinh` date NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `yeuthich`
--

CREATE TABLE `yeuthich` (
  `IDyeuthich` int(11) NOT NULL,
  `IDtruyen` int(10) NOT NULL,
  `IDuser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`IDadmin`);

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`IDtheloai`);

--
-- Chỉ mục cho bảng `chuong`
--
ALTER TABLE `chuong`
  ADD PRIMARY KEY (`IDchuong`);

--
-- Chỉ mục cho bảng `docganday`
--
ALTER TABLE `docganday`
  ADD PRIMARY KEY (`IDdocganday`);

--
-- Chỉ mục cho bảng `downloadbook`
--
ALTER TABLE `downloadbook`
  ADD PRIMARY KEY (`IDtaitruyen`);

--
-- Chỉ mục cho bảng `story`
--
ALTER TABLE `story`
  ADD PRIMARY KEY (`IDtruyen`);

--
-- Chỉ mục cho bảng `tblauthors`
--
ALTER TABLE `tblauthors`
  ADD PRIMARY KEY (`id_author`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`IDuser`);

--
-- Chỉ mục cho bảng `yeuthich`
--
ALTER TABLE `yeuthich`
  ADD PRIMARY KEY (`IDyeuthich`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `admin`
--
ALTER TABLE `admin`
  MODIFY `IDadmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `IDtheloai` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `chuong`
--
ALTER TABLE `chuong`
  MODIFY `IDchuong` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `docganday`
--
ALTER TABLE `docganday`
  MODIFY `IDdocganday` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `downloadbook`
--
ALTER TABLE `downloadbook`
  MODIFY `IDtaitruyen` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `story`
--
ALTER TABLE `story`
  MODIFY `IDtruyen` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `tblauthors`
--
ALTER TABLE `tblauthors`
  MODIFY `id_author` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `IDuser` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `yeuthich`
--
ALTER TABLE `yeuthich`
  MODIFY `IDyeuthich` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
