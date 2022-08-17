package com.uni.stay.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.uni.stay.controller.StayController;
import com.uni.stay.model.dto.BookingStay;
import com.uni.stay.model.dto.Stay;

public class StayMenu {

	private Scanner sc = new Scanner(System.in);
	
	private StayController stayController = new StayController();
	private BookingStay bookingStay = new BookingStay();
	private String[] date;
	private String year;
	private String month;
	private String day;
	private String tomorrow;
	
	public void areaMenu() {
		int areaChoice;
		String area = "";
		
		do {
			System.out.println("\n*******����********");
			System.out.println("1.���ֽ�");
			System.out.println("2.��������");
			System.out.println("0.���� ȭ��");
			System.out.println("��ȣ���� : ");
			
			areaChoice = sc.nextInt();
			
			
			switch(areaChoice) {
			case 1: 
				area = "���ֽ�";
				bookingStay.setStayArea(area);
				stayMenu();
				
				break;
			case 2:
				area = "��������";
				bookingStay.setStayArea(area);
				stayMenu();	
				break;
			case 0:
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				//TODO
				break;
				
			default :
				System.out.println("��ȣ�� �߸��Է��Ͽ����ϴ�.");
			}
			
			
		} while(true);
		
		
		
	}

	private void stayMenu() {
		int stayChoice;
		int code = 0; 
		
		do {
			System.out.println("\n*******���� ����********");
			System.out.println("1.���");
			System.out.println("2.ȣ��");
			System.out.println("3.����Ʈ/�ܵ�");
			System.out.println("4.��Ÿ");
			System.out.println("0.���� ȭ��");
			System.out.println("��ȣ���� : ");
			
			stayChoice = sc.nextInt();
			sc.nextLine();
			
			switch(stayChoice) {
			case 1: 
				code = 1;
				bookingStay.setStayCode(1);
				dayMenu();
				break;
			case 2: 
				code = 2;
				bookingStay.setStayCode(2);
				dayMenu();
				break;
			case 3: 
				code = 3;
				bookingStay.setStayCode(3);
				dayMenu();
				break;
			case 4: 
				code = 4;
				bookingStay.setStayCode(4);
				dayMenu();
				break;
			case 0:
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				areaMenu();
				break;
				
			default :
				System.out.println("��ȣ�� �߸��Է��Ͽ����ϴ�.");
			}
			
			
		} while(true);
		
	}

	private void dayMenu() {
		int choice;
		
		do {
			System.out.println("\n*******�Խ� ����********");
			System.out.println("1.�Խ� ���� �Է�");
			System.out.println("0.���� ȭ��");
			System.out.println("��ȣ���� : ");
			
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1: 
				dayChoice();
				nameMenu();
				break;
			case 0:
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				stayMenu();
				break;
				
			default :
				System.out.println("��ȣ�� �߸��Է��Ͽ����ϴ�.");
			}
			
			
		} while(true);
		
	}

	public void dayChoice() {
		
		System.out.println("�Խ� ���ڸ� �Է��� �ּ��� ( '-'�����ڷ� �⵵���� �Է�, ex)2022-01-01 ): ");
		String bookingDate = sc.nextLine();
		
		date = bookingDate.split("-");
		year = date[0];
		month = date[1];
		day = date[2];
		
		int temp = Integer.parseInt(day);
		temp++; //��¥�� 1�� �߰�
		
		tomorrow = Integer.toString(temp);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date transDate = null;
		try {
			transDate = formatter.parse(bookingDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		bookingStay.setStayDay(transDate);
		
		
//		System.out.println(transDate);

//		System.out.println(bookingStay.getStayDay());
	}

	private void nameMenu() {
		int choice;
		
		do {
			System.out.println("\n*******���� ��� �� ����********");
			System.out.println("1.���� ��� �� ����");
			System.out.println("0.���� ȭ��");
			System.out.println("��ȣ���� : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1: 
				stayController.selectByNameList(bookingStay.getStayArea(), bookingStay.getStayCode());
				
				System.out.println("���Ҹ� �������ּ��� (���Ҹ� �Է�): ");
				String stayName = sc.nextLine();
				bookingStay.setStayName(stayName);
				
				infoMenu();
				break;
			case 0:
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				dayMenu();
				break;
				
			default :
				System.out.println("��ȣ�� �߸��Է��Ͽ����ϴ�.");
			}
			
			
		} while(true);
		
		
	}

	private void infoMenu() {
		
		do {
			System.out.println("\n*******���� ���� ����********");
			System.out.println("1.���� ���� ���� Ȯ��");
			System.out.println("0.���� ȭ��");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			
			switch(choice) {
			case 1: 
				stayController.selectByStayInfo(bookingStay.getStayArea(), bookingStay.getStayCode()
						,bookingStay.getStayDay() , bookingStay.getStayName());
				
				System.out.println("�����Ͻðڽ��ϱ�?(y/n)");
				String booking = sc.nextLine();
				if(booking.equals("y")||booking.equals("Y")) {
					bookingMenu();
				}
				break;
			case 0:
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				nameMenu();
				break;
				
			default :
				System.out.println("��ȣ�� �߸��Է��Ͽ����ϴ�.");
			}
			
			
		} while(true);
		
	}

	private void bookingMenu() {

		stayController.selectByBookingConfirmInfo(bookingStay.getStayArea(), bookingStay.getStayCode()
				,bookingStay.getStayDay() , bookingStay.getStayName());
		
		System.out.println("���͸� �����ֽø� �޴��� ���ư��ϴ�.");
		String menu = sc.nextLine();
		
		
	}

	public void displayStayNameList(List<Stay> s2) {
		System.out.println();
		System.out.println("������ ���� ��� �Դϴ�");
		System.out.println("----------------------------------");
		System.out.println();
		int i = 1;
		
		for(Stay s : s2) {
			System.out.println(i++ + ". " + s.getStayName());
		}
	}

	public void displayError(String message) {
		System.out.println("���� ��û ó�� ���� : " + message);
		
	}

	public void displayStayInfoList(List<String> s2) {
		System.out.println();
		System.out.println("---------���� ����---------");
		System.out.println();
		
		System.out.println("���Ҹ� : " + bookingStay.getStayName());
		System.out.println("�ּ� : " + s2.get(1));
		System.out.println("Check In : " + year + "�� " + month + "�� " + day + "�� 15��00�� ����");
		System.out.println("Check Out : " + year + "�� " + month + "�� " + tomorrow + "�� 11��00�� ����");
		System.out.println("�ݾ� : " + s2.get(2) + "��");
	
		System.out.println();
		
		
	}

	public void displayBookingConfirm(List<String> s2) {
		System.out.println();
		System.out.println("---------���� �Ϸ�---------");
		System.out.println();
		
		System.out.println("���Ҹ� : " + bookingStay.getStayName());
		System.out.println("�ּ� : " + s2.get(1));
		System.out.println("Check In : " + year + "�� " + month + "�� " + day + "�� 15��00�� ����");
		System.out.println("Check Out : " + year + "�� " + month + "�� " + tomorrow + "�� 11��00�� ����");
		System.out.println("�ݾ� : " + s2.get(2) + "��");
		System.out.println();
		System.out.println("���Ұ� ����Ǿ����ϴ�.");
	}

}
