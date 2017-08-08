
/* File name:DrawingLines.java
 *  * This program allowss you to make lines
*/

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
public class DrawingLines extends GraphicsProgram {
	
	
	public void init() {
		
		addMouseListeners();
		
	}
	
	
	public void mousePressed(MouseEvent e){
		
		last=new GPoint(e.getPoint());
		
		line=new GLine(e.getX(),e.getY(),e.getX(),e.getY());
		
		add(line);
		
	}
	
    public void mouseDragged(MouseEvent e){
		
    	line.setEndPoint(e.getX(),e.getY());
		
	}
	
	
	
private GPoint last=new GPoint();

private GLine line;
}
		
		