package com.uni.rentCar.view;

import java.util.List;
import java.util.Scanner;

import com.uni.rentCar.controller.RentCarController;
import com.uni.rentCar.model.dto.RentCarDto;

public class RentCarMenu {

	private static Scanner sc = new Scanner(System.in);
	private RentCarController RentCarController = new RentCarController();
	
	public void RentCarMenu() {
		
		int choice;
		
		while(true) {
			
			System.out.println("\n=========== ����ī ���� ���α׷� =============");
			System.out.println("1. ��ü ��Ʈī ��ȸ ");
			System.out.println("2. ��Ʈī �μ� ���� ");
			System.out.println("3. ��Ʈī �μ� �ð� ");
			System.out.println("4. ��Ʈī �ݳ� ���� ");
			System.out.println("3. ��Ʈī �ݳ� �ð� ");
			System.out.println("8. ��Ʈī ���� ��ȸ(������� �ʴ´�.)");
			System.out.println("9. ���α׷� ����");
			
			System.out.println("��ȣ�� �Է��ϼ��� : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				RentCarController.selectAll();
				break;
			case 2:
				RentCarController.selectDate();
				break;
			case 3:
				RentCarController.selectTime();
				break;
			case 9:
				
				System.out.println("������ �����ðڽ��ϱ�??(y/n)");
				if ('y' == sc.next().toLowerCase().charAt(0)) {
					
					// DB�� ������ ���� while���� ����������.
					RentCarController.exitProgram();
					return;
				}

				break;
			}
			
			
		}
		
		
		

//		do {
//			
//			System.out.println("\n============ ����ī ���� ���α׷�  ==============");
//			System.out.println("1. �μ� ���� ��ȸ");
//			System.out.println("2. �μ� �ð� ��ȸ (8:00 ~ 20:00 2�ð� ����)");
//			System.out.println("3. �ݳ� ���� ��ȸ" + "(udpate�� �ڹٿ��� �ð��� �޴´�)");
//			System.out.println("4. �ݳ� �ð� ��ȸ" + "(�ݳ����ڶ� ���� ����)");
//			
//			
//			/*System.out.println("1.ȸ�� ��ü ��ȸ");// SELECT
//			System.out.println("2.ȸ�� ���̵� ��ȸ");// SELECT
//			System.out.println("3.ȸ�� �̸� ��ȸ");// SELECT
//			System.out.println("4.ȸ�� ����");// INSERT
//			System.out.println("5.ȸ�� ���� ����");// UPDATE
//			System.out.println("6.ȸ�� Ż��");// DELETE
//			System.out.println("9.���α׷� ������");// ����
//			System.out.println("��ȣ���� : ");*/
//
//			choice = sc.nextInt();
//
//			switch (choice) {
//			case 1:
//				memberController.selectAll();
//				break;
//			case 2:
//				memberController.selectOne(inputMemberId());
//				break;
//			case 3:
//				memberController.selectByName(inputMemberName());
//				break;
//			case 4:
//				//memberController.insertMember(inputMember());
//				break;
//			case 5:
//				//memberController.updateMember(updateMember());
//				break;
//			case 6:
//				memberController.deleteMember(inputMemberId());
//				break;
//			case 9:
//				System.out.println("������ �����ðڽ��ϱ�??(y/n)");
//				if ('y' == sc.next().toLowerCase().charAt(0)) {
//					memberController.exitProgram();
//					return;
//				}
//
//				break;
//
//			default:
//				System.out.println("��ȣ�� �߸��Է��Ͽ����ϴ�.");
//			}
//
//		} while (true);
	}

	private RentCarDto updateMember() {
		
		RentCarDto rent = new RentCarDto();
		
//		m.setUserId(inputMemberId());
//		System.out.println("��ȣ : ");
//		m.setPassword(sc.next());
//		System.out.println("�̸��� : ");
//		m.setEmail(sc.next());
//		System.out.println("��ȭ��ȣ(-�����Է�) : ");
//		m.setPhone(sc.next());
//		System.out.println("�ּ� : ");
//		sc.nextLine();//�Է¹����� enter Ű ����
//		m.setAddress(sc.nextLine());

		return rent;
	}

	private RentCarDto inputMember() {
		
		RentCarDto rent = new RentCarDto();
		
//		System.out.println("���ο� ȸ�������� �Է��ϼ��� >>");
//		System.out.println("���̵� : ");
//		m.setUserId(sc.next());
//		System.out.println("��ȣ : ");
//		m.setPassword(sc.next());
//		System.out.println("�̸� : ");
//		m.setUserName(sc.next());
//		System.out.println("���� : ");
//		m.setAge(sc.nextInt());
//		System.out.println("����(M/F) : ");
//		m.setGender(sc.next().toUpperCase());
//		System.out.println("�̸��� : ");
//		m.setEmail(sc.next());
//		System.out.println("��ȭ��ȣ(-�����Է�) : ");
//		m.setPhone(sc.next());
//		System.out.println("�ּ� : ");
//		sc.nextLine();//�Է¹����� enter Ű ����
//		m.setAddress(sc.nextLine());
//		System.out.println("���(, �� ������� �Է�) : ");
//		m.setHobby(sc.next());
		
		
		return rent;
	}

	private String inputMemberName() {
		System.out.println("��ȸ�� ȸ���̸� �Է� : ");
		return sc.next();
	}

	private String inputMemberId() {
		System.out.println("���̵��Է� : ");
		return sc.next();
	}

	// ����ī ��ȸ�� ����Ʈ ����
	public void displayRentCarList(List<RentCarDto> list) {
		//System.out.println("\n��ȸ�� ��ü ȸ�������� ������ �����ϴ�.");
		System.out.println("\n��ȸ�� ��ü ����ī ������ ������ �����ϴ�.");
		System.out.println("\n��Ʈ��ȣ\t������ȣ\t����\t  �μ�����\t\t�μ��ð�"
				+ "\t\t�ݳ�����\t\t�ݳ��ð�\t    �뿩�Ⱓ\t����\t �з�\t ����\t ����\t ����");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		
		for (RentCarDto m : list) {
			System.out.println(m);
		}

	}

	// �����޽��� ��¿� �޼ҵ�
	public void displayError(String message) {
		System.out.println("���� ��û ó�� ���� : " + message);

	}
	
	//���̵�� ��ȸ�� ȸ�� �Ѹ� ������ ����� �޼ҵ�
	public void displayMember(RentCarDto m) {
		System.out.println("\n��ȸ�� ��ü ����ī ������ ������ �����ϴ�.");
		System.out.println("\n��Ʈ��ȣ\t������ȣ\t����\t  �μ�����\t\t�μ��ð�"
				+ "\t\t�ݳ�����\t\t�ݳ��ð�\t    �뿩�Ⱓ\t����\t �з�\t ����\t ����\t ����");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println(m);
	}
	//���� �޼��� ���
	public void displaySuccess(String message) {
		System.out.println("���� ��û ��� : "+message)  ;
	}
		
	
}
