package bean;

import java.util.Date;
//机构名称、通讯地址、单位网址、电子邮箱、联系人、电话、传真、机构属性（分）、机构简介
//技术需求名称、重大需求概述、关键字、研究类型（分）、学科分类（分）、需求技术所属领域、需求技术应用行业
//技术需求合作模式（分）、计划总投资、企业自筹、银行贷款、其他融资
public class NeedBean {
	private int nd_id;
	private String jgmc;//机构名称
	private String txdz;//通讯地址
	private String dwwz;//单位网址
	private String email;//电子邮箱
	private String lxr;//联系人
	private String phone;//电话
	private String cz;//传真
	private String jgsx;//机构属性
	private String jgjj;//机构简介
	private String nd_name;//技术需求名称
	private String nd_gs;//重大需求概述
	private String key;//关键字
	private String yjlx;//研究类型
	private String xkfl;//学科分类
	private String ssly;//需求技术所属领域
	private String yyhy;//需求技术应用行业
	private String hzms;//合作模式（分）
	private String ztz;//计划总投资
	private String qyzc;//企业自筹
	private String yhdk;//银行贷款
	private String qtrz;//其他融资
	private int nd_state;//审核状态
	
	public NeedBean() {
		// TODO Auto-generated constructor stub
	}
	//jgmc txdz	dwwz email lxr phone cz jgsx jgjj nd_name nd_gs
	
	public int getNd_state(){
		return nd_state;
	}
	public void setNd_state(int nd_state){
		this.nd_state = nd_state;
	}
	
	public int getNd_id() {
		return nd_id;
	}
	public void setNd_id(int nd_id) {
		this.nd_id = nd_id;
	}
	public String getJgmc() {
		return jgmc;
	}
	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}
	public String getTxdz() {
		return txdz;
	}
	public void setTxdz(String txdz) {
		this.txdz = txdz;
	}
	public String getDwwz() {
		return dwwz;
	}
	public void setDwwz(String dwwz) {
		this.dwwz = dwwz;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String getJgsx() {
		return jgsx;
	}
	public void setJgsx(String jgsx) {
		this.jgsx = jgsx;
	}
	public String getJgjj() {
		return jgjj;
	}
	public void setJgjj(String jgjj) {
		this.jgjj = jgjj;
	}
	public String getNd_name() {
		return nd_name;
	}
	public void setNd_name(String nd_name) {
		this.nd_name = nd_name;
	}
	public String getNd_gs() {
		return nd_gs;
	}
	public void setNd_gs(String nd_gs) {
		this.nd_gs = nd_gs;
	}
	//key yjlx xkfl ssly yyhy hzms ztz qyzc yhdk qtrz
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getYjlx() {
		return yjlx;
	}
	public void setYjlx(String yjlx) {
		this.yjlx = yjlx;
	}
	public String getXkfl() {
		return xkfl;
	}
	public void setXkfl(String xkfl) {
		this.xkfl = xkfl;
	}
	public String getSsly() {
		return ssly;
	}
	public void setSsly(String ssly) {
		this.ssly = ssly;
	}
	public String getYyhy() {
		return yyhy;
	}
	public void setYyhy(String yyhy) {
		this.yyhy = yyhy;
	}
	public String getHzms() {
		return hzms;
	}
	public void setHzms(String hzms) {
		this.hzms = hzms;
	}
	public String getZtz() {
		return ztz;
	}
	public void setZtz(String ztz) {
		this.ztz = ztz;
	}
	public String getQyzc() {
		return qyzc;
	}
	public void setQyzc(String qyzc) {
		this.qyzc = qyzc;
	}
	public String getYhdk() {
		return yhdk;
	}
	public void setYhdk(String yhdk) {
		this.yhdk = yhdk;
	}
	public String getQtrz() {
		return qtrz;
	}
	public void setQtrz(String qtrz) {
		this.qtrz = qtrz;
	}
	public NeedBean(String jgmc,String txdz,String	dwwz,String email,String lxr,String phone 
			,String cz,String jgsx,String jgjj,String nd_name,String nd_gs,String key
			,String yjlx,String xkfl,String ssly,String yyhy,String hzms,String ztz 
			,String qyzc,String yhdk,String qtrz) {
		//jgmc txdz	dwwz email lxr phone cz jgsx jgjj nd_name nd_gs
		super();
		this.jgmc = jgmc;
		this.txdz = txdz;
		this.dwwz = dwwz;
		this.email = email;
		this.lxr = lxr;
		this.phone = phone;
		this.cz = cz;
		this.jgsx = jgsx;
		this.jgjj =jgjj;
		this.nd_name = nd_name;
		this.nd_gs = nd_gs;
		//key yjlx xkfl ssly yyhy hzms ztz qyzc yhdk qtrz
		this.key = key;
		this.yjlx = yjlx;
		this.xkfl = xkfl;
		this.ssly = ssly;
		this.yyhy = yyhy;
		this.hzms = hzms;
		this.ztz = ztz;
		this.qyzc = qyzc;
		this.yhdk = yhdk;
		this.qtrz = qtrz;
	}
	
	
}
