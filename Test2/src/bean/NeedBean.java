package bean;

import java.util.Date;
//�������ơ�ͨѶ��ַ����λ��ַ���������䡢��ϵ�ˡ��绰�����桢�������ԣ��֣����������
//�����������ơ��ش�����������ؼ��֡��о����ͣ��֣���ѧ�Ʒ��ࣨ�֣�����������������������Ӧ����ҵ
//�����������ģʽ���֣����ƻ���Ͷ�ʡ���ҵ�Գ���д����������
public class NeedBean {
	private int nd_id;
	private String jgmc;//��������
	private String txdz;//ͨѶ��ַ
	private String dwwz;//��λ��ַ
	private String email;//��������
	private String lxr;//��ϵ��
	private String phone;//�绰
	private String cz;//����
	private String jgsx;//��������
	private String jgjj;//�������
	private String nd_name;//������������
	private String nd_gs;//�ش��������
	private String key;//�ؼ���
	private String yjlx;//�о�����
	private String xkfl;//ѧ�Ʒ���
	private String ssly;//��������������
	private String yyhy;//������Ӧ����ҵ
	private String hzms;//����ģʽ���֣�
	private String ztz;//�ƻ���Ͷ��
	private String qyzc;//��ҵ�Գ�
	private String yhdk;//���д���
	private String qtrz;//��������
	private int nd_state;//���״̬
	
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
