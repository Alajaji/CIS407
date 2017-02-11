package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	

	private static final long serialVersionUID = -473349850293143017L;
	
	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12*9;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private Player player;
	
	public Game(){
		
		
		new Window(WIDTH, HEIGHT, "My Game!", this);
		
		player = new Player(450,470,ID.Player);
		this.addKeyListener(new KeyInput(player));
		

		
		//handler = new Handler();
		//handler.addObject(new Player(450,470,ID.Player));
		
		
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
        }
                stop();
		
	}
	
	private void tick(){
		player.tick();
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
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		
		new Game();

	}

}
