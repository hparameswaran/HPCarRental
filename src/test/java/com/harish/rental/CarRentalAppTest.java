package com.harish.rental;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class CarRentalAppTest {

	@Test
	public void testSimpleCase1() {
		
		
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
	
	}
	
		
	@Test
	public void testSimpleCase2() {
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
	    
	    
	}
	
	
	@Test
	public void testSimpleCase3() {
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
		
		
	}

}
