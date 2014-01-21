
public class ExceptionExercise {

	public static void main(String[] str) {
		ExceptionExercise exceptionExercise = new ExceptionExercise();
		try {
			//exceptionExercise = null;
			exceptionExercise.showText("Text");
			exceptionExercise.showText(1);
		} catch (NoStringException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Exception nicht abgefangen");
		}
	}

	public void showText(Object o) throws NoStringException {
		if (o instanceof String) {
			String s = (String) o;
			System.out.println(s);
			return;
		}

		throw new NoStringException("Dies war kein String");

	}
}
