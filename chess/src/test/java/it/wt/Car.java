package it.wt;

import java.util.HashMap;
import java.util.Map;


public class Car {
	
	
	private 	int maxSpeed;
	private 	String manufacturer;
	
	
//	 enum WheelPosition {
//			FRONT_LEFT, FRONT_RIGHT, BACK_LEFT, BACK_RIGHT
//		}
	
	
	 Map<WheelPosition, Wheel> wheelMap;

	public Car(String manufacturer, int maxSpeed, Map<WheelPosition, Wheel> wheelMap) {
		this.manufacturer = manufacturer;
		this.maxSpeed =maxSpeed;
		this.wheelMap = wheelMap;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public String getManufacturer() {
		return manufacturer;
	}

//	innerclass Wheel
//	consturtor set weheelPos
}
