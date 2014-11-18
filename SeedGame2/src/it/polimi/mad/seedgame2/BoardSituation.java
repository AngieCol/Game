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
    	
		for(int i=0; i<numColumn-1; i++)
		{
			Board[0][i]=new Slot("B2",3);
			Board[1][i]=new Slot("N",-1);
			Board[2][i]=new Slot("B1",3);		
			
		}
		Board[1][0]=new Slot("T2",0);
		Board[1][numColumn-1]=new Slot("T1",0);
    	
    	turno= 1;

	}
    
    public String movement(int positionCol, int positionRow)
    {
		Slot s= Board[positionRow][positionCol];
    	
		String rta= verifyMovement(s);
		
		
		if (rta!="")
		{
			return rta;
		}
		
		else
		{
			putSeeds(positionCol,positionRow);
			
			/*
			if(getTurno()==1){
				if(currentX==numColumn-1 && currentY==1 )
			}
			
			if((!(&& getTurno()==1)) && getTurno()==1){
				setTurno(2);
			}
			else if((!(currentX==0 && currentY==1 && getTurno()==2))&& getTurno()==2){
				setTurno(1);
			}
			*/
			return "Move done";
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
    		Board[row][col].sumSeed(1);
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
	   	
    	String respuesta="";
    	
    	if(s.numSeed==0)
	   	{
	   		respuesta= "It is an empty slot. ";
	   	}
    	
    	//B1, B2, T1, T2, N
    	if (s.type=="B2" && getTurno()==1){
	   		respuesta+= "This slot belongs to the player 2. ";
	   	}
    	if (s.type=="B1" && getTurno()==2){
	   		respuesta+= "This slot belongs to the player 1. ";
	   	}	
    	if (s.type=="T1" || s.type=="T2"){
	   		respuesta+= "You cannot move from here. ";
	   	}
    	if (s.type=="N" || s.type=="N"){
	   		respuesta+= "This is part of the Board, You cannot move from here. ";
	   	}
    	
    	
    	return respuesta;
	}
    
    
    public void eatSeeds() {
    	
    	int numeatedSeeds=0; 
    	
    	numeatedSeeds= Board[currentX][currentY].getNumSeed();
		
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
    
    
    
    

}
