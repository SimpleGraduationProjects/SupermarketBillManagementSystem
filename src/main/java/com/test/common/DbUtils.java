package com.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 数据库的工具类
 * @author 
 * @throws ClassNotFoundException
 * 			数据库驱动加载失败
 * @
 *
 */
public class DbUtils {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		//加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获得数据库连接对象
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/a_supermarket?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true"
				,"root","123456");
		//关闭数据库自动提交功能
		conn.setAutoCommit(false);
		//返回数据库连接对象
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
