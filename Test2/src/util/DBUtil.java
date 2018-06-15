package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ���ݿ�Ĺ�����
 */

public class DBUtil {

	//�������ݿ�Ĺ�������Ҫ�õ����ݿ�ĵ�ַ���û���������
	public static String db_url = "jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=UTF-8";
	public static String db_user = "root";
	public static String db_password = "root";
	
	//�������ӵķ���
	public static Connection getConn(){
		Connection conn = null;
		try{
			//������������ȡ����
			Class.forName( "com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(db_url,db_user,db_password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
		
	}
	
	//�ر��������ݿ����õ��Ķ���
	public static void close(Statement state,Connection conn){
		if(state!=null){
			try{
				state.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try{
				conn.close();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
	}
	//�����һ�ֹرն�������
	public static void close(ResultSet rs,Statement state,Connection conn){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(state!=null){
			try{
				state.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try{
				conn.close();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
	}
}
