
package it.polimi.mad.seedgame2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;




/**
 * 
 *
 */
public class MatchPreferencesUI extends Activity {


	String mNaaa;

	AutoCompleteTextView autocompletePlayer1;
	AutoCompleteTextView autocompletePlayer2;
	CheckBox checkBoxPlayAgainstComputer; 
	DataBaseHandler dbHandler;
	
	
	String array_spinnerP1[];
	String array_spinnerP2[];
	boolean controlSoundBool=true;
	boolean backgroundSoundBool=true;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{


		super.onCreate(savedInstanceState);
		setContentView(R.layout.matchpreferences);
		
		  dbHandler= OpenHelperManager.getHelper(this, DataBaseHandler.class);
		  RuntimeExceptionDao<Player, integer> playerDAO= dbHandler.getPlayerRuntimeExceptionDao();
		  DeleteBuilder<Player, integer> deleteBuilder = playerDAO.deleteBuilder();
		  try {
			
		//	playerDAO.deleteById(arg0);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	        
		  OpenHelperManager.releaseHelper();
		  
		 // Player p= new Player("Goku");
		//	savePlayer(p);
		  Log.e("Gameconsola",playerDAO.queryForAll().toString() );
		  
		
		
		  try {
				controlSoundBool=getIntent().getExtras().getBoolean("controlSound");
				backgroundSoundBool=getIntent().getExtras().getBoolean("backgroundSound");
				
			} catch (Exception e) {
				controlSoundBool=true; 
				backgroundSoundBool=true;
				
			}
				
		
		getAllPlayers();
       
			
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, array_spinnerP1);
        autocompletePlayer1 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        autocompletePlayer1.setAdapter(adapter);
        
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, array_spinnerP2);
        autocompletePlayer2 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
        autocompletePlayer2.setAdapter(adapter2);
        
        checkBoxPlayAgainstComputer=(CheckBox)findViewById(R.id.checkBox2);
        checkBoxPlayAgainstComputer.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				
				if(checkBoxPlayAgainstComputer.isChecked())
					autocompletePlayer2.setEnabled(false);
				
				else
					autocompletePlayer2.setEnabled(true);	
			}
		});
        
		Button bCreate = (Button) findViewById(R.id.button1);
		bCreate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				String namePlayer1=autocompletePlayer1.getText().toString();
				String namePlayer2="";
				if(checkBoxPlayAgainstComputer.isChecked())
					namePlayer2="Computer";
					
				else
					namePlayer2=autocompletePlayer2.getText().toString();
				
				
				
				if(!(Arrays.asList(array_spinnerP1).contains(namePlayer1))){
					Player p= new Player(namePlayer1);
					savePlayer(p);
					Log.v("GameConsola", "Player1 creado");
					
				}
				if((!(Arrays.asList(array_spinnerP2).contains(namePlayer2)))&& namePlayer2!="Computer"){
					Player p= new Player(namePlayer2);
					savePlayer(p);
					Log.v("GameConsola", "Player2 creado");
				}
				
				
				Intent in= new Intent(MatchPreferencesUI.this, MatchUI2.class);
				in.putExtra("p1", namePlayer1);
				in.putExtra("p2", namePlayer2);
				in.putExtra("controlSound", controlSoundBool);
				in.putExtra("backgroundSound", backgroundSoundBool);
				startActivity(in);
			}
		});

		 

			


	}





	
	
	
	
	/**
	 * 
	 */
	public void savePlayer(Player p) {
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