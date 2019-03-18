package com.stuman;

import java.util.regex.Pattern;

/*
 * 1.学生该有的属性：
 * ID必须前三位字母后三位数字，且不能重复
 * 字符串类型的姓名、ID、住址
 * 整形地年龄
 * 2.都设为私有，需要setter和getter
 * 3.重载构造函数
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

	public boolean setId(String id) {            //只执行单次判断是否可以设置id
		if(isMatch(id))
		{
			this.id = id;
			return true;
			
		}
		else {
			System.out.println("你输入的id号不符合规范,请重新输入：");
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
