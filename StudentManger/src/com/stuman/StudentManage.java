package com.stuman;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1.��ӭ����
 * 2.�鿴����ѧ��
 * 3.���ѧ��
 * 4.ɾ��ѧ��
 * 5.�޸�ѧ��
 * 6.�˳�
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
				sc.nextLine();//��Ҫ�����س�ô��
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
	
	//������
	public static void HelloW() {	
		System.out.println("-------------��ӭʹ��ѧ������ϵͳ-------------");
		System.out.println("1.�鿴����ѧ��");
		System.out.println("2.���ѧ��");
		System.out.println("3.ɾ��ѧ��");
		System.out.println("4.�޸�ѧ��");
		System.out.println("5.�˳�");
		System.out.println("���������ѡ��");
	}
	public static void findAllStudents(ArrayList<Students> stus){
		if(stus.size()==0) {
			System.out.println("û��ѧ���ɹ���ѯ��");
			return;
		}
		for(int i =0;i<stus.size();i++) {
			Students stu = stus.get(i);
			System.out.println("ID:"+stu.getId()+"\t����:"+stu.getName()+"\t����:"+stu.getAge()+"\tסַ:"+stu.getAddress());
		}
	}
	public static void addStudent(ArrayList<Students> stus) {
		Students stu =new Students();
		Scanner sc = new Scanner(System.in);
		System.out.println("������ѧ��ID��");
		while(true) {
			String sid = sc.nextLine();
			if(stu.setId(sid))	{	
				if(matchId(sid,stus))
				break;
				else
				System.out.println("�������id���Ѿ���ʹ��,�����������µ�id��:");
			}
			else ;
		}

		System.out.println("������ѧ��������");
		String sname = sc.nextLine();
		System.out.println("������ѧ�����䣺");
		int sage = sc.nextInt();
		sc.nextLine();
		
		System.out.println("������ѧ��סַ��");
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
		System.out.println("������ѧ��id");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		int flag =1;
		for(int i=0;i<stus.size();i++) {
			if(id.equals(stus.get(i).getId())) {
				stus.remove(i);
				System.out.println("ɾ��ѧ���ɹ�");
				flag=0;
			}
		}
		if(flag==1) {
			System.out.println("û���ҵ�Ҫɾ����ѧ��");
		}
	}
	public static void changeStu(ArrayList<Students> stus) {
		int flag = 1;
		System.out.println("������Ҫ�޸�ѧ����id");
		Scanner sc =new Scanner(System.in);
		String id = sc.nextLine();
		Students stu =new Students();
		for(int i =0;i<stus.size();i++) {
			if(id.equals(stus.get(i).getId())) {
				System.out.println("������ѧ��������");
				String sname = sc.nextLine();
				System.out.println("������ѧ�����䣺");
				int sage = sc.nextInt();
				sc.nextLine();
				
				System.out.println("������ѧ��סַ��");
				String saddress = sc.nextLine();
				
				
				stus.get(i).setName(sname);
				stus.get(i).setAge(sage);
				stus.get(i).setAddress(saddress);
				System.out.println("�޸�ѧ���ɹ�");
				flag=0;
			}

		}
		if(flag==1) {
			System.out.println("δ�ҵ�id��Ӧ��ѧ��");
		}
		
		
	}
}
