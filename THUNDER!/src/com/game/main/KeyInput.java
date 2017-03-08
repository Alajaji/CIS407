package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Player player;

	public KeyInput(Player player){
		this.player = player;
	}
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		
		if(key == KeyEvent.VK_UP && player.getY() >= 470){
			player.setY(player.getY() - 150);
			player.setVelY(10);
		}
		if(key == KeyEvent.VK_LEFT){
			player.setX(player.getX() - 10);
			
		}
		if(key == KeyEvent.VK_RIGHT){
			player.setX(player.getX() + 10);
			
		}
		
	

		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
	}

}
