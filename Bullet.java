/**
 * @(#)Bullet.java
 *
 *
 * @author 
 * @version 1.00 2021/11/21
 */

import java.awt.*;
public class Bullet {
	private int x;
	private int y;
	protected int width = 10;
	protected int height = 10;
    public Bullet(int x,int y) {
    	this.x = x;
    	this.y = y;
    }
    public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    }
    public void move(){
    	y -= 5;
    }
    public void draw(Graphics g){
    	g.fillRect(x,y,width,height);
    }
}