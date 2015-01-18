package it.polimi.mad.seedgame2;


import android.app.Activity;
import android.content.Intent;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class WinUI extends Activity {



	/**
	 * variables
	 */

	
	
	//frame animation
	ImageView frameAnimation;
	MediaPlayer mpBAckground;
	TextView playerInfo;
	MediaPlayer mpButton;
	AnimationDrawable frameAnimationDraw;
	/**
	 * Methods
	 */



	/**
	 * Match onCreate 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.win);
		mpBAckground= MediaPlayer.create(this, R.raw.celebrationsound);
		mpBAckground.start();
	
	    frameAnimation = (ImageView)findViewById(R.id.frameAnimation);
		
	  
		
				

	//	String s= getIntent().getExtras().getString("winner");
		
	//	Log.v("Game Consola", "En winUI"+ s);
		
				
	//	if (s.equalsIgnoreCase("The winner is Player 1!!!")){
			frameAnimation.setBackgroundResource(R.drawable.animationlistp1win);
			frameAnimationDraw= (AnimationDrawable)frameAnimation.getBackground();
			frameAnimationDraw.start();
			
			
			  frameAnimation.setBackgroundResource(R.drawable.animationlist);
				frameAnimationDraw= (AnimationDrawable)frameAnimation.getBackground();
				frameAnimationDraw.start();
	/*		
	 * 
	 * 
	 * 
	//	}
	//	else{
			frameAnimation.setBackgroundResource(R.drawable.animationlistp2win);
			frameAnimationDraw= (AnimationDrawable)frameAnimation.getBackground();
			frameAnimationDraw.start();
			
	//	}
		*/
	
		/*frameAnimation.post(new Runnable() {
			
			@Override
			public void run() {
				AnimationDrawable frameAnimationDraw= (AnimationDrawable)frameAnimation.getBackground();
				frameAnimationDraw.start();
			}
		});
		
		*/
		mpButton= MediaPlayer.create(this, R.raw.clicksound);

		
		
		
		ImageButton newMatch = (ImageButton) findViewById(R.id.imageButtonnewgame);
		newMatch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent in= new Intent(WinUI.this, MatchPreferencesUI.class);
				//Intent in= new Intent(WinUI.this, MatchUI2.class);
				mpBAckground.stop();
				mpButton.start();
		
				
				startActivity(in);
				
				
				
			}
		});
		
	}

	





}
