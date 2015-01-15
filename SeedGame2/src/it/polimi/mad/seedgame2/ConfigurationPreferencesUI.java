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
import android.widget.Button;
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
	Boolean controlSoundBool; 
	Boolean backgroundSoundBool;
	Boolean animationBool;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.configurationpreferences);

		controlSound= (CheckBox)findViewById(R.id.checkBoxControlSound);
		backgroundSound= (CheckBox)findViewById(R.id.checkBoxBackgroundSound);
		animation= (CheckBox)findViewById(R.id.checkBoxAnimation);
		mpButton= MediaPlayer.create(this, R.raw.clicksound);




		ImageButton  newGame = (ImageButton) findViewById(R.id.imageButtonnewgame);
		newGame.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent in= new Intent(ConfigurationPreferencesUI.this, MatchUI2.class);
				in.putExtra("controlSound", controlSoundBool);
				in.putExtra("backgroundSound", backgroundSoundBool);
				in.putExtra("animation", animationBool);
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
			
			break;
		case R.id.checkBoxBackgroundSound:

			break;

		case R.id.checkBoxAnimation:

			break;


		}

	}


}
