package model;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

public class HopDong implements Serializable {
    private int id;
    private Date ngayKy;
    private double tongTienVay;
    private int tongSoLanTra;
    private double tongDuNo;
    private double tongDuNoQuaHan;
    private KhachHang khachHang;
    private DoiTac doiTac;
    private ArrayList<DotThanhToan> dsDotThanhToan = new ArrayList<>();
    private ArrayList<ChiTietMatHang> dsMatHang = new ArrayList<>();
    
    public HopDong() {
        super();
        ArrayList<ChiTietMatHang> dsMatHang = new ArrayList<>();
        ArrayList<DotThanhToan> dsDotThanhToan = new ArrayList<>();
    }


    public HopDong(Date ngayKy, double tongTienVay, int tongSoLanTra, double tongDuNo, double tongDuNoQuaHan, KhachHang khachHang, DoiTac doiTac) {
        this.ngayKy = ngayKy;
        this.tongTienVay = tongTienVay;
        this.tongSoLanTra = tongSoLanTra;
        this.tongDuNo = tongDuNo;
        this.tongDuNoQuaHan = tongDuNoQuaHan;
        this.khachHang = khachHang;
        this.doiTac = doiTac;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Date getNgayKy() {
        return ngayKy;
    }


    public void setNgayKy(Date ngayKy) {
        this.ngayKy = ngayKy;
    }


    public double getTongTienVay() {
        return tongTienVay;
    }


    public void setTongTienVay(double tongTienVay) {
        this.tongTienVay = tongTienVay;
    }


    public int getTongSoLanTra() {
        return tongSoLanTra;
    }


    public void setTongSoLanTra(int tongSoLanTra) {
        this.tongSoLanTra = tongSoLanTra;
    }


    public double getTongDuNo() {
        return tongDuNo;
    }


    public void setTongDuNo(double tongDuNo) {
        this.tongDuNo = tongDuNo;
    }


    public double getTongDuNoQuaHan() {
        return tongDuNoQuaHan;
    }


    public void setTongDuNoQuaHan(double tongDuNoQuaHan) {
        this.tongDuNoQuaHan = tongDuNoQuaHan;
    }


    public KhachHang getKhachHang() {
        return khachHang;
    }


    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }


    public DoiTac getDoiTac() {
        return doiTac;
    }


    public void setDoiTac(DoiTac doiTac) {
        this.doiTac = doiTac;
    }


    public ArrayList<DotThanhToan> getDsDotThanhToan() {
        return dsDotThanhToan;
    }


    public void setDsDotThanhToan(ArrayList<DotThanhToan> dsDotThanhToan) {
        this.dsDotThanhToan = dsDotThanhToan;
    }


    public ArrayList<ChiTietMatHang> getDsMatHang() {
        return dsMatHang;
    }


    public void setDsMatHang(ArrayList<ChiTietMatHang> dsMatHang) {
        this.dsMatHang = dsMatHang;
    }
    
}