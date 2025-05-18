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

   public ArrayList<HopDong> getChiTietHopDong(int hopDongId) {
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
       ArrayList<MatHang> listChiTietMatHang = new ArrayList<>();
       String MatHangsql = "SELECT donGia, soLuong, tblMatHang.ten, tblMatHang.donViTinh FROM tblChiTietMatHang"
       +
       "JOIN tblMatHang ON tblChiTietMatHang.tblMatHangID = tblMatHang.id"
       +
       "JOIN tblHopDong ON tblChiTietMatHang.tblHopDongID = tblHopDong.id"
       +
       "WHERE tblHopDongID = ?";
       try {
           ChiTietMatHang chiTietMatHang = new ChiTietMatHang();
           PreparedStatement ps = con.prepareStatement(MatHangsql);
           ps.setInt (1 , hopDongId);
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               MatHang matHang = new MatHang();
               matHang.setDonGia(rs.getDouble("donGia"));
              // matHang.setSoLuong(rs.getInt("soLuong"));
               matHang.setTen(rs.getString("ten"));
               matHang.setDonViTinh(rs.getString("donViTinh"));
               listChiTietMatHang.add(matHang);
           }
       } catch (Exception e) {
           throw new RuntimeException(e);
       }


}
}
