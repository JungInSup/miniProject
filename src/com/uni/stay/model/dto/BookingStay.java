package com.uni.stay.model.dto;

import java.util.Date;

public class BookingStay {

	private int stayCode;
	private String stayArea;
	private String stayName;
	private Date stayDay;
//	private int price;
	
	public BookingStay() {
	}

	public BookingStay(int stayCode, String stayArea, String stayName, Date stayDay) {
		super();
		this.stayCode = stayCode;
		this.stayArea = stayArea;
		this.stayName = stayName;
		this.stayDay = stayDay;
	}

	public int getStayCode() {
		return stayCode;
	}

	public void setStayCode(int stayCode) {
		this.stayCode = stayCode;
	}

	public String getStayArea() {
		return stayArea;
	}

	public void setStayArea(String stayArea) {
		this.stayArea = stayArea;
	}

	public String getStayName() {
		return stayName;
	}

	public void setStayName(String stayName) {
		this.stayName = stayName;
	}

	public Date getStayDay() {
		return stayDay;
	}

	public void setStayDay(Date stayDay) {
		this.stayDay = stayDay;
	}

	
	
}