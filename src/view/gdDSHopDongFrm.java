package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import model.KhachHang;
import dao.KhachHangDAO;
import model.HopDong;
import model.ThongKe;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gdDSHopDongFrm extends JFrame {
    private JTable tblDSHopDong;
    private ThongKe thongKe;
    private ArrayList<HopDong> dsHopDong;

    public gdDSHopDongFrm(ThongKe thongKe) {
        this.thongKe = thongKe;

        // Khởi tạo giao diện
        setTitle("Danh sách hợp đồng");
        setLayout(new BorderLayout(10, 10));

        // Panel chứa tiêu đề
        JPanel titlePanel = new JPanel();
        JLabel lblTitle = new JLabel("Danh sách hợp đồng của khách hàng: " + thongKe.getTen());
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(lblTitle);
        add(titlePanel, BorderLayout.NORTH);

        // Tạo table
        tblDSHopDong = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblDSHopDong);
        add(scrollPane, BorderLayout.CENTER);

        // Panel chứa nút điều khiển
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnDong = new JButton("Quay lại");
        btnDong.setBackground(new Color(144, 238, 144));
        btnDong.setPreferredSize(new Dimension(100, 30));
        buttonPanel.add(btnDong);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load dữ liệu
        loadTableData();

        // Thêm mouse listener cho bảng
        tblDSHopDong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblDSHopDong.getSelectedRow();
                int column = tblDSHopDong.getSelectedColumn();

                // Kiểm tra nếu user click vào cột id hợp đồng
                if (column == 1 && row >= 0) {
                    HopDong selectedHopDong = dsHopDong.get(row);
                    gdChiTietHopDongFrm cthd = new gdChiTietHopDongFrm(thongKe, selectedHopDong.getId());
                    cthd.setVisible(true);
                }
            }
        });

        // Thêm action listener
        btnDong.addActionListener(e -> dispose());

        // Cài đặt frame
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void loadTableData() {
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        dsHopDong = khachHangDAO.getDSHopDong(thongKe.getId());

        String[] columnNames = {
                "STT", "Mã HĐ", "Ngày ký", "Tổng tiền vay", "Tổng số lần trả", "Tổng dư nợ còn", "Tổng dư nợ quá hạn"
        };

        Object[][] data = new Object[dsHopDong.size()][columnNames.length];
        ArrayList<model.DotThanhToan> dsDotThanhToan = thongKe.getDsDotThanhToan();
        for (int i = 0; i < dsHopDong.size(); i++) {
            data[i][0] = i + 1;
            data[i][1] = dsHopDong.get(i).getId();
            data[i][2] = dsHopDong.get(i).getNgayKy();
            double tongTienPhaiTra = 0;
            int tongSoLanTra = 0;
            double tongDuNo = 0;
            double tongDuNoQuaHan = 0;
            if (dsDotThanhToan != null) {
                int hopDongId = dsHopDong.get(i).getId();
                java.util.Date now = new java.util.Date();
                for (model.DotThanhToan dtt : dsDotThanhToan) {
                    if (dtt.getHopDongId() == hopDongId) {
                        tongTienPhaiTra += dtt.getSoTienThanhToan();
                        tongSoLanTra++;
                        if (dtt.getTrangThai() == 0) {
                            tongDuNo += dtt.getSoTienThanhToan();
                            if (dtt.getNgayThanhToan().before(now)) {
                                tongDuNoQuaHan += dtt.getSoTienThanhToan();
                            }
                        }
                    }
                }
                data[i][3] = tongTienPhaiTra;
                data[i][4] = tongSoLanTra;
                data[i][5] = tongDuNo;
                data[i][6] = tongDuNoQuaHan;
            } else {
                data[i][3] = 0;
                data[i][4] = 0;
                data[i][5] = 0;
                data[i][6] = 0;
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblDSHopDong.setModel(model);
    }
}
