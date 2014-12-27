package it.polimi.mad.seedgame2;



import java.util.ArrayList;

import android.util.Log;

public class BoardSituation 
{

	/**
	 * variables
	 */
	static int numColumn = 6;
	static int numRow = 3;
	static int numBoardSeeds = 36;


	Slot[][] Board = null;
	int turn=0;
	int currentX=-1;
	int currentY=-1;
	String winner="";
	String OutputString="";
	ArrayList<String> movements = new ArrayList<String>();

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//==================================================================================================
	/////////////////////////////////////////////////////////////////////////////////////////////////////


	/**
	 * Methods
	 */


	/**
	 * BoardSituation Builds the initial Board Situation (Default) 
	 */
	public BoardSituation() 
	{

		Board= new Slot[numRow][numColumn];

		for(int i=0; i<numColumn; i++)
		{
			Board[0][i]=new Slot("B2",3);
			Board[1][i]=new Slot("N",-1);
			Board[2][i]=new Slot("B1",3);		

		}
		Board[1][0]=new Slot("T2",0);
		Board[1][numColumn-1]=new Slot("T1",0);

		setTurn(1);


		paintBoardInConsole("It is the turn of player "+getTurn()+".");
		generateOutputString();
	    movements.add("The game begins. It is the turn of player "+getTurn()+".");

	}


	/**
	 *  BoardSituation Builds the initial Board Situation with parameters
	 */
	public BoardSituation(String input) 
	{

		String[] inputSplited= input.split(",");

		Board= new Slot[numRow][numColumn];

		for(int i=0, j=6; i<numColumn; i++, j++)
		{
			Board[0][i]=new Slot("B2",Integer.parseInt(inputSplited[i]));
			Board[1][i]=new Slot("N",-1);
			Board[2][i]=new Slot("B1",Integer.parseInt(inputSplited[j]));		

		}
		Board[1][0]=new Slot("T2",Integer.parseInt(inputSplited[12]));
		Board[1][numColumn-1]=new Slot("T1",Integer.parseInt(inputSplited[13]));

		setTurn(Integer.parseInt(inputSplited[14]));

		paintBoardInConsole("It is the turn of player "+getTurn()+".");
		generateOutputString();
		movements.add("The game begins. It is the turn of player "+getTurn()+".");

	}


	/**
	 * paintBoardInConsole Displays the Board on the console
	 */
	public void paintBoardInConsole(String s) {



		Log.v("GameConsola", "                -----                         ");
		Log.w("GameConsola", s+" ");
		//	Log.w("GameConsola",getHistory()+" ");
		Log.w("GameConsola", " | "+ Board[0][0].getNumSeed()+" | "+ Board[0][1].getNumSeed()+" | "+ Board[0][2].getNumSeed()+" | "+  Board[0][3].getNumSeed()+" | "+  Board[0][4].getNumSeed()+" | "+  Board[0][5].getNumSeed()+" | " );
		Log.d("GameConsola", " | "+ Board[1][0].getNumSeed()+" | ============= | " + Board[1][5].getNumSeed()+" | " );
		Log.e("GameConsola", " | "+ Board[2][0].getNumSeed()+" | "+ Board[2][1].getNumSeed()+" | "+ Board[2][2].getNumSeed()+" | "+  Board[2][3].getNumSeed()+" | "+  Board[2][4].getNumSeed()+" | "+  Board[2][5].getNumSeed()+" | " );
		Log.v("GameConsola", "                -----                         ");



	}



	/**
	 * Movement allows the current player make a move
	 */
	public String movement(int positionRow, int positionCol)
	{
		Slot s= Board[positionRow][positionCol];

		String rta= verifyMovement(s);


		if (rta!="")
		{
			movements.add("Player "+getTurn()+ ":  Make a bad move->"+rta);
			generateOutputString();
			return rta;

		}

		else
		{
			putSeeds(positionRow,positionCol);
			String eaten=eatSeeds();
			setTurn();
			if(!verifyWin())
			{
				movements.add("Player "+getTurn()+ ":  Made a move. "+eaten);
				paintBoardInConsole("Move done!!! Now It's the turn of Player: "+getTurn()+". "+eaten);
				generateOutputString();
				return "Move done!!! Now It's the turn of Player: "+getTurn()+". "+eaten;

			}
			else
			{
				movements.add("The game is finished with the movement of Player "+getTurn()+ winner+". "+eaten);
				paintBoardInConsole("The game is finished. "+ winner+". "+eaten);
				generateOutputString();
				return "The game is finished. "+ winner+". "+eaten; 
			}
		}





	}




