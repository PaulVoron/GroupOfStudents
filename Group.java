package com.gmail.voron.paul;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Group implements CallOfDuty {

	private Student[] group;

	public Group(Student[] group) {
		super();
		this.group = new Student[10];
	}

	public Group(int maxStudents) {
		super();
		this.group = new Student[maxStudents];
	}

	public Group() {
		super();
		this.group = new Student[10];
	}

	public Student[] getGroup() {
		return group;
	}

	public void setGroup(Student[] group) {
		this.group = group;
	}

	public void createStudent() {
		if (checkFreePlace() == true) {
			String surname = inputText("Введите фамилию студента");
			if (surname == null) {
				surname = "noname";
			}
			String name = inputText("Введите имя студента");
			if (name == null) {
				name = "noname";
			}
			int sexInt = inputInt("Введите пол студента." + "\n" + "0 - жен." + "\n" + "1 - муж.");
			boolean sex;
			if (sexInt < 1) {
				sex = false;
			} else {
				sex = true;
			}
			int age = inputInt("Введите возраст студента");
			if (age < 6) {
				age = 6;
			} else if (age > 100) {
				age = 100;
			}
			int progress = inputInt("Введите средний балл студента" + "\n" + "(0-100)");
			if (progress < 0) {
				progress = 0;
			} else if (progress > 100) {
				progress = 100;
			}
			Student student = new Student(surname, name, sex, age, progress);
			addStudent(student);
		}
	}

	public boolean checkFreePlace() {
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				return true;
			}
		}
		try {
			throw new OverflowGroupException();
		} catch (OverflowGroupException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void addStudent(Student student) {
		if (student == null) {
			System.out.println("Нет данных для внесения.");
			return;
		}
		if (student.getSurname() == null) {
			System.out.println("Нет данных для внесения.");
			return;
		}
		for (int i = 0; i < group.length; i++) {
			if (group[i] == student) {
				System.out.println("Студент " + student.getSurname() + " уже есть в группе.");
				return;
			}
		}
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				group[i] = student;
				System.out.println("Студент " + student.getSurname() + " зачислен в группу");
				return;
			}
		}
		try {
			throw new OverflowGroupException();
		} catch (OverflowGroupException e) {
			System.out.println(e.getMessage());
		}
	}


	public void delStudent(String surname) {
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null && group[i].getSurname().equals(surname)) {
				group[i] = null;
				System.out.println("-------------------");
				System.out.println("Cтудент " + surname + " исключен из группы.");
				return;
			}
		}
		System.out.println("-------------------");
		System.out.println("Cтудент по фамилии " + surname + " не найден.");
	}

	public void sortGroup(int parametr) {
		if (parametr == 0) { // сортировка по успеваемости
			Arrays.sort(group, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
					: -1 * (a.getProgress() - b.getProgress()));
		}
		if (parametr == 1) { // сортировка по возрасту
			Arrays.sort(group, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
					: a.getAge() - b.getAge());
		}
		if (parametr == 2) { // сортировка по фамилии
			Arrays.sort(group, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
					: a.getSurname().compareTo(b.getSurname()));
		}
	}

	public Student searchStudent(String surname) {
		System.out.println("-------------------");
		System.out.println("Ищем студента... " + surname);
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				continue;
			}
			if (group[i].getSurname().equals(surname)) {
				return group[i];
			}
		}
		return new Student();
	}

	@Override
	public Student[] callOfDuty() {
		sortGroup(2);
		int k = group.length;
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				k = i;
				break;
			}
		}
		Student[] recruits = new Student[k];
		int j = 0;
		for (int i = 0; i < k; i++) {
			if (group[i].isSex() == true && group[i].getAge() > 17) {
				recruits[j++] = group[i];
			}
		}
		return recruits;
	}

	public String inputText(String question) {
		for (;;) {
			try {
				String requestText = String.valueOf(JOptionPane.showInputDialog(question));
				return requestText;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Неверный формат");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Cancel");
				return "Cancel";
			}
		}
	}

	public int inputInt(String question) {
		for (;;) {
			try {
				int requestText = Integer.valueOf(JOptionPane.showInputDialog(question));
				return requestText;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Неверный формат");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Cancel");
				return 0;
			}
		}
	}

	public void printGroup() {
		for (Student student : group) {
			System.out.println(student);
		}
	}

	@Override
	public String toString() {
		sortGroup(2);
		return "Group [group=" + Arrays.toString(group) + "]";
	}

}
