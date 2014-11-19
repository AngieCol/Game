package it.polimi.mad.seedgame2;

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
    	
    	turno= 1;

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
			eatSeeds();
			
			setTurn();
			
			return "Move done!. Now It's the turn of player "+getTurno();
		}
		
		
			
		
		
	}
    
    
    
    //VOY AQUÍIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
    public void setTurn() {
    	
    	  	
    	if(getTurno()==1 && currentX==1 && currentY==numColumn-1)
    	{
    		setTurno(1);
		}
		
		else if(getTurno()==2 && currentX==1 && currentY==0)
		{
			setTurno(2);
		}
		else if(getTurno()==2)
		{
			setTurno(1);
		}
		else 
		{
			setTurno(2);
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
    		}
    		
    		numSeeds--;
    		if (row==numRow-1 && col<numColumn-1)
        		col++;
        	else if(col==numColumn-1 && row>0)
        		row--;
        	else if(row==0 && col>0)
        		col--;
        	else if(col==0 && row<numRow-1 )
        		row++;	
    	}
    	
    	  	currentX=row;
    	  	currentY=col;
    	
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
    
    
    public void eatSeeds() {
    	
    	 
    	
    	
    	if(currentY==numRow-1 && getTurno()==1 && Board[currentX][currentY].getNumSeed()==1 && Board[currentX][0].getNumSeed()>0){
    		Board[1][numColumn-1].setNumSeed((Board[currentX][0].getNumSeed())+1);
    		Board[currentX][0].setNumSeed(0);
    		Board[currentX][currentY].setNumSeed(0);
    	}
    	else if(currentY==0 && getTurno()==2 && Board[currentX][currentY].getNumSeed()==1 && Board[currentX][numColumn-1].getNumSeed()>0){
    		Board[1][0].setNumSeed((Board[currentX][numColumn-1].getNumSeed())+1);
    		Board[currentX][numColumn-1].setNumSeed(0);
    		Board[currentX][currentY].setNumSeed(0);
    	}
    			
		
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
    
    
    
    

}
