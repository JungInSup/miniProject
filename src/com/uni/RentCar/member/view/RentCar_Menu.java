package com.uni.RentCar.member.view;

import java.util.Scanner;

import com.uni.RentCar.member.controller.Car_Controller;

public class RentCar_Menu {

	
	Scanner sc = new Scanner(System.in);
	
	Car_Controller car_con = new Car_Controller();
	
	// �ϴ� ���� ��ü ���� ȭ�� ����ڽ��ϴ�.
	public void CarMenu() {
		
		int car_classification = 0;
		
		while(true) {
			
			System.out.println("=======��Ʈ ����========");
			System.out.println("�μ� ���ڿ� �μ� �ð��� ������.");
			
			{
				// DB���� �μ����ڿ� �ð�, �ݳ����ڿ� �ݳ� �ð��� �޴´�.
				// �� 4���� �Ű������� ��� 
				
				// �μ� ���ڸ� ����.
				System.out.println("�μ� ���ڸ� ���ÿ� :" );
				// �μ� �ð��� ����.
				System.out.println("�μ� �ð��� ���ÿ� : ");
				
				// �ݳ� ���ڸ� ����
				System.out.println("�ݳ� ���ڸ� ���ÿ� : ");
				// �ݳ� �ð��� ����.
				System.out.println("�ݳ� �ð��� ���ÿ� : ");	
				
				// ���� ���� �Լ� 
				Car_Reservation(/*�μ� ����, �μ� �ð�, �ݳ� ����, �ݳ� �ð� */);
			}
			
			
			
			{
				
				// �� �з��� ����.
				System.out.println("============ ����ī ���� ��� ===========");
				System.out.println("1. ����");
				System.out.println("2. ����");
				System.out.println("3. SUV");
				
				car_classification = sc.nextInt();
				sc.nextLine();
				
				switch(car_classification) {
				
				case 1:
					// ����
					Car_Select(car_classification);
					break;
				case 2:
					// ����
					Car_Select(car_classification);
					break;
				case 3:
					// SUV
					Car_Select(car_classification);
					break;
				
				default:
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� ���ÿ�");
				}
				
				
				
			}
			
		}
		
	}
	
	public void Car_Reservation(/*�μ� ����, �μ� �ð�, �ݳ� ����, �ݳ� �ð� */) {
		
		car_con.Car_SelectTime(/*�μ� ����, �μ� �ð�, �ݳ� ����, �ݳ� �ð� */);
		
		//return => ������ �ʿ��Ѱ�?
		
	}
	
	public void Car_Select(int select) {
		
		car_con.Car_Select(select);
	}
}
