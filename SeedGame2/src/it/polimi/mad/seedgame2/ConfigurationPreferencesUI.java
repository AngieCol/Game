/**
 * 
 */
package it.polimi.mad.seedgame2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * 
 *
 */
public class ConfigurationPreferencesUI extends Activity implements OnCheckedChangeListener {

	CheckBox controlSound; 
	CheckBox backgroundSound;
	CheckBox animation;
	MediaPlayer mpButton;
	Boolean controlSoundBool=false; 
	Boolean backgroundSoundBool=false;
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.configurationpreferences);

		controlSound= (CheckBox)findViewById(R.id.checkBoxControlSound);
		backgroundSound= (CheckBox)findViewById(R.id.checkBoxBackgroundSound);
		
		mpButton= MediaPlayer.create(this, R.raw.clicksound);




		ImageButton  newGame = (ImageButton) findViewById(R.id.imageButtonnewgame);
		newGame.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent in= new Intent(ConfigurationPreferencesUI.this, MatchPreferencesUI.class);
				in.putExtra("controlSound", controlSoundBool);
				in.putExtra("backgroundSound", backgroundSoundBool);
				
				mpButton.start();
				startActivity(in);
			}
		});
		
		
	
		
		
		
		
		
		
	}

	/**
	 *
	 */
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch(buttonView.getId()){
		case R.id.checkBoxControlSound:
			
				controlSoundBool=isChecked;
			
			break;
			
		case R.id.checkBoxBackgroundSound:
			backgroundSoundBool=isChecked;
			
			break;

		


		}

	}


}
