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
		
		//Check some scenarios
		checkMaxVehiclesBooking();

	}

	private void bookThisVehicle(Vehicle vehicle, String startDate,
			int numOfDays) {
		try {

			if (carBookingService.bookCar(vehicle, startDate, numOfDays)) {
				System.out.println("Booked: " + vehicle + " From: " + startDate + " Days:" + numOfDays);
			} else {
				System.out.println("Not Available : " + vehicle + " From: " + startDate + " Days:" + numOfDays);
			}

		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

    private void checkMaxVehiclesBooking(){
    	System.out.println("Try booking ");
    	carBookingService.printCurrentBooking();
    	for (Vehicle vehicle: Vehicle.values()){
	    	for (int i = 0; i < 6; i++) {
				bookThisVehicle(vehicle, "07/01/2018", 2);
			}
    	}
       	int total = carBookingService.printCurrentBooking();
       	System.out.println("Total booking : " + total);
    }


}
