package it.polimi.mad.seedgame2;

import android.util.Log;

public class BoardSituation 
{

	/**
	 * variables
	 */

	static int numColumn = 6;
	static int numRow = 3;

	Slot[][] Board = null;
	int turno=0;
	int currentX=-1;
	int currentY=-1;
	
	String winner="";

	///////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////
	//=======================================================
	///////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////


	/**
	 * Métodos
	 */


	/**
	 * Initial BoardSituation
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

		setTurno(1);


		paintBoardInConsole("");


	}


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

			setTurno(Integer.parseInt(inputSplited[14]));

			paintBoardInConsole("");
			
		
	}


	public void paintBoardInConsole(String s) {
		
		
		Log.d("GameConsola", " =====================================================");
		Log.v("GameConsola", s);
		Log.e("GameConsola", " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Log.w("GameConsola", " | "+ Board[0][0].getNumSeed()+" | "+ Board[0][1].getNumSeed()+" | "+ Board[0][2].getNumSeed()+" | "+  Board[0][3].getNumSeed()+" | "+  Board[0][4].getNumSeed()+" | "+  Board[0][5].getNumSeed()+" | " );
		Log.v("GameConsola", " | "+ Board[1][0].getNumSeed()+" |  | " + Board[1][5].getNumSeed()+" | " );
		Log.v("GameConsola", " | "+ Board[2][0].getNumSeed()+" | "+ Board[2][1].getNumSeed()+" | "+ Board[2][2].getNumSeed()+" | "+  Board[2][3].getNumSeed()+" | "+  Board[2][4].getNumSeed()+" | "+  Board[2][5].getNumSeed()+" | " );
		Log.v("GameConsola", " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


	}


	public String movement(int positionRow, int positionCol)
	{
		Slot s= Board[positionRow][positionCol];

		String rta= verifyMovement(s);


		if (rta!="")
		{
			return rta;
		}

		else
		{
			putSeeds(positionRow,positionCol);
			String eated=eatSeeds();
			setTurn();
			if(!verifyWin())
			{
			 paintBoardInConsole("Move done!!! Now It's the turn of Player: "+getTurno()+". "+eated);
			 return "Move done!!! Now It's the turn of Player: "+getTurno()+". "+eated;
			
			}
			else
			{
				paintBoardInConsole("The game is finished. "+ winner+". "+". "+eated);
				return "The game is finished. "+ winner+". "+eated; 
			}
		}





	}






	public void setTurn() {

		if(getTurno()==1 && !(currentX==1 && currentY==numColumn-1))
		{
			setTurno(2);

		}

		else if(getTurno()==2 && !(currentX==1 && currentY==0))
		{
			setTurno(1);

		}

		

	}

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
			if(!(getTurno()==1 && row==1 && col==0) && !(getTurno()==2 && row==1 && col==numColumn-1))
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


	public String verifyMovement(Slot s) {




		//B1, B2, T1, T2, N
		if (s.type=="B2" && getTurno()==1){
			return "This slot belongs to the player 2. ";
		}
		else if (s.type=="B1" && getTurno()==2){
			return "This slot belongs to the player 1. ";
		}	
		else if (s.type=="T1" || s.type=="T2"){
			return "You cannot move from here. ";
		}
		else if (s.type=="N" || s.type=="N"){
			return "This is part of the Board, You cannot move from here. ";
		}
		else if(s.numSeed==0)
		{
			return "It is an empty slot. ";
		}
		else
		{
			return "";
		}



	}


	public String eatSeeds() {
		int seedsToTray=0;
		String eated="";
		if(currentX==numRow-1 && getTurno()==1 && Board[currentX][currentY].getNumSeed()==1 && Board[0][currentY].getNumSeed()>0){
			seedsToTray=(Board[0][currentY].getNumSeed())+1;
			Board[1][numColumn-1].sumSeed(seedsToTray);
			Board[0][currentY].setNumSeed(0);
			Board[currentX][currentY].setNumSeed(0);
			eated=" Player 1 eated "+ (seedsToTray-1)+ " seeds from Player 2 plus the one that belong to him/her. "; 
		}
		else if(currentX==0 && getTurno()==2 && Board[currentX][currentY].getNumSeed()==1 && Board[numRow-1][currentY].getNumSeed()>0){
			seedsToTray=(Board[numRow-1][currentY].getNumSeed())+1;
			Board[1][0].sumSeed(seedsToTray);
			Board[numRow-1][currentY].setNumSeed(0);
			Board[currentX][currentY].setNumSeed(0);
			eated=" Player 2 eated "+ (seedsToTray-1)+ " seeds from Player 1 plus the one that belong to him/her. ";
		}

		return eated;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
	public String getWinner() {
		return winner;
	}

	public void setWinner(String win) {
		winner = win;
	}
	
	
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
				setWinner("The winner is Player 1!!!");
			else if (Board[1][0].getNumSeed()<Board[1][numColumn-1].getNumSeed())
				setWinner("The winner is Player 2!!!");
			else
				setWinner("There is a draw of player 1 and player 2");
			return true;
		}
		
	}

	
	
	
	
	
	
	
	
	
	public String verifyStringInput(String s) {

		String[] inputSplited= s.split(",");
		String respuesta=""; 
				
		if(inputSplited.length!=15)
		{
			respuesta+="The number of integers separated by comma has to be 15. ";
		}
		if(!inputSplited[inputSplited.length-1].toString().equals("1") && !inputSplited[inputSplited.length-1].toString().equals("2"))
		{
			respuesta+="The last number must be 1 or 2 because it is the current player. ";
		}
		for(int i=0; i<inputSplited.length; i++)
			{
				try 
				{
					Integer.parseInt(inputSplited[i]);
					if(Integer.parseInt(inputSplited[i])<0)
						respuesta+="The input text must be integer numbers, greater than 0, separated by comma. "; 

				} 
				catch (NumberFormatException e) 
				{
					respuesta+="The input text cannot include letters or decimal numbers, it must be integer numbers, greater than 0, separated by comma. "; 

				}
			}
		
		return respuesta;
}


	
	
	
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

}
