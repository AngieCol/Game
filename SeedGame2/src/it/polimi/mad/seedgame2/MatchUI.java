package it.polimi.mad.seedgame2;

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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MatchUI extends OrmLiteBaseActivity<DataBaseHandler> {

	
	
	/**
	 * variables
	 */
	
	BoardSituation bs=null;
	Match mat=null;
	
	TextView b00= null;
	TextView b01= null;
	TextView b02= null;
	TextView b03= null;
	TextView b04= null;
	TextView b05= null;
	
	
	TextView b20= null;
	TextView b21= null;
	TextView b22= null;
	TextView b23= null;
	TextView b24= null;
	TextView b25= null;
	
	
	TextView b10= null;
	TextView b15= null;
	
	TextView message= null;
	EditText inputString=null;
	
	TextView explica= null;
	TextView playersInfo=null;
	
	
	ImageView player1Chicken; 
	
	DataBaseHandler dbHandler;
	
	MediaPlayer mp;

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
		mat= new Match("", "", "");
		
		message= (TextView) findViewById(R.id.textView34);
		
		explica=(TextView) findViewById(R.id.textView35);
		
		b00= (TextView) findViewById(R.id.textView1);
		b01= (TextView) findViewById(R.id.textView2);
		b02= (TextView) findViewById(R.id.textView3);
		b03= (TextView) findViewById(R.id.textView4);
		b04= (TextView) findViewById(R.id.textView5);
		b05= (TextView) findViewById(R.id.textView6);
		
		
		b20= (TextView) findViewById(R.id.textView14);
		b21= (TextView) findViewById(R.id.textView16);
		b22= (TextView) findViewById(R.id.textView18);
		b23= (TextView) findViewById(R.id.textView20);
		b24= (TextView) findViewById(R.id.textView22);
		b25= (TextView) findViewById(R.id.textView24);
		
		
		
		b10= (TextView) findViewById(R.id.textView7);
		b15= (TextView) findViewById(R.id.textView12);
		
		playersInfo= (TextView) findViewById(R.id.textView36);
		//playersInfo.setText("Player 1 is: "+getIntent().getExtras().getString("p1")+ " and Player 2 is: "+getIntent().getExtras().getString("p2"));
		playersInfo.setText("Player 1 is: not set and Player 2 is: not set");
		
		player1Chicken =(ImageView)findViewById(R.id.imageView1);
		
		
		//Match match= new Match(bs.generateOutputString(), getIntent().getExtras().getString("p1"), getIntent().getExtras().getString("p2"));
		
		//saveMatch(match);
		
		
		
				
				message.setText("Player "+bs.getTurn()+" begins");
				paintBoard();
				initialMove(player1Chicken);

		
		
		
		inputString= (EditText)findViewById(R.id.editText1);
		
		Button bStart2= (Button) findViewById(R.id.button2);
		bStart2.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				String inputS= inputString.getText().toString();
				
				String rta=mat.verifyStringInput(inputS);
				
				if(rta==""){
				 bs= new BoardSituation(inputS);
				 boolean b= bs.verifyWin();
				 if(!b){
					 message.setText("Player "+bs.getTurn()+" begins");
				 }
				 else{
					 message.setText("The game is finished. "+ bs.getWinner());
				 }
				 
				 paintBoard();
				}
				else
					message.setText("The input text has a wrong structure. "+rta);
				
				
				
			
				
			}
		});
		
		
	
		

		b00.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(0,0);
				message.setText(mess);
				paintBoard();
				moves(player1Chicken);
				b00.getX();
				b00.getY();
				
			}
		});
		
		
		b01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(0,1);
				message.setText(mess);
				paintBoard();
				
			}
		});
		
		b02.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(0,2);
				message.setText(mess);
				paintBoard();
			}
		});
		
		
		b03.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(0,3);
				message.setText(mess);
				paintBoard();
			}
		});
		
		b04.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(0,4);
				message.setText(mess);
				paintBoard();
			}
		});
		
		
		b05.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(0,5);
				message.setText(mess);
				paintBoard();
			}
		});
		
		
	

		b20.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(2,0);
				message.setText(mess);
				paintBoard();
			
			}
		});

		b21.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(2,1);
				message.setText(mess);
				paintBoard();
				
			}
		});

		b22.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(2,2);
				message.setText(mess);
				paintBoard();
			}
		});

		b23.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(2,3);
				message.setText(mess);
				paintBoard();
			}
		});

		b24.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(2,4);
				message.setText(mess);
				paintBoard();
			}
		});
		
		b25.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(2,5);
				message.setText(mess);
				paintBoard();
			}
		});
		
		
		
		b10.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(1,0);
				message.setText(mess);
				paintBoard();
			}
		});
		
		b15.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String mess= bs.movement(1,5);
				message.setText(mess);
				paintBoard();
			}
		});
		
		
		
		
		
		
	}

	
	
	/**
	 * paintBoard shows in the interface the Board
	 */
	
	public void paintBoard(){
		
		b00.setText((bs.Board[0][0].getNumSeed())+"");
		b01.setText((bs.Board[0][1].getNumSeed())+"");
		b02.setText((bs.Board[0][2].getNumSeed())+"");
		b03.setText((bs.Board[0][3].getNumSeed())+"");
		b04.setText((bs.Board[0][4].getNumSeed())+"");
		b05.setText((bs.Board[0][5].getNumSeed())+"");
		
		b10.setText((bs.Board[1][0].getNumSeed())+"");
		b15.setText((bs.Board[1][5].getNumSeed())+"");
		
		
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

	
}
