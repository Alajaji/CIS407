package com.game.main;

import java.awt.Color;

import java.awt.Graphics;
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
	
	public void tick(){
		x -= 20;
	
		boolean running = true;
		while(running){
			if (seconedPassed == 3 || seconedPassed == 9 ){
				x = 1100;

			}
			running = false;
        }
		
		
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 150, 20);
	}
}