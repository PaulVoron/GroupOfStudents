package com.gmail.voron.paul;

public class Student extends Human {

	private int progress;

	public Student(String surname, String name, boolean sex, int age, int progress) {
		super(surname, name, sex, age);
		this.progress = progress;
	}

	public Student(String surname, String name, boolean sex, int age) {
		super(surname, name, sex, age);
	}
	
	

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return "Student [surname=" + this.getSurname() + ", name=" + this.getName() + ", sex=" + this.isSex() + ", age="
				+ this.getAge() + ", progress=" + progress + "]";
	}
 
}
