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
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Toast;

/**
 * 
 *
 */
@SuppressLint("WrongCall")
public class AnimationUI extends Activity implements OnTouchListener {
	
	AnimationView av;
	Bitmap imageChickenToMove, imageChickenAnimated, imageSeed;
	float coordinateX, coordinateY;
	SpriteAnimation spriteAnimation ;
	
	
	boolean canDrawAnimation=false;
	SurfaceHolder surfaceHolderAnimation;
	Thread threadAnimation=null;
	boolean spriteLoaded=false;
	
	int widthScreen; 
	int heightScreen; 
	
	int x,y;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		imageChickenToMove=BitmapFactory.decodeResource(getResources(), R.drawable.pollo);
		imageChickenAnimated=BitmapFactory.decodeResource(getResources(), R.drawable.chickensheet);
		imageSeed =BitmapFactory.decodeResource(getResources(), R.drawable.seeed);
		
		
		av= new AnimationView(this);
		av.setOnTouchListener(this);
		
		coordinateX=0;
		coordinateY=0;
		
		x=0;
		y=0;
		
		Toast t= Toast.makeText(AnimationUI.this, "Move the chicken, touching the place you want to put it or draging the image", Toast.LENGTH_LONG);
		t.show();
		setContentView(av);
		
		
		//Get width and height of the screen without the bar 
		Display display = getWindowManager().getDefaultDisplay(); 
		
		
		Rect rectangle= new Rect();
		Window window= getWindow();
		window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
		int statusBarHeight= rectangle.top;
		int contentViewTop= 
		    window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
		int titleBarHeight= contentViewTop - statusBarHeight;
		widthScreen = display.getWidth();
		
		heightScreen = display.getHeight()-(titleBarHeight*5);
		
		
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
			
			
			spriteAnimation= new SpriteAnimation(AnimationView.this,imageChickenAnimated, widthScreen, heightScreen);
			
			//Draws the animation
			while(canDrawAnimation){
				//loop until the surface is valid
				if(!surfaceHolderAnimation.getSurface().isValid())
					continue;
				
				
				/*if(!spriteLoaded){
					spriteAnimation= new SpriteAnimation(AnimationView.this,imageChickenAnimated, widthScreen, heightScreen);
					spriteLoaded=true;
				}
				**/
				
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
		
		
		if(x< canvas.getWidth())
			x+=10;
		else
			x=0;
		if(y< canvas.getHeight())
			y+=10;
		else
			y=0;
	canvas.drawBitmap(imageSeed, x, y, new Paint());
	
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
