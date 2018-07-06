package com.harish.rental;

import java.time.LocalDate;


public class Booking {
	private Vehicle carType;
	private LocalDate startDate;  
	private LocalDate endDate;

	public Booking(Vehicle carType, LocalDate startDate, LocalDate endDate) {
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String toString() {
		return "Booking [carType=" + carType + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
