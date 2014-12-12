
package it.polimi.mad.seedgame2;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;

import android.R.integer;
import android.app.Activity;
import android.app.DownloadManager.Query;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore.Audio.PlaylistsColumns;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AnalogClock;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.database.sqlite.SQLiteDatabase;




/**
 * 
 *
 */
public class MatchPreferencesUI extends Activity {


	String mNaaa;

	AutoCompleteTextView autocompletePlayer1;
	AutoCompleteTextView autocompletePlayer2;
	DataBaseHandler dbHandler;
	
	
	String array_spinnerP1[];
	String array_spinnerP2[];
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{


		super.onCreate(savedInstanceState);
		setContentView(R.layout.matchpreferences);
		
		  dbHandler= OpenHelperManager.getHelper(this, DataBaseHandler.class);
		  RuntimeExceptionDao<Player, integer> playerDAO= dbHandler.getPlayerRuntimeExceptionDao();
		  DeleteBuilder<Player, integer> deleteBuilder = playerDAO.deleteBuilder();
		  try {
			//deleteBuilder.where().eq("numberWonGames", 0);
			deleteBuilder.prepare();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	        
		  OpenHelperManager.releaseHelper();
		  
		
		
		
		
		
		playerDAO.create(new Player("Pepe2"));
		
		Log.e("Gameconsola",playerDAO.queryForAll().toString() );
		getAllPlayers();
       
			
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, array_spinnerP1);
        autocompletePlayer1 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        autocompletePlayer1.setAdapter(adapter);
        
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, array_spinnerP2);
        autocompletePlayer1 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
        autocompletePlayer1.setAdapter(adapter2);
        

		Button bCreate = (Button) findViewById(R.id.button1);
		bCreate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				String namePlayer1=autocompletePlayer1.getText().toString();
				String namePlayer2=autocompletePlayer2.getText().toString();
				
				if(!(Arrays.asList(array_spinnerP1).contains(namePlayer1))){
					Player p= new Player(namePlayer1);
					savePlayer(p);
				}
				if(!(Arrays.asList(array_spinnerP1).contains(namePlayer1))){
					Player p= new Player(namePlayer1);
					savePlayer(p);
				}
				
				
				Intent in= new Intent(MatchPreferencesUI.this, MatchUI.class);
				in.putExtra("p1", namePlayer1);
				in.putExtra("p2", namePlayer2);
				startActivity(in);
			}
		});

		 

			


	}





	
	
	
	
	/**
	 * 
	 */
	private void savePlayer(Player p) {
		  dbHandler= OpenHelperManager.getHelper(this, DataBaseHandler.class);
		  RuntimeExceptionDao<Player, integer> playerDAO= dbHandler.getPlayerRuntimeExceptionDao();
		  playerDAO.create(p);
		  OpenHelperManager.releaseHelper();
		  
	}
	
	
	/**
	 * 
	 */
	private void getAllPlayers() {
		  dbHandler= OpenHelperManager.getHelper(this, DataBaseHandler.class);
		  RuntimeExceptionDao<Player, integer> playerDAO= dbHandler.getPlayerRuntimeExceptionDao();
		  
		  
		  	 		  
		  List<Player> players= playerDAO.queryForAll();
		  List<String> namesList = new ArrayList<String>();
		  for(Player p : players){
			 		 
			namesList.add(p.getUserName());
			
		  }
		  
	
		  
		  array_spinnerP1=namesList.toArray(new String[namesList.size()]);
		  array_spinnerP2=namesList.toArray(new String[namesList.size()]);
		  OpenHelperManager.releaseHelper();
		  
		  
	}
}