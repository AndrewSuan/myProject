package com.stuman;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1.欢迎界面
 * 2.查看所有学生
 * 3.添加学生
 * 4.删除学生
 * 5.修改学生
 * 6.退出
 * 
 * 
 * */
public class StudentManage {
	public static void main(String[] args) {
	
		
		ArrayList<Students> stus = new ArrayList<Students>();
		
		while(true) {
				HelloW();
				Scanner sc =new Scanner(System.in);
				int choice = sc.nextInt();
				sc.nextLine();//需要消除回车么？
				switch(choice) {
				case 1:
					findAllStudents(stus);
					break;
				case 2:
					addStudent(stus);
					break;
				case 3:
					delete(stus);
					break;
				case 4:
					changeStu(stus);
					break;
				case 5:
				default:
					System.exit(0);
				
				}
		}
		
	}
	
	//主界面
	public static void HelloW() {	
		System.out.println("-------------欢迎使用学生管理系统-------------");
		System.out.println("1.查看所有学生");
		System.out.println("2.添加学生");
		System.out.println("3.删除学生");
		System.out.println("4.修改学生");
		System.out.println("5.退出");
		System.out.println("请输入你的选择：");
	}
	public static void findAllStudents(ArrayList<Students> stus){
		if(stus.size()==0) {
			System.out.println("没有学生可供查询。");
			return;
		}
		for(int i =0;i<stus.size();i++) {
			Students stu = stus.get(i);
			System.out.println("ID:"+stu.getId()+"\t姓名:"+stu.getName()+"\t年龄:"+stu.getAge()+"\t住址:"+stu.getAddress());
		}
	}
	public static void addStudent(ArrayList<Students> stus) {
		Students stu =new Students();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生ID：");
		while(true) {
			String sid = sc.nextLine();
			if(stu.setId(sid))	{	
				if(matchId(sid,stus))
				break;
				else
				System.out.println("你输入的id号已经被使用,请重新输入新的id号:");
			}
			else ;
		}

		System.out.println("请输入学生姓名：");
		String sname = sc.nextLine();
		System.out.println("请输入学生年龄：");
		int sage = sc.nextInt();
		sc.nextLine();
		
		System.out.println("请输入学生住址：");
		String saddress = sc.nextLine();
	
		
		
		stu.setName(sname);
		stu.setAge(sage);
		stu.setAddress(saddress);
		stus.add(stu);

	}
	public static boolean matchId(String sid ,ArrayList<Students> stus) {
		boolean flag = true;
		for(int i =0 ; i < stus.size();i++) {
		if(sid.equals(stus.get(i).getId())) {
			return false;
		}
		else ;
	}
		return flag;
	}
	public static void delete(ArrayList<Students> stus) {
		System.out.println("请输入学生id");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		int flag =1;
		for(int i=0;i<stus.size();i++) {
			if(id.equals(stus.get(i).getId())) {
				stus.remove(i);
				System.out.println("删除学生成功");
				flag=0;
			}
		}
		if(flag==1) {
			System.out.println("没有找到要删除的学生");
		}
	}
	public static void changeStu(ArrayList<Students> stus) {
		int flag = 1;
		System.out.println("请输入要修改学生的id");
		Scanner sc =new Scanner(System.in);
		String id = sc.nextLine();
		Students stu =new Students();
		for(int i =0;i<stus.size();i++) {
			if(id.equals(stus.get(i).getId())) {
				System.out.println("请输入学生姓名：");
				String sname = sc.nextLine();
				System.out.println("请输入学生年龄：");
				int sage = sc.nextInt();
				sc.nextLine();
				
				System.out.println("请输入学生住址：");
				String saddress = sc.nextLine();
				
				
				stus.get(i).setName(sname);
				stus.get(i).setAge(sage);
				stus.get(i).setAddress(saddress);
				System.out.println("修改学生成功");
				flag=0;
			}

		}
		if(flag==1) {
			System.out.println("未找到id对应的学生");
		}
		
		
	}
}
