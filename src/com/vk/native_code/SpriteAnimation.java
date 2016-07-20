package com.vk.native_code;


import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

final public class SpriteAnimation extends Transition{
	
	 final ImageView imageView;
	 final int count;
	 final int columns;
	 int offsetX;
	 int offsetY;
	 final int width;
	 final int height;

    
    
    
   public SpriteAnimation
   (
    		ImageView imageView,
    		Duration duration,
    		int count,int columns,
    		int offsetX,int offsetY,
    		int width,int height
   )
   {  
	   this.imageView=imageView;
	   this.count=count;
	   this.columns=columns;
	   this.offsetX=offsetX;
	   this.offsetY=offsetY;
	   this.width=width;
	   this.height=height;
	   setCycleDuration(duration);   
	   setCycleCount(Animation.INDEFINITE);
	   setInterpolator(Interpolator.LINEAR);
	 DropShadow shadow = new DropShadow();
	 shadow.setRadius(7f);
		shadow.setOffsetX(-4);
		shadow.setOffsetY(-5);
		shadow.setColor(Color.BLACK);
		this.imageView.setEffect(shadow);
	   this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
    }
   
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}


	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}


	@Override
	protected void interpolate(double k) {
		final int index = Math.min((int) Math.floor(k*count), count-1);
		final int x = (index%columns)*width+offsetX;
		final int y = (index/columns)*height+offsetY;
		imageView.setViewport(new Rectangle2D(x, y, width, height));
	}
    
    
    
}
