
package it.polimi.mad.seedgame2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
 *
 */
public class MatchPreferencesUI extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.matchpreferences);
		
		
		Button b2 = (Button) findViewById(R.id.button1);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent in= new Intent(MatchPreferencesUI.this, MatchUI.class);
				startActivity(in);
			}
		});
	}
	
	
	
	
}
