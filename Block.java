/**
 * @(#)Block.java
 *
 *
 * @author 
 * @version 1.00 2021/11/21
 */

import java.awt.*;
public class Block {
	private int x;
	private int y;
	protected int width;
	protected int height;
    public Block(int x, int y) {
    	this.x = x;
    	this.y = y;
    	width = 60;
    	height = 10;
    }
    public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    }
    public void move(){
    	y += 5;
    }
    public boolean checkCollision(Bullet b){
    	if((x <= b.getX() && b.getX() <= x + width) || (x <= (b.getX() + b.width) && (b.getX() + b.width)  <= (x + width))){
    		if(y <= b.getY() && b.getY() <= y + height){
    			return true;
    		}
    	}
    	return false;
    }
    public void draw(Graphics g){
    	g.fillRect(x,y,width,height);
    }
    
}