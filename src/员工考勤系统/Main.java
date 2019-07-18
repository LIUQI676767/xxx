package 员工考勤系统;

import java.util.Scanner;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) {
		Company company = new Company();
        //添加员工
        company.xinzeng(001,"mike",20,'男');
        company.xinzeng(002,"lucy",22,'女');
        company.xinzeng(003,"annie",24,'女');
        company.xinzeng(004,"cindy",28,'女');
        //显示员工信息
        company.xianshi();
        //删除员工的方法
        sc = new Scanner(System.in);
        System.out.println("请输入删除员工ID");
        int empNum = sc.nextInt();
        company.shanchu(empNum);
        //显示删除后的员工信息
        company.xianshi();
        System.out.println("请输入查询员工ID");
        int ID = sc.nextInt();
        company.chazhao(ID);
        //主函数
        int input = 0;
        do{
        	System.out.println("----员工打卡系统- - - -");
            System.out.println("输入0--------退出");
            System.out.println("输入1--------签到");
            System.out.println("输入2--------签退");
            System.out.println("输入3--------查看签到签退信息");
            input = sc.nextInt();
            switch (input){
            //签到
            case 1:
                company.qiandao();
                break;
            //签退
            case 2:
                company.qiantui();
                break;
            //查看
            case 3:
                company.chakan();
                break;
            default:
                break;
            }
        }while(input!=0);
        System.out.println("退出");
    }
}

