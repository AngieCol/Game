package it.polimi.mad.seedgame2;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.R.integer;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class WinUI extends Activity implements OnClickListener{



	/**
	 * variables
	 */

	
	
	//frame animation
	ImageView frameAnimation;
	MediaPlayer mpBAckground;
	TextView playerInfo=null;

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
		
	
	    frameAnimation = (ImageView)findViewById(R.id.frameAnimation);
		frameAnimation.setBackgroundResource(R.drawable.animationlist);
		frameAnimation.post(new Runnable() {
			
			@Override
			public void run() {
				AnimationDrawable frameAnimationDraw= (AnimationDrawable)frameAnimation.getBackground();
				frameAnimationDraw.start();
			}
		});
	}

	/**
	 * 
	 **/
	@Override
	public void onClick(View arg0) {
		
		
	}





}
