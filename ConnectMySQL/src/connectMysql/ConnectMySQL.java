package connectMysql;
import java.sql.*;

public class ConnectMySQL {
	Connection con;
	String url = "jdbc:mysql://127.0.0.1:3306/test_usedatabase?useUnicode=true&characterEncoding=utf-8&useSSL=false";//url
	String user = "root";//���ݿ��û���
	String password = "admin";//���ݿ�����
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//�������ݿ�������
			System.out.println("���ݿ��������سɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ���������ʧ��");
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		}
		
	   return con;//���շ���Ҫ�󷵻�һ��Connection����
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectMySQL connectDBA = new ConnectMySQL();
		connectDBA.getConnection();

	}

}
