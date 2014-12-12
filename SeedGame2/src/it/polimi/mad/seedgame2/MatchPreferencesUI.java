
package it.polimi.mad.seedgame2;

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
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;




/**
 * 
 *
 */
public class MatchPreferencesUI extends Activity {


	String mNaaa;
	EditText playerUsername1;
	EditText playerUsername2;
	DataBaseHandler dbHandler;
	
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{


		super.onCreate(savedInstanceState);
		setContentView(R.layout.matchpreferences);
		
		doDBHandler();
		
		playerUsername1= (EditText) findViewById(R.id.editText1);
		playerUsername2= (EditText) findViewById(R.id.editText2);

		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Player p= new Player(playerUsername1.getText().toString());
				Player p2= new Player(playerUsername2.getText().toString());
				Log.i("GameConsola", p.userName);
				Log.i("GameConsola", p2.userName);
				
				Intent in= new Intent(MatchPreferencesUI.this, MatchUI.class);
				startActivity(in);
			}
		});

		 

		


	}





	/**
	 * 
	 */
	private void doDBHandler() {
		  dbHandler= OpenHelperManager.getHelper(this, DataBaseHandler.class);
		  RuntimeExceptionDao<Player, integer> playerDAO= dbHandler.getPlayerRuntimeExceptionDao();
		  
		  
		  playerDAO.create(new Player ("Juanita"));
		  playerDAO.create(new Player ("Dario"));
		  playerDAO.create(new Player ("Pepe"));
		  playerDAO.create(new Player ("Lala"));
		  
		  List<Player> players= playerDAO.queryForAll();
		  
		  Log.d("GameConsola", players.toString());
		  
		  
		  OpenHelperManager.releaseHelper();
		  
	}
}