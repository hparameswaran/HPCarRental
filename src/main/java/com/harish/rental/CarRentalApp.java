package com.harish.rental;

import java.text.ParseException;



public class CarRentalApp {
	
	
	
	private CarBookingService carBookingService;

	public static void main(String[] args) {
		System.out.println("Welcome to Car Retal Company");
		new CarRentalApp();
	}

	public CarRentalApp() {
		carBookingService = new CarBookingService();

		// Check some scenarios  - moved to junit
		//checkMaxVehiclesBooking();

	}

	public boolean bookThisVehicle(Vehicle vehicle, String startDate, int numOfDays) {
		boolean booked = false;
		try {

			if (carBookingService.bookCar(vehicle, startDate, numOfDays)) {
				System.out.println("Booked: " + vehicle + " From: " + startDate + " Days:" + numOfDays);
				booked = true;
			} else {
				System.out.println("Not Available : " + vehicle + " From: " + startDate + " Days:" + numOfDays);
			}

		} catch (ParseException e) {

			e.printStackTrace();
		}
		return booked;
	}
    
	public int  currentBooking() {
		return carBookingService.printCurrentBooking();
	}
	
	
	

}