	/**
	 * setTurn verifies which player is the next one to make a move
	 */

	public void setTurn() {

		if(getTurn()==1 && !(currentX==1 && currentY==numColumn-1))
		{
			setTurn(2);

		}

		else if(getTurn()==2 && !(currentX==1 && currentY==0))
		{
			setTurn(1);

		}



	}


	/**
	 * putSeeds leaves the seeds on the correspondent bowls
	 */
	public void putSeeds(int row, int col) {

		int numSeeds=Board[row][col].getNumSeed();
		Board[row][col].setNumSeed(0);


		//Siguiente posición donde comienza a poner semillas
		if (row==numRow-1 && col<numColumn-1)
			col++;
		else if(col==numColumn-1 && row>0)
			row--;
		else if(row==0 && col>0)
			col--;
		else if(col==0 && row<numRow-1 )
			row++;	
		//Comienza a poner semillas
		while (numSeeds>0)
		{
			//except P’s opponent's tray
			if(!(getTurn()==1 && row==1 && col==0) && !(getTurn()==2 && row==1 && col==numColumn-1))
			{
				Board[row][col].sumSeed(1);
				numSeeds--;
			}


			currentX=row;
			currentY=col;

			if (row==numRow-1 && col<numColumn-1)
				col++;
			else if(col==numColumn-1 && row>0)
				row--;
			else if(row==0 && col>0)
				col--;
			else if(col==0 && row<numRow-1 )
				row++;	
		}



	}



	/**
	 * verifyMovement verifies if the player movement is valid or not
	 */
	public String verifyMovement(Slot s) {
		//B1, B2, T1, T2, N
		if (s.type=="B2" && getTurn()==1){
			return "You are playing with a wrong player. This slot belongs to the player 2 and you are Player 1. ";
		}
		else if (s.type=="B1" && getTurn()==2){
			return "You are playing with a wrong player. This slot belongs to the player 1 and you are Player 2.  ";
		}	
		else if (s.type=="T1" || s.type=="T2"){
			return "You cannot move from here. This is a Tray, you only can move from a Bowl. ";
		}
		else if (s.type=="N" || s.type=="N"){
			return "This is part of the Board, You cannot move from here. ";
		}
		else if(s.numSeed==0)
		{
			return "You cannot choose this slot. You have to select a slot with at least 1 seed.  ";
		}
		else
		{
			return "";
		}



	}



	/**
	 * eatSeeds gets the seeds of the corresponding bowls and put them in the tray of the current player
	 */
	public String eatSeeds() {
		int seedsToTray=0;
		String eatenSeeds="";
		if(currentX==numRow-1 && getTurn()==1 && Board[currentX][currentY].getNumSeed()==1 ){
			seedsToTray=(Board[0][currentY].getNumSeed())+1;
			Board[1][numColumn-1].sumSeed(seedsToTray);
			Board[0][currentY].setNumSeed(0);
			Board[currentX][currentY].setNumSeed(0);
			eatenSeeds=" Player 1 ate "+ (seedsToTray-1)+ " seeds from Player 2 plus the one that belong to him/her. "; 
		}
		else if(currentX==0 && getTurn()==2 && Board[currentX][currentY].getNumSeed()==1 ){
			seedsToTray=(Board[numRow-1][currentY].getNumSeed())+1;
			Board[1][0].sumSeed(seedsToTray);
			Board[numRow-1][currentY].setNumSeed(0);
			Board[currentX][currentY].setNumSeed(0);
			eatenSeeds=" Player 2 ate "+ (seedsToTray-1)+ " seeds from Player 1 plus the one that belong to him/her. ";
		}

		return eatenSeeds;
	}


