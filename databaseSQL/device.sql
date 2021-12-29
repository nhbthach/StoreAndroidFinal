-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 04, 2020 lúc 08:21 AM
-- Phiên bản máy phục vụ: 10.4.14-MariaDB
-- Phiên bản PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `device`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `madonhang` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `tensanpham` varchar(1000) NOT NULL,
  `giasanpham` int(11) NOT NULL,
  `soluongsanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `madonhang`, `masanpham`, `tensanpham`, `giasanpham`, `soluongsanpham`) VALUES
(1, 9, 5, 'Điện thoại Samsung Galaxy A21s (6GB/64GB)', 26950000, 5),
(2, 9, 2, 'Laptop Acer Aspire A315 56 308N i3 1005G1/4GB/256GB/Win10 (NX.HS5SV.00C)', 32370000, 3),
(3, 9, 19, 'Điện thoại Samsung Galaxy Note 20 Ultra\r\n\r\n', 119960000, 4),
(4, 10, 5, 'Điện thoại Samsung Galaxy A21s (6GB/64GB)', 26950000, 5),
(5, 10, 2, 'Laptop Acer Aspire A315 56 308N i3 1005G1/4GB/256GB/Win10 (NX.HS5SV.00C)', 32370000, 3),
(6, 10, 19, 'Điện thoại Samsung Galaxy Note 20 Ultra\r\n\r\n', 119960000, 4),
(7, 11, 5, 'Điện thoại Samsung Galaxy A21s (6GB/64GB)', 26950000, 5),
(8, 11, 2, 'Laptop Acer Aspire A315 56 308N i3 1005G1/4GB/256GB/Win10 (NX.HS5SV.00C)', 32370000, 3),
(9, 11, 19, 'Điện thoại Samsung Galaxy Note 20 Ultra\r\n\r\n', 119960000, 4),
(10, 12, 5, 'Điện thoại Samsung Galaxy A21s (6GB/64GB)', 26950000, 5),
(11, 12, 2, 'Laptop Acer Aspire A315 56 308N i3 1005G1/4GB/256GB/Win10 (NX.HS5SV.00C)', 32370000, 3),
(12, 12, 19, 'Điện thoại Samsung Galaxy Note 20 Ultra\r\n\r\n', 119960000, 4),
(13, 13, 2, 'Laptop Acer Aspire A315 56 308N i3 1005G1/4GB/256GB/Win10 (NX.HS5SV.00C)', 21580000, 2),
(14, 13, 1, 'Điện thoại iPhone 11 Pro Max 64GB', 101970000, 3),
(15, 14, 1, 'Điện thoại iPhone 11 Pro Max 64GB', 33990000, 1),
(16, 14, 3, 'Laptop Dell Vostro 3590 i7 10510U/8GB/256GB/2GB 610R5/Win10 (GRMGK2)\r\n', 20290000, 1),
(17, 14, 4, 'Laptop Lenovo Ideapad S145 15IWL i7 8565U/8GB/512GB/2GB MX110/Win10 (81MV00TAVN)', 18590000, 1),
(18, 15, 2, 'Laptop Acer Aspire A315 56 308N i3 1005G1/4GB/256GB/Win10 (NX.HS5SV.00C)', 10790000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(100) NOT NULL,
  `sodienthoai` int(100) NOT NULL,
  `email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `tenkhachhang`, `sodienthoai`, `email`) VALUES
