package com.uni.rentCar.fin_List;

import java.util.ArrayList;

import com.uni.rentCar.model.dto.RentCarDto;

 
public class fin_List {

	public ArrayList<RentCarDto> book_date(ArrayList<RentCarDto> book) {
		
		 ArrayList<RentCarDto> book_date_list = new ArrayList<RentCarDto>(); 
		
		 
		 // ��¥�� ������ �ް� �� ���ǿ� ���ؼ� ���� ���� �ٽ� book_date_list�� �ִ´�.
		 // ���߿� �ٽ� ���� ������ Ȯ���ϱ� ���� Ȯ�ο�
		 for (int i = 0; i < book.size(); ++i) {
			 
			 book_date_list.add(i, book.get(i));
		 }
		 
		
		return book_date_list;
	}
	
	
	public ArrayList<RentCarDto> book_time(ArrayList<RentCarDto> book, String Select_time) {
		
		ArrayList<RentCarDto> book_time_list = new ArrayList<RentCarDto>();
		
		 // �ð����� ������ �ް� �� ���ǿ� ���ؼ� ���� ���� �ٽ� book_time_list�� �ִ´�.
		 // ���߿� �ٽ� ���� ������ Ȯ���ϱ� ���� Ȯ�ο�
//		 for (int i = 0; i < book.size(); ++i) {
//			 
//			 book_time_list.add(i, book.get(i));
//		 }
		 
		 //String test = format.format();
		
		 String select_time_add = Select_time + ":00";
		
		 for (int i = 0; i < book.size(); ++i) {
			 
			 if (book.get(i).getRentcar_datetime().equals(select_time_add)) {
				 
				 book_time_list.add(i, book.get(i));
			 }
		 }
		 
		 
		System.out.println("book_time test");
		
		for (int i = 0; i < book_time_list.size(); ++i) {
			
			System.out.println(book_time_list.get(i).getRentcar_date());
			System.out.println(book_time_list.get(i).getRentcar_datetime());
		}
		
		
		return book_time_list;
	}
	
	
	public ArrayList<RentCarDto> book_Carsection(ArrayList<RentCarDto> book) {
		
		ArrayList<RentCarDto> book_car_list = new ArrayList<RentCarDto>();
		
		 // �������� ������ �ް� �� ���ǿ� ���ؼ� ���� ���� �ٽ� book_car_list�� �ִ´�.
		 // ���߿� �ٽ� ���� ������ Ȯ���ϱ� ���� Ȯ�ο�
		 for (int i = 0; i < book.size(); ++i) {
			 
			 book_car_list.add(i, book.get(i));;
		 }
		
		
		return book_car_list;
	}

	
	// ������ �Ѱ��� ���� ����Ʈ
	
	public void book_fin() {
		
		ArrayList<RentCarDto> book_fin_list = new ArrayList<RentCarDto>();
		
		//book_fin_list = book_Carsection(book);
		
		
	}
	
}
