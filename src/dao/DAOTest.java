package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

// src/dao/DAOTest.java

public class DAOTest {
    @BeforeClass
    public static void setUp() {
        // Khởi tạo DAO để thực hiện kết nối
        new DAO();
    }

    @Test
    public void testConnectionNotNull() {
        // Kiểm tra kết nối không null
        assertNotNull("Connection should not be null", DAO.con);
    }

    @Test
    public void testConnectionIsValid() throws SQLException {
        // Kiểm tra kết nối có hợp lệ không
        assertTrue("Connection should be valid", !DAO.con.isClosed());
    }

    @Test
    public void testQueryExecution() throws SQLException {
        // Kiểm tra thực hiện query đơn giản
        Statement stmt = DAO.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT 1");

        assertTrue("Query should return results", rs.next());
        assertEquals("Query should return 1", 1, rs.getInt(1));

        rs.close();
        stmt.close();
    }

    @Test
    public void testDatabaseMetaData() throws SQLException {
        // Kiểm tra thông tin về cơ sở dữ liệu
        String databaseName = DAO.con.getCatalog();
        assertEquals("Database name should be 'tragop'", "tragop", databaseName);
    }

    @AfterClass
    public static void tearDown() throws SQLException {
        // Đóng kết nối sau khi test
        if (DAO.con != null && !DAO.con.isClosed()) {
            DAO.con.close();
        }
    }
}