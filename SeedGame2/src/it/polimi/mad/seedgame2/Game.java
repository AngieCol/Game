package it.polimi.mad.seedgame2;

public class Game {

	
	
	
	public Game() {
		
	}
	
	
	
	public Player[] getPlayers(){
		return new Player[8];
	}
	
	public Player[] getStatisticsPlayer(String statisticName){
		return new Player[8];
	}
	
	public Match[] getStatisticsMatch(String statisticName){
		return new Match[8];
	}

}
