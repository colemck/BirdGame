package birdgamefinished;

import apcs.Window;

public class Pipe {
	
	int x;
	int xspeed = 7;
	int gap = 170;
	int initialPos;
	
	int theight = Window.random(0, Window.height() - gap);
	int bheight = Window.height() - theight - gap;
	int w = 60;
	
	
	//the y coordinate of the pipes 
	int ty = theight / 2;
	int by = Window.height() - bheight/2;
	
	
	/*
	 * The Pipe constructor takes in a number to use as a starting value. We add that 
	 * value to the window width
	 */
	Pipe(int startingVal){
		this.x = Window.width() + startingVal;
		
		//saving the initial position of the pipe for later
		this.initialPos = x;
	}
	
	
	public void draw() {
		
		//pipes
		Window.out.color("green");
		Window.out.rectangle(x, ty, w, theight);
		Window.out.rectangle(x, by, w, bheight);
		
		//pipe rims
		Window.out.color("dark green");
		Window.out.rectangle(x, theight, w + 3, 10);
		Window.out.rectangle(x, Window.height() - bheight, w + 3, 10);
		
		
	}
	
	
	public void move(){
		
		x = x - xspeed;
		
		//resets the pipe
		if(x <= -150) {
			x = Window.width() + 150;
		}
		
		// note: 150 + 150 = 300   (pipe distances from each other)
	}
	
	
	
	
	
	//Called when bird hits pipe
	public void reset() {
		
		theight = Window.random(0, Window.height() - gap);
		bheight = Window.height() - theight - gap;
		
		//pipe coordinates
		x = initialPos;
		ty = theight / 2;
		by = Window.height() - bheight/2;
		
	}
	


}
