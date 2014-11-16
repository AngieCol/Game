package it.polimi.mad.seedgame2;

public class BoardSituation 
{
	
   /**
    * variables
    */
	
   static int numColumn = 6;
   static int numRow = 3;
   
   Slot[][] Board = new Slot[numRow][numColumn];
   int turno=0;
   
   
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
		for(int i=0; i<numColumn-1; i++)
		{
			Board[0][i]=new Slot("B2");
			Board[1][i]=new Slot("N");
			Board[2][i]=new Slot("B1");		
			
		}
		Board[1][0]=new Slot("T2");
		Board[1][numColumn-1]=new Slot("T1");
    	
    	turno= 1;

	}
    
    public String movement(int positionCol, int positionRow)
    {
		Slot s= Board[positionRow][positionCol];
    	
    	return "";
	}
    
    
    
    public String verifyMovement() {
	   	
	    	
    	return "";
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
    
    
    
    

}
