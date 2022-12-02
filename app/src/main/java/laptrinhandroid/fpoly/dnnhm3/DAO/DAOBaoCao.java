package laptrinhandroid.fpoly.dnnhm3.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Entity.BaoCao;
import laptrinhandroid.fpoly.dnnhm3.Entity.SanPham;
import laptrinhandroid.fpoly.dnnhm3.JDBC.DbSqlServer;

public class DAOBaoCao {
    Connection connection;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");

    public DAOBaoCao(){
        DbSqlServer db = new DbSqlServer(); // hàm khởi tạo để mở kết nối
        connection = db.openConnect(); // tạo mới DAO thì mở kết nối CSDL
    }

    public List<SanPham> getListAllSanPham() throws SQLException {
        List<SanPham> list = new ArrayList<>();
        Statement statement = connection.createStatement();
        String sql = " SELECT * FROM  SanPham";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                    rs.getString(3), rs.getFloat(4),
                    rs.getFloat(5), rs.getString(6),
                    rs.getInt(7), rs.getInt(8),
                    rs.getString(9)));// Đọc dữ liệu từ ResultSet
        }
        connection.close();
        return list;
    }

    public List<BaoCao> getListSanPhamByDay(String date) throws SQLException {
        List<BaoCao> list = new ArrayList<>();
        Statement statement = connection.createStatement();
        String sql = "select ChiTietHoaDon.tenSP, ChiTietHoaDon.soLuong, ChiTietHoaDon.donGia, ChiTietHoaDon.thanhTien,\n" +
                "\t\tSanPham.giaNhap, SanPham.giaBan,\n" +
                "\t\tHoaDonBan.ngayBan from ChiTietHoaDon \n" +
                "INNER JOIN SanPham ON ChiTietHoaDon.maSp = SanPham.maSP\n" +
                "INNER JOIN HoaDonBan ON ChiTietHoaDon.maHD = HoaDonBan.maHDBan\n" +
                "WHERE HoaDonBan.ngayBan = '" + date + "'";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new BaoCao(rs.getString(1), rs.getInt(2), rs.getFloat(3),
                    rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getDate(7)));// Đọc dữ liệu từ ResultSet
        }
        return list;
    }

}
