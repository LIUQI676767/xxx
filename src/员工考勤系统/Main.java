package Ա������ϵͳ;

import java.util.Scanner;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) {
		Company company = new Company();
        //���Ա��
        company.xinzeng(001,"mike",20,'��');
        company.xinzeng(002,"lucy",22,'Ů');
        company.xinzeng(003,"annie",24,'Ů');
        company.xinzeng(004,"cindy",28,'Ů');
        //��ʾԱ����Ϣ
        company.xianshi();
        //ɾ��Ա���ķ���
        sc = new Scanner(System.in);
        System.out.println("������ɾ��Ա��ID");
        int empNum = sc.nextInt();
        company.shanchu(empNum);
        //��ʾɾ�����Ա����Ϣ
        company.xianshi();
        System.out.println("�������ѯԱ��ID");
        int ID = sc.nextInt();
        company.chazhao(ID);
        //������
        int input = 0;
        do{
        	System.out.println("----Ա����ϵͳ- - - -");
            System.out.println("����0--------�˳�");
            System.out.println("����1--------ǩ��");
            System.out.println("����2--------ǩ��");
            System.out.println("����3--------�鿴ǩ��ǩ����Ϣ");
            input = sc.nextInt();
            switch (input){
            //ǩ��
            case 1:
                company.qiandao();
                break;
            //ǩ��
            case 2:
                company.qiantui();
                break;
            //�鿴
            case 3:
                company.chakan();
                break;
            default:
                break;
            }
        }while(input!=0);
        System.out.println("�˳�");
    }
}

