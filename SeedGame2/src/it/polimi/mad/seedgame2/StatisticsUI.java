/**
 * 
 */
package it.polimi.mad.seedgame2;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * 
 *
 */
public class StatisticsUI extends Activity {

	
	AutoCompleteTextView autocompletePlayers;
	DataBaseHandler dbHandler;
	String array_spinnerPlayers[];
	AutoCompleteTextView autocompletePlayer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistics);
		
		
		
		 dbHandler= OpenHelperManager.getHelper(this, DataBaseHandler.class);
		  RuntimeExceptionDao<Player, integer> playerDAO= dbHandler.getPlayerRuntimeExceptionDao();
		  
		  
		  	 		  
		  List<Player> players= playerDAO.queryForAll();
		  List<String> namesList = new ArrayList<String>();
		  for(Player p : players){
			 		 
			namesList.add(p.getUserName());
			
		  }
		  
	
		  array_spinnerPlayers=namesList.toArray(new String[namesList.size()]);
		  OpenHelperManager.releaseHelper();
		  
		  
		  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, array_spinnerPlayers);
	        autocompletePlayer = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
	        autocompletePlayer.setAdapter(adapter);
	        
	     
	       final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
	    
	      ArrayAdapter<String> adapt= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, array_spinnerPlayers);
	        spinner.setAdapter(adapt);
	       
	        spinner.setOnItemSelectedListener(new OnItemSelectedListener()
	        {
	           	@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					int index = spinner.getSelectedItemPosition();
	                Toast.makeText(getBaseContext(), 
	                    "You have selected item : " + array_spinnerPlayers[index], 
	                    Toast.LENGTH_SHORT).show();   
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					
					
				} 
	        
	        
	        });
	        
	}
}
