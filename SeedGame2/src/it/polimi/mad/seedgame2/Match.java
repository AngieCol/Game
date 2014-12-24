package it.polimi.mad.seedgame2;

import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable
public class Match {

	/**
	 * variables
	 */
	@DatabaseField(generatedId = true)
	int id ;
	
	@DatabaseField
	Date date;
	@DatabaseField
	String state;
	@DatabaseField
	String boardSituation;
	@DatabaseField
	String usernamePlayer1;
	@DatabaseField
	String usernamePlayer2;
	@DatabaseField
	BoardSituation bs=null;
	@DatabaseField
	String winner;
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//==================================================================================================
	/////////////////////////////////////////////////////////////////////////////////////////////////////


	/**
	 * Methods
	 */

	

	/**
	 * Match Constructor   
	 */
	public Match(String boardS,	String usernameP1, String usernameP2) {
		date= new Date();
		state="active";
		boardSituation= boardS;
		usernamePlayer1=usernameP1;
		usernamePlayer2=usernameP2;
		
	}

	
	/**
	 * verifyStringInput verifies the structure of the input string
	 */
	public String verifyStringInput(String s) {

		String[] inputSplited= s.split(",");
		String respuesta=""; 
		int numSeedsInInputString=0;
		int numSeedsInSlotPlayer1=0;
		int numSeedsInSlotPlayer2=0;
		
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
					int numSeed=Integer.parseInt(inputSplited[i]);
					if(Integer.parseInt(inputSplited[i])<0)
						respuesta+="The input text must be integer numbers, greater than 0, separated by comma. "; 

					//i<inputSplited.length-1 because the last one is the player that has the  turn
					if(i<inputSplited.length-1)
						numSeedsInInputString+=numSeed;
					
					if(i<6)
						numSeedsInSlotPlayer2+=numSeed;
					if(i>5 && i<12)
						numSeedsInSlotPlayer1+=numSeed;
				} 
				catch (NumberFormatException e) 
				{
					respuesta+="The input text cannot include letters or decimal numbers, it must be integer numbers, greater than 0, separated by comma. "; 

				}
			}
		if(numSeedsInInputString!=36)
		{
			respuesta+="The total number of seeds in the board has to be 36. ";
		}
		
		if(respuesta=="" && (numSeedsInSlotPlayer1==0 || numSeedsInSlotPlayer2==0))
		{
			respuesta=" The game cannot have as initial situation a player without any seeds on his/her bowls. ";
		}
		return respuesta;
}


	public void createPlayer() {
		
	}
	
	public void AssignInformationToPlayers(Player P1, Player P2, String winner, String[] History) {
		
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getBoardSituation() {
		return boardSituation;
	}


	public void setBoardSituation(String boardSituation) {
		this.boardSituation = boardSituation;
	}


	public String getUsernamePlayer1() {
		return usernamePlayer1;
	}


	public void setUsernamePlayer1(String usernamePlayer1) {
		this.usernamePlayer1 = usernamePlayer1;
	}


	public String getUsernamePlayer2() {
		return usernamePlayer2;
	}


	public void setUsernamePlayer2(String usernamePlayer2) {
		this.usernamePlayer2 = usernamePlayer2;
	}


	public BoardSituation getBs() {
		return bs;
	}


	public void setBs(BoardSituation bs) {
		this.bs = bs;
	}


	public String getWinner() {
		return winner;
	}


	public void setWinner(String winner) {
		this.winner = winner;
	}
	

}
