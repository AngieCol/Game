package it.polimi.mad.seedgame2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Statistics {
 
	@DatabaseField(generatedId = true)
	int id;
	
	@DatabaseField (unique=true)
	String nameStatistic;
	
	@DatabaseField
	String players[];
	
	@DatabaseField
	String matches[];
	
	
	
	
	public Statistics(String name, String[] players, String[] matches)
	{
		nameStatistic=name;
		this.players=players;
		this.matches=matches;
		
	}
	
	public void updateStatistics( String[] players, String[] matches)
	{
		
		this.players=players;
		this.matches=matches;
		
	}
	
	
	

}
