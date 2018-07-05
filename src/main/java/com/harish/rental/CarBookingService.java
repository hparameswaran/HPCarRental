package com.harish.rental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarBookingService {

	private EnumMap<Vehicle, List<Booking>> currentBooking = new EnumMap<Vehicle, List<Booking>>(Vehicle.class);

	public CarBookingService() {
		for (Vehicle vehicleType : Vehicle.values()) {
			currentBooking.put(vehicleType, new CopyOnWriteArrayList<Booking>());
		}
	}

	public synchronized boolean bookCar(Vehicle vehicle, String fromDate, int numberOfDays) throws ParseException {
		boolean bookingDone = false;

		Date startDate = convertStringToDate(fromDate);
		Date endDate = getEndDate(startDate, numberOfDays);
		// Check if there are any cars of the type available for that day and if so book
		// it
		if (checkAvailability(vehicle, fromDate, numberOfDays) > 0) {
			currentBooking.get(vehicle).add(new Booking(vehicle, startDate, endDate));
			bookingDone = true;
		}

		return bookingDone;
	}

	public int checkAvailability(Vehicle vehicle, String bookingDate, int days) throws ParseException {

		int maxAvailableVehicles = Vehicle.getMaxAvailableVehicles(vehicle);
		Date checkStartDate = convertStringToDate(bookingDate);
		Date checkEndDate = getEndDate(checkStartDate, days);
		for (Booking booking : currentBooking.get(vehicle)) {
			if (booking.getCarType().equals(vehicle)) {
				// If start date or end date is within the bookings start date or end date then
				// reduce max available vehicle by 1
				if (checkIfDateCollides(booking, checkStartDate) || checkIfDateCollides(booking, checkEndDate)) {
					--maxAvailableVehicles;
				}

			}
		}
		return maxAvailableVehicles;
	}

	private boolean checkIfDateCollides(Booking booking, Date checkDate) {
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

	private Date convertStringToDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date convDate = (Date) sdf.parse(date);
		return convDate;
	}

	private Date getEndDate(Date startDate, int numberOfDays) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.DATE, numberOfDays);
		Date endDate = calendar.getTime();
		return endDate;
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
