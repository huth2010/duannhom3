package laptrinhandroid.fpoly.dnnhm3.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Entity.BangLuong;
import laptrinhandroid.fpoly.dnnhm3.Entity.NhanVien;
import laptrinhandroid.fpoly.dnnhm3.JDBC.DbSqlServer;

public class DAOBangLuong {
    Connection objConn;
    public DAOBangLuong() {
        DbSqlServer db = new DbSqlServer(); // hàm khởi tạo để mở kết nối
        objConn = db.openConnect(); // tạo mới DAO thì mở kết nối CSDL
    }

    public boolean addBangLuong(BangLuong bangLuong) throws SQLException {
        Statement statement = objConn.createStatement();

         String s1 = "Insert into NhanVien(maNV, luongCB,ngayCong,chuNhat,ungLuong) values (" +
                "'" + bangLuong.getMaNV() + "'," +
                "'" + bangLuong.getLuongCB() + "'," +
                "'" + bangLuong.getNgayCong() + "'," +
                "'" + bangLuong.getChuNhat() + "'," +
                "'" + bangLuong.getUngLuong() + "'," +
             "')";
        if (statement.executeUpdate(s1) > 0) {
            statement.close();
            return true;
        }
        statement.close();
        return false;
    }

    public boolean updateBangLuong(BangLuong bangLuong) throws SQLException {
        String sql = "UPDATE NhanVien  SET " + "maNV = ?," + " luongCB =?," + "ngayCong=?" + ",chuNhat=?" + ",ungLuong=?" +  " WHERE maNv=?;";
        PreparedStatement preparedStatement = objConn.prepareStatement(sql);
        preparedStatement.setInt(1, bangLuong.getMaNV());
        preparedStatement.setFloat(2, bangLuong.getLuongCB());
        preparedStatement.setInt(3, bangLuong.getNgayCong());
        preparedStatement.setInt(4, bangLuong.getChuNhat());
        preparedStatement.setFloat(5, bangLuong.getUngLuong());
        if (preparedStatement.executeUpdate(sql) > 0) {
            preparedStatement.close();
            return true;
        }
        return false;
    }

    public boolean deleteBangLuong(int maNv) throws SQLException {
        Statement statement = objConn.createStatement();
        String sql = "Delete from NhanVien where maNv='" + maNv + "'";
        if (statement.executeUpdate(sql) > 0) {
            statement.close();
            return true;
        }
        return false;
    }
    public List<BangLuong> getListBangLuong(String maNV) throws SQLException {
        List<BangLuong> list = new ArrayList<>();
        Statement statement = objConn.createStatement();// Tạo đối tượng Statement.
        String sql = " SELECT * FROM  BangLuong where maNV='"+maNV+"'";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new BangLuong(rs.getInt(1), rs.getInt(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5), rs.getFloat(6) ));// Đọc dữ liệu từ ResultSet
        }
        objConn.close();// Đóng kết nối
        return list;
    }

}
