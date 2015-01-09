/**
 * 
 */
package it.polimi.mad.seedgame2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

/**
 * 
 *
 */
@SuppressLint("WrongCall")
public class AnimationUI extends Activity implements OnTouchListener {
	
	AnimationView av;
	Bitmap imageChickenToMove, imageChickenAnimated;
	float coordinateX, coordinateY;
	SpriteAnimation spriteAnimation ;
	
	
	boolean canDrawAnimation=false;
	SurfaceHolder surfaceHolderAnimation;
	Thread threadAnimation=null;
	boolean spriteLoaded=false;
	
	int widthScreen; 
	int heightScreen; 
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		imageChickenToMove=BitmapFactory.decodeResource(getResources(), R.drawable.pollo);
		imageChickenAnimated=BitmapFactory.decodeResource(getResources(), R.drawable.chickensheet);
		
		av= new AnimationView(this);
		av.setOnTouchListener(this);
		
		coordinateX=0;
		coordinateY=0;
		Toast t= Toast.makeText(AnimationUI.this, "Move the chicken, touching the place you want to put it or draging the image", Toast.LENGTH_LONG);
		t.show();
		setContentView(av);
		
		Display display = getWindowManager().getDefaultDisplay(); 
		widthScreen = display.getWidth();
		heightScreen = display.getHeight();
		
	}
	
		
	@Override
	protected void onPause() {

		super.onPause();
		av.pause();
	}

	@Override
	protected void onResume() {
		
		super.onResume();
		av.resume();
	}
	
	
	
	/**
	 * */
	@Override
	public boolean onTouch(View v, MotionEvent event) {
	 
	
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			
			coordinateX= event.getX();
			coordinateY=event.getY();
			break;

		case MotionEvent.ACTION_UP:
			
			coordinateX= event.getX();
			coordinateY=event.getY();
			break;
			
		 case MotionEvent.ACTION_MOVE:
			
			coordinateX= event.getX();
			coordinateY=event.getY();
				break;
		}
	  
		return true;
	}
	
	/**
	 * 
	 * Class required for the animation
	 *
	 */
	public class AnimationView extends SurfaceView implements Runnable{

		
		
		/**
		 * @param context
		 */
		public AnimationView(Context context) {
			super(context);
			surfaceHolderAnimation=getHolder();
			spriteAnimation= new SpriteAnimation(this, imageChickenAnimated, widthScreen, heightScreen);		
			
		}

		/**
		 */
		@Override
		public void run() {
			
			//Draws the animation
			while(canDrawAnimation){
				//loop until the surface is valid
				if(!surfaceHolderAnimation.getSurface().isValid())
					continue;
				
				
				if(!spriteLoaded){
					spriteAnimation= new SpriteAnimation(AnimationView.this,imageChickenAnimated, widthScreen, heightScreen);
					spriteLoaded=true;
				}
				
				
				Canvas canvasAnimation= surfaceHolderAnimation.lockCanvas();
				onDraw(canvasAnimation);
				surfaceHolderAnimation.unlockCanvasAndPost(canvasAnimation);
				
				
				
			}
		}
		
		
	/**
	 *
	 **/
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawARGB(255, 150, 150, 10);
		canvas.drawBitmap(imageChickenToMove,coordinateX-(imageChickenToMove.getWidth()/2),coordinateY-(imageChickenToMove.getHeight()/2), null);
		
		spriteAnimation.onDraw(canvas);
	}
		
		/**
		 */
		public void pause() {
			
			canDrawAnimation=false;
			while(true){
				try {
					threadAnimation.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			threadAnimation=null;
		}
		
		/**
		 */
		public void resume() {
			
			canDrawAnimation=true;
			threadAnimation = new Thread(this);
			threadAnimation.start();
		}
		
		
		
	}


	

	
}
