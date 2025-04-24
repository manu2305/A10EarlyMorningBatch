package Basic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Doremon {
   
	@DataProvider(name ="sizuka")
	@Test
	public void Nobita() {
		System.out.println("hello this is nobita");
	}
}
