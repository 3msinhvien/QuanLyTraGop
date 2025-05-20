package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.KhachHang;
import model.ThongKe;
import model.HopDong;

/**
 * KhachHangDAO class is used to access the database to get the information of
 * the customer
 * 
 * @author Tung
 *
 */

public class KhachHangDAO extends DAO {
    public ArrayList<HopDong> getDSHopDong(int khachHangId) {
        ArrayList<HopDong> dsHopDong = new ArrayList<>();
        String sql = "SELECT " +
                "    h.ID AS hopDongId, " +
                "    h.ngayKy, " +
                "    COUNT(dtt.ID) AS tongSoLanTra, " +
                "    SUM(dtt.soTienThanhToan) AS tongTienVay, " +
                "    SUM(CASE WHEN dtt.trangThai = 0 THEN dtt.soTienThanhToan ELSE 0 END) AS tongDuNo, " +
                "    SUM(CASE WHEN dtt.trangThai = 0 AND dtt.ngayThanhToan < CURRENT_DATE THEN dtt.soTienThanhToan ELSE 0 END) AS tongDuNoQuaHan "
                +
                "FROM " +
                "    tblHopDong h " +
                "LEFT JOIN " +
                "    tblDotThanhToan dtt ON h.ID = dtt.tblHopDongID " +
                "WHERE " +
                "    h.tblKhachHangID = ? " +
                "GROUP BY " +
                "    h.ID, h.ngayKy " +
                "ORDER BY " +
                "    tongDuNo DESC, h.ngayKy DESC";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, khachHangId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HopDong hopDong = new HopDong();
                hopDong.setId(rs.getInt("hopDongId"));
                hopDong.setNgayKy(rs.getDate("ngayKy"));
                hopDong.setTongSoLanTra(rs.getInt("tongSoLanTra"));
                hopDong.setTongTienVay(rs.getDouble("tongTienVay"));
                hopDong.setTongDuNo(rs.getDouble("tongDuNo"));
                hopDong.setTongDuNoQuaHan(rs.getDouble("tongDuNoQuaHan"));
                dsHopDong.add(hopDong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsHopDong;
    }
}

class KhachHangDAOTest {
    public static void main(String[] args) {
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        ArrayList<HopDong> list = khachHangDAO.getDSHopDong(1);
        for (HopDong hd : list) {
            System.out.println("ID: " + hd.getId());
            System.out.println("Ngày ký: " + hd.getNgayKy());
            System.out.println("Tổng số lần trả: " + hd.getTongSoLanTra());
            System.out.println("Tổng tiền vay: " + hd.getTongTienVay());
            System.out.println("Tổng dư nợ: " + hd.getTongDuNo());
            System.out.println("Tổng dư nợ quá hạn: " + hd.getTongDuNoQuaHan());
            System.out.println("-----------------------------");
        }
    }
}
