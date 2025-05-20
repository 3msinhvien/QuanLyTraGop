package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import dao.HopDongDAO;
import model.HopDong;
import model.KhachHang;
import model.DoiTac;
import model.MatHang;
import model.DotThanhToan;
import model.ChiTietMatHang;
import model.ThongKe;
import java.util.ArrayList;

public class gdChiTietHopDongFrm extends JFrame {
    private JTable tblMatHang, tblDotThanhToan;
    private JButton btnQuayLai;

    public gdChiTietHopDongFrm(ThongKe thongKe, int hopDongId) {
        setTitle("Chi tiết hợp đồng");
        setLayout(new BorderLayout(10, 10));

        // Gọi DAO để lấy dữ liệu
        HopDongDAO hopDongDAO = new HopDongDAO();
        HopDong hopDong = hopDongDAO.getChiTietHopDong(hopDongId);
        DoiTac doiTac = hopDong.getDoiTac();
        ArrayList<ChiTietMatHang> dsMatHang = hopDong.getDsMatHang();
        ArrayList<DotThanhToan> dsDotThanhToan = hopDong.getDsDotThanhToan();

        // Tiêu đề
        JLabel lblTitle = new JLabel("Chi tiết hợp đồng", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

        // Panel trung tâm
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Thông tin khách hàng từ ThongKe
        JPanel khachHangPanel = new JPanel(new GridLayout(0, 1, 2, 2));
        khachHangPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        khachHangPanel.add(new JLabel("1. Thông tin khách hàng"));
        khachHangPanel.add(new JLabel("Họ tên: " + thongKe.getTen()));
        khachHangPanel.add(new JLabel("SDT: " + thongKe.getSdt()));
        khachHangPanel.add(new JLabel("Email: " + thongKe.getEmail()));
        khachHangPanel.add(new JLabel("CCCD: " + thongKe.getCccd()));
        khachHangPanel.add(new JLabel("Địa chỉ: " + thongKe.getDiaChi()));
        centerPanel.add(khachHangPanel);
        centerPanel.add(Box.createVerticalStrut(10));

        // Thông tin đối tác
        JPanel doiTacPanel = new JPanel(new GridLayout(0, 1, 2, 2));
        doiTacPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        doiTacPanel.add(new JLabel("2. Thông tin đối tác"));
        doiTacPanel.add(new JLabel("Tên đối tác: " + doiTac.getTen()));
        doiTacPanel.add(new JLabel("Địa chỉ: " + doiTac.getDiaChi()));
        doiTacPanel.add(new JLabel("Thông tin liên hệ: " + doiTac.getThongTinLienHe()));
        doiTacPanel.add(new JLabel("Thông tin thanh toán: " + doiTac.getThongTinThanhToan()));
        centerPanel.add(doiTacPanel);
        centerPanel.add(Box.createVerticalStrut(10));

        // Danh sách mặt hàng
        centerPanel.add(new JLabel("3. Danh sách các mặt hàng"));
        String[] colNamesMatHang = { "STT", "Tên", "Đơn vị tính", "Số lượng", "Đơn giá", "Thành tiền" };
        Object[][] dataMatHang = new Object[dsMatHang.size()][colNamesMatHang.length];
        for (int i = 0; i < dsMatHang.size(); i++) {
            ChiTietMatHang chiTietMatHang = dsMatHang.get(i);
            MatHang matHang = chiTietMatHang.getMatHang();
            dataMatHang[i][0] = i + 1;
            dataMatHang[i][1] = matHang.getTen();
            dataMatHang[i][2] = matHang.getDonViTinh();
            dataMatHang[i][3] = chiTietMatHang.getSoLuong();
            dataMatHang[i][4] = chiTietMatHang.getDonGia();
            dataMatHang[i][5] = chiTietMatHang.getThanhTien();
        }

        tblMatHang = new JTable(new DefaultTableModel(dataMatHang, colNamesMatHang));
        JScrollPane spMatHang = new JScrollPane(tblMatHang);
        spMatHang.setPreferredSize(new Dimension(600, 60));
        centerPanel.add(spMatHang);
        centerPanel.add(Box.createVerticalStrut(10));

        // Danh sách đợt thanh toán
        centerPanel.add(new JLabel("4. Danh sách các đợt thanh toán"));
        String[] colDotTT = { "kỳ", "Thời điểm thanh toán", "Số tiền thanh toán", "Trạng thái" };
        Object[][] dataDotTT = new Object[dsDotThanhToan.size()][colDotTT.length];
        for (int i = 0; i < dsDotThanhToan.size(); i++) {
            DotThanhToan dotThanhToan = dsDotThanhToan.get(i);
            dataDotTT[i][0] = i + 1;
            dataDotTT[i][1] = dotThanhToan.getNgayThanhToan();
            dataDotTT[i][2] = dotThanhToan.getSoTienThanhToan();
            dataDotTT[i][3] = dotThanhToan.getTrangThai();
        }

        tblDotThanhToan = new JTable(new DefaultTableModel(dataDotTT, colDotTT));
        JScrollPane spDotTT = new JScrollPane(tblDotThanhToan);
        spDotTT.setPreferredSize(new Dimension(600, 60));
        centerPanel.add(spDotTT);

        add(centerPanel, BorderLayout.CENTER);

        // Nút Quay lại
        btnQuayLai = new JButton("Quay lại");
        btnQuayLai.setBackground(new Color(144, 238, 144));
        btnQuayLai.setPreferredSize(new Dimension(100, 30));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(btnQuayLai);
        add(bottomPanel, BorderLayout.SOUTH);

        // Sự kiện nút
        btnQuayLai.addActionListener(e -> dispose());

        setSize(750, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
