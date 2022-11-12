package laptrinhandroid.fpoly.dnnhm3.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Entity.NhanVien;
import laptrinhandroid.fpoly.dnnhm3.Entity.SanPham;
import laptrinhandroid.fpoly.dnnhm3.JDBC.DbSqlServer;

public class DAOSanPham {
    Connection objConn;

    public DAOSanPham() {
        DbSqlServer db = new DbSqlServer(); // hàm khởi tạo để mở kết nối
        objConn = db.openConnect(); // tạo mới DAO thì mở kết nối CSDL
    }

    public boolean addSanPham(SanPham sanPham) {
        Statement statement = null;
        try {
            statement = objConn.createStatement();
            String s1 = "Insert into SanPham(loaiSP, tenSP,giaNhap,giaBan,anh,soLuongDaBan,soLuong,ghiChu ) values (" +
                    "'" + sanPham.getLoaiSP() + "'," +
                    "'" + sanPham.getTenSP() + "'," +
                    "'" + sanPham.getGiaNhap() + "'," +
                    "'" + sanPham.getGiaBan() + "'," +
                    "'" + sanPham.getAnh() + "'," +
                    "'" + sanPham.getSoLuongDaBan() + "'," +
                    "'" + sanPham.getSoLuong() + "'," +
                    "'" + sanPham.getGhiChu() + "')";
            if (statement.executeUpdate(s1) > 0) {
                statement.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean updateSanPham(SanPham sanPham) {
        String sql = "UPDATE SanPham  SET " + "loaiSP = ?," + " tenSP =?," + "giaNhap=?" + ",giaBan=?" + ",anh=?" + ",soLuongDaBan=?" + ",soLuong=?" + ",ghiChu=?" + " WHERE maSP='"+sanPham.getMaSP()+"';";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = objConn.prepareStatement(sql);
            preparedStatement.setInt(1, sanPham.getLoaiSP());
            preparedStatement.setString(2, sanPham.getTenSP());
            preparedStatement.setFloat(3, sanPham.getGiaNhap());
            preparedStatement.setFloat(4, sanPham.getGiaBan());
            preparedStatement.setString(5, sanPham.getAnh());
            preparedStatement.setInt(6, sanPham.getSoLuongDaBan());
            preparedStatement.setInt(7, sanPham.getSoLuong());
            preparedStatement.setString(8, sanPham.getGhiChu());

            if (preparedStatement.executeUpdate(sql) > 0) {
                preparedStatement.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSanPham(int maSP) {
        Statement statement = null;
        try {
            statement = objConn.createStatement();
            String sql = "Delete from SanPham where maSP='" + maSP + "'";
            if (statement.executeUpdate(sql) > 0) {
                statement.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<SanPham> getListSanPham() throws SQLException {
        List<SanPham> list = new ArrayList<>();
        Statement statement = objConn.createStatement();
        String sql = " SELECT * FROM  SanPham";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new SanPham(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9)));// Đọc dữ liệu từ ResultSet
        }
        objConn.close();
        return list;
    }

}
