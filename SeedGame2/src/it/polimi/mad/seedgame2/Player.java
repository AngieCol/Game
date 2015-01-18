package it.polimi.mad.seedgame2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable
public class Player {
	
	
	
	
	@DatabaseField (id=true)
	String userName;
	@DatabaseField 
	int totalPoints;
	@DatabaseField
	int numPlayedGame;
	@DatabaseField
	int numDrawnGame;
	@DatabaseField(columnName="numberWonGames")
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
		totalPoints=0;
		isHuman=true;
		
	}


	public void updatePlayer(String winner, int points) {
		setNumPlayedGame(getNumPlayedGame()+1);
		
		if (points> highestScore)
			setHighestScore(points);
		if (points< lowestscore || lowestscore==0)
			setLowestscore(points);
		if(winner.equalsIgnoreCase("winner"))
			setNumWonGames(getNumWonGames()+1);
		else if(winner.equalsIgnoreCase("drawn"))
			setDrawnGames(getDrawnGames()+1);
		setTotalPoints(getTotalPoints()+points);
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


	public void setNumWonGames(int numDGames) {
		this.numWonGames = numWonGames;
	}
	public int getDrawnGames() {
		return numDrawnGame;
	}


	public void setDrawnGames(int numDGames) {
		this.numDrawnGame = numDGames;
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
	
	
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Player [ userName=" + userName + ", totalPoints="
				+ totalPoints + ", numPlayedGame=" + numPlayedGame
				+ ", numDrawnGame=" + numDrawnGame + ", numWonGames="
				+ numWonGames + ", highestScore=" + highestScore
				+ ", lowestscore=" + lowestscore + ", isHuman=" + isHuman + "]";
	}


	
}
