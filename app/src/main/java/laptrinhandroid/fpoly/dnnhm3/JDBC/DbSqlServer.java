package laptrinhandroid.fpoly.dnnhm3.JDBC;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbSqlServer {
    Connection connection;
    public Connection openConnect() {
        StrictMode.ThreadPolicy threadPolicy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String connectUrl = "jdbc:jtds:sqlserver://192.168.1.117:1433;databasename=duannhom3;user=ph20612;password=2992003;";
            this.connection =
                    DriverManager.getConnection(connectUrl);
            Log.d("ggggggg", "OK");

        } catch (Exception e) {
            Log.d("ggggggg", e.getMessage());
            e.printStackTrace();
         }
        return connection;
    }


}
