package com.harish.rental;

import java.util.HashMap;
import java.util.Map;

public enum Vehicle {

	SEDAN(1),
	SUV(2),
	VAN(3);
	
	
	private static int maxAvailableSuvs = 4;
	private static int maxAvailableSedans = 4;
	private static int maxAvailableVans = 4;
	
	private int value;
    private static Map<Integer,Vehicle> map = new HashMap<Integer, Vehicle>();

    private Vehicle(int value) {
        this.value = value;
    }

    static {
        for (Vehicle vehicleType : Vehicle.values()) {
            map.put(vehicleType.value, vehicleType);
        }
    }
	public static int getMaxAvailableSUVs() {
		return maxAvailableSuvs;
	}
	public static int getMaxAvailableSedans() {
		return maxAvailableSedans;
	}
	public static int getMaxAvailableVans() {
		return maxAvailableVans;
	}
	
	public static int getMaxAvailableVehicles(Vehicle vehicle){
		int max = 0;
		switch (vehicle)
	    {
	    	case SEDAN:{
	    		max = maxAvailableSedans;
	    		break;
	    	}
	    		
	    	case SUV: {
	    		max = maxAvailableSuvs;
	    		break;
	    	}
	    		
	    	case VAN:{
	    		max = maxAvailableVans;
	    		break;
	    	}
	    }
		return max;
	}
	
	public static Vehicle valueOf(int vehicle) {
        return (Vehicle) map.get(vehicle);
    }

    public int getValue() {
        return value;
    }
}
