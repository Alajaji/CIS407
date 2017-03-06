package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Thunder extends GameObject{

	public Thunder(int x, int y, ID id) {
		super(x, y, id);
		
		
		this.x = x;
		this.y = y;
	}
	
	public void tick(){
		x-= 20;
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 100, 20);
	}
}