package Ա������ϵͳ;

public class Employee {
	//Ա��ID
	private int ID;
	//Ա������
	private String name;
	//Ա������
	private int age;
	//Ա���Ա�
	private char sex;
	public Employee(int ID,String name,int age,char sex) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	//����һ��ToString��������Ԫ�ص���Ϣ
	public void ToString() {
		getID();
		getName();
		getAge();
		getSex();
	}
	//֧��get��set����
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
