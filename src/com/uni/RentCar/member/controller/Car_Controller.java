package com.uni.RentCar.member.controller;

import com.uni.RentCar.member.model.Car_Classification.Mid_Car;
import com.uni.RentCar.member.model.Car_Classification.SUV;
import com.uni.RentCar.member.model.Car_Classification.Small_Car;

public class Car_Controller {

	
	
	
	public void Car_SelectTime(/*�μ� ����, �μ� �ð�, �ݳ� ����, �ݳ� �ð� */) {
		
		// Car_SelectTime�� ���� ����Ϸᰡ ���� ���////
		// �� �������� �Ѿ�� �ȴ�.
		
	}
	
	
	
	public void Car_Select(int select) {
		
		/*
		 *	1 : ���� 
		 *  2 : ����
		 *  3 : SUV 
		 */
		
		
		if (select == 1) {
			Small_Car sm = new Small_Car();
			
			
			
		} else if (select == 2) {
			Mid_Car mi = new Mid_Car();
			
			
			
		} else if (select == 3) {
			SUV su = new SUV();
			
			
		}
		
	}
	
}
