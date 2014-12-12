
package it.polimi.mad.seedgame2;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore.Audio.PlaylistsColumns;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
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
	EditText playerUsername1;
	EditText playerUsername2;
	AutoCompleteTextView autocompletePlayer1;
	DataBaseHandler dbHandler;
	
	Spinner s1 ; 
	Spinner s2 ;
	String array_spinnerP1[];
	String array_spinnerP2[];
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{


		super.onCreate(savedInstanceState);
		setContentView(R.layout.matchpreferences);
		
	
		
		playerUsername1= (EditText) findViewById(R.id.editText1);
		playerUsername2= (EditText) findViewById(R.id.editText2);
		
		
		getAllPlayers();
       
		s1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array_spinnerP1);
        s1.setAdapter(adapter);
				
        s2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array_spinnerP2);
        s2.setAdapter(adapter2);
				
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, array_spinnerP1);
        autocompletePlayer1 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        autocompletePlayer1.setAdapter(adapter3);
        
        
        

		Button bCreate = (Button) findViewById(R.id.button1);
		bCreate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Player p= new Player(playerUsername1.getText().toString());
				Player p2= new Player(playerUsername2.getText().toString());
							
				savePlayers(p,p2);
				String s= autocompletePlayer1.getText().toString();
				Log.e("Gameconsola", s);
				
				Intent in= new Intent(MatchPreferencesUI.this, MatchUI.class);
				in.putExtra("p1", p.getUserName());
				in.putExtra("p2", p2.getUserName());
				startActivity(in);
			}
		});

		 

			


	}





	
	
	
	
	/**
	 * 
	 */
	private void savePlayers(Player p, Player p2) {
		  dbHandler= OpenHelperManager.getHelper(this, DataBaseHandler.class);
		  RuntimeExceptionDao<Player, integer> playerDAO= dbHandler.getPlayerRuntimeExceptionDao();
		  
		  
		  playerDAO.create(p);
		  playerDAO.create(p2);
		 		  
		   
		  
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