package it.polimi.mad.seedgame2;


import junit.framework.*;
import org.junit.Test;
import android.test.AndroidTestCase;
import android.util.Log;

public class GameSeedTests extends TestCase{

	
	//===========================================================================================
	//===========================================================================================
	// 1.	Creation of Board
	//===========================================================================================
	//===========================================================================================
	
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
	public void testBoardCreationDefault() 
	{
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testBoardCreationDefault"+"..........");
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
		assertTrue(s.getNumSeed()==0);
		s= b.Board[1][5];
		assertTrue(s.getType().equals("T1"));
		assertTrue(s.getNumSeed()==0);
		
		
		assertTrue(b.getTurno()==1);
		
		assertTrue(b.CountSeedsInBoard()==b.getNumBoardSeeds());
		
		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
		
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
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testBoardCreationParameters"+"++++++++++++");
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
		assertTrue(b.CountSeedsInBoard()==b.getNumBoardSeeds());
		
		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
		
	}
	
	/**
	 * The verification of the input text, before the creation of the Board 
	 * using Parameters returns the proper message when the inputString 
	 * is not created properly 
	 * 
	 * - There are more numbers in the input text (The length of the input text must be 15)
	 * - There are less numbers in the input text (The length of the input text must be 15)
	 * - The last number is not a valid player (Must be 1 or 2). 
	 * - The input text contains letters.
	 * - The input text contains decimals.
	 * - The input text contains negative numbers
	 * - The total number of seeds in the board is different to 36.
	 * - The input text contains letters, negative numbers, an invalid player(turn) and total number of seeds in the board is different to 36
	 */
	
	@Test
	public void testIncorrectInputString() 
	{
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testIncorrectInputString"+"++++++++++++");
		
		Match m=new Match("","","");
		String inputString="";
		
		//There are more numbers in the input text (The length of the input text must be 15)
		inputString="3,3,3,3,3,3,3,3,3,3,3,3,0,0,0,0,1";
		assertTrue(m.verifyStringInput(inputString).equals("The number of integers separated by comma has to be 15. "));
		
		
		//There are less numbers in the input text (The length of the input text must be 15)
		inputString="3,3,3,3,3,3,2,16,1";
		assertTrue(m.verifyStringInput(inputString).equals("The number of integers separated by comma has to be 15. "));
		
		//The last number is not a valid player (Must be 1 or 2). 
		inputString="3,3,3,3,3,3,3,3,3,3,3,3,0,0,9";
		assertTrue(m.verifyStringInput(inputString).equals("The last number must be 1 or 2 because it is the current player. "));
			
		
		//The input text contains letters.
		inputString="3,3,3,3,t,6,3,3,3,3,3,3,0,0,1";
		assertTrue(m.verifyStringInput(inputString).equals("The input text cannot include letters or decimal numbers, it must be integer numbers, greater than 0, separated by comma. "));
				
		//The input text contains decimals.
		inputString="3,3,3,6,3.8,3,3,3,3,3,3,3,0,0,1";
		assertTrue(m.verifyStringInput(inputString).equals("The input text cannot include letters or decimal numbers, it must be integer numbers, greater than 0, separated by comma. "));
				
		//The input text contains negative numbers
		inputString="3,3,3,3,3,6,10,3,-7,3,3,3,0,0,1";
		assertTrue(m.verifyStringInput(inputString).equals("The input text must be integer numbers, greater than 0, separated by comma. "));
	    
		//The total number of seeds in the board is different to 36.
		inputString="3,3,3,3,3,3,3,3,3,3,3,3,3,3,1";
		assertTrue(m.verifyStringInput(inputString).equals("The total number of seeds in the board has to be 36. "));
		
				
		//The input text contains negative numbers
		inputString="3,3,3,3,3,6,10,3,-7,3,3,3,0,0,1";
		assertTrue(m.verifyStringInput(inputString).equals("The input text must be integer numbers, greater than 0, separated by comma. "));
			    
		
		//The input text contains letters, negative numbers, an invalid player(turn) and total number of seeds in the board is different to 36
		inputString="3,3,3,3,3,3,3,3,p,3,3,3,0,0,-7";
		assertTrue(m.verifyStringInput(inputString).equals("The last number must be 1 or 2 because it is the current player. "+"The input text cannot include letters or decimal numbers, it must be integer numbers, greater than 0, separated by comma. "+"The input text must be integer numbers, greater than 0, separated by comma. "+"The total number of seeds in the board has to be 36. "));
			    
		
		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
		
	}
	


	
	//===========================================================================================
	//===========================================================================================
	// 2.	Movement
	//===========================================================================================
	//===========================================================================================
	

	
	
