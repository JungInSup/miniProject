package com.uni.rentCar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.uni.rentCar.fin_List.fin_List;
import com.uni.rentCar.model.dto.RentCarDto;
import com.uni.rentCar.model.service.RentCarService;
import com.uni.rentCar.view.RentCarMenu;
import com.uni.utile.StrDate;
import com.uni.utile.StrTime;

public class RentCarController {

	private RentCarService RentcarService = new RentCarService();
	
	// StackOverflow�� ��
	//public RentCarMenu Carmenu = new RentCarMenu();
	
	fin_List List_book_date = new fin_List();
	public ArrayList<RentCarDto> Final_appointment_Rentcar_list = new ArrayList<RentCarDto>();
	
	public void UpdatereturnDate() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("�ݳ� ��¥�� �Է��ϼ��� : (�� 20220809)");
		String str_date_sel = sc.next();
		sc.nextLine();
		
		System.out.println("�ݳ� �ð� �Է��ϼ��� : ((�� 8AM -> 8, 2pm -> 14)");
		String str_sec_sel = sc.next();
		sc.nextLine();
		
		StrDate str_date = new StrDate();
		String Return_date = str_date.strDate(str_date_sel);
		
		StrTime str_sec = new StrTime();
		String Return_second = str_sec.str_time(str_sec_sel);
		
		// rentcar_no
		//RentCarDto car_no = Carmenu.Final_reservation_car.get(0);
		
		
		int result = RentcarService.UpdatereturnDate("1001", Return_date, Return_second);
		
		// �� �ݳ��� ���� ���� �ǰ� ���� �ݳ� ��¥�� �������� ������Ʈ�� �� �� �ֱ���.
		// ��Ʈī�� �ϳ��� �����״ϱ� 
		
		if(result > 0 ) {	
			new RentCarMenu().displaySuccess("��Ʈī ���� ���� ����");
		}else {
			new RentCarMenu().displayError("��Ʈī ���� ���� ����");
		}
		
	}
	
	
	
	// ���� ��¥ ���� 
	public void selectDate() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("�μ� ��¥�� �Է��ϼ��� : (�� 20220809)");
		String str = sc.next();
		sc.nextLine();
		
		StrDate str_date = new StrDate();
		String Selec_date = str_date.strDate(str);
		
		ArrayList<RentCarDto> ca_list = RentcarService.selectDate(Selec_date);
	
		
		// =============================================
		// �μ� ��¥ ��ȸ�� �Ѱ��� �ٸ� ���� ����Ʈ�� ����.
		//if (Final_appointment_Rentcar_list != null) {
		Final_appointment_Rentcar_list = List_book_date.book_date(ca_list);	
		//}
		// =============================================
		
		if(!ca_list.isEmpty()) {// ����Ʈ��ü�� �̹� ������⶧���� null �̵ɼ� ���� ������ִ����� ����
			Carmenu.displayRentCarList(ca_list);
		}else {
			Carmenu.displayError("�ش�Ǵ� �����Ͱ� �����ϴ�.");
		}
	}
	
	
	public void selectTime() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("�μ� �ð��� �Է��ϼ��� : (�� 8AM -> 8, 2pm -> 14)");
		String str = sc.next();
		sc.nextLine();
		
		
		StrTime str_time = new StrTime();
		
		String Selec_time = str_time.str_time(str);
		
		ArrayList<RentCarDto> ca_list = RentcarService.selectTime(Selec_time);
		
		
		
		// ============================================
		// �μ� ��¥ ��ȸ �Ѱ��� �ٽ� �μ� �ð����� ��ȸ�� �ϰ� ��������Ʈ�� ����
		
		if (Final_appointment_Rentcar_list != null) {
			
			Final_appointment_Rentcar_list = List_book_date.book_time(Final_appointment_Rentcar_list, Selec_time);
			
		}
		// ============================================
		
		
		if(!ca_list.isEmpty()) {// ����Ʈ��ü�� �̹� ������⶧���� null �̵ɼ� ���� ������ִ����� ����
			Carmenu.displayRentCarList(ca_list);
		}else {
			Carmenu.displayError("�ش�Ǵ� �����Ͱ� �����ϴ�.");
		}
		
	}



	public void selectAll() {
		
		RentCarMenu Carmenu = new RentCarMenu();
		
		ArrayList<RentCarDto> list = RentcarService.selectAll();
		
		if(!list.isEmpty()) {// ����Ʈ��ü�� �̹� ������⶧���� null �̵ɼ� ���� ������ִ����� ����
			Carmenu.displayRentCarList(list);
		}else {
			Carmenu.displayError("�ش�Ǵ� �����Ͱ� �����ϴ�.");
		}
		
	}
	
	
	public void selectCarSection() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("�� ���� �����ϼ��� (����, ����, SUV) : ");
		String str = sc.next();
		sc.nextLine();
		
		ArrayList<RentCarDto> list = RentcarService.selectsection(str);
		
				
		//Carmenu.displayfinRentCar(list);
		
		// =============================================
		// �μ� ��¥,�ð� ��ȸ�� �Ѱ��� ������ �����ؼ� ���� ����Ʈ�� ���� 
		if (Final_appointment_Rentcar_list != null) {
			
			Final_appointment_Rentcar_list = List_book_date.book_Carsection(Final_appointment_Rentcar_list);
		}
		
		// =============================================
		
		if(!list.isEmpty()) {// ����Ʈ��ü�� �̹� ������⶧���� null �̵ɼ� ���� ������ִ����� ����
			Carmenu.displayRentCarList(list);
		}else {
			Carmenu.displayError("�ش�Ǵ� �����Ͱ� �����ϴ�.");
		}
		
	}
	
	

	public void selectOne(String inputMemberId) {
		RentCarMenu Carmenu = new RentCarMenu();
		
		RentCarDto m = RentcarService.selectOne(inputMemberId);
		
		if(m != null) {
			Carmenu.displayMember(m);
		}else {
			Carmenu.displayError(inputMemberId + " �ش�Ǵ� �����Ͱ� �����ϴ�.");
		}
		
	}

	public void selectByName(String inputMemberName) {
		
		RentCarMenu menu = new RentCarMenu();
		
		List<RentCarDto> list = RentcarService.selectByName(inputMemberName);
		
		if(!list.isEmpty()) {// ����Ʈ��ü�� �̹� ������⶧���� null �̵ɼ� ���� ������ִ����� ����
			menu.displayRentCarList(list);
		}else {
			menu.displayError("�ش�Ǵ� �����Ͱ� �����ϴ�.");
		}
		
	}

	public void insertMember(RentCarDto inputMember) {
		
		int result = RentcarService.insertMember(inputMember);
		
		if(result > 0 ) {
			
			new RentCarMenu().displaySuccess("ȸ�����Լ���");
		}else {
			new RentCarMenu().displayError("ȸ�����Խ���");
		}
		
	}

	public void updateMember(RentCarDto updateMember) {
		
		int result = RentcarService.updateMember(updateMember);
		
		
		if(result > 0 ) {	
			new RentCarMenu().displaySuccess("��Ʈī ���� ���� ����");
		}else {
			new RentCarMenu().displayError("��Ʈī ���� ���� ����");
		}
		
	}

	public void deleteMember(String inputMemberId) {
		int result = RentcarService.deleteMember(inputMemberId);
		
		if(result > 0 ) {
			new RentCarMenu().displaySuccess("ȸ����������");
		}else {
			new RentCarMenu().displayError("ȸ����������");
		}
		
	}

	public void exitProgram() {

		RentcarService.exitProgram();
		
	}
	
}
