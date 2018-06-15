package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NeedDao;

import bean.NeedBean;

/**
 * Servlet implementation class NeedServlet
 */
@WebServlet("/servlet/needServlet")
public class NeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding( "utf-8");
		String method=req.getParameter( "method");
		if(method.equals( "addNeed"))
			addNeed(req,resp);
		else if(method.equals("findYsh"))
			findYsh(req,resp);
		else if(method.equals("findWsh"))
			findWsh(req,resp);
		else if(method.equals("findBth"))
			findBth(req,resp);
		else if(method.equals( "listNeed"))
			listNeed(req,resp);
		else if(method.equals( "listDetail"))
			listNeed(req,resp);
		else if(method.equals("findZH"))
			findZH(req,resp);
		else if(method.equals( "find"))
			findNeed(req,resp);
		else if(method.equals( "lookNeed"))
			lookNeed(req,resp);
		else if(method.equals( "isPass"))
			isPass(req,resp);
		else if(method.equals("BlistNeed"))
			BlistNeed(req,resp);
	}
	
	//添加审核意见修改审核状态״̬
	private void isPass(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		req.setCharacterEncoding( "utf-8");
		int nd_id=Integer.parseInt(req.getParameter( "nd_id"));
		int nd_state =Integer.parseInt(req.getParameter( "nd_state")) ;
		String nd_advice = req.getParameter( "nd_advice");
		
		NeedDao needDao = new NeedDao();
		boolean f = needDao.isPass(nd_id, nd_state, nd_advice);
		
		if(f==true)
			resp.sendRedirect( req.getContextPath()+"/servlet/needServlet?method=lookNeed&status=3");
		else
			resp.sendRedirect( req.getContextPath()+"/servlet/needServlet?method=lookNeed&status=4");
	}
	
	//审核信息
	private void lookNeed(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		req.setCharacterEncoding( "utf-8");
		String nd_id=req.getParameter( "nd_id");
		if (nd_id == null) {
			List<NeedBean> needBeans = new ArrayList<NeedBean>();
			NeedDao needDao = new NeedDao();

			needBeans = needDao.findNeedByState(1);
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/look/look.jsp?status=1").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/look/look.jsp?status=2").forward(
						req, resp);
		}
		else{
			NeedBean needBean = new NeedBean();
			NeedDao needDao = new NeedDao();
			int nd_id1=Integer.parseInt(nd_id);
			needBean = needDao.singleNeed(nd_id1);
			req.setAttribute("needBean", needBean);
			if (needBean != null) {
				req.getRequestDispatcher("/look/lookDetail.jsp").forward(
						req, resp);
			} 
		}
	}
	
	//��ѯ������Ϣ
	private void findNeed(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		String nd_name = req.getParameter("nd_name");
		int nd_state = Integer.parseInt(req.getParameter("nd_state"));
		List<NeedBean> needBeans = null;
		NeedDao needDao = new NeedDao();
		if (nd_name != ""&&nd_state == 0){
			needBeans = needDao.findNeedByName(nd_name);
		}
		if (nd_state != 0&&nd_name =="")
			needBeans = needDao.findNeedByState(nd_state);
		if (nd_state == 0&&nd_name == "")
			needBeans = needDao.listNeed();
		if (nd_state != 0 && nd_name != "")
			needBeans = needDao.findNeedByNS(nd_name, nd_state);
		req.setAttribute("needBeans", needBeans);

		if (needBeans != null) {
			req.getRequestDispatcher("/need/list.jsp?status=1").forward(req,
					resp);
		} else
			req.getRequestDispatcher("/need/list.jsp?status=2").forward(req,
					resp);
	}
	
	//�ֱ��ѯ����ˡ�δ��ˡ����˻ص�����
	private void findYsh(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		List<NeedBean> needBeans = null;
		NeedDao needDao = new NeedDao();
		needBeans = needDao.findNeedByState(2);
		req.setAttribute("needBeans", needBeans);
		req.getRequestDispatcher("/need/listYsh.jsp").forward(req,
				resp);
	}
	
	private void findWsh(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		List<NeedBean> needBeans = null;
		NeedDao needDao = new NeedDao();
		needBeans = needDao.findNeedByState(1);
		req.setAttribute("needBeans", needBeans);
		req.getRequestDispatcher("/need/listWsh.jsp").forward(req,
				resp);
	}
	
	private void findBth(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		List<NeedBean> needBeans = null;
		NeedDao needDao = new NeedDao();
		needBeans = needDao.findNeedByState(3);
		req.setAttribute("needBeans", needBeans);
		req.getRequestDispatcher("/need/listBth.jsp").forward(req,
				resp);
	}
	//浏览需求信息
	private void listNeed(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		req.setCharacterEncoding( "utf-8");
		String nd_id=req.getParameter( "nd_id");
		if (nd_id == null) {
			List<NeedBean> needBeans = new ArrayList<NeedBean>();
			NeedDao needDao = new NeedDao();
			needBeans = needDao.listNeed();
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/need/list.jsp?status=1").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/need/list.jsp?status=2").forward(
						req, resp);
		}
		else{
			NeedBean needBean = new NeedBean();
			NeedDao needDao = new NeedDao();
			int nd_id1=Integer.parseInt(nd_id);
			needBean = needDao.singleNeed(nd_id1);
			req.setAttribute("needBean", needBean);
			if (needBean != null) {
				req.getRequestDispatcher("/need/listDetail.jsp").forward(
						req, resp);
			} 
		}
	}
	
	private void BlistNeed(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		req.setCharacterEncoding( "utf-8");
		//收到用于标记查询条件的数字
		int n = Integer.parseInt(req.getParameter("n"));
		if(n==1){
			//查看全部
			List<NeedBean> needBeans = new ArrayList<NeedBean>();
			NeedDao needDao = new NeedDao();
			needBeans = needDao.listNeed();
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/need/BlistDetail.jsp?status=1&n=0").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/need/BlistDetail.jsp?status=2&n=0").forward(
						req, resp);
		}else if(n==2||n==4||n==5||n==6){
			//基础研究
			List<NeedBean> needBeans = new ArrayList<NeedBean>();
			NeedDao needDao = new NeedDao();
			needBeans = needDao.findNeedJC(n);
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/need/BlistDetail.jsp?status=1&n=1").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/need/BlistDetail.jsp?status=2&n=0").forward(
						req, resp);
		}else{
			//其他类型
			List<NeedBean> needBeans = new ArrayList<NeedBean>();
			NeedDao needDao = new NeedDao();
			needBeans = needDao.findNeedJC(n);
			req.setAttribute("needBeans", needBeans);
			if (needBeans != null) {
				req.getRequestDispatcher("/need/BlistDetail.jsp?status=1&n=0").forward(
						req, resp);
			} else
				req.getRequestDispatcher("/need/BlistDetail.jsp?status=2&n=0").forward(
						req, resp);
		}
	}
	
	//获取需求信息添加到数据库
		private void addNeed(HttpServletRequest req,HttpServletResponse resp) throws IOException{
			req.setCharacterEncoding( "utf-8");
			//jgmc txdz	dwwz email lxr phone cz jgsx jgjj nd_name nd_gs
			//key yjlx xkfl ssly yyhy hzms ztz qyzc yhdk qtrz
			String jgmc = req.getParameter( "jgmc");
			String txdz = req.getParameter( "txdz");
			String dwwz = req.getParameter( "dwwz");
			String email = req.getParameter( "email");
			String lxr = req.getParameter( "lxr");
			String phone = req.getParameter( "phone");
			String cz = req.getParameter( "cz");
			String[] jgsxs1 = req.getParameterValues( "jgsx");
			String jgsx="";
			if(jgsxs1!=null){
			for(String jgsx1:jgsxs1){
				if(jgsx1!=null&&!jgsx1.equals(jgsxs1[0]))
					jgsx+=",";
				if(jgsx1.equals("1"))
					jgsx+="企业";
				else if(jgsx1.equals("2"))
					jgsx+="高等院校";
				else if(jgsx1.equals("3"))
					jgsx+="研究机构";
				else if(jgsx1.equals("4"))
					jgsx+="其他";
			}}
			String jgjj = req.getParameter( "jgjj");
			String nd_name = req.getParameter( "nd_name");
			String nd_gs = req.getParameter( "nd_gs");
			String key = req.getParameter( "key");
			String xkfl = req.getParameter( "xkfl");
			String[] sslys1 = req.getParameterValues( "ssly");
			String ssly="";
			if(sslys1!=null){
			for(String ssly1:sslys1){
				if(ssly1!=null&&!ssly1.equals(jgsxs1[0]))
					ssly+=",";
				if(ssly1.equals("1"))
					ssly+="电子信息技术";
				else if(ssly1.equals("2"))
					ssly+="光机电一体化";
				else if(ssly1.equals("3"))
					ssly+="软件";
				else if(ssly1.equals("4"))
					ssly+="生物制药技术";
				else if(ssly1.equals("5"))
					ssly+="新材料及应用技术";
				else if(ssly1.equals("6"))
					ssly+="先进制造技术";
				else if(ssly1.equals("7"))
					ssly+="现代农业技术";
				else if(ssly1.equals("8"))
					ssly+="新能源与高校节能技术";
				else if(ssly1.equals("9"))
					ssly+="资源与环境保护新技术";
				else if(ssly1.equals("10"))
					ssly+="其他技术（注明）";
			}}
			String yyhy = req.getParameter( "yyhy");
			String[] hzmss1 = req.getParameterValues( "hzms");
			String hzms="";
			if(hzmss1!=null){
			for(String hzms1:hzmss1){
				if(hzms1!=null&&!hzms1.equals(hzmss1[0]))
					hzms+=",";
				if(hzms1.equals("1"))
					hzms+="独立开发";
				else if(hzms1.equals("2"))
					hzms+="技术转让";
				else if(hzms1.equals("3"))
					hzms+="技术入股";
				else if(hzms1.equals("4"))
					hzms+="合作开发";
				else if(hzms1.equals("5"))
					hzms+="其他";
			}}
			String ztz = req.getParameter( "ztz");
			String qyzc = req.getParameter( "qyzc");
			String yhdk = req.getParameter( "yhdk");
			String qtrz = req.getParameter( "qtrz");
			String[] yjlxs1=req.getParameterValues("yjlx");
			String yjlx="";
			if(yjlxs1!=null){
			for(String yjlx1:yjlxs1){
				if(yjlx1!=null&&!yjlx1.equals(yjlxs1[0]))
					yjlx+=",";
				if(yjlx1.equals("1"))
					yjlx+="基础研究";
				else if(yjlx1.equals("2"))
					yjlx+="应用研究";
				else if(yjlx1.equals("3"))
					yjlx+="实验发展";
				else if(yjlx1.equals("4"))
					yjlx+="研究发展与成果应用";
				else if(yjlx1.equals("5"))
					yjlx+="技术推广与科技服务";
				
			}}
			
			NeedBean needBean = new NeedBean(jgmc,txdz,dwwz,email,lxr,phone,cz,jgsx,jgjj,nd_name,nd_gs,key,yjlx,xkfl,ssly,yyhy,hzms,ztz,qyzc,yhdk,qtrz);
			NeedDao needDao= new NeedDao();
			boolean f = needDao.addNeed(needBean);
			if(f==true){
				resp.sendRedirect( req.getContextPath()+"/need/add.jsp?status=1");
			}
			else
				resp.sendRedirect( req.getContextPath()+"/need/add.jsp?status=2");
		}

		//综合查询
		private void findZH(HttpServletRequest req, HttpServletResponse resp)
				throws IOException, ServletException{
			req.setCharacterEncoding("utf-8");
			int num = Integer.parseInt(req.getParameter("num"));
			List<NeedBean> needBeans = null;
			NeedDao needDao = new NeedDao();
			
			if(num == 1){
				String sType0 = req.getParameter("sType0");
				String q0 = req.getParameter("q0");
				needBeans = needDao.findZH(sType0, q0, "", "", "", "", "", "");
			}else if(num == 2){
				String sType0 = req.getParameter("sType0");
				String q0 = req.getParameter("q0");
				String logic1 = req.getParameter("logic1");
				String sType1 = req.getParameter("sType1");
				String q1 = req.getParameter("q1");
				needBeans = needDao.findZH(sType0, q0, logic1, sType1, q1, "", "", "");
			}else{
				String sType0 = req.getParameter("sType0");
				String q0 = req.getParameter("q0");
				String logic1 = req.getParameter("logic1");
				String sType1 = req.getParameter("sType1");
				String q1 = req.getParameter("q1");
				String logic2 = req.getParameter("logic2");
				String sType2 = req.getParameter("sType2");
				String q2 = req.getParameter("q2");
				needBeans = needDao.findZH(sType0, q0, logic1, sType1, q1, logic2, sType2, q2);
			}
			
			req.setAttribute("needBeans", needBeans);

			if (needBeans != null) {
				req.getRequestDispatcher("/need/listZH.jsp?status=1").forward(req,
						resp);
			} else
				req.getRequestDispatcher("/need/listZH.jsp?status=2").forward(req,
						resp);
		}
}
