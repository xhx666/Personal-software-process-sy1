package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import bean.NeedBean;

public class NeedDao {
	
	//��������޸�״̬��Ϣ���Լ�����޸���������ݿ���
	public boolean isPass(int nd_id,int nd_state,String nd_advice){
		boolean f = false;
		boolean f1=false;
		boolean f2=false;
		String sql = "update need set nd_advice='"+nd_advice+"' where nd_id='"+nd_id+"'";
		Connection conn = DBUtil.getConn();
		Statement state =null;
		try{
			state=conn.createStatement();
			int a = state.executeUpdate(sql);
			if(a==1){
				f1=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(state, conn);
		}
		f2=changeState(nd_id,nd_state);
		if(f1==true&&f2==true){
			f=true;
		}
		return f;
	}
	
	//��������޸�״̬��Ϣ
	public boolean changeState(int nd_id,int nd_state){
		boolean f = false;
		String sql = "update need set nd_state='"+nd_state+"' where nd_id='"+nd_id+"'";
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
	
	//������Ų�ѯ�������ϸ��Ϣ
	public NeedBean singleNeed(int nd_id){
		String sql = "select * from need where nd_id= '"+nd_id+"'";
		Connection conn =DBUtil.getConn();
		Statement state =null;
		ResultSet rs = null;
		NeedBean needBean =new NeedBean();
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean.setNd_id(rs.getInt( "nd_id"));
				needBean.setJgmc( rs.getString( "jgmc"));//��������
				needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
				needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
				needBean.setEmail(rs.getString( "email")) ;
				needBean.setLxr(rs.getString( "lxr"));
				needBean.setPhone(rs.getString( "phone"));
				needBean.setCz(rs.getString( "cz"));
				needBean.setJgsx(rs.getString( "jgsx"));
				needBean.setJgjj(rs.getString("jgjj"));
				needBean.setNd_name(rs.getString( "nd_name"));
				needBean.setNd_gs(rs.getString( "nd_gs"));
				needBean.setKey(rs.getString( "keyw"));
				needBean.setYjlx(rs.getString( "yjlx"));
				needBean.setXkfl(rs.getString( "xkfl"));
				needBean.setSsly(rs.getString( "ssly"));
				needBean.setYyhy(rs.getString( "yyhy"));
				needBean.setHzms(rs.getString( "hzms"));
				needBean.setZtz(rs.getString( "ztz"));
				needBean.setQyzc(rs.getString( "qyzc"));
				needBean.setYhdk(rs.getString( "yhdk"));
				needBean.setQtrz(rs.getString( "qtrz"));
				needBean.setNd_state(rs.getInt("nd_state"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return needBean;
	}
	
	//ͨ�����Ʋ�ѯ����������Ϣ
	public List<NeedBean> findNeedByName(String nd_name){
		List<NeedBean> needBeans = new ArrayList<NeedBean>();
		String sql = "select * from need where nd_name like '%"+nd_name+"%'";
		Connection conn =DBUtil.getConn();
		Statement state =null;
		ResultSet rs = null;
		NeedBean needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new NeedBean();
				needBean.setNd_id(rs.getInt( "nd_id"));
				needBean.setJgmc( rs.getString( "jgmc"));//��������
				needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
				needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
				needBean.setEmail(rs.getString( "email")) ;
				needBean.setLxr(rs.getString( "lxr"));
				needBean.setPhone(rs.getString( "phone"));
				needBean.setCz(rs.getString( "cz"));
				needBean.setJgsx(rs.getString( "jgsx"));
				needBean.setJgjj(rs.getString("jgjj"));
				needBean.setNd_name(rs.getString( "nd_name"));
				needBean.setNd_gs(rs.getString( "nd_gs"));
				needBean.setKey(rs.getString( "keyw"));
				needBean.setYjlx(rs.getString( "yjlx"));
				needBean.setXkfl(rs.getString( "xkfl"));
				needBean.setSsly(rs.getString( "ssly"));
				needBean.setYyhy(rs.getString( "yyhy"));
				needBean.setHzms(rs.getString( "hzms"));
				needBean.setZtz(rs.getString( "ztz"));
				needBean.setQyzc(rs.getString( "qyzc"));
				needBean.setYhdk(rs.getString( "yhdk"));
				needBean.setQtrz(rs.getString( "qtrz"));
				needBean.setNd_state(rs.getInt("nd_state"));
				needBeans.add(needBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return needBeans;
	}
	
	//ͨ��״̬��ѯ���еļ���������Ϣ
	public List<NeedBean> findNeedByState(int nd_state){
		List<NeedBean> needBeans = new ArrayList<NeedBean>();
		String sql = "select * from need where nd_state='"+nd_state+"'";
		Connection conn =DBUtil.getConn();
		Statement state =null;
		ResultSet rs = null;
		NeedBean needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new NeedBean();
				needBean.setNd_id(rs.getInt( "nd_id"));
				needBean.setJgmc( rs.getString( "jgmc"));//��������
				needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
				needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
				needBean.setEmail(rs.getString( "email")) ;
				needBean.setLxr(rs.getString( "lxr"));
				needBean.setPhone(rs.getString( "phone"));
				needBean.setCz(rs.getString( "cz"));
				needBean.setJgsx(rs.getString( "jgsx"));
				needBean.setJgjj(rs.getString("jgjj"));
				needBean.setNd_name(rs.getString( "nd_name"));
				needBean.setNd_gs(rs.getString( "nd_gs"));
				needBean.setKey(rs.getString( "keyw"));
				needBean.setYjlx(rs.getString( "yjlx"));
				needBean.setXkfl(rs.getString( "xkfl"));
				needBean.setSsly(rs.getString( "ssly"));
				needBean.setYyhy(rs.getString( "yyhy"));
				needBean.setHzms(rs.getString( "hzms"));
				needBean.setZtz(rs.getString( "ztz"));
				needBean.setQyzc(rs.getString( "qyzc"));
				needBean.setYhdk(rs.getString( "yhdk"));
				needBean.setQtrz(rs.getString( "qtrz"));
				needBean.setNd_state(rs.getInt("nd_state"));
				needBeans.add(needBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return needBeans;
	}
	
	public List<NeedBean> findNeedByNS(String nd_name,int nd_state){
		List<NeedBean> needBeans = new ArrayList<NeedBean>();
		String sql = "select * from need where nd_state='"+nd_state+"' and nd_name like '%"+nd_name+"%'";
		Connection conn =DBUtil.getConn();
		Statement state =null;
		ResultSet rs = null;
		NeedBean needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new NeedBean();
				needBean.setNd_id(rs.getInt( "nd_id"));
				needBean.setJgmc( rs.getString( "jgmc"));//��������
				needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
				needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
				needBean.setEmail(rs.getString( "email")) ;
				needBean.setLxr(rs.getString( "lxr"));
				needBean.setPhone(rs.getString( "phone"));
				needBean.setCz(rs.getString( "cz"));
				needBean.setJgsx(rs.getString( "jgsx"));
				needBean.setJgjj(rs.getString("jgjj"));
				needBean.setNd_name(rs.getString( "nd_name"));
				needBean.setNd_gs(rs.getString( "nd_gs"));
				needBean.setKey(rs.getString( "keyw"));
				needBean.setYjlx(rs.getString( "yjlx"));
				needBean.setXkfl(rs.getString( "xkfl"));
				needBean.setSsly(rs.getString( "ssly"));
				needBean.setYyhy(rs.getString( "yyhy"));
				needBean.setHzms(rs.getString( "hzms"));
				needBean.setZtz(rs.getString( "ztz"));
				needBean.setQyzc(rs.getString( "qyzc"));
				needBean.setYhdk(rs.getString( "yhdk"));
				needBean.setQtrz(rs.getString( "qtrz"));
				needBean.setNd_state(rs.getInt("nd_state"));
				needBeans.add(needBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return needBeans;
	}
	
	public List<NeedBean> findNeedJC(int n){
		List<NeedBean> needBeans = new ArrayList<NeedBean>();
		if(n==2){
			String sql = "select * from need where yjlx='基础研究'";
			Connection conn =DBUtil.getConn();
			Statement state =null;
			ResultSet rs = null;
			NeedBean needBean =null;
			try{
				state=conn.createStatement();
				rs=state.executeQuery(sql);
				while(rs.next()){
					needBean = new NeedBean();
					needBean.setNd_id(rs.getInt( "nd_id"));
					needBean.setJgmc( rs.getString( "jgmc"));//��������
					needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
					needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
					needBean.setEmail(rs.getString( "email")) ;
					needBean.setLxr(rs.getString( "lxr"));
					needBean.setPhone(rs.getString( "phone"));
					needBean.setCz(rs.getString( "cz"));
					needBean.setJgsx(rs.getString( "jgsx"));
					needBean.setJgjj(rs.getString("jgjj"));
					needBean.setNd_name(rs.getString( "nd_name"));
					needBean.setNd_gs(rs.getString( "nd_gs"));
					needBean.setKey(rs.getString( "keyw"));
					needBean.setYjlx(rs.getString( "yjlx"));
					needBean.setXkfl(rs.getString( "xkfl"));
					needBean.setSsly(rs.getString( "ssly"));
					needBean.setYyhy(rs.getString( "yyhy"));
					needBean.setHzms(rs.getString( "hzms"));
					needBean.setZtz(rs.getString( "ztz"));
					needBean.setQyzc(rs.getString( "qyzc"));
					needBean.setYhdk(rs.getString( "yhdk"));
					needBean.setQtrz(rs.getString( "qtrz"));
					needBean.setNd_state(rs.getInt("nd_state"));
					needBeans.add(needBean);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
			return needBeans;
		}else if(n==3){
			String sql = "select * from need where yjlx not in ('基础研究')";
			Connection conn =DBUtil.getConn();
			Statement state =null;
			ResultSet rs = null;
			NeedBean needBean =null;
			try{
				state=conn.createStatement();
				rs=state.executeQuery(sql);
				while(rs.next()){
					needBean = new NeedBean();
					needBean.setNd_id(rs.getInt( "nd_id"));
					needBean.setJgmc( rs.getString( "jgmc"));//��������
					needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
					needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
					needBean.setEmail(rs.getString( "email")) ;
					needBean.setLxr(rs.getString( "lxr"));
					needBean.setPhone(rs.getString( "phone"));
					needBean.setCz(rs.getString( "cz"));
					needBean.setJgsx(rs.getString( "jgsx"));
					needBean.setJgjj(rs.getString("jgjj"));
					needBean.setNd_name(rs.getString( "nd_name"));
					needBean.setNd_gs(rs.getString( "nd_gs"));
					needBean.setKey(rs.getString( "keyw"));
					needBean.setYjlx(rs.getString( "yjlx"));
					needBean.setXkfl(rs.getString( "xkfl"));
					needBean.setSsly(rs.getString( "ssly"));
					needBean.setYyhy(rs.getString( "yyhy"));
					needBean.setHzms(rs.getString( "hzms"));
					needBean.setZtz(rs.getString( "ztz"));
					needBean.setQyzc(rs.getString( "qyzc"));
					needBean.setYhdk(rs.getString( "yhdk"));
					needBean.setQtrz(rs.getString( "qtrz"));
					needBean.setNd_state(rs.getInt("nd_state"));
					needBeans.add(needBean);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
			return needBeans;
		}else if(n==4){
			String sql = "select * from need where xkfl='学科A'";
			Connection conn =DBUtil.getConn();
			Statement state =null;
			ResultSet rs = null;
			NeedBean needBean =null;
			try{
				state=conn.createStatement();
				rs=state.executeQuery(sql);
				while(rs.next()){
					needBean = new NeedBean();
					needBean.setNd_id(rs.getInt( "nd_id"));
					needBean.setJgmc( rs.getString( "jgmc"));//��������
					needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
					needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
					needBean.setEmail(rs.getString( "email")) ;
					needBean.setLxr(rs.getString( "lxr"));
					needBean.setPhone(rs.getString( "phone"));
					needBean.setCz(rs.getString( "cz"));
					needBean.setJgsx(rs.getString( "jgsx"));
					needBean.setJgjj(rs.getString("jgjj"));
					needBean.setNd_name(rs.getString( "nd_name"));
					needBean.setNd_gs(rs.getString( "nd_gs"));
					needBean.setKey(rs.getString( "keyw"));
					needBean.setYjlx(rs.getString( "yjlx"));
					needBean.setXkfl(rs.getString( "xkfl"));
					needBean.setSsly(rs.getString( "ssly"));
					needBean.setYyhy(rs.getString( "yyhy"));
					needBean.setHzms(rs.getString( "hzms"));
					needBean.setZtz(rs.getString( "ztz"));
					needBean.setQyzc(rs.getString( "qyzc"));
					needBean.setYhdk(rs.getString( "yhdk"));
					needBean.setQtrz(rs.getString( "qtrz"));
					needBean.setNd_state(rs.getInt("nd_state"));
					needBeans.add(needBean);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
			return needBeans;
		}else if(n==5){
			String sql = "select * from need where xkfl='学科B'";
			Connection conn =DBUtil.getConn();
			Statement state =null;
			ResultSet rs = null;
			NeedBean needBean =null;
			try{
				state=conn.createStatement();
				rs=state.executeQuery(sql);
				while(rs.next()){
					needBean = new NeedBean();
					needBean.setNd_id(rs.getInt( "nd_id"));
					needBean.setJgmc( rs.getString( "jgmc"));//��������
					needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
					needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
					needBean.setEmail(rs.getString( "email")) ;
					needBean.setLxr(rs.getString( "lxr"));
					needBean.setPhone(rs.getString( "phone"));
					needBean.setCz(rs.getString( "cz"));
					needBean.setJgsx(rs.getString( "jgsx"));
					needBean.setJgjj(rs.getString("jgjj"));
					needBean.setNd_name(rs.getString( "nd_name"));
					needBean.setNd_gs(rs.getString( "nd_gs"));
					needBean.setKey(rs.getString( "keyw"));
					needBean.setYjlx(rs.getString( "yjlx"));
					needBean.setXkfl(rs.getString( "xkfl"));
					needBean.setSsly(rs.getString( "ssly"));
					needBean.setYyhy(rs.getString( "yyhy"));
					needBean.setHzms(rs.getString( "hzms"));
					needBean.setZtz(rs.getString( "ztz"));
					needBean.setQyzc(rs.getString( "qyzc"));
					needBean.setYhdk(rs.getString( "yhdk"));
					needBean.setQtrz(rs.getString( "qtrz"));
					needBean.setNd_state(rs.getInt("nd_state"));
					needBeans.add(needBean);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
			return needBeans;
		}else if(n==6){
			String sql = "select * from need where xkfl='学科C'";
			Connection conn =DBUtil.getConn();
			Statement state =null;
			ResultSet rs = null;
			NeedBean needBean =null;
			try{
				state=conn.createStatement();
				rs=state.executeQuery(sql);
				while(rs.next()){
					needBean = new NeedBean();
					needBean.setNd_id(rs.getInt( "nd_id"));
					needBean.setJgmc( rs.getString( "jgmc"));//��������
					needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
					needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
					needBean.setEmail(rs.getString( "email")) ;
					needBean.setLxr(rs.getString( "lxr"));
					needBean.setPhone(rs.getString( "phone"));
					needBean.setCz(rs.getString( "cz"));
					needBean.setJgsx(rs.getString( "jgsx"));
					needBean.setJgjj(rs.getString("jgjj"));
					needBean.setNd_name(rs.getString( "nd_name"));
					needBean.setNd_gs(rs.getString( "nd_gs"));
					needBean.setKey(rs.getString( "keyw"));
					needBean.setYjlx(rs.getString( "yjlx"));
					needBean.setXkfl(rs.getString( "xkfl"));
					needBean.setSsly(rs.getString( "ssly"));
					needBean.setYyhy(rs.getString( "yyhy"));
					needBean.setHzms(rs.getString( "hzms"));
					needBean.setZtz(rs.getString( "ztz"));
					needBean.setQyzc(rs.getString( "qyzc"));
					needBean.setYhdk(rs.getString( "yhdk"));
					needBean.setQtrz(rs.getString( "qtrz"));
					needBean.setNd_state(rs.getInt("nd_state"));
					needBeans.add(needBean);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
			return needBeans;
		}else if(n==7){
			String sql = "select * from need where yjlx='应用研究'";
			Connection conn =DBUtil.getConn();
			Statement state =null;
			ResultSet rs = null;
			NeedBean needBean =null;
			try{
				state=conn.createStatement();
				rs=state.executeQuery(sql);
				while(rs.next()){
					needBean = new NeedBean();
					needBean.setNd_id(rs.getInt( "nd_id"));
					needBean.setJgmc( rs.getString( "jgmc"));//��������
					needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
					needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
					needBean.setEmail(rs.getString( "email")) ;
					needBean.setLxr(rs.getString( "lxr"));
					needBean.setPhone(rs.getString( "phone"));
					needBean.setCz(rs.getString( "cz"));
					needBean.setJgsx(rs.getString( "jgsx"));
					needBean.setJgjj(rs.getString("jgjj"));
					needBean.setNd_name(rs.getString( "nd_name"));
					needBean.setNd_gs(rs.getString( "nd_gs"));
					needBean.setKey(rs.getString( "keyw"));
					needBean.setYjlx(rs.getString( "yjlx"));
					needBean.setXkfl(rs.getString( "xkfl"));
					needBean.setSsly(rs.getString( "ssly"));
					needBean.setYyhy(rs.getString( "yyhy"));
					needBean.setHzms(rs.getString( "hzms"));
					needBean.setZtz(rs.getString( "ztz"));
					needBean.setQyzc(rs.getString( "qyzc"));
					needBean.setYhdk(rs.getString( "yhdk"));
					needBean.setQtrz(rs.getString( "qtrz"));
					needBean.setNd_state(rs.getInt("nd_state"));
					needBeans.add(needBean);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
			return needBeans;
		}else if(n==8){
			String sql = "select * from need where yjlx='实验发展'";
			Connection conn =DBUtil.getConn();
			Statement state =null;
			ResultSet rs = null;
			NeedBean needBean =null;
			try{
				state=conn.createStatement();
				rs=state.executeQuery(sql);
				while(rs.next()){
					needBean = new NeedBean();
					needBean.setNd_id(rs.getInt( "nd_id"));
					needBean.setJgmc( rs.getString( "jgmc"));//��������
					needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
					needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
					needBean.setEmail(rs.getString( "email")) ;
					needBean.setLxr(rs.getString( "lxr"));
					needBean.setPhone(rs.getString( "phone"));
					needBean.setCz(rs.getString( "cz"));
					needBean.setJgsx(rs.getString( "jgsx"));
					needBean.setJgjj(rs.getString("jgjj"));
					needBean.setNd_name(rs.getString( "nd_name"));
					needBean.setNd_gs(rs.getString( "nd_gs"));
					needBean.setKey(rs.getString( "keyw"));
					needBean.setYjlx(rs.getString( "yjlx"));
					needBean.setXkfl(rs.getString( "xkfl"));
					needBean.setSsly(rs.getString( "ssly"));
					needBean.setYyhy(rs.getString( "yyhy"));
					needBean.setHzms(rs.getString( "hzms"));
					needBean.setZtz(rs.getString( "ztz"));
					needBean.setQyzc(rs.getString( "qyzc"));
					needBean.setYhdk(rs.getString( "yhdk"));
					needBean.setQtrz(rs.getString( "qtrz"));
					needBean.setNd_state(rs.getInt("nd_state"));
					needBeans.add(needBean);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
			return needBeans;
		}else if(n==9){
			String sql = "select * from need where yjlx='研究发展'";
			Connection conn =DBUtil.getConn();
			Statement state =null;
			ResultSet rs = null;
			NeedBean needBean =null;
			try{
				state=conn.createStatement();
				rs=state.executeQuery(sql);
				while(rs.next()){
					needBean = new NeedBean();
					needBean.setNd_id(rs.getInt( "nd_id"));
					needBean.setJgmc( rs.getString( "jgmc"));//��������
					needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
					needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
					needBean.setEmail(rs.getString( "email")) ;
					needBean.setLxr(rs.getString( "lxr"));
					needBean.setPhone(rs.getString( "phone"));
					needBean.setCz(rs.getString( "cz"));
					needBean.setJgsx(rs.getString( "jgsx"));
					needBean.setJgjj(rs.getString("jgjj"));
					needBean.setNd_name(rs.getString( "nd_name"));
					needBean.setNd_gs(rs.getString( "nd_gs"));
					needBean.setKey(rs.getString( "keyw"));
					needBean.setYjlx(rs.getString( "yjlx"));
					needBean.setXkfl(rs.getString( "xkfl"));
					needBean.setSsly(rs.getString( "ssly"));
					needBean.setYyhy(rs.getString( "yyhy"));
					needBean.setHzms(rs.getString( "hzms"));
					needBean.setZtz(rs.getString( "ztz"));
					needBean.setQyzc(rs.getString( "qyzc"));
					needBean.setYhdk(rs.getString( "yhdk"));
					needBean.setQtrz(rs.getString( "qtrz"));
					needBean.setNd_state(rs.getInt("nd_state"));
					needBeans.add(needBean);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
			return needBeans;
		}else{
			return null;
		}
	}
	//�������
	public List<NeedBean> listNeed(){
		List<NeedBean> needBeans = new ArrayList<NeedBean>();
		String sql = "select * from need";
		Connection conn =DBUtil.getConn();
		Statement state =null;
		ResultSet rs = null;
		NeedBean needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new NeedBean();
				needBean.setNd_id(rs.getInt( "nd_id"));
				needBean.setJgmc( rs.getString( "jgmc"));//��������
				needBean.setTxdz( rs.getString( "txdz"));//ͨѶ��ַ
				needBean.setDwwz( rs.getString( "dwwz"));//��λ��ַ
				needBean.setEmail(rs.getString( "email")) ;
				needBean.setLxr(rs.getString( "lxr"));
				needBean.setPhone(rs.getString( "phone"));
				needBean.setCz(rs.getString( "cz"));
				needBean.setJgsx(rs.getString( "jgsx"));
				needBean.setJgjj(rs.getString("jgjj"));
				needBean.setNd_name(rs.getString( "nd_name"));
				needBean.setNd_gs(rs.getString( "nd_gs"));
				needBean.setKey(rs.getString( "keyw"));
				needBean.setYjlx(rs.getString( "yjlx"));
				needBean.setXkfl(rs.getString( "xkfl"));
				needBean.setSsly(rs.getString( "ssly"));
				needBean.setYyhy(rs.getString( "yyhy"));
				needBean.setHzms(rs.getString( "hzms"));
				needBean.setZtz(rs.getString( "ztz"));
				needBean.setQyzc(rs.getString( "qyzc"));
				needBean.setYhdk(rs.getString( "yhdk"));
				needBean.setQtrz(rs.getString( "qtrz"));
				needBean.setNd_state(rs.getInt("nd_state"));
				needBeans.add(needBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return needBeans;
	}
	
	//����������ݿ���
	public boolean addNeed(NeedBean needBean){
		boolean f = false;
		//jgmc txdz	dwwz email lxr phone cz jgsx jgjj nd_name nd_gs
		//key yjlx xkfl ssly yyhy hzms ztz qyzc yhdk qtrz
		String sql = "insert into need(jgmc,txdz,dwwz,email,lxr,phone,cz,jgsx,jgjj,nd_name,nd_gs,keyw,yjlx,xkfl,ssly,yyhy,hzms,ztz,qyzc,yhdk,qtrz) values('"+needBean.getJgmc()+"','"+needBean.getTxdz()+"','"+needBean.getDwwz()+"','"+needBean.getEmail()+"','"+needBean.getLxr()+"','"+needBean.getPhone()+"','"+needBean.getCz()+"','"+needBean.getJgsx()+"','"+needBean.getJgjj()+"','"+needBean.getNd_name()+"','"+needBean.getNd_gs()+"','"+needBean.getKey()+"','"+needBean.getYjlx()+"','"+needBean.getXkfl()+"','"+needBean.getSsly()+"','"+needBean.getYyhy()+"','"+needBean.getHzms()+"','"+needBean.getZtz()+"','"+needBean.getQyzc()+"','"+needBean.getYhdk()+"','"+needBean.getQtrz()+"')";
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

	//ͳ��δ��˵���Ŀ
	public int findNoPass(){
		String sql = "select * from need where nd_state = 1";
		Connection conn =DBUtil.getConn();
		Statement state =null;
		ResultSet rs = null;
		int num = 0;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				num++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
			return num;
	}

	//ͳ������˵���Ŀ
	public int findPass(){
			String sql = "select * from need where nd_state = 2";
			Connection conn =DBUtil.getConn();
			Statement state =null;
			ResultSet rs = null;
			int num = 0;
			try{
				state=conn.createStatement();
				rs=state.executeQuery(sql);
				while(rs.next()){
					num++;
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
				return num;
		}

	//ͳ��δ��˵���Ŀ
	public int findNotPass(){
			String sql = "select * from need where nd_state = 3";
			Connection conn =DBUtil.getConn();
			Statement state =null;
			ResultSet rs = null;
			int num = 0;
			try{
				state=conn.createStatement();
				rs=state.executeQuery(sql);
				while(rs.next()){
					num++;
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
				return num;
		}
	
	//综合查询
		public List<NeedBean> findZH(String search1,String find1,String logic1,String search2,String find2,String logic2,String search3,String find3){
			List<NeedBean> needBeans = new ArrayList<NeedBean>();
			String sql = "select * from need where "+search1+" like '%"+find1+"%' ";
			Connection conn =DBUtil.getConn();
			Statement state =null;
			ResultSet rs = null;
			NeedBean needBean =null;
			if(!logic1.equals("")){
				if(logic1.equals("not"))
					sql += "and " + search2 + " not like '"+find2+"' ";
				else
					sql += logic1+" "+search2+" like '%"+find2+"%'";
			}
			if(!logic2.equals("")){
				if(logic2.equals("not"))
					sql += " and " + search3 + " not like '%"+find3+"%'";
				else
					sql += logic2+search3+"like '%"+find3+"%'";
			}
			try{
				state=conn.createStatement();
				rs=state.executeQuery(sql);
				while(rs.next()){
					needBean = new NeedBean();
					needBean.setNd_id(rs.getInt( "nd_id"));
					needBean.setJgmc( rs.getString( "jgmc"));//机构名称
					needBean.setTxdz( rs.getString( "txdz"));//通讯地址
					needBean.setDwwz( rs.getString( "dwwz"));//单位网址
					needBean.setEmail(rs.getString( "email")) ;
					needBean.setLxr(rs.getString( "lxr"));
					needBean.setPhone(rs.getString( "phone"));
					needBean.setCz(rs.getString( "cz"));
					needBean.setJgsx(rs.getString( "jgsx"));
					needBean.setJgjj(rs.getString("jgjj"));
					needBean.setNd_name(rs.getString( "nd_name"));
					needBean.setNd_gs(rs.getString( "nd_gs"));
					needBean.setKey(rs.getString( "keyw"));
					needBean.setYjlx(rs.getString( "yjlx"));
					needBean.setXkfl(rs.getString( "xkfl"));
					needBean.setSsly(rs.getString( "ssly"));
					needBean.setYyhy(rs.getString( "yyhy"));
					needBean.setHzms(rs.getString( "hzms"));
					needBean.setZtz(rs.getString( "ztz"));
					needBean.setQyzc(rs.getString( "qyzc"));
					needBean.setYhdk(rs.getString( "yhdk"));
					needBean.setQtrz(rs.getString( "qtrz"));
					needBean.setNd_state(rs.getInt("nd_state"));
					needBeans.add(needBean);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				DBUtil.close(rs, state, conn);
			}
			return needBeans;
		}
}
