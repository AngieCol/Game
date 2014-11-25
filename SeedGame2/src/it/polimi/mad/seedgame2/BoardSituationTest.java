package it.polimi.mad.seedgame2;

//import static org.junit.Assert.*;
import junit.framework.*;
import org.junit.Test;
//import android.test.AndroidTestCase;
//import android.util.Log;

public class BoardSituationTest extends TestCase{

	
	/**
	 * Players	alternate	turns	
	 * Board Situation 
	 * 
	 */
	
	
	/**
	 * Player doesn't change turns	
	 * Board Situation 
	 * 
	 */
	
	
	
	
	
	/**
	 * The first test consist in:
	 *  1) Initial situation of the Board has to be the following: 
	 *  [0][0]: number of seeds 3, type B2
	 *  [0][1]: number of seeds 3, type B2
	 *  [0][2]: number of seeds 3, type B2
	 *  [0][3]: number of seeds 3, type B2
	 *  [0][4]: number of seeds 3, type B2
	 *  [0][5]: number of seeds 3, type B2
	 *  
	 *  [2][0]: number of seeds 3, type B1
	 *  [2][1]: number of seeds 3, type B1
	 *  [2][2]: number of seeds 3, type B1
	 *  [2][3]: number of seeds 3, type B1
	 *  [2][4]: number of seeds 3, type B1
	 *  [2][5]: number of seeds 3, type B1
	 *  
	 *  [1][0]: number of seeds 0, type T2
	 *  [1][5]: number of seeds 0, type T1
	 *  
	 *  2) Player 1 selects Player's 2 Bowls and the system doesn't allow player 1 to play
	 *  
	 *  
	 *  3) player 1 moves in position [2][5] and the final state of the board after play 1 moves has to be the following
	 *  [0][0]: number of seeds 3, type B2
	 *  [0][1]: number of seeds 3, type B2
	 *  [0][2]: number of seeds 3, type B2
	 *  [0][3]: number of seeds 3, type B2
	 *  [0][4]: number of seeds 4, type B2=> The number of seeds changes from 3 to 4
	 *  [0][5]: number of seeds 4, type B2=> The number of seeds changes from 3 to 4
	 *  
	 *  [2][0]: number of seeds 3, type B1
	 *  [2][1]: number of seeds 3, type B1
	 *  [2][2]: number of seeds 3, type B1
	 *  [2][3]: number of seeds 3, type B1
	 *  [2][4]: number of seeds 3, type B1
	 *  [2][5]: number of seeds 0, type B1=> The number of seeds changes to 0 and are distributed on the next positions (counter-clockwise) 
	 *  
	 *  [1][0]: number of seeds 0, type T2
	 *  [1][5]: number of seeds 0, type T1=> The number of seeds changes to 1 
	 *  
	 *  
	 *  2) Player 2 selects a Tray  and the system doesn't allow to play
	 *  
	 *  3) player 2 moves in position [0][2], he/she has the right to play again and the final state of the board has to be:
	 *  [0][0]: number of seeds 4, type B2=> The number of seeds changes from 3 to 4
	 *  [0][1]: number of seeds 4, type B2=> The number of seeds changes from 3 to 4
	 *  [0][2]: number of seeds 0, type B2=> The number of seeds changes to 0 and they are distributed on the next positions (counter-clockwise)
	 *  [0][3]: number of seeds 3, type B2
	 *  [0][4]: number of seeds 4, type B2
	 *  [0][5]: number of seeds 4, type B2
	 *  
	 *  [2][0]: number of seeds 3, type B1
	 *  [2][1]: number of seeds 3, type B1
	 *  [2][2]: number of seeds 3, type B1
	 *  [2][3]: number of seeds 3, type B1
	 *  [2][4]: number of seeds 3, type B1
	 *  [2][5]: number of seeds 0, type B1 
	 *  
	 *  [1][0]: number of seeds 1, type T2=> The number of seeds changes to 1
	 *  [1][5]: number of seeds 0, type T1 
	 *  
	 *  4)Player 2 selects Player's 1 Bowls and the system doesn't allow player 1 to play
	 *  
	 *  5) player 2 moves in position [0][1], the final state of the board has to be:
	 *  [0][0]: number of seeds 5, type B2=> The number of seeds changes from 4 to 5
	 *  [0][1]: number of seeds 0, type B2=> The number of seeds changes to 0 and they are distributed on the next positions (counter-clockwise)
	 *  [0][2]: number of seeds 0, type B2
	 *  [0][3]: number of seeds 3, type B2
	 *  [0][4]: number of seeds 4, type B2
	 *  [0][5]: number of seeds 4, type B2
	 *  
	 *  [2][0]: number of seeds 4, type B1=> The number of seeds changes from 3 to 4
	 *  [2][1]: number of seeds 4, type B1=> The number of seeds changes from 3 to 4
	 *  [2][2]: number of seeds 3, type B1
	 *  [2][3]: number of seeds 3, type B1
	 *  [2][4]: number of seeds 3, type B1
	 *  [2][5]: number of seeds 0, type B1 
	 *  
	 *  [1][0]: number of seeds 2, type T2=> The number of seeds changes from 1 to 2
	 *  [1][5]: number of seeds 0, type T1 
	 *  
	 *  6) player 1 moves in position [2][2], he/she eat the seeds of player 2 (position [0][5] because the last seed was in [2][5] and it was an empty slot)and the final state of the board has to be:
	 *  [0][0]: number of seeds 5, type B2=> The number of seeds changes from 4 to 5
	 *  [0][1]: number of seeds 0, type B2
	 *  [0][2]: number of seeds 0, type B2
	 *  [0][3]: number of seeds 3, type B2
	 *  [0][4]: number of seeds 4, type B2
	 *  [0][5]: number of seeds 0, type B2=> Player 1 take all the seeds
	 *  
	 *  [2][0]: number of seeds 4, type B1
	 *  [2][1]: number of seeds 4, type B1
	 *  [2][2]: number of seeds 0, type B1=> The number of seeds changes to 0 and they are distributed on the next positions (counter-clockwise)
	 *  [2][3]: number of seeds 4, type B1=> The number of seeds changes from 3 to 4
	 *  [2][4]: number of seeds 4, type B1=> The number of seeds changes from 3 to 4
	 *  [2][5]: number of seeds 0, type B1=> It was an empty position, and the last seed arrives here, that's why this seed and the Player's 2 seed of the bowl opposite to	the	empty bowl go to the Player's 1 Tray 
	 *  
	 *  [1][0]: number of seeds 2, type T2
	 *  [1][5]: number of seeds 5, type T1=>  Player 1 take all the seeds (one from [2][5] and 4 from [0][5])
	 *  
	 */
	@Test
	public void testPlayer1Wins() 
	{
		
		BoardSituation b = new BoardSituation();
		
		for(int i=0; i<b.numColumn-1; i++){
			
			assertTrue(b.movement(0,i).equals("This slot belongs to the player 2. "));
			
		}
		
	}
	
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

}
