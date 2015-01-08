/**
 * 
 */
package it.polimi.mad.seedgame2;

import it.polimi.mad.seedgame2.AnimationUI.AnimationView;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

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
	
	/**
	 * @param animationView
	 * @param imageChickenAnimated
	 */
	public SpriteAnimation(AnimationView theAnimationView, Bitmap imageChickenAnimated) {
		bitmapImage=imageChickenAnimated;
		animationView= theAnimationView;
		width= bitmapImage.getWidth();
		height=bitmapImage.getHeight();
		speedX=5;
		speedX=0;
		coordinateX=0;
		coordinateY=0;
		
		
		
	}

	/**
	 * @param canvas
	 */
	public void onDraw(Canvas canvas) {
	  
		
		Rect src= new Rect(0, 0, width, height);
		Rect dst= new Rect(coordinateX,coordinateY, coordinateX+width, coordinateY+height);
		canvas.drawBitmap(bitmapImage, src, dst, null);
		
	}

}
