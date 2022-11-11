package laptrinhandroid.fpoly.dnnhm3.DAO;

import android.util.Log;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Entity.BangLuong;
import laptrinhandroid.fpoly.dnnhm3.Entity.KhachHang;
import laptrinhandroid.fpoly.dnnhm3.Entity.NhanVien;
import laptrinhandroid.fpoly.dnnhm3.JDBC.DbSqlServer;

public class DAONhanVien {
    Connection objConn;

    public DAONhanVien() {
        DbSqlServer db = new DbSqlServer(); // hàm khởi tạo để mở kết nối
        objConn = db.openConnect(); // tạo mới DAO thì mở kết nối CSDL
    }

    public boolean addNhanVien(NhanVien nhanVien) throws SQLException {
        Statement statement = objConn.createStatement();
        String s = "Insert into KhachHang(anh,hoTen,soDT,diaChi) values ('" + nhanVien.getAnh() + "','" + nhanVien.getHoTen() + "','" + nhanVien.getSoDT() + "','" + nhanVien.getDiaChi() + "')";
        String s1 = "Insert into NhanVien(anh, hoTen,gioiTinh,soDT,diaChi,anhPhoToCC,anhXNKcoTATS,email,passwords,token,ngayBD,ngaySinh) values (" +
                "'" + nhanVien.getAnh() + "'," +
                "'" + nhanVien.getHoTen() + "'," +
                "'" + nhanVien.getGioiTinh() + "'," +
                "'" + nhanVien.getSoDT() + "'," +
                "'" + nhanVien.getDiaChi() + "'," +
                "'" + nhanVien.getAnhPhoToCC() + "'," +
                "'" + nhanVien.getAnhXNKcoTATS() + "'," +
                "'" + nhanVien.getEmail() + "'," +
                "'" + nhanVien.getPasswords() + "'," +
                "'" + nhanVien.getToken() + "'," +
                "'" + nhanVien.getNgayBD() + "'," +
                "'" + nhanVien.getNgaySinh() + "')";
        if (statement.executeUpdate(s1) > 0) {
            statement.close();
            return true;
        }
        statement.close();
        return false;
    }

    public boolean updateNhanVien(NhanVien nhanVien) throws SQLException {
        String sql = "UPDATE NhanVien  SET " + "anh = ?," + " hoTen =?," + "gioiTinh=?" + ",soDT=?" + ",diaChi=?" + ",anhPhoToCC=?" + ",anhXNKcoTATS=?" + ",email=?" + ",passwords=?" + ",token=?" + ",ngayBD=?" + ",ngaySinh=?" + "  WHERE maNv=?;";
        PreparedStatement preparedStatement = objConn.prepareStatement(sql);
        preparedStatement.setString(1, nhanVien.getAnh());
        preparedStatement.setString(2, nhanVien.getHoTen());
        preparedStatement.setString(3, nhanVien.getGioiTinh());
        preparedStatement.setString(4, nhanVien.getSoDT());
        preparedStatement.setString(5, nhanVien.getDiaChi());
        preparedStatement.setString(6, nhanVien.getAnhPhoToCC());
        preparedStatement.setString(7, nhanVien.getAnhXNKcoTATS());
        preparedStatement.setString(8, nhanVien.getEmail());
        preparedStatement.setString(9, nhanVien.getPasswords());
        preparedStatement.setString(10, nhanVien.getToken());
        preparedStatement.setDate(11, (Date) nhanVien.getNgayBD());
        preparedStatement.setDate(12, (Date) nhanVien.getNgaySinh());
        preparedStatement.setInt(13, nhanVien.getMaNv());
        if (preparedStatement.executeUpdate(sql) > 0) {
            preparedStatement.close();
            return true;
        }
        return false;
    }

    public boolean deleteNhanVien(int maNv) throws SQLException {
        Statement statement = objConn.createStatement();
        String sql = "Delete from NhanVien where maNv='" + maNv + "'";
        if (statement.executeUpdate(sql) > 0) {
            statement.close();
            return true;
        }
        return false;
    }

    public List<NhanVien> getListNhanVien() throws SQLException {
        List<NhanVien> list = new ArrayList<>();
        Statement statement = objConn.createStatement();// Tạo đối tượng Statement.
        String sql = " SELECT * FROM  NhanVien";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getDate(12), rs.getDate(13)));// Đọc dữ liệu từ ResultSet
        }
        objConn.close();// Đóng kết nối
        return list;
    }

}
