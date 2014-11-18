package it.polimi.mad.seedgame2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Match extends Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.match);
		final BoardSituation bs= new BoardSituation();
	
		
		final TextView b11= (TextView) findViewById(R.id.textView1);
		final TextView b12= (TextView) findViewById(R.id.textView2);
		final TextView b13= (TextView) findViewById(R.id.textView3);
		final TextView b14= (TextView) findViewById(R.id.textView4);
		final TextView b15= (TextView) findViewById(R.id.textView5);
		final TextView b16= (TextView) findViewById(R.id.textView6);
		
		
		Button bStart= (Button) findViewById(R.id.button1);
		bStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*b11.setText(bs.Board[0][0].getNumSeed());
				b12.setText(bs.Board[0][1].getNumSeed());
				b13.setText(bs.Board[0][2].getNumSeed());
				b14.setText(bs.Board[0][3].getNumSeed());
				b15.setText(bs.Board[0][4].getNumSeed());
				b16.setText(bs.Board[0][5].getNumSeed());
				*/
				
				b11.setText("a");
				b12.setText("a");
				b13.setText("a");
				b14.setText("a");
				b15.setText("a");
				b16.setText("a");
				
			}
		});
		
		
		
		
		
		b11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				b11.setText("hola");
			}
		});





	}



}