	/**
	 * Player 2 begins. Players	alternate turns.	
	 * After Player's 2 movement is the turn of player 1.
	 * The movement of player 2 doesn't finish on an empty slot, neither in a tray
	 * 
	 */
	@Test
	public void testAlternateTurns() 
	{
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testAlternateTurns"+"++++++++++++");
		
		
		//Create a initial situation
		String inputString="1,1,1,1,4,4,2,4,1,1,1,1,10,4,2";
		BoardSituation b = new BoardSituation(inputString);
		
		//Player 2 plays 
		b.movement(0,5);
		
		//The turn is for Player 1 
		assertTrue(b.getTurno()==1);
		
		
		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
	
	}
	
	
	/**
	 * Player 1 begins. Player 1 plays two times (Player1’s	last	seed	drops	in	
	 * his/her	own	tray, then Player 1	moves again)
	 * 
	 */
	
	@Test
	public void testKeepsTurn() 
	{
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testKeepsTurn"+"++++++++++++");
		
		
		//Create a initial situation
		String inputString="1,1,1,1,4,2,2,4,1,3,1,1,10,4,1";
		BoardSituation b = new BoardSituation(inputString);
		
		//The turn is for Player 1 
		assertTrue(b.getTurno()==1);
		
		//Player 1 plays 
		b.movement(2,3);
		
		//The turn is still for Player 1 
		assertTrue(b.getTurno()==1);
		
		

		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
		
	}
	
	
	
	/**
	 * Player 1 begins. Player 1 takes all the	seeds	from	the selected bowl	and	moves 
	 * counter-clockwise, dropping	one	seed	in	each	bowl	or	tray, except	Player2’s 
	 * Tray. Player 1 moves normally (Without eating seeds or repeating turn). The seeds of 
	 * the selected bowl are enough to arrive in player's 2 Tray, but Player 1 doesn't leave seeds 
	 * there). 
	 * 	
	 *  
	 */
	
	@Test
	public void testNormalMoveP1() 
	{
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testNormalMoveP1"+"++++++++++++");
		
		
		//Create a initial situation
		String inputString="2,2,2,2,2,2,2,2,2,2,10,2,3,1,1";
		BoardSituation b = new BoardSituation(inputString);
		
		//The turn is for Player 1 
		assertTrue(b.getTurno()==1);
		
		//Player 1 plays 
		b.movement(2,4);
		
		//The turn is now for Player 2 
		assertTrue(b.getTurno()==2);
		
		
		//Player's 1 bowls has to be 0, because it's the selected bowl
		Slot s= b.Board[2][4];
		assertTrue(s.getNumSeed()==0);
		
		//Player's 2 tray have the same number of seeds as before (3)
		s= b.Board[1][0];
		assertTrue(s.getNumSeed()==3);
		
		
		//Player's 1 bowl in position [2][1] also has to change (increment 1) to 3 because no seed was dropped in player's 2 tray
		s= b.Board[2][1];
		assertTrue(s.getNumSeed()==3);
		
		//Player's 1 bowl in position [2][2] has to be the same (2 seeds) because thrown seeds were only 10
		s= b.Board[2][2];
		assertTrue(s.getNumSeed()==2);
		
		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
		
	}
	
	
	
	
	
	/**
	 * Player 2 begins. Player 2 takes all the	seeds	from	the selected bowl	and	moves 
	 * counter-clockwise, dropping	one	seed	in	each	bowl	or	tray, except	Player1’s 
	 * Tray. Player 2 moves normally (Without eating seeds or repeating turn). The seeds of 
	 * the selected bowl are enough to arrive in player's 1 Tray, but Player 2 doesn't leave seeds 
	 * there).
	 * 
	 */
	@Test
	public void testNormalMoveP2() 
	{
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testNormalMoveP2"+"++++++++++++");
		
		
		//Create a initial situation
		String inputString="2,2,10,2,2,2,2,2,2,2,2,2,3,1,2";
		BoardSituation b = new BoardSituation(inputString);
		
		//The turn is for Player 2 
		assertTrue(b.getTurno()==2);
		
		//Player 2 plays 
		b.movement(0,2);
		
		//The turn is now for Player 1 
		assertTrue(b.getTurno()==1);
		
		
		//Player's 2 bowls has to be 0, because it's the selected bowl
		Slot s= b.Board[0][2];
		assertTrue(s.getNumSeed()==0);
		
		//Player's 1 tray have the same number of seeds as before (1)
		s= b.Board[1][5];
		assertTrue(s.getNumSeed()==1);
		
		
		//Player's 2 bowl in position [0][5] also has to change (increment 1) to 3 because no seed was dropped in player's 1 tray
		s= b.Board[0][5];
		assertTrue(s.getNumSeed()==3);
		
		//Player's 2 bowl in position [0][4] has to be the same (2 seeds) because thrown seeds were only 10
		s= b.Board[0][4];
		assertTrue(s.getNumSeed()==2);
		
		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
		
	}
	
	
	/**
	 * Player 1 begins. Player's 1	last	seed	drops	in	an	empty	bowl	of	Player2, 
	 * but Player1 doesn't eat any seed (Player 1 only eats if the last	seed	dropped	is in	
	 * an	empty bowl belonging to the	Player1)
	 * 
	 */
	
