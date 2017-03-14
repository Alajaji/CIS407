package com.game.main;

import java.awt.Canvas;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Game extends Canvas implements Runnable{
	
	
	private static final long serialVersionUID = -473349850293143017L;
	
	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12*9;
	private Thread thread;
	private boolean running = false;
	private Player player;
	private Thunder thunder;
	private HealthBar healthBar;
	private int score = HealthBar.HEALTH;;
	private String highscore = "High Score: ";

	
	int seconedPassed = 0;
	Timer timer = new Timer();
	TimerTask task = new TimerTask(){
		public void run(){
			seconedPassed++;
		}
		
		
	};
	
	public Game(){
		
		
		timer.scheduleAtFixedRate(task, 1000, 1000);
		new Window (WIDTH, HEIGHT, "THUNDER!", this);
		
		healthBar = new HealthBar();
		player = new Player(450,470,ID.Player);
		this.addKeyListener(new KeyInput(player));
		this.requestFocus();
		thunder = new Thunder(1150,550,ID.Thunder);
		
		
		
		
		
		

		
		
	}

	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		seconedPassed = 0;
		highscore = "High Score: ";
		Clip music = null;
		Clip die = null;
		Clip won = null;
		try {
			  AudioInputStream audio = AudioSystem.getAudioInputStream(new File("ThunderstruckACDC8bit.wav"));
			  music = AudioSystem.getClip();
			  music.open(audio);
			  music.start();
			  audio = AudioSystem.getAudioInputStream(new File("smb_mariodie.wav"));
			  die = AudioSystem.getClip();
			  die.open(audio);
			} 
			catch(UnsupportedAudioFileException uae) {
			  System.out.println(uae);
			} 
			catch(IOException ioe) { 
			  System.out.println(ioe);
			} 
			catch(LineUnavailableException lua) { 
			  System.out.println(lua);
			}
		
		try {
			  AudioInputStream audio = AudioSystem.getAudioInputStream(new File("smb_stage_clear.wav"));
			  won = AudioSystem.getClip();
			  won.open(audio);
			  
			} 
			catch(UnsupportedAudioFileException uae) {
			  System.out.println(uae);
			} 
			catch(IOException ioe) { 
			  System.out.println(ioe);
			}
			catch(LineUnavailableException lua) { 
			  System.out.println(lua);
			}
		thunder = new Thunder(1150,550,ID.Thunder);
		HealthBar.HEALTH = 100;
		
		long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                //System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
                            if(HealthBar.HEALTH <=0){
                            	music.stop();
                            	die.start();
                            	if (JOptionPane.showConfirmDialog(null, "You Died! Want to restart?","GAME OVER!",
                    			        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            		die.stop();
                            		run();
                    			} else {
                    				System.exit(1);
                    			}
                            }
                            if(seconedPassed == 91){
                            	music.stop();
                            	won.start();
                            	if(HealthBar.HEALTH >= score){
                            		score = HealthBar.HEALTH;
                            		highscore = "New High Score! ";
                            	}
                            	if (JOptionPane.showConfirmDialog(null, "You Won! Want to restart?" + 
                                    	"\n" + highscore + score ,"YOU WON!",
                    			        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            		won.stop();
                            		run();
                    			} else {
                    				System.exit(1);
                    			}
                            }
        }
        
        stop();
                
		
	}
	
	private void tick(){
		player.tick();
		thunder.tick();
		healthBar.tick();
		if(player.getBounds().intersects(thunder.getBounds())){
			HealthBar.HEALTH -= 2;
		}
		
		
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null){
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(102,155,102));
		g.fillRect(0, 0, WIDTH, 550);
	
		g.setColor(new Color(102,102,51));
		g.fillRect(0,550, WIDTH, 20);
		
		g.setColor(new Color(91,77,45));
		g.fillRect(0,570, WIDTH, 200);
		
		player.render(g);
		thunder.render(g);
		healthBar.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		
		new Game();
		
		

	}

}
