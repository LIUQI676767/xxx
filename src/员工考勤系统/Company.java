package 员工考勤系统;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Company {

	//操作方法，操作后有信息提示
	public static void main(String[] args) {
	}
	//Map中的KEY为签到的日期
	private Map<String,List<DaKaXinXi>> map = new HashMap<>();
	//新增人员方法
	private Map<Integer,Employee> mapEmp = new HashMap<>();
	public Map<Integer,Employee> xinzeng(int ID,String name,int age,char sex){
        mapEmp.put(ID,new Employee(ID,name,age,sex));
        return mapEmp;
    }
	//定义“存放员工的容器”和“存放考勤日期及打卡信息的容器”2个容器(需使用泛型)
	//删除人员方法
	void shanchu(int ID){
		mapEmp.remove(ID);
	}
	//查找人员方法
	public void chazhao(int ID) {
		System.out.println("ID:"+mapEmp.get(ID).getID()+" 姓名:"+mapEmp.get(ID).getName()+" 年龄"+mapEmp.get(ID).getAge()+" 性别"+mapEmp.get(ID).getSex());
	}
	//显示员工信息方法
	public void xianshi() {
		for(Map.Entry<Integer,Employee> m :mapEmp.entrySet()){
            System.out.println("ID:"+m.getValue().getID()+" 姓名:"+m.getValue().getName()+" 年龄"+m.getValue().getAge()+" 性别"+m.getValue().getSex());
        }
	}
	//签到方法
	private Scanner sc2;
	public void qiandao(){
        Date date = new Date();
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        String qiandaoDate = sdfDate.format(date);
        String kaoqinTime = sdfTime.format(date);
        System.out.println("请输入签到员工ID");
        sc2 = new Scanner(System.in);
        int inputID = sc2.nextInt();
        if(!mapEmp.containsKey(inputID)){
            System.out.println("无此ID员工");
            return;
        }
        List<DaKaXinXi> listKaoQin = null;
        if(!map.containsKey(qiandaoDate)){
            //第一个签到的员工
            listKaoQin = new ArrayList<>();
            DaKaXinXi kq = new DaKaXinXi();
            kq.setID(mapEmp.get(inputID).getID());
            kq.setQiandao(kaoqinTime);
            kq.setQiantui("");
            listKaoQin.add(kq);
            map.put(qiandaoDate,listKaoQin);
            System.out.println("卡号"+inputID+"打卡成功");
        }else {//说明之前,今天已经有人签到过了
            listKaoQin = map.get(qiandaoDate);
            //判断是否已经签到过
            boolean bIsFind = false;
            for (DaKaXinXi kr : listKaoQin) {
                if (kr.getID() == mapEmp.get(inputID).getID()) {
                    System.out.println("卡号"+inputID+"今天已经打过卡了");
                    bIsFind = true;
                    break;
                }
            }
            if (!bIsFind) {
            	DaKaXinXi kr = new DaKaXinXi();
                kr.setID(mapEmp.get(inputID).getID());
                kr.setQiandao(kaoqinTime);
                kr.setQiantui("");
                listKaoQin.add(kr);
                System.out.println("卡号"+inputID+"打卡成功");
            }
        }
    }
	//签退方法
	private Scanner sc3;
	public void qiantui(){
        System.out.println("请输入签退员工ID");
        sc3 = new Scanner(System.in);
        int inputID = sc3.nextInt();
        if(!mapEmp.containsKey(inputID)){
            System.out.println("无此ID员工");
            return;
        }
        Date date = new Date();
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        String qiandaoDate = sdfDate.format(date);
        String kaoqinTime = sdfTime.format(date);
        if(!map.containsKey(qiandaoDate)){
            System.out.println("卡号"+inputID+"今天还没有签到,无法签退");
        }else{
            List<DaKaXinXi> listKaoQin = map.get(qiandaoDate);
            boolean bIsFind = false;
            for(DaKaXinXi kr : listKaoQin){
                if(kr.getID() == mapEmp.get(inputID).getID()){
                    kr.setQiandao(kaoqinTime);
                    bIsFind = true;
                    break;
                }
            }
            if(!bIsFind){
                System.out.println("卡号"+inputID+"今天还没有签到,无法签退");
            }else{
                System.out.println("卡号"+inputID+"签退成功");
            }
        }
    }
	//查看方法
	private Scanner sc;
	public void chakan(){
        System.out.println("请输入要查询的日期（yyyy-MM-dd）");
        sc = new Scanner(System.in);
        String qiandaoDate = sc.nextLine();
        List<DaKaXinXi> listKaoQin = map.get(qiandaoDate);
        for(DaKaXinXi kr : listKaoQin){
            System.out.println(kr.getID()+" 签到时间为:"+kr.getQiandao()+" 签退时间为:"+kr.getQiantui());
        }
    }
}
