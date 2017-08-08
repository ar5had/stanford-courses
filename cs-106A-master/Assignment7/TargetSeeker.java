import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
public class TargetSeeker extends GraphicsProgram{
	
	public void init(){
		
		setTarget();
		
		setSeeker();
		
		addMouseListeners();
		
		
		
		while(true){
			
			pause(6);
			
			seeker.move(x, y);
			
			speedChecker();
			
			
			
		}
		
		
	}

	private void setTarget(){
		
		target=new GOval(10,10);
		target.setFilled(true);
		target.setFillColor(Color.RED);
		add(target,200,300);
	}
	
	private void setSeeker(){
		
		seeker=new GRect(20,20);
		
		add(seeker,5,5);
		
		
	}
	
	
	public void mouseClicked(MouseEvent e){
		
		remove(target);
		
		add(target,e.getX(),e.getY());
		
		
	}
	
	
	
	private void speedChecker(){
		int xmid=(int)(seeker.getX()+10-target.getX()-5);
		
		int ymid=(int)(seeker.getY()+10-target.getY()-5);
		
		
		
		if(xmid<0)
			x=1;
		else if(xmid==0)
			x=0;
		else
		
			x=-1;
		if(ymid<0)
			y=1;
		else if(ymid==0)
			y=0;
		else
			y=-1;
				
		
		}
	
	
	
	private double x,y;
	private GRect seeker;
	private GOval target;
}
