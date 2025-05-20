package model;

import java.io.Serializable;
import java.util.Date;

public class DotThanhToan implements Serializable {
    private int id;
    private Date ngayThanhToan;
    private double soTienThanhToan;
    private int trangThai;

    public DotThanhToan() {
        super();
    }

    public DotThanhToan(Date ngayThanhToan, double soTienThanhToan, int trangThai) {
        super();
        this.ngayThanhToan = ngayThanhToan;
        this.soTienThanhToan = soTienThanhToan;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public double getSoTienThanhToan() {
        return soTienThanhToan;
    }

    public void setSoTienThanhToan(double soTienThanhToan) {
        this.soTienThanhToan = soTienThanhToan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}

