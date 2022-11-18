package laptrinhandroid.fpoly.dnnhm3.DAO;

import android.util.Log;

import com.google.type.DateTime;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Entity.BangLuong;
import laptrinhandroid.fpoly.dnnhm3.Entity.ChamCong;
import laptrinhandroid.fpoly.dnnhm3.FormatDay;
import laptrinhandroid.fpoly.dnnhm3.JDBC.DbSqlServer;

public class DAOChamCong implements Serializable {
    Connection objConn;

    public DAOChamCong() {
        DbSqlServer db = new DbSqlServer(); // hàm khởi tạo để mở kết nối
        objConn = db.openConnect(); // tạo mới DAO thì mở kết nối CSDL
    }

    public boolean addChamCong(ChamCong chamCong) {
        Statement statement = null;
        try {
            statement = objConn.createStatement();
            String s1 = "Insert into ChamCong(maNV, gioBatDau,gioKetThuc,ngay,xacNhanChamCong) values (" +
                    "'" + chamCong.getMaNV() + "'," +
                    "'" + chamCong.getGioBatDau() + "'," +
                    "'" + chamCong.getGioKetThuc() + "'," +
                    "'" + chamCong.getNgay() + "'," +
                    "'" + chamCong.getXacNhanChamCong() + "'," +
                    "')";
            if (statement.executeUpdate(s1) > 0) {
                statement.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean updateChamCong(ChamCong chamCong) throws SQLException {
        String sql = "UPDATE ChamCong  SET " + "maNV = ?," + " gioBatDau =?," + "gioKetThuc=?" + ",ngay=?" + ",xacNhanChamCong=?" + " WHERE ngay='" + new Date(System.currentTimeMillis()) + "';";
        PreparedStatement preparedStatement = objConn.prepareStatement(sql);
        preparedStatement.setInt(1, chamCong.getMaNV());
        preparedStatement.setObject(2, chamCong.getGioBatDau());
        preparedStatement.setObject(3, chamCong.getGioKetThuc());
        preparedStatement.setDate(4, chamCong.getNgay());
        preparedStatement.setInt(5, chamCong.getXacNhanChamCong());
        if (preparedStatement.executeUpdate(sql) > 0) {
            preparedStatement.close();
            return true;
        }
        return false;
    }


    public List<CalendarDay> getListChamCong(String maNV, int trangThai) throws SQLException {
        List<CalendarDay> list = new ArrayList<>();
        if (objConn != null) {
            Statement statement = objConn.createStatement();// Tạo đối tượng Statement.
            String sql = " SELECT  ngay FROM  ChamCong where maNV='" + maNV + "' AND xacNhanChamCong='" + trangThai + "'";
            // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(FormatDay.calendarDay(rs.getDate(1)));// Đọc dữ liệu từ ResultSet
            }
            objConn.close();// Đóng kết nối
        }

        return list;
    }

    public ChamCong getChamCong(int maNV) throws SQLException {

            Statement statement = objConn.createStatement();// Tạo đối tượng Statement.
            String sql = " SELECT  * FROM  ChamCong where maNV='" + maNV + "' AND ngay='" + new Date(System.currentTimeMillis()) + "'";
             ResultSet rs = statement.executeQuery(sql);
            if (rs.first()) {
                ChamCong chamCong = new ChamCong(rs.getInt(1), rs.getInt(2), rs.getTime(1), rs.getTime(1), rs.getDate(1), rs.getInt(1));
                objConn.close();
                return chamCong;
            }
            objConn.close();// Đóng kết nối

        return null;
    }
}
