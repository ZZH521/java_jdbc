package connectMysql;
import java.sql.*;

public class ConnectMySQL {
	Connection con;
	String url = "jdbc:mysql://127.0.0.1:3306/test_usedatabase?useUnicode=true&characterEncoding=utf-8&useSSL=false";//url
	String user = "root";//数据库用户名
	String password = "admin";//数据库密码
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动类
			System.out.println("数据库驱动加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库驱动加载失败");
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		
	   return con;//按照方法要求返回一个Connection对象
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectMySQL connectDBA = new ConnectMySQL();
		connectDBA.getConnection();

	}

}
