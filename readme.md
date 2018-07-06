# A Car Rental System

Main classes
- CarRentalApp : main class (this class could be re-factored into a RestController later)
- CarBookingService : service class that has a Map of current bookings. This class has the main method
- Booking : An entity class to hold details of a vehicle booking (vehicleType, startDate,endDate)
- Vehicle : An Enum type with methods to convert int to Enum if needed.

## Tools
- Eclipse Photon
- Java 8
- gradle 4.8.1

## Building and running
- Unzaip the code.
- open command prompt inside the folder that was unzipped (HPCarRental)
- run "gradle build -info"  this will build and run the Jnits

