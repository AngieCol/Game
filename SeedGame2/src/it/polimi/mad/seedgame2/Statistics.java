package it.polimi.mad.seedgame2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Statistics {
 
	@DatabaseField(generatedId = true, unique=true)
	int id;
	
	@DatabaseField (unique=true)
	String nameStatistic;
	
	@DatabaseField
	Player players[];
	

	
	
	
	
	public Statistics(String name, Player[] players, String[] matches)
	{
		nameStatistic=name;
		this.players=players;
		
		
	}
	
	public void updateStatistics( Player[] players, String[] matches)
	{
		
		this.players=players;
		
		
	}
	
	
	

}