(7, 'Thach', 974757799, 'bthach@gmail.com'),
(8, 'HelloMan', 974757777, 'nhbtha@gmail.com'),
(9, 'baothach', 2147483647, 'bthach@gmail.com'),
(10, 'baothach', 2147483647, 'bthach@gmail.com'),
(11, 'baothach', 2147483647, 'bthach@gmail.com'),
(12, 'hello', 123456789, 'bthachne@gmail.com'),
(13, 'baothachvip', 912131415, 'daylamail@gmail.com'),
(14, 'muahang', 199999999, 'nhbthach@gmail.com'),
(15, 'nhbhthac', 642424734, 'asdadadad@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) NOT NULL,
  `hinhanhloaisanpham` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenloaisanpham`, `hinhanhloaisanpham`) VALUES
(1, 'Điện thoại', 'https://i.pinimg.com/564x/c5/60/83/c56083ad76ea4c50d04a31b7deed0a02.jpg'),
(2, 'Laptop', 'https://i.pinimg.com/564x/63/27/dc/6327dc05b7533e1896f37ed18d5926f8.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL,
  `motasanpham` varchar(5000) NOT NULL,
  `idsanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idsanpham`) VALUES
(1, 'Điện thoại iPhone 11 Pro Max 64GB', 33990000, 'https://cdn.tgdd.vn/Products/Images/42/200533/iphone-11-pro-max-black-400x460.png', 'Camera được cải tiến mạnh mẽ. Hiệu năng \"đè bẹp\" mọi đối thủ. Dung lượng pin \'trâu\'. Khả năng phát nội dung Dolby Vision với độ sáng 1200 nits. Khả năng chống bụi bẩn và mồ hôi. Màn hình: OLED, 6.5\", Super Retina XDR, HDH iOS 13. Có 3 Camera 12MP. CPU:  Apple A13 Bionic 6 nhân. RAM: 4G. Bộ nhớ trong: 64GB.', 1),
(2, 'Laptop Acer Aspire A315 56 308N i3 1005G1/4GB/256GB/Win10 (NX.HS5SV.00C)', 10790000, 'https://cdn.tgdd.vn/Products/Images/44/223654/acer-aspire-a315-56-308n-i3-nxhs5sv00c-15-223654-600x600.jpg', 'CPU: Intel Core i3 Ice Lake, 1005G1, 1.20 GHz. RAM: 4 GB, DDR4 (On board +1 khe), 2400 MHz. Ổ cứng: SSD 256GB NVMe PCIe, Hỗ trợ khe cắm HDD SATA. Màn hình: 15.6 inch, Full HD (1920 x 1080). Card màn hình: Card đồ họa tích hợp, Intel UHD Graphics. Cổng kết nối: 2 x USB 2.0, USB 3.1, HDMI, LAN (RJ45). Hệ điều hành: Windows 10 Home SL. Thiết kế: Vỏ nhựa, PIN liền. Kích thước: Dày 19.9 mm, 1.7 kg', 2),
(3, 'Laptop Dell Vostro 3590 i7 10510U/8GB/256GB/2GB 610R5/Win10 (GRMGK2)\r\n', 20290000, 'https://cdn.tgdd.vn/Products/Images/44/220718/dell-vostro-3590-i7-grmgk2-220718-220718-600x600.jpg', 'CPU: Intel Core i7 Comet Lake, 10510U, 1.80 GHz. RAM: 8 GB, DDR4 (On board +1 khe), 2666 MHz. Ổ cứng: SSD 256GB NVMe PCIe, Hỗ trợ khe cắm HDD SATA. Màn hình: 15.6 inch, Full HD (1920 x 1080). Card màn hình: Card đồ họa rời, AMD Radeon 610R5, 2GB. Cổng kết nối: 2 x USB 3.1, HDMI, LAN (RJ45), USB 2.0, VGA (D-Sub). Hệ điều hành: Windows 10 Home SL. Thiết kế: Vỏ nhựa, PIN liền. Kích thước: Dày 19.8 mm, 1.99 kg', 2),
(4, 'Laptop Lenovo Ideapad S145 15IWL i7 8565U/8GB/512GB/2GB MX110/Win10 (81MV00TAVN)', 18590000, 'https://cdn.tgdd.vn/Products/Images/44/207797/lenovo-ideapad-s145-15iwl-i7-8565u-8gb-512gb-mx110-025820-105848-600x600.jpg', 'CPU: Intel Core i7 Coffee Lake, 8565U, 1.80 GHz. RAM: 8 GB, DDR4 (On board 4GB +1 khe 4GB), 2400 MHz. Ổ cứng: SSD 512 GB M.2 PCIe. Màn hình: 15.6 inch, Full HD (1920 x 1080). Card màn hình: Card đồ họa rời, NVIDIA GeForce MX110, 2GB. Cổng kết nối: 2 x USB 3.0, HDMI, USB 2.0. Hệ điều hành: Windows 10 Home SL. Thiết kế:	Vỏ nhựa, PIN liền. Kích thước: Dày 19.9mm, 1.73 kg', 2),
(5, 'Điện thoại Samsung Galaxy A21s (6GB/64GB)', 5390000, 'https://cdn.tgdd.vn/Products/Images/42/219314/samsung-galaxy-a21s-055620-045627-400x460.png', 'Thiết kế cao cấp, cảm biến vân tay ở mặt lưng. Màn hình chính của máy kích thước 6.5 inch với độ phân giải  HD+ (720 x 1520 Pixels). Vi xử lý 8 nhân tốc độ 2.0 GHz, đi kèm với dung lượng  RAM 6 GB và bộ nhớ trong lên đến 64 GB. Cụm 4 camera sau 48 MP ấn tượng. Pin lên đến 5000 mAh', 1),
(6, 'Điện thoại OPPO Reno3', 7490000, 'https://cdn.tgdd.vn/Products/Images/42/213591/oppo-reno3-trang-400x460-400x460.png', '4 cụm Camera, ống kính góc siêu rộng 8 MP, cảm biến xóa phông trắng đen 2 MP và camera tele 13 MP. Màn hình Super AMOLED Full HD+ trên OPPO Reno3 , dải màu chuẩn điện ảnh DCI-P3 và cho độ sáng cực cao lên đến 1200 nits. Chip Helio P90 8 nhân. Công nghệ sạc pin nhanh Super VOOC 3.0. RAM 8G, bộ nhớ trong 128GB', 1),
(7, 'Điện thoại iPhone 11 Pro Max 256GB', 37990000, 'https://cdn.tgdd.vn/Products/Images/42/210653/iphone-11-pro-max-256gb-black-400x460.png', 'Pro về camera sau. Không chỉ có camera sau được nâng cấp mà camera selfie trên iPhone 11 Pro Max cũng được nâng lên độ phân giải 12 MP thay vì 7 MP như trước. Bộ nhớ trong lớn lên tới 256 GB giúp bạn thoải mái quay video 4K, chụp hình độ phân giải cao hay tải game và ứng dụng. Đây là chiếc iPhone có dung lượng pin lớn nhất từ trước tới nay mà Apple từng sản xuất.', 1),
(8, 'Laptop Lenovo IdeaPad S145 15IIL i3 1005G1/4GB/256GB/Win10 (81W8001XVN)', 9890000, 'https://cdn.tgdd.vn/Products/Images/44/216292/lenovo-ideapad-s145-81w8001xvn-a4-216292-600x600.jpg', 'CPU: Intel Core i3 Ice Lake, 1005G1, 1.20 GHz. RAM: 4 GB, DDR4 (On board +1 khe), 2666 MHz. Ổ cứng: SSD 256GB NVMe PCIe, Hỗ trợ khe cắm HDD SATA. Màn hình: 15.6 inch, Full HD (1920 x 1080). Card màn hình: Card đồ họa tích hợp, Intel UHD Graphics. Cổng kết nối:	2 x USB 3.0, HDMI, USB 2.0. Hệ điều hành: Windows 10 Home SL. Thiết kế: Vỏ nhựa, PIN liền. Kích thước: Dày17.9 mm, 1.79kg', 2),
(9, 'Điện thoại BlackBerry KEY2\r\n', 10390000, 'https://cdn.tgdd.vn/Products/Images/42/171028/blackberry-key2-3-400x460.png', 'Màn hình: IPS LCD, 4.5\", Full HD. Hệ điều hành: Android 8 (Oreo). Camera sau: Chính 12 MP & Phụ 12 MP. Camera trước:	8 MP. CPU: Snapdragon 660 8 nhân. RAM: 6 GB. Bộ nhớ trong: 64 GB. Thẻ nhớ:	MicroSD, hỗ trợ tối đa', 1),
(10, 'Laptop Acer Nitro AN515 43 R9FD R5 3550H/8GB/512GB/4GB GTX1650/Win10 (NH.Q6ZSV.003)', 17540000, 'https://cdn.tgdd.vn/Products/Images/44/221409/acer-nitro-an515-43-r5-nhq6zsv003-221409-600x600.jpg', 'CPU: AMD Ryzen 5, 3550H, 2.10 GHz. RAM: 8 GB, DDR4 (2 khe), 2400 MHz. Ổ cứng: SSD 512 GB M.2 PCIe, Hỗ trợ khe cắm HDD SATA. Màn hình: 15.6 inch, Full HD (1920 x 1080). Card màn hình: Card đồ họa rời, NVIDIA GeForce GTX 1650 4GB. Cổng kết nối: 2 x USB 3.1, HDMI, LAN (RJ45), USB 2.0, USB Type-C. Hệ điều hành: Windows 10 Home SL. Thiết kế:	Vỏ nhựa, PIN liền. Kích thước: Dày 25.9 mm, 2.3 kg.', 2),
(11, 'Điện thoại Huawei Nova 5T', 8999000, 'https://cdn.tgdd.vn/Products/Images/42/209795/huawei-nova-5t-400x460-400x460.png', 'Màn hình: IPS LCD, 6.26\", Full HD+. Hệ điều hành: Android 9 (Pie). Camera sau: Chính 48 MP & Phụ 16 MP, 2 MP, 2 MP. Camera trước: 32 MP. CPU: Kirin 980 8 nhân. RAM: 8 GB. Bộ nhớ trong: 128 GB', 1),
(12, 'Laptop HP 348 G7 i3 8130U/4GB/256GB/Win10 (9PG83PA)\r\n', 10990000, 'https://cdn.tgdd.vn/Products/Images/44/221511/hp-348-g7-i3-9pg83pa-030020-110045-600x600.jpg', 'CPU: Intel Core i3 Coffee Lake, 8130U, 2.20 GHz. RAM: 4 GB, DDR4 (2 khe), 2666 MHz. Ổ cứng: SSD 256GB NVMe PCIe, Hỗ trợ khe cắm HDD SATA. Màn hình: 14 inch, Full HD (1920 x 1080). Card màn hình: Card đồ họa tích hợp, Intel® UHD Graphics 620. Cổng kết nối: 3 x USB 3.1, HDMI, LAN (RJ45), USB Type-C. Hệ điều hành: Windows 10 Home SL. Thiết kế: Vỏ nhựa, PIN liền. Kích thước: Dày 1.99 mm, 1.5 kg.', 2),
(13, 'Điện thoại Vivo X50', 11990000, 'https://cdn.tgdd.vn/Products/Images/42/223288/vivo-x50-155520-035542-400x460.png', 'Màn hình:  AMOLED, 6.56\", Full HD+. Hệ điều hành: Android 10. Camera sau: Chính 48 MP & Phụ 13 MP, 8 MP, 5 MP. Camera trước: 32 MP. CPU: Snapdragon 730 8 nhân. RAM: 8 GB Bộ nhớ trong: 128 GB', 1),
(14, 'Laptop Asus VivoBook A412FA i5 10210U/8GB/512GB/Win10 (EK738T)\r\n\r\n', 16690000, 'https://cdn.tgdd.vn/Products/Images/44/217509/asus-vivobook-a412fa-i5-ek738t-217509-600x600.jpg', 'CPU: Intel Core i5 Comet Lake, 10210U, 1.60 GHz. RAM: 8 GB, DDR4 (On board 4GB +1 khe 4GB), 2666 MHz. Ổ cứng: SSD 512 GB M.2 PCIe, Hỗ trợ khe cắm HDD SATA. Màn hình: 14 inch, Full HD (1920 x 1080). Card màn hình: Card đồ họa tích hợp, Intel UHD Graphics. Cổng kết nối: USB 3.1, HDMI, USB 2.0, USB Type-C. Hệ điều hành: Windows 10 Home SL. Thiết kế: Vỏ nhựa, PIN liền. Kích thước: Dày 19.5 mm, 1.406 kg', 2),
(15, 'Điện thoại Samsung Galaxy Z Flip\r\n', 36000000, 'https://cdn.tgdd.vn/Products/Images/42/213022/samsung-galaxy-z-flip-chitiet-2-788x544.png', 'Đột phá với thiết kế màn hình gập. Galaxy Z Flip sở hữu màn hình Infinity Flex với công nghệ kính uốn dẻo Ultra Thin Glass (UTG) độc đáo từ Samsung. Nâng cấp camera kép, chụp ảnh ban đêm ấn tượng. Hiệu năng đỉnh cao với Snapdragon 855 Plus. Samsung Galaxy Z Flip khi được trang bị viên pin lớn dung lượng 3300 mAh, có hỗ trợ công nghệ sạc nhanh 15W. RAM 8GB, bộ nhớ trong 256GB', 1),
(16, 'Laptop Asus VivoBook X509MA N4020/4GB/256GB/Win10 (BR271T)\r\n\r\n', 6990000, 'https://cdn.tgdd.vn/Products/Images/44/224411/asus-vivobook-x509ma-n4020-br271t-034520-104519-600x600.jpg', 'CPU: Intel Celeron, N4020, 1.10 GHz. RAM: 4 GB, DDR4 (1 khe), 2666 MHz. Ổ cứng: SSD 256GB NVMe PCIe, Hỗ trợ khe cắm HDD SATA. Màn hình: 15.6 inch, HD (1366 x 768). Card màn hình: Card đồ họa tích hợp, Intel® UHD Graphics 600. Cổng kết nối: 2 x USB 2.0, USB 3.1, HDMI, USB Type-C. Hệ điều hành: Windows 10 Home SL. Thiết kế: Vỏ nhựa, PIN liền. Kích thước: Dày 22.9 mm, 1.66 kg', 2),
(17, 'Điện thoại Xiaomi Redmi 9 (4GB/64GB)', 3590000, 'https://cdn.tgdd.vn/Products/Images/42/217308/xiaomi-redmi-9-114620-094649-400x460.png', '4Camera: Camera chính 13 MP, Camera góc siêu rộng 8 MP, camera macro 5 MP và cảm biến đo độ sâu 2 MP. Vi xử lý MediaTek Helio G80 8 nhân tốc độ lên đến 2.0 Ghz. Màn hình siêu rộng 6.53 inch độ phân giải Full HD+ (1080 x 2340 Pixels), thiết kế tràn viền mỏng các cạnh. Dung lượng pin 5.020 mAh.', 1),
(18, 'Laptop HP 15s du1076TX i5 10210U/8GB/512GB/2GB MX130/Win10 (1R8E2PA)\r\n\r\n', 17490000, 'https://cdn.tgdd.vn/Products/Images/44/227070/hp-15s-du1076tx-i5-8gb-10210u-512gb-2gb-mx130-win1-600x600.jpg', 'CPU: Intel Core i5 Comet Lake, 10210U, 1.60 GHz. RAM: 8 GB, DDR4 (2 khe), 2666 MHz. Ổ cứng: SSD 512 GB M.2 PCIe, Hỗ trợ khe cắm HDD SATA. Màn hình: 15.6 inch, Full HD (1920 x 1080). Card màn hình: Card đồ họa rời, NVIDIA Geforce MX130, 2GB. Cổng kết nối: 2 x USB 3.1, HDMI, LAN (RJ45), USB Type-C. Hệ điều hành: Windows 10 Home SL. Thiết kế:	Vỏ nhựa, PIN liền. Kích thước: Dày 19.9 mm, 1.751 kg.', 2),
(19, 'Điện thoại Samsung Galaxy Note 20 Ultra\r\n\r\n', 29990000, 'https://cdn.tgdd.vn/Products/Images/42/220522/samsung-galaxy-note-20-ultra-vangdong-400x460-400x460.png', 'Màn hình 2K+ Dynamic AMOLED 2X tràn viền hoàn hảo, thiết kế thời thượng. Galaxy Note 20 Ultra sử dụng con chip Exynos 990 8 nhân mạnh mẽ. RAM 8 GB, 256 GB ROM. Bút S Pen mới, được nâng cấp nhiều tính năng. Camera chính có độ phân giải lên đến 108 MP bổ sung lấy nét Laser AF. Pin 4500 mAh, Note 20 Ultra, hỗ trợ sạc nhanh.', 1),
(20, 'Laptop HP 15s du0063TU i5 8265U/4GB/1TB/Win10 (6ZF63PA)\r\n\r\n', 11750000, 'https://cdn.tgdd.vn/Products/Images/44/204053/hp-15s-du0063tu-i5-8265u-4gb-1tb-win10-6zf63pa-020720-110758-600x600.jpg', 'CPU: Intel Core i5 Coffee Lake, 8265U, 1.60 GHz. RAM: 4 GB, DDR4 (2 khe), 2400 MHz. Ổ cứng: HDD: 1 TB SATA3, Hỗ trợ khe cắm SSD M.2. Màn hình: 15.6 inch, Full HD (1920 x 1080). Card màn hình: Card đồ họa tích hợp, Intel® UHD Graphics 620. Cổng kết nối: HDMI 1.4, 2 x USB 3.1, LAN (RJ45), USB Type-C. Hệ điều hành: Windows 10 Home SL. Thiết kế:	Vỏ nhựa, PIN liền. Kích thước: Dày 19.9 mm, 1.74 kg', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
