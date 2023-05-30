package KomalTestNGPractices;


import org.testng.annotations.Test;

public class TestDependencies {
	static String TrackNumber =  null;

	@Test(priority=1)
	public void CreateShipment() {
		System.out.println("CreateShipment");
		TrackNumber="ASDRTVGH45";
	}
	
	@Test(priority=2)
	public void TrackShipment() throws Exception {
		if (TrackNumber!=null)
		System.out.println("TrackShipment");
		
		else 
			throw  new Exception ("Invalid tracking Number");
	}

	@Test(priority=3)
	public void CancelShipment() throws Exception {
		if (TrackNumber!=null)
			System.out.println("CancelShipment");

			else 
				throw  new Exception ("Invalid tracking Number");
	}


}
