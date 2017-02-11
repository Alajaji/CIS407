package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject{

	public Player(int x, int y, ID id) {
		super(x, y, id);
		
		
		this.x = x;
		this.y = y;
	}
	
	public void tick(){
		if(y != 470){
			y += velY;
		}
		
	}
	
	public void render(Graphics g){
		g.setColor(new Color(60,0,0));
		g.fillRect(x, y, 30, 10);
		
		g.setColor(new Color(153,102,0));
		g.fillRect(x, y+10, 30, 15);
		
		g.setColor(Color.BLACK);
		g.fillRect(x, y+25, 10, 15);
		
		g.setColor(new Color(153,102,0));
		g.fillRect(x+10, y+25, 10, 15);
		
		g.setColor(Color.BLACK);
		g.fillRect(x+20, y+25, 10, 15);
		
		g.setColor(new Color(153,102,0));
		g.fillRect(x, y+40, 30, 15);
		
		g.setColor(new Color(60,0,0));
		g.fillRect(x, y+55, 30, 45);
		
		
		
	}
}
