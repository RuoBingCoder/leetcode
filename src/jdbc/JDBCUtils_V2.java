package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.ResourceBundle;

import static jdbc.JDBCUtils_V3.getConnectionBlanket;

/**
 * 提供获取连接和释放资源的 方法
 *
 * @author Never Say Never
 * @version V1.0
 * @date 2016年7月29日
 */
public class JDBCUtils_V2 {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static Locale locale = new Locale("zh", "CN");

    /**
     * 静态代码块加载配置文件信息
     */
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db", locale);
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        username = bundle.getString("username");
        password = bundle.getString("password");
    }

    /**
     * 获取连接方法
     *
     * @return
     */
    public static Connection getConnection() {
        return getConnectionBlanket(driver, url, username, password);
    }

    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        JDBCUtils_V1.releaseConnect(conn, pstmt, rs);

    }

    public static void main(String[] args) {
        System.out.println(driver);
    }
}

