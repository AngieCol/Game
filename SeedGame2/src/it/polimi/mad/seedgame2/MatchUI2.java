package it.polimi.mad.seedgame2;

import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.R.integer;
import android.R.string;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
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

	MediaPlayer mpButtonSoundEffect;
	MediaPlayer mpButtonSoundEffectError;
	MediaPlayer mpBackgroundSound;
	
	//Preferences
	Boolean controlSoundBool; 
	Boolean backgroundSoundBool;
	Boolean animationBool;
	String player1;
	String player2;
	

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
		setContentView(R.layout.match3);
		bs= new BoardSituation();
		

		
		
		try {
			controlSoundBool=getIntent().getExtras().getBoolean("controlSound");
			backgroundSoundBool=getIntent().getExtras().getBoolean("backgroundSound");
			
		} catch (Exception e) {
			controlSoundBool=true; 
			backgroundSoundBool=true;
			
		}

						
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
		history.setTextColor(Color.parseColor("#FFD700"));
		mpBackgroundSound= MediaPlayer.create(this, R.raw.soundbackgroundgame);
		mpButtonSoundEffect= MediaPlayer.create(this, R.raw.soundgame1);
		
		mpBackgroundSound.setOnPreparedListener(new OnPreparedListener() {
			
			public void onPrepared(MediaPlayer mp) {
				// TODO Auto-generated method stub
				if(backgroundSoundBool){
					
					mpBackgroundSound.start();
				
					
				}
			}
		});
		
		mpButtonSoundEffectError= MediaPlayer.create(this, R.raw.pigsound);	
		playersInfo= (TextView) findViewById(R.id.tvPlayerInfo);
		
		player1Chicken =(ImageView)findViewById(R.id.chickenPlayer1);
		player2Chicken =(ImageView)findViewById(R.id.chickenPlayer2);
		playersInfo.setTextColor(Color.parseColor("#9400D3"));
		
		try{
			
			player1= getIntent().getExtras().getString("p1");
			player2= getIntent().getExtras().getString("p2");
			playersInfo.setText("Player 1 is: "+player1+ "\n  Player 2 is: "+player2);
		}
		catch(Exception e){
			playersInfo.setText("Player 1 is: not set and Player 2 is: not set");
		}
		
		
		
		//Match match= new Match(bs.generateOutputString(), getIntent().getExtras().getString("p1"), getIntent().getExtras().getString("p2"));
		//saveMatch(match);
	
		paintBoard();
		initialMove1(player1Chicken);
		initialMove2(player2Chicken);



		
		
		
		
	 
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

	
	
	public int giveImage(int numSeeds){
		
	if(numSeeds==1)return R.drawable.num1;
	if(numSeeds==2)return R.drawable.num2;
	if(numSeeds==3)return R.drawable.num3;
	if(numSeeds==4)return R.drawable.num4;
	if(numSeeds==5)return R.drawable.num5;
	if(numSeeds==6)return R.drawable.num6;
	if(numSeeds==7)return R.drawable.num7;
	if(numSeeds==8)return R.drawable.num8;
	if(numSeeds==9)return R.drawable.num9;
	if(numSeeds==10)return R.drawable.num10;
	if(numSeeds==11)return R.drawable.num11;
	if(numSeeds==12)return R.drawable.num12;
	if(numSeeds==13)return R.drawable.num13;
	if(numSeeds==14)return R.drawable.num14;
	if(numSeeds==15)return R.drawable.num15;
	if(numSeeds==16)return R.drawable.num16;
	if(numSeeds==17)return R.drawable.num17;
	if(numSeeds==18)return R.drawable.num18;
	if(numSeeds==19)return R.drawable.num19;
	if(numSeeds==20)return R.drawable.num20;
	if(numSeeds==21)return R.drawable.num21;
	if(numSeeds==22)return R.drawable.num22;
	if(numSeeds==23)return R.drawable.num23;
	if(numSeeds==24)return R.drawable.num24;
	if(numSeeds==25)return R.drawable.num25;
	if(numSeeds==26)return R.drawable.num26;
	if(numSeeds==27)return R.drawable.num27;
	if(numSeeds==28)return R.drawable.num28;
	if(numSeeds==29)return R.drawable.num29;
	if(numSeeds==30)return R.drawable.num30;
	if(numSeeds==31)return R.drawable.num31;
	if(numSeeds==32)return R.drawable.num32;
	if(numSeeds==33)return R.drawable.num33;
	if(numSeeds==34)return R.drawable.num34;
	if(numSeeds==35)return R.drawable.num35;
	if(numSeeds==36)return R.drawable.num36;
		else
			return R.drawable.num0;
	}
	
	
	public void paintBoard(){
		b00.setImageResource(giveImage(bs.Board[0][0].getNumSeed()));
		b01.setImageResource(giveImage(bs.Board[0][0].getNumSeed()));
		
		
		
		b00.setImageResource(giveImage(bs.Board[0][0].getNumSeed()));
		b01.setImageResource(giveImage(bs.Board[0][1].getNumSeed()));
		b02.setImageResource(giveImage(bs.Board[0][2].getNumSeed()));
		b03.setImageResource(giveImage(bs.Board[0][3].getNumSeed()));
		b04.setImageResource(giveImage(bs.Board[0][4].getNumSeed()));
		b05.setImageResource(giveImage(bs.Board[0][5].getNumSeed()));

		t10.setImageResource(giveImage(bs.Board[1][0].getNumSeed()));
		t15.setImageResource(giveImage(bs.Board[1][5].getNumSeed()));


		b20.setImageResource(giveImage(bs.Board[2][0].getNumSeed()));
		b21.setImageResource(giveImage(bs.Board[2][1].getNumSeed()));
		b22.setImageResource(giveImage(bs.Board[2][2].getNumSeed()));
		b23.setImageResource(giveImage(bs.Board[2][3].getNumSeed()));
		b24.setImageResource(giveImage(bs.Board[2][4].getNumSeed()));
		b25.setImageResource(giveImage(bs.Board[2][5].getNumSeed()));


		if(bs.getTurn()==2 && playersInfo.getText().toString().contains("Player 2 is: Computer")){
			if(bs.getBestMove()!=20){
			String mess= bs.movement(0,bs.getBestMove());
		//	message.setText(mess);
			paintBoard();
			}
		}

		Log.v("Game Consola", bs.getHistoryString());
		
		

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
	 */
	public void updatePlayers() {
		dbHandler=  new DataBaseHandler(this);
		Player p= new Player(player1);
		Player p2= new Player(player2);
		try {
			Dao<Player, String> playerDAO= dbHandler.getDaoPlayer();
			p=playerDAO.queryForId(player1);
			
			p2=playerDAO.queryForId(player2);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	
		
		if(bs.getWinner().equalsIgnoreCase("The winner is Player 1!!!")){
			p.updatePlayer("winner", 10);
			p2.updatePlayer("noWinner", 0);
		}
				
		else if(bs.getWinner().equalsIgnoreCase("The winner is Player 2!!!")){
			p.updatePlayer("noWinner", 0);
			p2.updatePlayer("winner", 10);
		}
		else{
			p.updatePlayer("drawn", 5);
			p2.updatePlayer("drawn", 5);
		}
		
		dbHandler=  new DataBaseHandler(this);
		
		try {
			Dao<Player, String> playerDAO= dbHandler.getDaoPlayer();
			playerDAO.update(p);
			playerDAO.update(p2);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		OpenHelperManager.releaseHelper();

	}


	/**
	 * 
	 * @param view
	 */
	private void initialMove1( View view )
	{
		
		TranslateAnimation anim = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, //fromXType 
				-1.0f,                       //fromXValue
				Animation.RELATIVE_TO_SELF, //toXType
				0.2f,                      //toXValue
				Animation.RELATIVE_TO_SELF, //fromYType
				-1.0f,                       //fromYValue
				Animation.RELATIVE_TO_SELF, //toYType
				0.0f);
		anim.setDuration(1200);
		anim.setFillAfter( true );
		view.startAnimation(anim);
	}
	private void initialMove2( View view )
	{
		
		TranslateAnimation anim = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, //fromXType 
				5.0f,                       //fromXValue
				Animation.RELATIVE_TO_SELF, //toXType
				0.7f,                      //toXValue
				Animation.RELATIVE_TO_SELF, //fromYType
				7.0f,                       //fromYValue
				Animation.RELATIVE_TO_SELF, //toYType
				0.0f);
		anim.setDuration(1200);
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



	
	@Override
	public void onClick(View v) {
		Animation animFad =  AnimationUtils.loadAnimation(MatchUI2.this, R.anim.fadeanim);
		Animation animForbiddenSelection =  AnimationUtils.loadAnimation(MatchUI2.this, R.anim.forbiddenmoveanim);
			
	
		switch(v.getId()){
		case R.id.iv00:
			bs.movement(0,0);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b00.startAnimation(animFad);
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
			
		break;
		case R.id.iv01:
			bs.movement(0,1);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b01.startAnimation(animFad);
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
			
		break;
		case R.id.iv02:
			bs.movement(0,2);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b02.startAnimation(animFad);
			
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
		break;
		case R.id.iv03:
			bs.movement(0,3);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b03.startAnimation(animFad);
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
			
		break;
		case R.id.iv04:
			bs.movement(0,4);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b04.startAnimation(animFad);
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
		break;		
		case R.id.iv05:
			bs.movement(0,5);
			history.setText(bs.getHistoryString());

			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b05.startAnimation(animFad);
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
		break;
		case R.id.iv10:
			bs.movement(1,0);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffectError.start();
			t10.startAnimation(animForbiddenSelection);
			
		break;
		case R.id.iv15:
			bs.movement(1,5);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffectError.start();
			t15.startAnimation(animForbiddenSelection);
			
		break;
		case R.id.iv20:
			bs.movement(2,0);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b20.startAnimation(animFad);
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
		case R.id.iv21:
			bs.movement(2,1);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b21.startAnimation(animFad);
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
			
		break;
		case R.id.iv22:
			bs.movement(2,2);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b22.startAnimation(animFad);
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
			
		break;
		case R.id.iv23:
			bs.movement(2,3);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b23.startAnimation(animFad);
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
		break;
		case R.id.iv24:
			bs.movement(2,4);
			history.setText(bs.getHistoryString());
		
			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b24.startAnimation(animFad);
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
		break;
		case R.id.iv25:
			bs.movement(2,5);
			history.setText(bs.getHistoryString());
			
			if(controlSoundBool)
				mpButtonSoundEffect.start();
			b25.startAnimation(animFad);
			paintBoard();
			if(history.getText().toString().contains("The game is finished")){
				Intent in= new Intent(MatchUI2.this, WinUI.class);
				String sWin= bs.getWinner().toString();
				in.putExtra("winner", sWin);
				updatePlayers();
				startActivity(in);
				this.finish();
			}
		break;
		
		}
		
	}
	
	
	@Override
	protected void onResume() {
		
		super.onResume();
		mpBackgroundSound.stop();
	}


	@Override
	protected void onPause() {
		
		super.onPause();
		mpBackgroundSound.stop();
	}

	


}
