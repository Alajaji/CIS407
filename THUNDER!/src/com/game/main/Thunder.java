package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Thunder extends GameObject{

	public Thunder(int x, int y, ID id) {
		super(x, y, id);
		
		Random random = new Random();
		Random random1 = new Random();
		
		velX = 10;
		velY = 10;
	}
	
	public void tick(){
		x += velX;
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 1000, 10);
	}
}