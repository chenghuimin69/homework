package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import entity.Student;
import utils.BaseDao;

public class StudentDaoImpl extends BaseDao implements StudentDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	/**
	 * ����id����ѧ����Ϣ
	 */
	@Override
	public Student findById(String id) {
		Student stuId=null;
		try {
			// ������Ӷ���
			conn = getConnection();
			// ����Ҫִ�е�SQL����
			String sql = "select name,age from student where id=?";
			// ����ִ�ж���
			pst = conn.prepareStatement(sql);
			// sql������ʺţ�Ϊ�ʺŸ�ֵ
			pst.setString(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				stuId=new Student();
				stuId.setName(rs.getString(1));
				stuId.setAge(rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pst, conn);
		}
		return stuId;

	}

	@Override
	public List<Student> getAll() {
		List<Student> list=new ArrayList<Student>();
		try {
			conn = getConnection();
			String sql = "select * from student";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Student(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pst, conn);
		}
		return list;
	}

}
