package it.polimi.mad.seedgame2;

//import static org.junit.Assert.*;
import junit.framework.*;
import org.junit.Test;
//import android.test.AndroidTestCase;
//import android.util.Log;

public class BoardSituationTest extends TestCase{

	
	/**
	 * Correct Default Creation of the Board	
	 * Creation of each slot
	 * 3,3,3,3,3,3 belongs to player's 2 bowls
	 * 3,3,3,3,3,3 belongs to player's 1 bowls
	 * 0  belongs to player's 2 tray
	 * 0  belongs to player's 1 tray
	 * Player 1 has the turn 
	 * Number of seeds are 36
	 */
	@Test
	public void testBoardCreationdefault() 
	{
		BoardSituation b = new BoardSituation();
		
		
		Slot s= b.Board[0][0];
		
		
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==3);
		s= b.Board[0][1];
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==3);
		s= b.Board[0][2];
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==3);
		s= b.Board[0][3];
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==3);
		s= b.Board[0][4];
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==3);
		s= b.Board[0][5];
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==3);
		
		s= b.Board[2][0];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==3);
		s= b.Board[2][1];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==3);
		s= b.Board[2][2];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==3);
		s= b.Board[2][3];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==3);
		s= b.Board[2][4];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==3);
		s= b.Board[2][5];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==3);
		
		
		s= b.Board[1][0];
		assertTrue(s.getType().equals("T2"));
		assertTrue(s.getNumSeed()==3);
		s= b.Board[1][5];
		assertTrue(s.getType().equals("T1"));
		assertTrue(s.getNumSeed()==3);
		
		
		assertTrue(b.getTurno()==1);
		
		assertTrue(b.CountSeedsInBoard()==b.numBoardSeeds);
		
		
	}
	
	/**
	 * Correct Creation of the Board using Parameters	
	 * inputString="1,1,1,1,5,5,2,4,0,0,0,0,10,6,2"
	 * Creation of each slot. 
	 * 1,1,1,1,5,5 belongs to player's 2 bowls
	 * 2,4,0,0,0,0 belongs to player's 1 bowls
	 * 10  belongs to player's 2 tray
	 * 6  belongs to player's 1 tray
	 * Player 2 has the turn 
	 * Number of seeds are 36
	 * 
	 */
	@Test
	public void testBoardCreationParameters() 
	{
		String inputString="1,1,1,1,5,5,2,4,0,0,0,0,10,6,2";
		BoardSituation b = new BoardSituation(inputString);
		
		
		Slot s= b.Board[0][0];
		
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==1);
		s= b.Board[0][1];
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==1);
		s= b.Board[0][2];
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==1);
		s= b.Board[0][3];
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==1);
		s= b.Board[0][4];
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==5);
		s= b.Board[0][5];
		assertTrue(s.getType().equals("B2"));
		assertTrue(s.getNumSeed()==5);
		
		
		s= b.Board[2][0];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==2);
		s= b.Board[2][1];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==4);
		s= b.Board[2][2];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==0);
		s= b.Board[2][3];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==0);
		s= b.Board[2][4];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==0);
		s= b.Board[2][5];
		assertTrue(s.getType().equals("B1"));
		assertTrue(s.getNumSeed()==0);
		
		
		s= b.Board[1][0];
		assertTrue(s.getType().equals("T2"));
		assertTrue(s.getNumSeed()==10);
		s= b.Board[1][5];
		assertTrue(s.getType().equals("T1"));
		assertTrue(s.getNumSeed()==6);
		
		assertTrue(b.getTurno()==2);
		assertTrue(b.CountSeedsInBoard()==b.numBoardSeeds);
	}
	
	/**
	 * The verification of the input text, before the creation of the Board 
	 * using Parameters returns the proper message when the inputString 
	 * is not created properly 
	 * 
	 * - There are more numbers in the input text (The length of the input text must be 15)
	 * - There are less numbers in the input text (The length of the input text must be 15)
	 * - The last number is not a valid player (Must be 1 or 2). 
	 * - The last number is not a valid player (Must be 1 or 2). 
	 * - The input text contains letters.
	 * - The input text contains decimals.
	 * - The input text contains negative numbers
	 * - The total number of seeds in the board is different to 36.
	 */
	
	@Test
	public void testIncorrectInputString() 
	{
		//There are more numbers in the input text (The length of the input text must be 15)
		String inputString="3,3,3,3,3,3,3,3,3,3,3,3,0,0,1";
		Match m=new Match("","","");
		//assertTrue(m.verifyStringInput(inputString).equals(""));
		
		
		
		
		
	}
	
	
	/**
	 * Players	alternate	turns	
	 * Board Situation 
	 * 
	 */
	@Test
	public void testAlternateTurns() 
	{

	}
	
	/**
	 * Player doesn't change turns	(Player1’s	last	seed	drops	in	
	 * his/her	own	tray,	Player 1	moves again)
	 * Board Situation 
	 * 
	 */
	
	/**
	 * Player 1 takes all the	seeds	from	the selected bowl	and	moves
	 * counter-clockwise,	dropping	one	seed	in	each	bowl	or	tray,
	 * except	Player2’s Tray		
	 * Board Situation 
	 * 
	 */
	
	/**
	 * Player 2 takes all the	seeds	from	the selected bowl	and	moves
	 * counter-clockwise,	dropping	one	seed	in	each	bowl	or	tray,
	 * except	Player1’s Tray		
	 * Board Situation 
	 * 
	 */
	

	/**
	 * Player's 1	last	seed	drops	in	an	empty	bowl	of	Player1,
	 * Player1	moves	that	seed	to his/her	Tray	and	also	picks up
	 * all	the	seeds	in	Player's 2	bowl (opposite	to	the	empty	bowl),
	 * and	places	them	all	in	Player’s 1	own	tray	
	 * 
	 */
	
	
	
	/**
	 * Player's 2	last	seed	drops	in	an	empty	bowl	of	Player2,
	 * Player2	moves	that	seed	to his/her	Tray	and	also	picks up
	 * all	the	seeds	in	Player's 1	bowl (opposite	to	the	empty	bowl),
	 * and	places	them	all	in	Player’s 2	own	tray	
	 * 
	 */
	
	/**
	 * The end of the	game (All	the	bowls on	one player's	side	are	
	 * empty. The	remaining	seeds	are	moved	to	the	other player's	tray.
	 * The	winner	is	the	player	with	the	most	seeds.		
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
	
	
	
	
}
