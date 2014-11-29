package it.polimi.mad.seedgame2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MatchUI extends Activity {

	
	
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
		setContentView(R.layout.match);
		bs= new BoardSituation();
		mat= new Match("", "", "");
		
		message= (TextView) findViewById(R.id.textView34);
		message.setText("Please Select the Players and Press Start...");
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
		
		
		
		
		Button bStart= (Button) findViewById(R.id.button1);
		bStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				bs= new BoardSituation();
				message.setText("Player "+bs.getTurno()+" begins");
				paintBoard();
				
			
				
			}
		});
		
		
		
		
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
					 message.setText("Player "+bs.getTurno()+" begins");
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
		
	}


}
