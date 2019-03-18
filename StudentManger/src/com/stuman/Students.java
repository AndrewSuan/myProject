package com.stuman;

import java.util.regex.Pattern;

/*
 * 1.ѧ�����е����ԣ�
 * ID����ǰ��λ��ĸ����λ���֣��Ҳ����ظ�
 * �ַ������͵�������ID��סַ
 * ���ε�����
 * 2.����Ϊ˽�У���Ҫsetter��getter
 * 3.���ع��캯��
 * */
public class Students {
	private String id;
	private int age;
	private String name;
	private String address;
	
	public Students() {

	}

	public Students(String id, int age, String name, String address) {
		setId(id);
		this.age = age;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public boolean setId(String id) {            //ִֻ�е����ж��Ƿ��������id
		if(isMatch(id))
		{
			this.id = id;
			return true;
			
		}
		else {
			System.out.println("�������id�Ų����Ϲ淶,���������룺");
			return false;
		}
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public static boolean isMatch(String id) {
		String regex = "^[a-zA-Z]{3}[0-9]{4}$";
		boolean flag = Pattern.matches(regex, id);
		return flag;
	}
	
	
	
}
