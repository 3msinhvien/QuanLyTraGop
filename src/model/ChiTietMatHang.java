package model;
import java.io.Serializable;

public class ChiTietMatHang implements Serializable{
    private int id;
    private double donGia;
    private int soLuong;
    private double thanhTien;

    public ChiTietMatHang() {
        super();
    }
    public ChiTietMatHang(int id, double donGia, int soLuong, double thanhTien) {
        super();
        this.id = id;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public double getThanhTien() {
        return thanhTien;
    }
    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

}