	@Test
	public void testP1DoesNotEatSeedsOfP2() 
	{
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testP1DoesNotEatSeedsOfP2"+"..........");
		
		
		//Create a initial situation
		String inputString="2,2,2,0,0,0,2,2,2,5,2,2,4,11,1";
		BoardSituation b = new BoardSituation(inputString);
		
		//The turn is for Player 1 
		assertTrue(b.getTurno()==1);
		
		//Player 1 plays 
		b.movement(2,3);
		
		//The turn is now for Player 2 
		assertTrue(b.getTurno()==2);
		
		//Player's 1 bowls has to be 0, because it's the selected bowl
		Slot s= b.Board[2][3];
		assertTrue(s.getNumSeed()==0);
		
		//Player's 1 tray only have one seed more (It had 11, now 12)
		s= b.Board[1][5];
		assertTrue(s.getNumSeed()==12);
		
		
		//Player's 2 bowl at position [0][4] is 1, not 0 (because this seed wasn't eaten by player 1)
		s= b.Board[0][4];
		assertTrue(s.getNumSeed()==1);
		
		
		//Player's 1 bowl at position [2][4] is 3, not 0 (because this seed wasn't eaten by player 1)
		s= b.Board[2][4];
		assertTrue(s.getNumSeed()==3);
		
		
		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
		
		
	}
	
	/**
	 * Player 2 begins. Player's 2	last	seed	drops	in	an	empty	bowl	of	Player1, 
	 * but Player2 doesn't eat any seed (Player 2 only eats if the last	seed	dropped	is in	
	 * an	empty bowl belonging to the	Player2)
	 * 
	 */
	
	@Test
	public void testP2DoesNotEatSeedsOfP1() 
	{
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testP2DoesNotEatSeedsOfP1"+"..........");
		
		
		//Create a initial situation
		String inputString="2,2,5,2,2,2,0,0,0,2,2,2,4,11,2";
		BoardSituation b = new BoardSituation(inputString);
		
		//The turn is for Player 2 
		assertTrue(b.getTurno()==2);
		
		//Player 2 plays 
		b.movement(0,2);
		
		//The turn is now for Player 1 
		assertTrue(b.getTurno()==1);
		
		//Player's 2 bowls has to be 0, because it's the selected bowl
		Slot s= b.Board[0][2];
		assertTrue(s.getNumSeed()==0);
		
		//Player's 2 tray only have one seed more (It had 4, now 5)
		s= b.Board[1][0];
		assertTrue(s.getNumSeed()==5);
		
		
		//Player's 2 Slot at position [0][1] is 3, not 2 (because this seed wasn't eaten by player 2)
		s= b.Board[0][1];
		assertTrue(s.getNumSeed()==3);
		
		
		//Player's 1 Slot at position [2][1] is 1, not 0 (because this seed wasn't eaten by player 2)
		s= b.Board[2][1];
		assertTrue(s.getNumSeed()==1);
		
		
		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
		
		
	}
	

	/**
	 * Player 1 begins. Player's 1	last	seed	drops	in	an	empty	bowl	of	Player1,
	 * Player1	moves	that	seed	to his/her	Tray	and	also	picks up all	the	seeds
	 * in	Player's 2	bowl (opposite	to	the	empty	bowl), and	places	them	all	in	
	 * Player’s 1	own	tray	
	 * 
	 */
	
