package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import dao.ThongKeDAO;
import model.ThongKe;

public class gdThongKeFrm extends JFrame {
    private JTable tblThongKe;
    private ThongKeDAO thongKeDAO;
    private JButton btnQuayLai;
    private ArrayList<ThongKe> listThongKe; // Thêm biến để lưu danh sách thống kê

    public gdThongKeFrm() {
        // Khởi tạo giao diện cơ bản
        setTitle("Thống kê khách hàng theo dư nợ");
        setLayout(new BorderLayout(10, 10));

        // Panel chứa tiêu đề
        JPanel titlePanel = new JPanel();
        JLabel lblTitle = new JLabel("Thống kê khách hàng theo dư nợ");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(lblTitle);
        add(titlePanel, BorderLayout.NORTH);

        // Tạo table
        tblThongKe = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblThongKe);
        add(scrollPane, BorderLayout.CENTER);

        // Panel chứa nút Quay lại
        JPanel buttonPanel = new JPanel();
        btnQuayLai = new JButton("Quay lại");
        btnQuayLai.setBackground(new Color(144, 238, 144)); // Light green color
        btnQuayLai.setPreferredSize(new Dimension(100, 30));
        buttonPanel.add(btnQuayLai);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load dữ liệu
        loadTableData();

        // Thêm mouse listener cho bảng
        tblThongKe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblThongKe.getSelectedRow();
                int column = tblThongKe.getSelectedColumn();

                // Kiểm tra nếu click vào cột tên khách hàng (cột thứ 3)
                if (column == 2 && row >= 0) {
                    ThongKe selectedKH = listThongKe.get(row);
                    // Mở form danh sách hợp đồng với mã khách hàng
                    gdDSHopDongFrm dshd = new gdDSHopDongFrm(selectedKH);
                    dshd.setVisible(true);
                }
            }
        });

        // Cài đặt frame
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Thêm action listener cho nút Quay lại
        btnQuayLai.addActionListener(e -> dispose());
    }

    private void loadTableData() {
        thongKeDAO = new ThongKeDAO();
        listThongKe = thongKeDAO.getTKKhachHang(); // Lưu danh sách vào biến instance

        // Định nghĩa tên các cột
        String[] columnNames = {
                "STT", "Mã KH", "Tên KH", "SĐT", "Tổng dư nợ còn", "Tổng dư nợ quá hạn"
        };

        // Tạo dữ liệu cho bảng
        Object[][] data = new Object[listThongKe.size()][columnNames.length];
        for (int i = 0; i < listThongKe.size(); i++) {
            ThongKe tk = listThongKe.get(i);
            data[i][0] = i + 1; // STT
            data[i][1] = tk.getId();
            data[i][2] = tk.getTen();
            data[i][3] = tk.getSdt();
            data[i][4] = tk.getTongDuNoCon();
            data[i][5] = tk.getTongDuNoQuaHan();
        }

        // Tạo model cho table
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép edit trực tiếp trên bảng
            }
        };

        // Set model cho table
        tblThongKe.setModel(tableModel);
    }

    // Test thử form
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new gdThongKeFrm().setVisible(true);
        });
    }
}