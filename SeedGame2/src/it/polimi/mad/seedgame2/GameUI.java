package it.polimi.mad.seedgame2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class GameUI extends Activity {

	MediaPlayer mpButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		mpButton= MediaPlayer.create(this, R.raw.sound1);

			
		ImageButton newMatch = (ImageButton) findViewById(R.id.imageButtonnewgame);
		newMatch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				//Intent in= new Intent(GameUI.this, MatchPreferencesUI.class);
				Intent in= new Intent(GameUI.this, MatchUI2.class);
				startActivity(in);
				mpButton.start();
			}
		});
		
		
		
		
		
		Button configuratePreferences = (Button) findViewById(R.id.imageButtonpreferences);
		configuratePreferences.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				
				Intent in= new Intent(GameUI.this, ConfigurationPreferencesUI.class);
				startActivity(in);
				mpButton.start();
			}
		});
		
		Button seeStatistics = (Button) findViewById(R.id.imageButtonstatistics);
		seeStatistics.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				
				Intent in= new Intent(GameUI.this, Statistics.class);
				startActivity(in);
				mpButton.start();
			}
		});
	}

}
