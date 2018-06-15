package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import bean.UserBean;
import util.DBUtil;

public class UserDao {

		//�޸��û�������
		public boolean changeUser(UserBean userBean){
			boolean f= false;
			String sql = "update user set password = '"+userBean.getPassword()+"' where username='"+userBean.getUsername()+"'";
			Connection conn = DBUtil.getConn();
			Statement state = null;
			try{
				state = conn.createStatement();
				int a = state.executeUpdate(sql);
				if(a==1)
					f=true;
			
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close( state, conn);
			}
			return f;
		}
	
		//�õ��û�����Ϣ
		public UserBean findUser(String username){
			String sql = "select * from user where username = '"+username+"'";
			Connection conn = DBUtil.getConn();
			Statement state = null;
			ResultSet rs = null;
			UserBean userBean=new UserBean();
			try{
				state = conn.createStatement();
				rs= state.executeQuery(sql);
				while (rs.next()){
					userBean.setUsername(rs.getString( "username"));
					userBean.setPassword(rs.getString( "password"));
					userBean.setInstitution(rs.getString( "institution"));
					userBean.setTruename(rs.getString("truename"));
					userBean.setUserid(rs.getString("userid"));
					userBean.setPhone(rs.getString( "phone"));
					userBean.setWorkplace(rs.getString( "workplace"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
			
			return userBean;
		}
	
		//ע���û�
		public boolean addUser(UserBean userBean){
			boolean f = false;
			String sql = "insert into user(username,password,workplace,institution,truename,userid,phone) values('"+userBean.getUsername()+"','"+userBean.getPassword()+"','"+userBean.getWorkplace()+"','"+userBean.getInstitution()+"','"+userBean.getTruename()+"','"+userBean.getUserid()+"','"+userBean.getPhone()+"')";
			Connection conn = DBUtil.getConn();
			Statement state =null;
			try{
				state=conn.createStatement();
				int a = state.executeUpdate(sql);
				if(a==1){
					f=true;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(state, conn);
			}
			return f;
		}
	
		//�ж��û����ڲ������ݿ���
		public String checkUser(String username){
			String sql = "select * from user where username = '"+username+"'";
			String password="";
			Connection conn = DBUtil.getConn();
			Statement state = null;
			ResultSet rs = null;
			
			try{
				state = conn.createStatement();
				rs= state.executeQuery(sql);
				while (rs.next()){
					password=rs.getString("password");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
			return password;
		}
}