	@Test
	public void testEatSeedsP1() 
	{
		
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testEatSeedsP1"+"..........");
		
		
		//Create a initial situation
		String inputString="2,2,5,2,2,2,2,0,2,0,0,2,4,11,1";
		BoardSituation b = new BoardSituation(inputString);
		
		//The turn is for Player 1 
		assertTrue(b.getTurno()==1);
		
		//Player 1 plays 
		b.movement(2,2);
		
		//The turn is now for Player 2 
		assertTrue(b.getTurno()==2);
		
		//Player's 2 bowls has to be 0, because it's the selected bowl
		Slot s= b.Board[2][2];
		assertTrue(s.getNumSeed()==0);
		
		//Player's 1 ate the seeds of player2 of the position [0][4] and the own seed of position [2][4] 
		//Player's 1 had 11 seeds on his/her tray, now he/her has 14
		s= b.Board[1][5];
		assertTrue(s.getNumSeed()==14);
		
		
		//Player's 2 Slot at position [0][4] is now empty
		s= b.Board[0][4];
		assertTrue(s.getNumSeed()==0);
		
		
		//Player's 1 Slot at position [2][4] is now empty
		s= b.Board[2][4];
		assertTrue(s.getNumSeed()==0);
		
		
		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
		
		
	
	}
	
	
	
	
	/**
	 * Player 2 begins. Player's 2	last	seed	drops	in	an	empty	bowl	of	Player2,
	 * Player2	moves	that	seed	to his/her	Tray	and	also	picks up all	the	seeds
	 * in	Player's 1	bowl (opposite	to	the	empty	bowl), and	places	them	all	in	Player’s 2	
	 * own	tray. SPECIAL CASE of the rule when the opponent doesn't have seeds in that positions	
	 * 
	 */
	
	@Test
	public void testEatSeedsP2SpecialCase() 
	{
		
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testEatSeedsP2SpecialCase"+"..........");
		
		
		//Create a initial situation
		String inputString="2,2,5,0,2,2,2,0,2,0,0,2,10,7,2";
		BoardSituation b = new BoardSituation(inputString);
		
		//The turn is for Player 2 
		assertTrue(b.getTurno()==2);
		
		//Player 2 plays 
		b.movement(0,5);
		
		//The turn is now for Player 1 
		assertTrue(b.getTurno()==1);
		
		//Player's 2 bowls has to be 0, because it's the selected bowl
		Slot s= b.Board[0][5];
		assertTrue(s.getNumSeed()==0);
		
		//Player's 2 ate the seeds of player1 of the position [2][3] (The bowl was empty)
		//Player's 2 ate his/her own seed of position [0][3] 
		//Player's 2 had 10 seeds on his/her tray, now he/her has 11
		s= b.Board[1][0];
		assertTrue(s.getNumSeed()==11);
		
		
		//Player's 1 Slot at position [2][3] is still empty
		s= b.Board[2][3];
		assertTrue(s.getNumSeed()==0);
		
		
		//Player's 2 Slot at position [0][3] is now empty
		s= b.Board[0][3];
		assertTrue(s.getNumSeed()==0);
		
		
		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
		
		
	
	}
	
	
	/**
	 * The end of the	game (All	the	bowls on	one player's	side	are	
	 * empty. The	remaining	seeds	are	moved	to	the	other player's	tray.
	 * The	winner	is	the	player	with	the	most	seeds.		
	 */
	

	
	@Test
	public void testVerifyIfGameEnds() 
	{
		
		Log.v("GameConsola", "**************************************************");
		Log.v("GameConsola", ".........."+"testVerifyIfGameEnds"+"..........");
		
		
		//Create a initial situation
		String inputString="0,0,0,0,0,0,2,2,2,2,2,2,18,6,2";
		BoardSituation b = new BoardSituation(inputString);
		
		//The turn is for Player 2 
		assertTrue(b.getTurno()==2);
		
		b.movement(2, 2);
		
		Boolean bo=b.verifyWin();
		Log.e("GameConsola", bo+"");
		
		
		
		
		/*//Player 2 plays 
		b.movement(0,5);
		
		//The turn is now for Player 1 
		assertTrue(b.getTurno()==1);
		
		//Player's 2 bowls has to be 0, because it's the selected bowl
		Slot s= b.Board[0][5];
		assertTrue(s.getNumSeed()==0);
		
		//Player's 2 ate the seeds of player1 of the position [2][3] (The bowl was empty)
		//Player's 2 ate his/her own seed of position [0][3] 
		//Player's 2 had 10 seeds on his/her tray, now he/her has 11
		s= b.Board[1][0];
		assertTrue(s.getNumSeed()==11);
		
		
		//Player's 1 Slot at position [2][3] is still empty
		s= b.Board[2][3];
		assertTrue(s.getNumSeed()==0);
		
		
		//Player's 2 Slot at position [0][3] is now empty
		s= b.Board[0][3];
		assertTrue(s.getNumSeed()==0);
		
		
		Log.v("GameConsola", "***************************************");
		Log.v("GameConsola", "+++++++++++++++++++++++++++++++++++++++");
		Log.v("GameConsola", "                                        ");
		
		*/
	
	}
	
	
	
}
