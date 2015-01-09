/**
 * 
 */
package it.polimi.mad.seedgame2;

import it.polimi.mad.seedgame2.AnimationUI.AnimationView;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

/**
 * 
 *
 */
public class SpriteAnimation {

	int coordinateX;
	int coordinateY;
	int speedX;
	int speedY;
	int height;
	int width;
	Bitmap bitmapImage;
	AnimationView animationView;
	int currentFrame=0;
	String direction="";
	int widthScreen; 
	int heightScreen; 
	int numColumnsSpriteSheet=12;
	int numRowsSpriteSheet=9;
	
	
	/**
	 * @param animationView
	 * @param imageChickenAnimated
	 */
	public SpriteAnimation(AnimationView theAnimationView, Bitmap imageChickenAnimated, int widthScr,int heightScr ) {
		bitmapImage=imageChickenAnimated;
		animationView= theAnimationView;
		height=bitmapImage.getHeight()/numRowsSpriteSheet;
		width= bitmapImage.getWidth()/numColumnsSpriteSheet;
		coordinateX=0;
		coordinateY=0;
		speedX=5;
		speedY=0;
		widthScreen=widthScr; 
		heightScreen=heightScr-250; 
		
	
		
	}
	
	
	/**
	 * 
	 */
	private void update() {
		String s= "width="+width+", height="+height+", coordinateX="+coordinateX+", CoordinateY="+coordinateY+ ", speedX="+speedX +", speedY="+speedY +", animaviewHeight="+animationView.getHeight() +", animaviewWidth="+animationView.getWidth();
		Log.v("move", s);
		
		
		
		
		//Down direction
		if(coordinateX > /*animationView.getWidth()*/widthScreen- width - speedX){
			speedX=0;
			speedY=5;
			direction="down";
		}
		
		//Left direction
		if(coordinateY > /*animationView.getHeight()*/ heightScreen- height - speedY){
			speedX=-5;
			speedY=0;
			direction="left";
		
		}
		
	
		//Up direction
		if(coordinateX + speedX < 0){
			coordinateX=0;
			speedX=0;
			speedY=-5;
			direction="up";
		}
		
		//Right direction
		if(coordinateY + speedY < 0){
			coordinateY=0;
			speedX=5;
			speedY=0;
			direction="right";
		}
		
		coordinateX =  coordinateX + speedX;
		coordinateY = coordinateY + speedY;
		
	
	}


	/**
	 * @param canvas
	 */
	public void onDraw(Canvas canvas) {
	  
		update();
		//int sourceY=
		Rect src= new Rect(0, 0, width, height);
		Rect dst= new Rect(coordinateX,coordinateY, coordinateX+width, coordinateY+height);
		canvas.drawBitmap(bitmapImage, src, dst, null);
		
	}

	
}
