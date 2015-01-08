package it.polimi.mad.seedgame2;

import java.io.IOException;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.R.integer;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MatchUI2 extends OrmLiteBaseActivity<DataBaseHandler> implements OnClickListener{



	/**
	 * variables
	 */

	BoardSituation bs=null;
	Match mat=null;

	ImageView b00= null;
	ImageView b01= null;
	ImageView b02= null;
	ImageView b03= null;
	ImageView b04= null;
	ImageView b05= null;


	ImageView b20= null;
	ImageView b21= null;
	ImageView b22= null;
	ImageView b23= null;
	ImageView b24= null;
	ImageView b25= null;


	ImageView t10= null;
	ImageView t15= null;

	TextView history= null;
	
	TextView playersInfo=null;


	ImageView player1Chicken; 
	ImageView player2Chicken;
	DataBaseHandler dbHandler;

	MediaPlayer mpButton;
	
	//Preferences
	Boolean controlSoundBool=true; 
	Boolean backgroundSoundBool=true;
	Boolean animationBool=true;

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//==================================================================================================
	/////////////////////////////////////////////////////////////////////////////////////////////////////


	/**
	 * Methods
	 */



	/**
	 * Match onCreate 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.match2);
		bs= new BoardSituation();
		//mat= new Match("", "", "");

		
		b00= (ImageView) findViewById(R.id.iv00);
		b01= (ImageView) findViewById(R.id.iv01);
		b02= (ImageView) findViewById(R.id.iv02);
		b03= (ImageView) findViewById(R.id.iv03);
		b04= (ImageView) findViewById(R.id.iv04);
		b05= (ImageView) findViewById(R.id.iv05);


		b20= (ImageView) findViewById(R.id.iv20);
		b21= (ImageView) findViewById(R.id.iv21);
		b22= (ImageView) findViewById(R.id.iv22);
		b23= (ImageView) findViewById(R.id.iv23);
		b24= (ImageView) findViewById(R.id.iv24);
		b25= (ImageView) findViewById(R.id.iv25);


		t10= (ImageView) findViewById(R.id.iv10);
		t15= (ImageView) findViewById(R.id.iv15);

		history=(TextView) findViewById(R.id.moves);
		mpButton= MediaPlayer.create(this, R.raw.sound1);
		playersInfo= (TextView) findViewById(R.id.tvPlayerInfo);
		
		player1Chicken =(ImageView)findViewById(R.id.chickenPlayer1);
		player2Chicken =(ImageView)findViewById(R.id.chickenPlayer2);
				
		//playersInfo.setText("Player 1 is: "+getIntent().getExtras().getString("p1")+ " and Player 2 is: "+getIntent().getExtras().getString("p2"));
		playersInfo.setText("Player 1 is: not set and Player 2 is: not set");
		
		//Match match= new Match(bs.generateOutputString(), getIntent().getExtras().getString("p1"), getIntent().getExtras().getString("p2"));
		//saveMatch(match);
	
		paintBoard();
		//initialMove(player1Chicken);



		
		
		
		
	 
		b00.setOnClickListener(this);
		b01.setOnClickListener(this);
		b02.setOnClickListener(this);
		b03.setOnClickListener(this);
		b04.setOnClickListener(this);
		b05.setOnClickListener(this);
		t10.setOnClickListener(this);
		t15.setOnClickListener(this);
		b20.setOnClickListener(this);
		b21.setOnClickListener(this);
		b22.setOnClickListener(this);
		b23.setOnClickListener(this);
		b24.setOnClickListener(this);
		b25.setOnClickListener(this);
		
		
	}



	/**
	 * paintBoard shows in the interface the Board
	 */

	public void paintBoard(){

		/*b00.setText((bs.Board[0][0].getNumSeed())+"");
		b01.setText((bs.Board[0][1].getNumSeed())+"");
		b02.setText((bs.Board[0][2].getNumSeed())+"");
		b03.setText((bs.Board[0][3].getNumSeed())+"");
		b04.setText((bs.Board[0][4].getNumSeed())+"");
		b05.setText((bs.Board[0][5].getNumSeed())+"");

		t10.setText((bs.Board[1][0].getNumSeed())+"");
		t15.setText((bs.Board[1][5].getNumSeed())+"");


		b20.setText((bs.Board[2][0].getNumSeed())+"");
		b21.setText((bs.Board[2][1].getNumSeed())+"");
		b22.setText((bs.Board[2][2].getNumSeed())+"");
		b23.setText((bs.Board[2][3].getNumSeed())+"");
		b24.setText((bs.Board[2][4].getNumSeed())+"");
		b25.setText((bs.Board[2][5].getNumSeed())+"");


		if(bs.getTurn()==2 && playersInfo.getText().toString().contains(" and Player 2 is: Computer")){

			String mess= bs.movement(0,bs.getBestMove());
			message.setText(mess);
			paintBoard();
		}

		if(message.getText().toString().contains("The game is finished. ")){

		}
*/
	}



	/**
	 * 
	 */
	public void saveMatch(Match m) {
		dbHandler= OpenHelperManager.getHelper(this, DataBaseHandler.class);
		RuntimeExceptionDao<Match, integer> matchDAO= dbHandler.getMatchRuntimeExceptionDao();
		matchDAO.create(m);
		OpenHelperManager.releaseHelper();

	}



	/**
	 * 
	 * @param view
	 */
	private void initialMove( View view )
	{
		/* RelativeLayout root = (RelativeLayout) findViewById( R.id.relativeLayoutPollo );
	    DisplayMetrics dm = new DisplayMetrics();
	    this.getWindowManager().getDefaultDisplay().getMetrics( dm );
	    int statusBarOffset = dm.heightPixels - root.getMeasuredHeight();

	    int originalPos[] = new int[2];
	    view.getLocationOnScreen( originalPos );

	    int xDest = dm.widthPixels/2;
	    xDest -= (view.getMeasuredWidth()/2);
	    int yDest = dm.heightPixels/2 - (view.getMeasuredHeight()/2) - statusBarOffset;
		 */
		TranslateAnimation anim = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, //fromXType 
				-1.0f,                       //fromXValue
				Animation.RELATIVE_TO_SELF, //toXType
				0.2f,                      //toXValue
				Animation.RELATIVE_TO_SELF, //fromYType
				-1.0f,                       //fromYValue
				Animation.RELATIVE_TO_SELF, //toYType
				0.0f);
		anim.setDuration(500);
		anim.setFillAfter( true );
		view.startAnimation(anim);
	}


	/**
	 * 
	 * @param view
	 */
	private void moves( View view )
	{

		TranslateAnimation anim = new TranslateAnimation(
				b00.getX(), b01.getX(), b00.getY(),b00.getY());
		anim.setDuration(100);
		anim.setFillAfter( true );
		view.startAnimation(anim);
	}



	
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.iv00:
			bs.movement(0,0);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
			
			
		break;
		case R.id.iv01:
			bs.movement(0,1);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;
		case R.id.iv02:
			bs.movement(0,2);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;
		case R.id.iv03:
			bs.movement(0,3);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;
		case R.id.iv04:
			bs.movement(0,4);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;		
		case R.id.iv05:
			bs.movement(0,5);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;
		case R.id.iv10:
			bs.movement(1,0);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;
		case R.id.iv15:
			bs.movement(1,5);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;
		case R.id.iv20:
			bs.movement(2,0);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		case R.id.iv21:
			bs.movement(2,1);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;
		case R.id.iv22:
			bs.movement(2,2);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;
		case R.id.iv23:
			bs.movement(2,3);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;
		case R.id.iv24:
			bs.movement(2,4);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;
		case R.id.iv25:
			bs.movement(2,5);
			history.setText(bs.getHistoryString());
			paintBoard();
			mpButton.start();
		break;
		}
		
	}





}
