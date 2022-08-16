package com.uni.rentCar.controller;

import java.util.ArrayList;
import java.util.List;

import com.uni.rentCar.model.dto.RentCarDto;
import com.uni.rentCar.model.service.RentCarService;
import com.uni.rentCar.view.RentCar_Menu;

public class RentCarController {

private RentCarService memberService = new RentCarService();
	
	public void selectAll() {
		
		RentCar_Menu Carmenu = new RentCar_Menu();
		
		ArrayList<RentCarDto> list = memberService.selectAll();
		
		if(!list.isEmpty()) {// ����Ʈ��ü�� �̹� ������⶧���� null �̵ɼ� ���� ������ִ����� ����
			Carmenu.displayMemberList(list);
		}else {
			Carmenu.displayError("�ش�Ǵ� �����Ͱ� �����ϴ�.");
		}
		
	}

	public void selectOne(String inputMemberId) {
		
		RentCar_Menu menu = new RentCar_Menu();
		RentCarDto m = memberService.selectOne(inputMemberId);
		
		if(m != null) {
			menu.displayMember(m);
		}else {
			menu.displayError(inputMemberId + " �ش�Ǵ� �����Ͱ� �����ϴ�.");
		}
		
	}

	public void selectByName(String inputMemberName) {
		
		RentCar_Menu menu = new RentCar_Menu();
		
		List<RentCarDto> list = memberService.selectByName(inputMemberName);
		
		if(!list.isEmpty()) {// ����Ʈ��ü�� �̹� ������⶧���� null �̵ɼ� ���� ������ִ����� ����
			menu.displayMemberList(list);
		}else {
			menu.displayError("�ش�Ǵ� �����Ͱ� �����ϴ�.");
		}
		
	}

	public void insertMember(RentCarDto inputMember) {
		
		int result = memberService.insertMember(inputMember);
		
		if(result > 0 ) {
			
			new RentCar_Menu().displaySuccess("ȸ�����Լ���");
		}else {
			new RentCar_Menu().displayError("ȸ�����Խ���");
		}
		
	}

	public void updateMember(RentCarDto updateMember) {
		int result = memberService.updateMember(updateMember);
		
		if(result > 0 ) {
			
			new RentCar_Menu().displaySuccess("ȸ����������");
		}else {
			new RentCar_Menu().displayError("ȸ����������");
		}
		
	}

	public void deleteMember(String inputMemberId) {
		int result = memberService.deleteMember(inputMemberId);
		
		if(result > 0 ) {
			new RentCar_Menu().displaySuccess("ȸ����������");
		}else {
			new RentCar_Menu().displayError("ȸ����������");
		}
		
	}

	public void exitProgram() {

		memberService.exitProgram();
		
	}
	
}
