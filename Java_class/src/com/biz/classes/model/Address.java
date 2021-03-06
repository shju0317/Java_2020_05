package com.biz.classes.model;

public class Address {
	
	// 멤버변수(필드)가 private이기 때문에
	// 인스턴스를 통해서 직접접근이 불가능하다.
	private String city;
	private String gu;
	private String dong;
	private String addr;
	
	private int age;
	
	// age 변수에 값을 저장하기 위한 method
	public void setAge(int age) {
		this.age = age;
	}
	
	// age 변수에서 값을 읽기 위한 method
	public int getAge() {
		return age;
	}
	
	// 인스턴스를 통해서 필드변수에 값을 저장하기 위한 'setter method()'
	// (String city) : 매개변수, 파라미터, argument
	// 					인스턴스를 통해서 setCity메서드에게 어떤 값을 전달하는 용도
	public void setCity(String city) {
		this.city = city;
	}
	
	// 인스턴스를 통해서 필드변수에 저장된 값을 읽기 위한 'getter method()'
	public String getCity() {
		// return키워드가 있는 method는 return하고자 하는 값의 type을 
		// method 이름 앞에 붙여주어야 한다.
		return city;
	}
}
