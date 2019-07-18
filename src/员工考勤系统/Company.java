package Ա������ϵͳ;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Company {

	//��������������������Ϣ��ʾ
	public static void main(String[] args) {
	}
	//Map�е�KEYΪǩ��������
	private Map<String,List<DaKaXinXi>> map = new HashMap<>();
	//������Ա����
	private Map<Integer,Employee> mapEmp = new HashMap<>();
	public Map<Integer,Employee> xinzeng(int ID,String name,int age,char sex){
        mapEmp.put(ID,new Employee(ID,name,age,sex));
        return mapEmp;
    }
	//���塰���Ա�����������͡���ſ������ڼ�����Ϣ��������2������(��ʹ�÷���)
	//ɾ����Ա����
	void shanchu(int ID){
		mapEmp.remove(ID);
	}
	//������Ա����
	public void chazhao(int ID) {
		System.out.println("ID:"+mapEmp.get(ID).getID()+" ����:"+mapEmp.get(ID).getName()+" ����"+mapEmp.get(ID).getAge()+" �Ա�"+mapEmp.get(ID).getSex());
	}
	//��ʾԱ����Ϣ����
	public void xianshi() {
		for(Map.Entry<Integer,Employee> m :mapEmp.entrySet()){
            System.out.println("ID:"+m.getValue().getID()+" ����:"+m.getValue().getName()+" ����"+m.getValue().getAge()+" �Ա�"+m.getValue().getSex());
        }
	}
	//ǩ������
	private Scanner sc2;
	public void qiandao(){
        Date date = new Date();
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        String qiandaoDate = sdfDate.format(date);
        String kaoqinTime = sdfTime.format(date);
        System.out.println("������ǩ��Ա��ID");
        sc2 = new Scanner(System.in);
        int inputID = sc2.nextInt();
        if(!mapEmp.containsKey(inputID)){
            System.out.println("�޴�IDԱ��");
            return;
        }
        List<DaKaXinXi> listKaoQin = null;
        if(!map.containsKey(qiandaoDate)){
            //��һ��ǩ����Ա��
            listKaoQin = new ArrayList<>();
            DaKaXinXi kq = new DaKaXinXi();
            kq.setID(mapEmp.get(inputID).getID());
            kq.setQiandao(kaoqinTime);
            kq.setQiantui("");
            listKaoQin.add(kq);
            map.put(qiandaoDate,listKaoQin);
            System.out.println("����"+inputID+"�򿨳ɹ�");
        }else {//˵��֮ǰ,�����Ѿ�����ǩ������
            listKaoQin = map.get(qiandaoDate);
            //�ж��Ƿ��Ѿ�ǩ����
            boolean bIsFind = false;
            for (DaKaXinXi kr : listKaoQin) {
                if (kr.getID() == mapEmp.get(inputID).getID()) {
                    System.out.println("����"+inputID+"�����Ѿ��������");
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
                System.out.println("����"+inputID+"�򿨳ɹ�");
            }
        }
    }
	//ǩ�˷���
	private Scanner sc3;
	public void qiantui(){
        System.out.println("������ǩ��Ա��ID");
        sc3 = new Scanner(System.in);
        int inputID = sc3.nextInt();
        if(!mapEmp.containsKey(inputID)){
            System.out.println("�޴�IDԱ��");
            return;
        }
        Date date = new Date();
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        String qiandaoDate = sdfDate.format(date);
        String kaoqinTime = sdfTime.format(date);
        if(!map.containsKey(qiandaoDate)){
            System.out.println("����"+inputID+"���컹û��ǩ��,�޷�ǩ��");
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
                System.out.println("����"+inputID+"���컹û��ǩ��,�޷�ǩ��");
            }else{
                System.out.println("����"+inputID+"ǩ�˳ɹ�");
            }
        }
    }
	//�鿴����
	private Scanner sc;
	public void chakan(){
        System.out.println("������Ҫ��ѯ�����ڣ�yyyy-MM-dd��");
        sc = new Scanner(System.in);
        String qiandaoDate = sc.nextLine();
        List<DaKaXinXi> listKaoQin = map.get(qiandaoDate);
        for(DaKaXinXi kr : listKaoQin){
            System.out.println(kr.getID()+" ǩ��ʱ��Ϊ:"+kr.getQiandao()+" ǩ��ʱ��Ϊ:"+kr.getQiantui());
        }
    }
}
