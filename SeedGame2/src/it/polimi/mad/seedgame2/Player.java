package it.polimi.mad.seedgame2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable
public class Player {
	
	
	@DatabaseField(generatedId = true)
	int id ;
	@DatabaseField 
	String userName;
	@DatabaseField
	int totalPoints;
	@DatabaseField
	int numPlayedGame;
	@DatabaseField
	int numDrawnGame;
	@DatabaseField
	int numWonGames; 
	@DatabaseField
	int highestScore;
	@DatabaseField
	int lowestscore;
	@DatabaseField
	boolean isHuman;
	

	public Player() {
		
	}
	public Player(String usern) {
		userName=usern;
		numPlayedGame=0;
		numDrawnGame=0;
		numWonGames=0; 
		highestScore=0;
		lowestscore=0;
		isHuman=true;
		
	}


	public void updatePlayer(String winner, int points) {
		numPlayedGame++;
		
		if (points> highestScore)
			highestScore=points;
		if (points< lowestscore)
			lowestscore=points;
		if(winner.equalsIgnoreCase("winner"))
			numWonGames++;
		else if(winner.equalsIgnoreCase("drawn"))
			numDrawnGame++;
		
	}
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getTotalPoints() {
		return totalPoints;
	}


	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}


	public int getNumPlayedGame() {
		return numPlayedGame;
	}


	public void setNumPlayedGame(int numPlayedGame) {
		this.numPlayedGame = numPlayedGame;
	}


	public int getNumWonGames() {
		return numWonGames;
	}


	public void setNumWonGames(int numWonGames) {
		this.numWonGames = numWonGames;
	}


	public int getHighestScore() {
		return highestScore;
	}


	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}


	public int getLowestscore() {
		return lowestscore;
	}


	public void setLowestscore(int lowestscore) {
		this.lowestscore = lowestscore;
	}


	public boolean isHuman() {
		return isHuman;
	}


	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Player [id=" + id + ", userName=" + userName /*+ ", totalPoints="
				+ totalPoints + ", numPlayedGame=" + numPlayedGame
				+ ", numDrawnGame=" + numDrawnGame + ", numWonGames="
				+ numWonGames + ", highestScore=" + highestScore
				+ ", lowestscore=" + lowestscore + ", isHuman=" + isHuman*/ + "]";
	}


	
}
