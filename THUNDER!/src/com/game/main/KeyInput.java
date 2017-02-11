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
		
		
		if(key == KeyEvent.VK_W && player.getY() >= 470){
			player.setY(player.getY() - 100);
			player.setVelY(10);
		}
		
	

		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
	}

}
