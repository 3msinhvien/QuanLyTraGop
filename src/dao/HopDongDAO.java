package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.HopDong;
import model.ChiTietMatHang;
import model.DoiTac;
import model.MatHang;

public class HopDongDAO extends DAO {
    public HopDongDAO() {
        super();
    }

    public HopDong getChiTietHopDong(int hopDongId) {
        HopDong hopDong = new HopDong();
        String HopDongsql = "SELECT * FROM tblHopDong WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(HopDongsql);
            ps.setInt(1, hopDongId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hopDong.setId(rs.getInt("id"));
                hopDong.setNgayKy(rs.getDate("ngayKy"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Lấy ra danh sách mặt hàng
        ArrayList<ChiTietMatHang> listChiTietMatHang = new ArrayList<>();
        String MatHangsql = "SELECT tblChiTietMatHang.donGia, tblChiTietMatHang.soLuong, tblMatHang.ten, tblMatHang.donViTinh FROM tblChiTietMatHang "
                +
                "JOIN tblMatHang ON tblChiTietMatHang.tblMatHangID = tblMatHang.id "
                +
                "JOIN tblHopDong ON tblChiTietMatHang.tblHopDongID = tblHopDong.id "
                +
                "WHERE tblHopDongID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(MatHangsql);
            ps.setInt(1, hopDongId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietMatHang chiTietMatHang = new ChiTietMatHang();
                MatHang matHang = new MatHang();
                matHang.setTen(rs.getString("ten"));
                matHang.setDonViTinh(rs.getString("donViTinh"));
                chiTietMatHang.setSoLuong(rs.getInt("soLuong"));
                chiTietMatHang.setDonGia(rs.getDouble("tblChiTietMatHang.donGia"));
                chiTietMatHang.setThanhTien(rs.getDouble("tblChiTietMatHang.donGia") * chiTietMatHang.getSoLuong());
                chiTietMatHang.setMatHang(matHang);
                listChiTietMatHang.add(chiTietMatHang);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Lay thong tin doi tac
        DoiTac doiTac = new DoiTac();
        String doiTacsql = "SELECT * FROM tblDoiTac";
        try {
            PreparedStatement ps = con.prepareStatement(doiTacsql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doiTac.setTen(rs.getString("ten"));
                doiTac.setDiaChi(rs.getString("diaChi"));
                doiTac.setThongTinLienHe("thongTinLienHe");
                doiTac.setThongTinThanhToan("thongTinThanhToan");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        hopDong.setDsMatHang(listChiTietMatHang);
        hopDong.setDoiTac(doiTac);
        return hopDong;

    }
}

// Hàm hiển thị thông tin hợp đồng và hàm main test
class HopDongDAOTest {
    public static void hienThiThongTinHopDong(HopDong hopDong) {
        System.out.println("=== Thông tin hợp đồng ===");
        System.out.println("ID: " + hopDong.getId());
        System.out.println("Ngày ký: " + hopDong.getNgayKy());

        // Thông tin đối tác
        DoiTac doiTac = hopDong.getDoiTac();
        if (doiTac != null) {
            System.out.println("--- Đối tác ---");
            System.out.println("Tên: " + doiTac.getTen());
            System.out.println("Địa chỉ: " + doiTac.getDiaChi());
            System.out.println("Thông tin liên hệ: " + doiTac.getThongTinLienHe());
            System.out.println("Thông tin thanh toán: " + doiTac.getThongTinThanhToan());
        }

        // Danh sách mặt hàng
        ArrayList<ChiTietMatHang> dsMatHang = hopDong.getDsMatHang();
        if (dsMatHang != null && !dsMatHang.isEmpty()) {
            System.out.println("--- Danh sách mặt hàng ---");
            for (ChiTietMatHang ctmh : dsMatHang) {
                System.out.println("Tên mặt hàng: " + ctmh.getMatHang().getTen());
                System.out.println("Đơn vị tính: " + ctmh.getMatHang().getDonViTinh());
                System.out.println("Số lượng: " + ctmh.getSoLuong());
                System.out.println("Đơn giá: " + ctmh.getDonGia());
                System.out.println("Thành tiền: " + ctmh.getThanhTien());
                System.out.println("-----------------------------");
            }
        }
    }

    public static void main(String[] args) {
        HopDongDAO hopDongDAO = new HopDongDAO();
        int hopDongId = 1; // Thay bằng id hợp đồng bạn muốn test
        HopDong hopDong = hopDongDAO.getChiTietHopDong(hopDongId);
        hienThiThongTinHopDong(hopDong);
    }
}
