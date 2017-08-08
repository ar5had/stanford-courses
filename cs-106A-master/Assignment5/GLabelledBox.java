import acm.graphics.*;
import acm.program.*;
import java.awt.*;
public class GLabelledBox extends GCompound{

	public GLabelledBox(String str){
		
		GLabel lab=new GLabel(str);
		
		lab.setFont("sansserif-15-italic");
		
		GRect rect=new GRect( BOX_WIDTH,BOX_HEIGHT);
		//rect.setFilled(true);
		//rect.setFillColor(Color.WHITE);
		add(lab,(rect.getWidth()-lab.getWidth())/2,(rect.getHeight()+lab.getAscent())/2);
		add(rect,0,0);
		
	}
	private static final double BOX_WIDTH = 120; 
	private static final double BOX_HEIGHT = 50;
}
