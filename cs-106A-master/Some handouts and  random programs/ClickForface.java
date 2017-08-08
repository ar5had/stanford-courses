import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class ClickForface extends GraphicsProgram{
	
	
	public void init(){
		
		
		addMouseListeners();
		
		
	}
	
	public void mouseClicked(MouseEvent e){
		
		
		ashraf=new man();
		
		add(ashraf,e.getX(),e.getY());
		
	}
	
	
private man ashraf;
	
}
