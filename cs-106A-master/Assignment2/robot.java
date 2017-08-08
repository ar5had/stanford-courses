import acm.program.*;
import acm.graphics.*;
import java.awt.*;
public class robot extends GraphicsProgram{
	
	public void run(){
	
		GRect head = new GRect(280,460);
		GRect mouth = new GRect(150,50);
		GOval eye1=new GOval(70,70);
		GOval eye2=new GOval(70,70);
		
		head.setFilled(true);
		head.setColor(Color.BLACK);
		head.setFillColor(Color.GRAY);
		eye1.setFilled(true);
		eye1.setFillColor(Color.YELLOW);
		eye1.setColor(Color.YELLOW);
		
		eye2.setFilled(true);
		eye2.setFillColor(Color.YELLOW);
		eye2.setColor(Color.YELLOW);
		
		mouth.setFilled(true);
		mouth.setFillColor(Color.WHITE);
		mouth.setColor(Color.WHITE);
		
		
		
		add(head,(getWidth()/2-140),(getHeight()/2-230));
		add(mouth,(getWidth()/2-75),(getHeight()/2+100));
		
		add(eye1,(getWidth()/2-105),(getHeight()/2-200));
		add(eye2,(getWidth()/2+35),(getHeight()/2-200));
		
		
		
		
	}

}
