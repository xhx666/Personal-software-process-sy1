package bean;

public class UserBean {
	private String userid;//���֤��
	private String username;//�˻���
	private String password;//����
	private String phone;//�绰
	private String workplace;//��λ����
	private String institution;//��֯����
	private String truename;//��ʵ����
	
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public UserBean(String username, String password, String phone,
			String workplace,String institution,String truename,String userid) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.workplace = workplace;
		this.institution=institution;
		this.truename=truename;
		this.userid=userid;
	}
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}
}
