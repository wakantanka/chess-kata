
public class Process {

	public static void main(String[] str){
		Thread t = new Thread( new OwnCommand() );
		t.setName("TextProzess");
		t.start();
		System.out.println("In der Main-Methode");
	}
	
}

class OwnCommand implements Runnable
{
  @Override public void run()
  {
	  System.out.println("In dem OwnCommand");
	  
  }
}