	/**
	 * verifyWin verifies if the match is finish because a player doesn't have more seeds in his/her bowls
	 */
	public boolean verifyWin() {

		int numSeed1=0;
		int numSeed2=0;

		for(int i=0; i<numColumn; i++)
		{
			numSeed2+=Board[0][i].getNumSeed();
			numSeed1+=Board[numRow-1][i].getNumSeed();
		}

		if(numSeed1>0 && numSeed2>0)
		{
			return false;
		}
		else 
		{
			if(numSeed1<1)
			{
				Board[1][0].sumSeed(numSeed2);
				for(int i=0; i<numColumn; i++)
				{
					Board[0][i].setNumSeed(0);
				}
			}
			else
			{
				Board[1][numColumn-1].sumSeed(numSeed1);
				for(int i=0; i<numColumn; i++)
				{
					Board[numRow-1][i].setNumSeed(0);
				}
			}
			if(Board[1][0].getNumSeed()>Board[1][numColumn-1].getNumSeed())
				setWinner("The winner is Player 2!!!");
			else if (Board[1][0].getNumSeed()<Board[1][numColumn-1].getNumSeed())
				setWinner("The winner is Player 1!!!");
			else
				setWinner("There is a draw of player 1 and player 2");
			return true;
		}

	}





	/**
	 * CountSeedsInBoard counts all the seeds in the Board
	 */
	public int CountSeedsInBoard() 
	{
		int numTotalSeeds=0;
		for(int i=0; i<numColumn; i++)
		{
			numTotalSeeds+=Board[0][i].getNumSeed()+Board[2][i].getNumSeed();
		}
		numTotalSeeds+=Board[1][0].getNumSeed()+Board[1][5].getNumSeed();
		return numTotalSeeds;
	}


	/**
	 * getTurno returns the current player
	 */
	public int getTurn() {
		return turn;
	}


	/**
	 * setTurno sets the current player
	 */
	public void setTurn(int turno) {
		this.turn = turno;
	}

	/**
	 * getWinner returns the player who wins the match
	 */
	public String getWinner() {
		return winner;
	}


	/**
	 * setWinner sets the player who wins the match
	 */
	public void setWinner(String win) {
		winner = win;
	}

	/**
	 * getNumColumn() returns the number of columns of the Board
	 */
	public static int getNumColumn() {
		return numColumn;
	}


	/**
	 * getNumRow() returns the number of rows of the Board
	 */
	public static int getNumRow() {
		return numRow;
	}

	/**
	 * getNumBoardSeeds() returns the number of all the seeds in the Board
	 */
	public static int getNumBoardSeeds() {
		return numBoardSeeds;
	}

	/**
	 * getCurrentX returns the row position of the last seed dropped by a player
	 */
	public int getCurrentX() {
		return currentX;
	}

	/**
	 * setCurrentX sets the row position of the last seed dropped by a player
	 */
	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	/**
	 * getCurrentY returns the column position of the last seed dropped by a player
	 */
	public int getCurrentY() {
		return currentY;
	}

	/**
	 * setCurrentY sets the column  position of the last seed dropped by a player
	 */
	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}


	/**
	 * Generate the output string, which allows to evaluate if the move is performed correctly  
	 */
	public String generateOutputString() {
		OutputString="";
		for(int j=0; j<numRow ; j++)
		{
			if(j!=1)
			{
				for(int i=0; i<numColumn; i++)
				{

					OutputString+=Board[j][i].getNumSeed()+",";
				}
			}
		}
		OutputString+=Board[1][0].getNumSeed()+",";
		OutputString+=Board[1][numColumn-1].getNumSeed()+",";
		OutputString+=getTurn();
		return OutputString;
	}

	/**
	 * getOutputString returns output string, which allows to evaluate if the move is performed correctly
	 */
	public String getOutputString() {
		return OutputString;
	}
	
	
	
	/**
	 * 
	 */
	public ArrayList<String> getMovements() {
		return movements;
	}
	
	
	////////////////////////========================================/////////////////////////////////////////
	//Computer 

	/**
	 * 
	 */
	public int getBestMove() {
		int bestMove= 0;
		//Calculate if you can get an extra turn
		
		//Calculate if you can eat 
		
		int numSeed=0;
		for(int i=0; i<numColumn && numSeed==0 ; i++)
		{
			if (Board[0][i].getNumSeed()>0){
				numSeed=Board[0][i].getNumSeed();
				bestMove=i;
			}
					

		}
		
		return bestMove;
	}
	
	

	
	
	
	
	

}




