package com.game.main;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Thunder extends GameObject{
	int seconedPassed = 0;
	Timer timer = new Timer();
	TimerTask task = new TimerTask(){
		public void run(){
			
			seconedPassed++;
		}
		
		
	};
	

	public Thunder(int x, int y, ID id) {
		super(x, y, id);
		
		timer.scheduleAtFixedRate(task, 1000, 1000);
		this.x = x;
		this.y = y;
		
	}
	public Rectangle getBounds(){
		return new Rectangle(x, y, 150, 20);
	}
	public void tick(){
		if (seconedPassed >= 12){
			x -= 30;

		}

		
	
		boolean running = true;
		
		while(running){
			if (seconedPassed == 11 || seconedPassed == 14 || seconedPassed == 18 || seconedPassed == 21 
					|| seconedPassed == 25 || seconedPassed == 29 || seconedPassed == 32 
					|| seconedPassed == 36 || seconedPassed == 39 || seconedPassed == 43
					|| seconedPassed == 51 || seconedPassed == 59 || seconedPassed == 66
					|| seconedPassed == 73 ){
				x = 1150;

			}
			running = false;
        }
		
		
		
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 150, 20);
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		if (seconedPassed == 11 || seconedPassed == 14 || seconedPassed == 18 || seconedPassed == 22 
				|| seconedPassed == 25 || seconedPassed == 29 || seconedPassed == 32 
				|| seconedPassed == 36 || seconedPassed == 39 || seconedPassed == 43
				|| seconedPassed == 51 || seconedPassed == 59 || seconedPassed == 66
				|| seconedPassed == 73){
			g.setColor(Color.YELLOW);
			g.fillRect(0, 120, 1000, 30);
			g.fillRect(0, 180, 1000, 30);
			g.fillRect(0, 180+60, 1000, 30);
			g.fillRect(0, 180+120, 1000, 30);
			g.fillRect(0, 180+180, 1000, 30);

		}
		
	}
}