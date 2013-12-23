/**
 * 
 */
package it.wt.car;

import static org.junit.Assert.*;


import it.wt.car.BMW;
import it.wt.car.Car;
import it.wt.car.Wheel;
import it.wt.car.WheelPosition;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author kurs
 *
 */
public class CarTest {
	
			
	@Test
	public void testCar() {
		Map<WheelPosition, Wheel> wheelMap =  getWheelMap();
		Car myCar = new Car("bmw", 210, wheelMap);
	}
	

	@Test
	public void testBMW() {

		Map<WheelPosition, Wheel> wheelMap =  getWheelMap();
		
		Car myBmw = new BMW(210, wheelMap);
	}
	
	private Map<WheelPosition, Wheel> getWheelMap() {
		Wheel perelly = new Wheel();
		Map<WheelPosition, Wheel> wheelMap = new HashMap<WheelPosition, Wheel>() ;
		
			
		
		for (WheelPosition pos : WheelPosition.values()) {
			wheelMap.put (pos, perelly);
		}
		
//		wheelMap.put (   WheelPosition.FRONT_LEFT, perelly  );
//		wheelMap.put (   WheelPosition.FRONT_RIGHT, perelly  );
//		wheelMap.put (   WheelPosition.BACK_LEFT, perelly  );
//		wheelMap.put (   WheelPosition.BACK_LEFT, perelly  );
		return wheelMap;
	}
	

}
