# A Car Rental System

Main classes
- CarRentalApp : main class (this class could be re-factored into a RestController later)
- CarBookingService : service class that has a Map of current bookings
- Booking : An entity class to hold details of a vehicle booking (vehicleType, startDate,endDate)
- Vehicle : An Enum type with methods to convert int to Enum if needed.