package 员工考勤系统;

public class Employee {
	//员工ID
	private int ID;
	//员工姓名
	private String name;
	//员工年龄
	private int age;
	//员工性别
	private char sex;
	public Employee(int ID,String name,int age,char sex) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	//定义一个ToString方法返回元素的信息
	public void ToString() {
		getID();
		getName();
		getAge();
		getSex();
	}
	//支持get、set方法
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
}
