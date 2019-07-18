package 员工考勤系统;

public class DaKaXinXi {
	//建立员工ID（int），签到时间(date)、签退时间(date) 3个对象
	private int ID;
	private String qiandao;
	private String qiantui;
	//支持get、set方法
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getQiandao() {
		return qiandao;
	}

	public void setQiandao(String qiandao) {
		this.qiandao = qiandao;
	}

	public String getQiantui() {
		return qiantui;
	}

	public void setQiantui(String qiantui) {
		this.qiantui = qiantui;
	}	
	DaKaXinXi(){	
	}
}
