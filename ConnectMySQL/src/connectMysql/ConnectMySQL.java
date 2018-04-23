package connectMysql;
import java.sql.*;

public class ConnectMySQL {
	static Connection con; // 声明Connection对象
	static Statement sql; // 声明Statement对象
	static ResultSet res; // 声明ResultSet对象
	String url = "jdbc:mysql://127.0.0.1:3306/test_usedatabase?useUnicode=true&characterEncoding=utf-8&useSSL=false";//url
	String user = "root";//数据库用户名
	String password = "admin";//数据库密码
	/*
	 * 连接mySQL数据库
	 * */
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
		
		try {
			sql = con.createStatement(); // 实例化Statement对象
			// 执行SQL语句，返回结果集
			res = sql.executeQuery("select * from testfirst");
			while (res.next()) { // 如果当前语句不是最后一条则进入循环
				String id = res.getString("id"); // 获取列名是"id"的字段值
				// 获取列名是"name"的字段值
				String name = res.getString("name");
				// 获取列名是"sex"的字段值
				String sex = res.getString("sex");
				// 获取列名是"birthday"的字段值
				String age = res.getString("age");
				System.out.print("编号：" + id); // 将列值输出
				System.out.print(" 姓名:" + name);
				System.out.print(" 性别:" + sex);
				System.out.println(" 年龄：" + age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
