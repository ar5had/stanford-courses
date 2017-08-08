import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;

public class MouseTracker extends GraphicsProgram{

	public void run(){
		
		lab=new GLabel("");
		lab.setFont("times new roman-34");
		
		add(lab,50,50);
		
		addMouseListeners();
		
		
		
		
	}
	
	public void mouseMoved(MouseEvent e){
		
	lab.setLabel("Mouse:"+e.getX()+","+e.getY());	
	}
	
	
	
	
GLabel lab;
}
