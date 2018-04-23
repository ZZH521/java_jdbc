package connectMysql;
import java.sql.*;

public class ConnectMySQL {
	static Connection con; // ����Connection����
	static Statement sql; // ����Statement����
	static ResultSet res; // ����ResultSet����
	String url = "jdbc:mysql://127.0.0.1:3306/test_usedatabase?useUnicode=true&characterEncoding=utf-8&useSSL=false";//url
	String user = "root";//���ݿ��û���
	String password = "admin";//���ݿ�����
	/*
	 * ����mySQL���ݿ�
	 * */
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
		
		try {
			sql = con.createStatement(); // ʵ����Statement����
			// ִ��SQL��䣬���ؽ����
			res = sql.executeQuery("select * from testfirst");
			while (res.next()) { // �����ǰ��䲻�����һ�������ѭ��
				String id = res.getString("id"); // ��ȡ������"id"���ֶ�ֵ
				// ��ȡ������"name"���ֶ�ֵ
				String name = res.getString("name");
				// ��ȡ������"sex"���ֶ�ֵ
				String sex = res.getString("sex");
				// ��ȡ������"birthday"���ֶ�ֵ
				String age = res.getString("age");
				System.out.print("��ţ�" + id); // ����ֵ���
				System.out.print(" ����:" + name);
				System.out.print(" �Ա�:" + sex);
				System.out.println(" ���䣺" + age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
