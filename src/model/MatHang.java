package model;
import java.io.Serializable;

public class MatHang implements Serializable {
    public int id;
    public String ten;
    public String donViTinh;
    public double donGia;

    public MatHang() {
        super();
    }
    public MatHang(String ten, String donViTinh, double donGia, int tblDoiTacId) {
        super();
        this.ten = ten;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
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
    public String getDonViTinh() {
        return donViTinh;
    }
    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    
}
