package com.gmail.voron.paul;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		//simpleTesting();      // ������� ������� (������ 3)
		interactiveTesting();   // ������������� ������� (������ 4)
	}

	public static void interactiveTesting() {

		Group groupOne = createGroup();
		for (;;) {
			String surname;
			int command = mainMenu();
			if (command == 9) {
				System.out.println("-------------------");
				System.out.println("��������� ���������");
				break;
			}
			switch (command) {
			case 1:
				groupOne.createStudent();
				break;
			case 2:
				groupOne.delStudent(groupOne.inputText("���������� ��������. ������� �������"));
				break;
			case 3:
				surname = groupOne.inputText("����� ��������. ������� �������");
				Student student = groupOne.searchStudent(surname);
				if (student.getSurname() == null) {
					System.out.println("� ������ ��� ������ ��������.");
				} else {
					System.out.println("������� " + surname + " ������:");
					System.out.println(student.toString());
				}
				break;
			case 4:
				groupOne.sortGroup(2);
				break;
			case 5:
				groupOne.sortGroup(0);
				break;
			case 6:
				groupOne.sortGroup(1);
				break;
			case 7:
				System.out.println("-------------------");
				groupOne.printGroup();
				break;
			case 8:
				System.out.println("-------------------");
				recruitPrint(groupOne);
				break;
			case 9:
				break;
			default:
				JOptionPane.showMessageDialog(null, "�������� �������, ��������� ����.");
				break;
			}
		}
	}

	public static Group createGroup() {
		int capacityGroup;
		for (;;) {
			try {
				capacityGroup = Integer
						.valueOf(JOptionPane.showInputDialog("������� ����������� " + "\n" + " ������ (1-100)"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "�������� ������");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Cancel. Set default value = 10");
				capacityGroup = 10;
				break;
			}
		}
		if (capacityGroup > 100) {
			capacityGroup = 100;
		}
		if (capacityGroup < 0) {
			capacityGroup = 1;
		}
		Group groupOne = new Group(capacityGroup);
		System.out.println("������� ������� ������, ������������ �� " + capacityGroup + " ���������.");
		System.out.println("-----------------------------------------------------------");
		return groupOne;
	}

	public static int mainMenu() {

		for (;;) {
			try {
				int command = Integer.valueOf(JOptionPane.showInputDialog("��������� ��������: (������� �����)" + "\n"
						+ "------------------------------------------------------------" + "\n"
						+ "1 - ���� ������ �������� � ���������� ��� � ������" + "\n"
						+ "2 - ���������� �������� �� ������ (�� �������)" + "\n" + "3 - ����� �������� (�� �������)"
						+ "\n" + "4 - ���������� ������ �� �������" + "\n"
						+ "5 - ���������� ������ �� ������������ (�� ������� � �������)" + "\n"
						+ "6 - ���������� ������ �� ��������" + "\n" + "7 - ����� �� ����� ������ ���������" + "\n"
						+ "8 - ������� ������ ����������� � ������� �� �����" + "\n" + "9 - ����� �� ���������"));
				return command;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "�������� �������, ��������� ����.");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Cancel");
				return 9;
			}
		}
	}

	public static void recruitPrint(Group group) {
		System.out.println("������ �����������:");
		for (Student recruit : group.callOfDuty()) {
			if (recruit == null) {
				continue;
			}
			System.out.println("���������-" + recruit);
		}
	}

	public static void simpleTesting() {

		Student studentOne = new Student("Ivanov", "Petro", true, 20, 69);
		Student studentTwo = new Student("Petrov", "Andrey", true, 17, 68);
		Student studentThree = new Student("Sidorova", "Maria", false, 19, 74);
		Student studentFour = new Student("Andreev", "Ivan", true, 18, 85);
		Student studentFive = new Student("Koval", "Sergiy", true, 21, 71);
		Student studentSix = new Student("Bondar", "Anna", false, 17, 85);
		Student studentSeven = new Student("Kobzar", "Oleg", true, 19, 95);
		Student studentEight = new Student("Tatarenko", "Vera", false, 18, 91);
		Student studentNine = new Student("Tkachenko", "Vasil", true, 17, 88);
		Student studentTen = new Student("Valeev", "Alexey", true, 19, 86);
		Student studentEleven = new Student("Moskal", "Anton", true, 18, 69);

		Student studentNullOne = new Student();
		Student studentNullTwo = null;

		Group groupOne = new Group();

		groupOne.addStudent(studentOne);
		groupOne.addStudent(studentTwo);
		groupOne.addStudent(studentNullOne); // ������� �������� "null"-�������� - ���� �������
		groupOne.addStudent(studentNullTwo); // ������� �������� "null"-�������� - ������ �������
		groupOne.addStudent(studentThree);
		groupOne.addStudent(studentFour);
		groupOne.addStudent(studentFive);
		groupOne.addStudent(studentSix);
		groupOne.addStudent(studentSeven);
		groupOne.addStudent(studentEight);
		groupOne.addStudent(studentNine);
		groupOne.addStudent(studentTen);
		groupOne.addStudent(studentEleven); // ������� �������� ������� ��������

		System.out.println();

		groupOne.delStudent("Pupkin"); // ������� ������� ��������������� ��������
		groupOne.delStudent("Tkachenko");
		groupOne.delStudent("Koval");
		groupOne.delStudent("Andreev");

		groupOne.addStudent(studentEleven);
		groupOne.addStudent(studentOne); // ������� ������ � ������ ��������, ������� ��� ���� � ������

		System.out.println("--------");
		groupOne.printGroup();
		System.out.println("--------");

		groupOne.sortGroup(0); // ���������� �� ������������
		System.out.println("--------");
		groupOne.printGroup();

		groupOne.sortGroup(1); // ���������� �� ��������
		System.out.println("--------");
		groupOne.printGroup();

		groupOne.sortGroup(2); // ���������� �� �������
		System.out.println("--------");
		groupOne.printGroup();

		System.out.println("--------");
		System.out.println(groupOne.toString()); // ����� toString() - �� ��������
		System.out.println("--------");
		System.out.println();
		System.out.println(groupOne.searchStudent("Tatarenko").toString()); // ����� �� �������
		System.out.println(groupOne.searchStudent("Anderson").toString()); // ��� ������ ��������
		System.out.println("-------------------");
		recruitPrint(groupOne);
	}
}
