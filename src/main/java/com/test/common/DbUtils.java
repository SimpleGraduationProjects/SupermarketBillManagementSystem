package com.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * ���ݿ�Ĺ�����
 * @author 
 * @throws ClassNotFoundException
 * 			���ݿ���������ʧ��
 * @
 *
 */
public class DbUtils {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		//�������ݿ�����
		Class.forName("com.mysql.jdbc.Driver");
		//������ݿ����Ӷ���
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/a_supermarket?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true"
				,"root","123456");
		//�ر����ݿ��Զ��ύ����
		conn.setAutoCommit(false);
		//�������ݿ����Ӷ���
		return conn;
	}
	
	public static void close(ResultSet rs,Statement stat,Connection conn) throws SQLException{
		if (rs!=null) {
			rs.close();
		}
		if (stat!=null) {
			stat.close();
		}
		if (conn!=null) {
			conn.close();
		}
	}
}
