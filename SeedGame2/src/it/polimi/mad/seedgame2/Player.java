package it.polimi.mad.seedgame2;

public class Player {
	
	
	String userName;
	int totalPoints; 
	int numPlayedGame;
	int numWonGames; 
	int HighestScore;
	int Lowestscore;
	boolean isHuman;
	int playerNumber;


	public Player(String username) {
		this.userName=username;
		numPlayedGame=0;
		numWonGames=0; 
		HighestScore=0;
		Lowestscore=0;
		isHuman=true;
		
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
		return HighestScore;
	}


	public void setHighestScore(int highestScore) {
		HighestScore = highestScore;
	}


	public int getLowestscore() {
		return Lowestscore;
	}


	public void setLowestscore(int lowestscore) {
		Lowestscore = lowestscore;
	}


	public boolean isHuman() {
		return isHuman;
	}


	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}


	public int getPlayerNumber() {
		return playerNumber;
	}


	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

}
