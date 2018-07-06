package com.harish.rental;

import java.text.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.EnumMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarBookingService {

	private EnumMap<Vehicle, List<Booking>> currentBooking = new EnumMap<Vehicle, List<Booking>>(Vehicle.class);
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-mm-dd");
    
	public CarBookingService() {
		//Create a HashMap with List for each type of vehicle.
		for (Vehicle vehicleType : Vehicle.values()) {
			currentBooking.put(vehicleType, new CopyOnWriteArrayList<Booking>());
		}
	}
    
	
   /**
   * This method is used to book a Vehicle
   * the method inside locks on the list of booking of 
   * the particular vehicle type that it is booking
   * @param vehicle Vehicle type Enum
   * @param fromDate  This is the start date of booking
   * @param fromDate  This is the date when this vehicle will be available for next booking
   * @return boolean If booking happened then returns true otherwise returns false
   */
	public  boolean bookCar(Vehicle vehicle, String fromDate, int numberOfDays) throws ParseException {
		
		int maxAvailableVehicles = Vehicle.getMaxAvailableVehicles(vehicle);
		//We synchronize on the List of Booking of that particular type of Vehicle
		synchronized(currentBooking.get(vehicle)) {
			LocalDate startDate = LocalDate.parse(fromDate);  //"yyyy-mm-dd" is default format of LocalDate class
			LocalDate endDate = startDate.plus(numberOfDays, ChronoUnit.DAYS);
			// Check if there are any cars of the type available for that day and if so book it
			if (checkAvailability(currentBooking.get(vehicle), startDate, endDate,maxAvailableVehicles) > 0) {
				currentBooking.get(vehicle).add(new Booking(vehicle, startDate, endDate));
				return true;
			}else {
				return false;
			}
		}
	}

	private int checkAvailability(List<Booking> bookings, LocalDate fromDate, LocalDate endDate, int maxAvailableVehicle) throws ParseException {

		int availableVehicles = maxAvailableVehicle;
		for (Booking booking : bookings) {
			// If start date or end date is within the bookings start date or end date then
			// reduce max available vehicle by 1
			if (checkIfDateCollides(booking, fromDate) || checkIfDateCollides(booking, endDate)) {
				--availableVehicles;
			}
		}
		return availableVehicles;
	}

	private boolean checkIfDateCollides(Booking booking, LocalDate checkDate) {
		boolean collides = false;
		//Start date is included in booking. end date is 
		if (booking.getStartDate().compareTo(checkDate) <= 0) {
			if (booking.getEndDate().compareTo(checkDate) > 0) {
				// this means the checkDate is
				collides = true;
			}
		}
		return collides;
	}

	public int printCurrentBooking() {
		int count = 0;
		for (Vehicle key : currentBooking.keySet()) {
			for (Booking booking : currentBooking.get(key)) {
				System.out.println(++count + ":" + booking);
			}
		}
		return count;
	}
}
