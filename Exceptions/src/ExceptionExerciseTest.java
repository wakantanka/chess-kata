import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.swing.JPanel;

import org.junit.Test;

public class ExceptionExerciseTest {

	@Test(expected = ExerciseException.class)
	public void testTrowExerciseException() throws ExerciseException {
		String myStr = "doof";
		JPanel myNotStr = new JPanel();
		showText(myStr);
		showText(myNotStr);
	}

	@Test
	public void testExerciseExceptionMsg() {
		JPanel myNotStr = new JPanel();
		try {
			showText(myNotStr);
		} catch (ExerciseException e) {

			System.out.println(e.getMessage());
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullPointerExceptionErrorProv() throws ExerciseException {
			showText(null);
	}
	
	@Test(expected = ClassCastException.class)
	public void testClassCastExceptionErrorProv()  {
		Object myNotStr = new JPanel();
		String string = (String) myNotStr;
	
	}
	
	
	@Test 
	public void testNullPointerExceptionErrorProv2() throws ExerciseException {
			
		try {
			showText(null);
			fail();
		} catch (NullPointerException e) {
				assertTrue(true);
				System.out.println("fange NPE");
		} catch (Exception e){
		   fail();
		}
			
	}


	void showText(Object myObj) throws ExerciseException {
		 myObj.equals(myObj);
		try {
			System.out.println((String) myObj);
		} catch (ClassCastException e) {
			throw new ExerciseException();
			// e.printStackTrace();
		}

	}

}
