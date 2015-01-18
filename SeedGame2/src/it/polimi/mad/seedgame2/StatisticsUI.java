/**
 * 
 */
package it.polimi.mad.seedgame2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Spinner;

/**
 * 
 *
 */
public class StatisticsUI extends Activity {


	AutoCompleteTextView autocompletePlayers;
	DataBaseHandler dbHandler;
	String array_spinnerPlayers[];
	AutoCompleteTextView autocompletePlayer;
	TextView playerInfo;
	TextView statistisInfo;
	int initialAmount=100;
	Spinner spinnerPlayers;
	Spinner spinnerStatistics;

	String[] statisticsArray = {"**Select Statistic**","Top scores","Top Winners","Highest points"};

	
	String[ ] [ ] pruebaMatrix = {   { "A", "B", "C", "D", "E" },
            { "B", "20", "1", "31", "25", "9" },
            {"C", "21", "25", "41", "45", "5" },
            { "D", "2", "15", "51", "12", "55"  },
            { "E" , "11", "28", "11", "10", "53" }
        };
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {




		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistics);

		playerInfo=(TextView)findViewById(R.id.textView4);
		statistisInfo=(TextView)findViewById(R.id.textView7);
		
		
		dbHandler= OpenHelperManager.getHelper(this, DataBaseHandler.class);
		Dao<Player, String> playerDAO;
		List<Player> players = new ArrayList<Player>();
		
		try {
			playerDAO = dbHandler.getDaoPlayer();
			players=playerDAO.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		
		List<String> namesList = new ArrayList<String>();


		final String[][] playersMatrix = new String [initialAmount][initialAmount];

		int index=0;
		namesList.add("**Select Player**");
	//	Toast.makeText(getBaseContext(), "Select a player to see his/her statistics or select a general statistic.", Toast.LENGTH_SHORT).show();
		for(Player p : players){

			namesList.add(p.getUserName());
			/*	String s0=p.getUserName()+"";
			String s1=p.getHighestScore()+"";
			String s2=p.getLowestscore()+"";
			String s3=p.getNumPlayedGame()+"";
			String s4=p.getNumWonGames()+"";
			String s5=p.getTotalPoints()+"";

			 */
			playersMatrix[index][0]=p.getUserName()+"";
			playersMatrix[index][1]=p.getHighestScore()+"";
			playersMatrix[index][2]=p.getLowestscore()+"";
			playersMatrix[index][3]=p.getNumPlayedGame()+"";
			playersMatrix[index][4]=p.getNumWonGames()+"";
			playersMatrix[index][5]=p.getTotalPoints()+"";
			
			index++;
		}


		array_spinnerPlayers=namesList.toArray(new String[namesList.size()]);
		OpenHelperManager.releaseHelper();


		/*  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, array_spinnerPlayers);
	        autocompletePlayer = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
	        autocompletePlayer.setAdapter(adapter);
		 */  

		spinnerPlayers = (Spinner) findViewById(R.id.spinner1);

		ArrayAdapter<String> adapt= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, array_spinnerPlayers);
		spinnerPlayers.setAdapter(adapt);

		spinnerPlayers.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = spinnerPlayers.getSelectedItemPosition();

				//if(!array_spinnerPlayers[index].equalsIgnoreCase("**Select Player**"))
					//Toast.makeText(getBaseContext(), "You have selected item : " + array_spinnerPlayers[index], Toast.LENGTH_SHORT).show();   
				
					
				if(!array_spinnerPlayers[index].equalsIgnoreCase("**Select Player**")){
				
				int i;
				boolean out=false;
				for(i=0; i<array_spinnerPlayers.length && !out ;i++)
				{
					if(playersMatrix[i][0]!=null){
						if(playersMatrix[i][0].equalsIgnoreCase(array_spinnerPlayers[index]))
							out=true;

					}
					else {
						out=true;
					}
				}
			
					playerInfo.setText(
						"Name: "+playersMatrix[i-1][0]
								
								+"\n HighestScore: "+ playersMatrix[i-1][1]
										+"\n Lowestscore: "+ playersMatrix[i-1][2]
												+"\n getNumPlayedGame: "+ playersMatrix[i-1][3]
														+"\n getNumWonGames: "+ playersMatrix[i-1][4]
																+"\n getTotalPoints: "+ playersMatrix[i-1][5]);

			}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {


			} 


		});

		/*
		spinnerStatistics = (Spinner) findViewById(R.id.spinner2);

		ArrayAdapter<String> adapt2= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, statisticsArray);
		spinnerStatistics.setAdapter(adapt2);
		spinnerStatistics.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = spinnerStatistics.getSelectedItemPosition();
			
				
				if(!statisticsArray[index].equalsIgnoreCase(" **Select Statistic**"))
					statistisInfo.setText("");
				//{"Top scores","Top Winners","Highest points"};
				if(statisticsArray[index].equalsIgnoreCase("Top scores")){
					for(int column = 1; column < pruebaMatrix[1].length; column++)
				    {
				        for (int row = 0; row < pruebaMatrix.length; row++)
				       {
				          for (int rowTwo = row + 1; rowTwo < pruebaMatrix.length; rowTwo++)
				          {
				        	  int numRowTwo= Integer.parseInt(pruebaMatrix[rowTwo][column]);
				        	  int numRow=Integer.parseInt(pruebaMatrix[row][column]);
				        	  
				          
				             if(numRowTwo>numRow)
				            {
				              //  int temp=pruebaMatrix[row][column];
				               pruebaMatrix[row][column] = pruebaMatrix[rowTwo][column];
				               //pruebaMatrix[rowTwo][column]=temp;
				           }
				       }
				   }
					
					
				}
				
				}		

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {


			} 


		});
		*/

	}
	
	
	  
  
}
