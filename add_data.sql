-- Tạo database và chọn sử dụng
USE tragop;

-- Tạo bảng
CREATE TABLE tblKhachHang (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(255),
    sdt VARCHAR(255),
    email VARCHAR(255),
    cccd VARCHAR(255),
    diaChi VARCHAR(255),
    ghiChu VARCHAR(255)
);

CREATE TABLE tblDoiTac (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(255),
    diaChi VARCHAR(255),
    thongTinLienHe VARCHAR(255),
    thongTinThanhToan VARCHAR(255)
);

CREATE TABLE tblHopDong (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ngayKy DATE,
    tblKhachHangID INT,
    tblDoiTacID INT,
    FOREIGN KEY (tblKhachHangID) REFERENCES tblKhachHang(ID),
    FOREIGN KEY (tblDoiTacID) REFERENCES tblDoiTac(ID)
);

CREATE TABLE tblDotThanhToan (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ngayThanhToan DATE,
    soTienThanhToan DOUBLE,
    trangThai INT,
    tblHopDongID INT,
    FOREIGN KEY (tblHopDongID) REFERENCES tblHopDong(ID)
);

CREATE TABLE tblMatHang (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(255),
    donViTinh VARCHAR(255),
    donGia DOUBLE
);

CREATE TABLE tblChiTietMatHang (
    soLuong INT,
    tblMatHangID INT,
    tblHopDongID INT,
    PRIMARY KEY (tblMatHangID, tblHopDongID),
    FOREIGN KEY (tblMatHangID) REFERENCES tblMatHang(ID),
    FOREIGN KEY (tblHopDongID) REFERENCES tblHopDong(ID)
);

-- Thêm khách hàng
INSERT INTO tblKhachHang (ten, sdt, email, cccd, diaChi, ghiChu)
VALUES
('Nguyen Van A', '0911111111', 'a@gmail.com', '111111111', 'Hanoi', 'Khách quen'),
('Tran Thi B', '0922222222', 'b@gmail.com', '222222222', 'HCM', 'Mới'),
('Le Van C', '0933333333', 'c@gmail.com', '333333333', 'Danang', 'VIP');

-- Thêm đối tác
INSERT INTO tblDoiTac (ten, diaChi, thongTinLienHe, thongTinThanhToan)
VALUES
('CTY ABC', 'Hanoi', '0345678901', 'STK: 123456 - Vietcombank'),
('CTY XYZ', 'HCM', '0356789012', 'STK: 234567 - ACB');

-- Thêm mặt hàng
INSERT INTO tblMatHang (ten, donViTinh, donGia)
VALUES
('Laptop Dell', 'Chiếc', 2000),
('iPhone 14', 'Chiếc', 2500),
('TV Samsung', 'Chiếc', 1500),
('Tủ lạnh LG', 'Chiếc', 1200);

-- Thêm hợp đồng
INSERT INTO tblHopDong (ngayKy, tblKhachHangID, tblDoiTacID)
VALUES
('2025-05-01', 1, 1),
('2025-05-02', 1, 2),
('2025-05-03', 2, 1),
('2025-05-04', 3, 2);

-- Thêm chi tiết mặt hàng
INSERT INTO tblChiTietMatHang (soLuong, tblMatHangID, tblHopDongID)
VALUES
(1, 1, 1),
(2, 2, 1),
(1, 3, 2),
(1, 4, 3),
(2, 2, 4);

-- Thêm đợt thanh toán
INSERT INTO tblDotThanhToan (ngayThanhToan, soTienThanhToan, trangThai, tblHopDongID)
VALUES
('2025-05-10', 500, 1, 1),
('2025-06-10', 1000, 0, 1),
('2025-05-15', 2500, 0, 2),
('2025-06-15', 2500, 0, 2),
('2025-07-15', 2500, 0, 2),
('2025-06-01', 1200, 1, 3),
('2025-06-15', 800, 0, 4);
