package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class HealthBar {
	public static int HEALTH = 100;
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.red);
		g.fillRect(20, 20, HEALTH*2, 35);
		g.setColor(Color.white);
		g.drawRect(20, 20, 200, 35);
		
	}
}
