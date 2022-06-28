/**
 * @(#)Panel.java
 *
 *
 * @author 
 * @version 1.00 2021/11/21
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
public class GamePanel extends JPanel{
	public final int DELAY = 50;
	public JLabel score;
	public ArrayList<Bullet> bullets;
	public ArrayList<Block> blocks;
	public Timer timer;
	public Random r;
	public int x;
	public int y;
	public int hits;
    public GamePanel(int x, int y) {
    	super();
    	this.x = x;
    	this.y = y;
    	init();
    }
    public void init(){
    	hits = 0;
    	TimerListener listener = new TimerListener();
    	timer = new Timer(DELAY,listener);
    	bullets = new ArrayList<Bullet>();
    	blocks = new ArrayList<Block>();
    	score = new JLabel("score: " + hits);
    	r = new Random();
    	for(int i = 0; i < 7; i++){
    		int rx = r.nextInt(x-60);
    		int ry = r.nextInt(y);
    		blocks.add(new Block(rx,ry));
    	}
    	addMouseListener(new ClickListener());
    	setVisible(true);
    	setPreferredSize(new Dimension(800,600));
    	setBackground(Color.white);
    	add(score);
    	timer.start();
    }
    public void paintComponent(Graphics g){
    	g.setColor(Color.red);
    	super.paintComponent(g);
    	for(int i = 0; i < bullets.size(); i++){
    		bullets.get(i).draw(g);
    	}
    	g.setColor(Color.green);
    	for(int i = 0; i < blocks.size(); i++){
    		blocks.get(i).draw(g);
    	}
    	
    }
    private class ClickListener implements MouseListener{
    	public void mouseClicked(MouseEvent e){}
    	public void mouseReleased(MouseEvent e){}
    	public void mousePressed(MouseEvent e){
    		bullets.add(new Bullet(e.getX(),600));
    		repaint();}
    	public void mouseEntered(MouseEvent e){}
    	public void mouseExited(MouseEvent e){}
    }
    private class TimerListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		for(int i = 0; i < bullets.size(); i++){
    			bullets.get(i).move();
    			if(bullets.get(i).getY() < 0){
    				bullets.remove(i);
    			}
    		}
    		for(int i = 0; i < blocks.size(); i++){
    			blocks.get(i).move();
    			if(blocks.get(i).getY() >= 600){
    				blocks.remove(i);
    			}
    		}
    		ArrayList<String> rbl = new ArrayList<String>();
    		ArrayList<String> rbu = new ArrayList<String>();
    		for(int i = 0; i < blocks.size(); i++){
    			for(int a = 0; a < bullets.size(); a++){	
    				if(blocks.get(i).checkCollision(bullets.get(a))){
    					rbl.add(i+"");
    					rbu.add(a+"");
    					hits++;
    					score.setText("score: " + hits);
    				}
    			}
    		}
    		for(int i = 0; i < rbl.size(); i++){
    			blocks.remove(Integer.parseInt(rbl.get(i)));
    		}
    		for(int i = 0; i < rbu.size(); i++){
    			bullets.remove(Integer.parseInt(rbu.get(i)));
    		}
    		if(blocks.size() < 5){
    			for(int i = 0; i < 3; i++){
    				int rx = r.nextInt(800-60);
    				int ry = 0;
    				blocks.add(new Block(rx,ry));
    			}
    		}
    		repaint();
    	}
    }
    
    
}