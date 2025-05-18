package model;
import java.io.Serializable;
import java.util.ArrayList;

public class DoiTac implements Serializable {
    private int id;
    private String ten;
    private String diaChi;
    private String thongTinLienHe;
    private String thongTinThanhToan;
    private ArrayList<MatHang> dsMatHang = new ArrayList<>();

    public DoiTac() {
        super();
        ArrayList<MatHang> dsMatHang = new ArrayList<>();
    }

    public DoiTac(String ten, String diaChi, String thongTinLienHe, String thongTinThanhToan) {
        super();
        this.ten = ten;
        this.diaChi = diaChi;
        this.thongTinLienHe = thongTinLienHe;
        this.thongTinThanhToan = thongTinThanhToan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThongTinLienHe() {
        return thongTinLienHe;
    }

    public void setThongTinLienHe(String thongTinLienHe) {
        this.thongTinLienHe = thongTinLienHe;
    }

    public String getThongTinThanhToan() {
        return thongTinThanhToan;
    }

    public void setThongTinThanhToan(String thongTinThanhToan) {
        this.thongTinThanhToan = thongTinThanhToan;
    }

    public ArrayList<MatHang> getDsMatHang() {
        return dsMatHang;
    }

    public void setDsMatHang(ArrayList<MatHang> dsMatHang) {
        this.dsMatHang = dsMatHang;
    }
}



