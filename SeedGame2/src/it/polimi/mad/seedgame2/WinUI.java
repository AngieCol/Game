package it.polimi.mad.seedgame2;


import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.format.Time;
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
		Timer myTimer = new Timer();



		frameAnimation = (ImageView)findViewById(R.id.frameAnimation);
		frameAnimation.setBackgroundResource(R.drawable.animationlist);
		frameAnimationDraw= (AnimationDrawable)frameAnimation.getBackground();
		frameAnimationDraw.start();


		String s= getIntent().getExtras().getString("winner");

		//Log.v("Game Consola", "En winUI"+ s);


		if (s.equalsIgnoreCase("The winner is Player 1!!!")){


			MyTimerTask mytask = new MyTimerTask(1);
			myTimer.schedule(mytask, 2000);


		}
		else if(s.equalsIgnoreCase("The winner is Player 2!!!")){

			MyTimerTask mytask = new MyTimerTask(2);
			myTimer.schedule(mytask, 2000);

		}

		else{
			//			frameAnimation.setBackgroundResource(R.drawable.animationlistp2win);
			//			frameAnimationDraw= (AnimationDrawable)frameAnimation.getBackground();
			//			frameAnimationDraw.start();
			MyTimerTask mytask = new MyTimerTask(3);
			myTimer.schedule(mytask, 2000);

		}

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
				WinUI.this.finish();



			}
		});

	}

	public class MyTimerTask extends TimerTask{

		/* (non-Javadoc)
		 * @see java.util.TimerTask#run()
		 */
		int playerId = 0;
		public MyTimerTask(int p){
			playerId = p;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			runOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(playerId == 1){
						frameAnimation.setBackgroundResource(R.drawable.animationlistp1win);
						frameAnimationDraw= (AnimationDrawable)frameAnimation.getBackground();
						frameAnimationDraw.start();}
					else if(playerId == 2){
						frameAnimation.setBackgroundResource(R.drawable.animationlistp2win);
						frameAnimationDraw= (AnimationDrawable)frameAnimation.getBackground();
						frameAnimationDraw.start();
					}
					else{
						frameAnimation.setBackgroundResource(R.drawable.animationlistdrawwin);
						frameAnimationDraw= (AnimationDrawable)frameAnimation.getBackground();
						frameAnimationDraw.start();
					}
				}
			});
		}

	}



	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {

		super.onPause();
		mpBAckground.stop();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {

		super.onResume();
		mpBAckground.stop();
	}

}
