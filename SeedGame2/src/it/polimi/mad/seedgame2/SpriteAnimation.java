/**
 * 
 */
package it.polimi.mad.seedgame2;

import it.polimi.mad.seedgame2.AnimationUI.AnimationView;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

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
	int direction=3;
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
		heightScreen=heightScr;//-250; 
		
	
		
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
			direction=1;//down
		}
		
		//Left direction
		if(coordinateY > /*animationView.getHeight()*/ heightScreen- height - speedY){
			speedX=-5;
			speedY=0;
			direction=2;//left
		
		}
		
	
		//Up direction
		if(coordinateX + speedX < 0){
			coordinateX=0;
			speedX=0;
			speedY=-5;
			direction=0;//up
		}
		
		//Right direction
		if(coordinateY + speedY < 0){
			coordinateY=0;
			speedX=5;
			speedY=0;
			direction=3;//right
		}
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		currentFrame=++currentFrame%numColumnsSpriteSheet;
		
		coordinateX =  coordinateX + speedX;
		coordinateY = coordinateY + speedY;
		
	
	}


	/**
	 * @param canvas
	 */
	public void onDraw(Canvas canvas) {
	  
		update();
		int sourceX= currentFrame*width;
		int sourceY= direction*height;
		Rect src= new Rect(sourceX, sourceY, sourceX+width, sourceY+ height);
		Rect dst= new Rect(coordinateX,coordinateY, coordinateX+width, coordinateY+height);
		canvas.drawBitmap(bitmapImage, src, dst, null);
		
	}

	
}
