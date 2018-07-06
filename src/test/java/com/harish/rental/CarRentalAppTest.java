package com.harish.rental;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class CarRentalAppTest {

	@Test
	public void testMaxVehiclebooking() {
		
		/**
		 * We try to book 6 Vehicles of each type for same start/end date
		 * Since we only have 4 max vehicles last two booking will not happen
		 * on each vehicle type
		 */
		CarRentalApp carRentalAppTest = new CarRentalApp();
		int booking = carRentalAppTest.currentBooking();
		assertEquals(booking,0);
		for (Vehicle vehicle : Vehicle.values()) {
			for (int i = 0; i < 6; i++) {
				carRentalAppTest.bookThisVehicle(vehicle, LocalDate.now().toString(), 2);
			}
		}
		booking = carRentalAppTest.currentBooking();
		assertEquals(booking,12);
		System.out.println("Total booking : " + booking);
		System.out.println("Simple case try to book 6 vehicles of each type from same start/end, PASSED");
	}
	
		
	@Test
	public void testMaxSedanForTenDays() {
		
		/**
		 * We try to book 4 sedans for one day for each subsequent day (upto 10 days)
		 * we should be successful for all booking
		 * on each vehicle type
		 */
		CarRentalApp carRentalAppTest = new CarRentalApp();
		LocalDate today = LocalDate.now();
	    int booking = carRentalAppTest.currentBooking();
		assertEquals(booking,0);
		for(int i=1;i<=10;i++) {
			carRentalAppTest.bookThisVehicle(Vehicle.SEDAN, today.plus(i, ChronoUnit.DAYS).toString(), 1);
			carRentalAppTest.bookThisVehicle(Vehicle.SEDAN, today.plus(i, ChronoUnit.DAYS).toString(), 1);
			carRentalAppTest.bookThisVehicle(Vehicle.SEDAN, today.plus(i, ChronoUnit.DAYS).toString(), 1);
			carRentalAppTest.bookThisVehicle(Vehicle.SEDAN, today.plus(i, ChronoUnit.DAYS).toString(), 1);
		}
		
		booking = carRentalAppTest.currentBooking();
		assertEquals(booking,40);
		boolean booked = carRentalAppTest.bookThisVehicle(Vehicle.SEDAN, today.toString(), 1);
		assertFalse(booked);
		System.out.println("Total booking : " + booking);
		System.out.println("Simple case 4 sedans for one day for each subsequent day (upto 10 days), PASSED");
	    
	    
	}
	
	
	@Test
	public void testMaxSedanForFourdays() {
		/**
		 * We try to book 4 sedans for four days for each subsequent day (upto 5 days)
		 * it will succeed the first time and then fifth day
		 */
		CarRentalApp carRentalAppTest = new CarRentalApp();
		LocalDate today = LocalDate.now();
	    int booking = carRentalAppTest.currentBooking();
		assertEquals(booking,0);
		
		for(int i=0;i<=4;i++) {
			carRentalAppTest.bookThisVehicle(Vehicle.SEDAN, today.plus(i, ChronoUnit.DAYS).toString(), 4);
			carRentalAppTest.bookThisVehicle(Vehicle.SEDAN, today.plus(i, ChronoUnit.DAYS).toString(), 4);
			carRentalAppTest.bookThisVehicle(Vehicle.SEDAN, today.plus(i, ChronoUnit.DAYS).toString(), 4);
			carRentalAppTest.bookThisVehicle(Vehicle.SEDAN, today.plus(i, ChronoUnit.DAYS).toString(), 4);
				
		}
		booking = carRentalAppTest.currentBooking();
		assertEquals(booking,8);
		boolean booked = carRentalAppTest.bookThisVehicle(Vehicle.SEDAN, today.toString(), 2);
		assertFalse(booked);
		
		System.out.println("Simple 4 sedans for four days for each subsequent day (upto 5 days), PASSED");
		
	}

}
