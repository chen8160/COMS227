package lab5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import balloon4.Balloon;

public class BalloonTests {
	private Balloon a;
	
	@Before
	public void setup(){
		a = new Balloon(5);
	}
	
	@Test
	public void testInitialRadius(){
		assertEquals(0,a.getRadius());
	}
	
	@Test
	public void testInitialPop(){
		assertEquals(false,a.isPopped());
	}
	
	@Test
	public void testBlow(){
		a.blow(3);
		assertEquals(3,a.getRadius());
	}
	@Test
	public void testPopAfterBlow(){
		a.blow(3);
		assertEquals(false,a.isPopped());
	}
	@Test
	public void testPopExceedMax(){
		a.blow(6);
		assertEquals(true,a.isPopped());
	}
	@Test
	public void testRadiusAfterExceedMax(){
		a.blow(6);
		assertEquals(0,a.getRadius());
	}
	@Test
	public void testDeflate(){
		a.blow(3);
		a.deflate();
		assertEquals(0,a.getRadius());
	}
	@Test
	public void testPop(){
		a.blow(3);
		a.pop();
		assertEquals(true,a.isPopped());
	}
	@Test
	public void testRadiusAfterPop(){
		a.blow(3);
		a.pop();
		assertEquals(0,a.getRadius());
	}
	@Test
	public void testBlowMuiltipleTimes(){
		a.blow(1);
		a.blow(3);
		assertEquals(4,a.getRadius());
	}
	@Test
	public void testPopInitialBalloon(){
		a.pop();
		assertEquals(true,a.isPopped());
	}
	@Test
	public void testBlowAfterPop(){
		a.pop();
		a.blow(3);
		assertEquals(0,a.getRadius());
	}
	@Test
	public void testPopAfterdeflate(){
		a.deflate();
		assertEquals(false,a.isPopped());
	}
	
	
}
