/**
 * 
 */
package it.wt;

import static org.junit.Assert.*;

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
		wheelMap.put (   WheelPosition.FRONT_LEFT, perelly  );
		wheelMap.put (   WheelPosition.FRONT_RIGHT, perelly  );
		wheelMap.put (   WheelPosition.BACK_LEFT, perelly  );
		wheelMap.put (   WheelPosition.BACK_LEFT, perelly  );
		return wheelMap;
	}
	

}
