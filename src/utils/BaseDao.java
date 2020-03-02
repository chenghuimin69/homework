package utils;
/**
 * ���ݿ����������
 * @author lindy
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	// ������Ҫ�õ����ַ�������
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/StudentM?UseUnicode=true&characterEncoding=UTF-8";
	private final String USERNAME = "root";
	private final String PASSWORD = "1234";
	
	// ������Ҫʹ�õĽӿڶ���
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	// ������ݿ����ӵķ���
	public Connection getConnection() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// �ͷ���Դ
	public void closeAll(ResultSet rs,PreparedStatement pst,Connection conn) {
		try {
			if(rs != null)
				rs.close();
			if(pst != null)
				pst.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
