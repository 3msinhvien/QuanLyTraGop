package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.ThongKe;
import model.DotThanhToan;

public class ThongKeDAO extends DAO {

    public ThongKeDAO() {
        super();
    }

    public ArrayList<ThongKe> getTKKhachHang() {
        ArrayList<ThongKe> result = new ArrayList<ThongKe>();
        String sql = "SELECT " +
                "    tblKhachHang.id AS id, " +
                "    tblKhachHang.ten AS ten, " +
                "    tblKhachHang.sdt AS sdt, " +
                "    tblKhachHang.email AS email, " +
                "    tblKhachHang.cccd AS cccd, " +
                "    tblKhachHang.diaChi AS diaChi, " +
                "    tblKhachHang.ghiChu AS ghiChu, " +
                "    SUM(CASE WHEN tblDotThanhToan.trangThai = 0 THEN tblDotThanhToan.soTienThanhToan ELSE 0 END) AS tongDuNoCon, "
                +
                "    SUM(CASE WHEN tblDotThanhToan.ngayThanhToan < CURRENT_DATE AND tblDotThanhToan.trangThai = 0 THEN tblDotThanhToan.soTienThanhToan ELSE 0 END) AS tongDuNoQuaHan "
                +
                "FROM tblKhachHang " +
                "JOIN tblHopDong ON tblKhachHang.ID = tblHopDong.tblKhachHangID " +
                "JOIN tblDotThanhToan ON tblHopDong.ID = tblDotThanhToan.tblHopDongID " +
                "GROUP BY tblKhachHang.id, tblKhachHang.ten, tblKhachHang.sdt " +
                "ORDER BY tongDuNoCon DESC";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ThongKe thongKe = new ThongKe();
                thongKe.setId(rs.getInt("id"));
                thongKe.setTen(rs.getString("ten"));
                thongKe.setSdt(rs.getString("sdt"));
                thongKe.setEmail(rs.getString("email"));
                thongKe.setCccd(rs.getString("cccd"));
                thongKe.setDiaChi(rs.getString("diaChi"));
                thongKe.setGhiChu(rs.getString("ghiChu"));
                thongKe.setTongDuNoCon(rs.getDouble("tongDuNoCon"));
                thongKe.setTongDuNoQuaHan(rs.getDouble("tongDuNoQuaHan"));
                ArrayList<DotThanhToan> dsDotThanhToan = getDsDotThanhToanByKhachHangId(thongKe.getId());
                thongKe.setDsDotThanhToan(dsDotThanhToan);
                result.add(thongKe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<DotThanhToan> getDsDotThanhToanByKhachHangId(int khachHangId) {
        ArrayList<DotThanhToan> list = new ArrayList<>();
        String sql = "SELECT dtt.*, dtt.tblHopDongID FROM tblDotThanhToan dtt " +
                "JOIN tblHopDong hd ON dtt.tblHopDongID = hd.ID " +
                "WHERE hd.tblKhachHangID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, khachHangId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DotThanhToan dtt = new DotThanhToan();
                dtt.setId(rs.getInt("id"));
                dtt.setNgayThanhToan(rs.getDate("ngayThanhToan"));
                dtt.setSoTienThanhToan(rs.getDouble("soTienThanhToan"));
                dtt.setTrangThai(rs.getInt("trangThai"));
                dtt.setHopDongId(rs.getInt("tblHopDongID"));
                list.add(dtt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

// test thông tin trả ra
class ThongKeDAOTest {
    public static void main(String[] args) {
        ThongKeDAO thongKeDAO = new ThongKeDAO();
        ArrayList<ThongKe> list = thongKeDAO.getTKKhachHang();
        for (ThongKe tk : list) {
            System.out.println("ID: " + tk.getId());
            System.out.println("Tên: " + tk.getTen());
            System.out.println("SĐT: " + tk.getSdt());
            System.out.println("Tổng dư nợ còn: " + tk.getTongDuNoCon());
            System.out.println("Tổng dư nợ quá hạn: " + tk.getTongDuNoQuaHan());
            System.out.println("-----------------------------");
        }
    }
}
