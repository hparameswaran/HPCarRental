package com.harish.rental;

import java.util.Date;

public class Booking {
	private Vehicle carType;
	private Date startDate;
	private Date endDate;
	
	
	public Booking(Vehicle carType, Date startDate, Date endDate) {
		super();
		this.carType = carType;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Vehicle getCarType() {
		return carType;
	}
	public void setCarType(Vehicle carType) {
		this.carType = carType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String toString() {
		return "Booking [carType=" + carType + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
}
