package it.polimi.mad.seedgame2;

import java.util.Date;

public class Match {

	Date date;
	String state;
	String boardSituation;
	String usernamePlayer1;
	String usernamePlayer2;
	BoardSituation bs=null;
	String winner;
	
	
	public Match(String boardS,	String usernameP1, String usernameP2) {
		date= new Date();
		state="active";
		boardSituation= boardS;
		usernamePlayer1=usernameP1;
		usernamePlayer2=usernameP2;
		
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
