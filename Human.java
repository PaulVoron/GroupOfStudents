package com.gmail.voron.paul;

public class Human {

	private String surname;
	private String name;	
	private boolean sex;
	private int age;
	
	public Human(String surname, String name, boolean sex, int age) {
		super();
		this.surname = surname;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public Human() {
		super();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human [surname=" + surname + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
}
