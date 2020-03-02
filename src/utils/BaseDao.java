package utils;
/**
 * 数据库操作工具类
 * @author lindy
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	// 定义需要用到的字符串内容
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/StudentM?UseUnicode=true&characterEncoding=UTF-8";
	private final String USERNAME = "root";
	private final String PASSWORD = "1234";
	
	// 创建需要使用的接口对象
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	// 获得数据库连接的方法
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
	
	// 释放资源
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
