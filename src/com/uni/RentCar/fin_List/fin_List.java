package com.uni.rentCar.fin_List;

import java.util.ArrayList;

import com.uni.rentCar.model.dto.RentCarDto;

public class fin_List {

	
	public ArrayList<RentCarDto> book_date(ArrayList<RentCarDto> book) {
		
		 ArrayList<RentCarDto> book_date_list = new ArrayList<RentCarDto>(); 
		
		 
		 // ��¥�� ������ �ް� �� ���ǿ� ���ؼ� ���� ���� �ٽ� book_date_list�� �ִ´�.
		 // ���߿� �ٽ� ���� ������ Ȯ���ϱ� ���� Ȯ�ο�
		 for (int i = 0; i < book.size(); ++i) {
			 
			 book_date_list.set(i, book.get(i));
		 }
		 
		
		return book_date_list;
	}
	
	
	public ArrayList<RentCarDto> book_time(ArrayList<RentCarDto> book) {
		
		ArrayList<RentCarDto> book_time_list = new ArrayList<RentCarDto>();
		
		 // �ð����� ������ �ް� �� ���ǿ� ���ؼ� ���� ���� �ٽ� book_time_list�� �ִ´�.
		 // ���߿� �ٽ� ���� ������ Ȯ���ϱ� ���� Ȯ�ο�
		 for (int i = 0; i < book.size(); ++i) {
			 
			 book_time_list.set(i, book.get(i));
		 }
		
		
		return book_time_list;
	}
	
	
	public ArrayList<RentCarDto> book_Carmodel(ArrayList<RentCarDto> book) {
		
		ArrayList<RentCarDto> book_car_list = new ArrayList<RentCarDto>();
		
		 // �������� ������ �ް� �� ���ǿ� ���ؼ� ���� ���� �ٽ� book_car_list�� �ִ´�.
		 // ���߿� �ٽ� ���� ������ Ȯ���ϱ� ���� Ȯ�ο�
		 for (int i = 0; i < book.size(); ++i) {
			 
			 book_car_list.set(i, book.get(i));
		 }
		
		
		return book_car_list;
	}
	
	public ArrayList<RentCarDto> book_fin() {
		
		ArrayList<RentCarDto> book_fin_list = new ArrayList<RentCarDto>();
		
		
		return book_fin_list;
	}
	
}
