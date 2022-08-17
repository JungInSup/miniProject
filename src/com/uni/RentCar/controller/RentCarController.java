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
	
	// ���� ��¥ ���� 
	public void selectDate() {
		
		Scanner sc = new Scanner(System.in);
		RentCarMenu Carmenu = new RentCarMenu();
		
		System.out.println("���� ��¥�� �Է��ϼ��� : (�� 20220809)");
		String str = sc.next();
		sc.nextLine();
		
		StrDate str_date = new StrDate();
		String Selec_date = str_date.strDate(str);
		
		ArrayList<RentCarDto> ca_list = RentcarService.selectDate(Selec_date);
	
		
		// =============================================
		// �μ� ��¥ ��ȸ�� �Ѱ��� �ٸ� ���� ����Ʈ�� ����.
		fin_List List_book_date = new fin_List();
		List_book_date.book_date(ca_list);
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
		
		System.out.println("���� �ð��� �Է��ϼ��� : (�� 8AM -> 8, 2pm -> 14)");
		String str = sc.next();
		sc.nextLine();
		
		
		StrTime str_time = new StrTime();
		
		String Selec_time = str_time.str_time(str);
		
		ArrayList<RentCarDto> ca_list = RentcarService.selectTime(Selec_time);
		
		// =============================================
		// �μ� �ð� ��ȸ�� �Ѱ��� �ٸ� ���� ����Ʈ�� ����.
		fin_List List_book_date = new fin_List();
		List_book_date.book_time(ca_list);
		// =============================================
		
		
		
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
			
			new RentCarMenu().displaySuccess("ȸ����������");
		}else {
			new RentCarMenu().displayError("ȸ����������");
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
