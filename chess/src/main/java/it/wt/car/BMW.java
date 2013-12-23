/**
 * 
 */
package it.wt.car;

import java.util.Map;

/**
 * @author kurs
 *
 */
public class BMW extends Car {

	public BMW(int maxSpeed, Map<WheelPosition, Wheel> wheelMap) {
		super("BMW", maxSpeed,wheelMap );
		System.out.println("BMW erschaffen mit " + this.getMaxSpeed() +" km/h maximal Geschwindigkeit");
	}

	
	
}
