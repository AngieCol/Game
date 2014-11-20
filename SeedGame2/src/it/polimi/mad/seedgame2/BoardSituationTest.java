package it.polimi.mad.seedgame2;

//import static org.junit.Assert.*;
import junit.framework.*;
import org.junit.Test;
//import android.test.AndroidTestCase;
//import android.util.Log;

public class BoardSituationTest extends TestCase{

	
	/**
	 * Player 1 plays in player's 2 board
	 */
/*	@Test
	public void testBoardSituation() 
	{
		
		BoardSituation b = new BoardSituation();
		
		for(int i=0; i<b.numColumn-1; i++){
			
			assertTrue(b.movement(0,i).equals("This slot belongs to the player 2. "));
			
		}
		
	}
	*/
	/**
	 * Player 1 plays in player's 2 board
	 */
	@Test
	public void testBoardSituation2() 
	{
		
		BoardSituation b = new BoardSituation();
		Slot s= b.Board[2][0];
		
			
			assertTrue(b.verifyMovement(s).equals(""));
			
		
		
	}
	
	/*
	@Test
	public void testBoardSituation() {
		fail("Not yet implemented");
	}

	@Test
	public void testMovement() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutSeeds() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerifyMovement() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTurno() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTurno() {
		fail("Not yet implemented");
	}
*/
}
