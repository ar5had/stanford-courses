import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Box extends GraphicsProgram{

	public void init(){
		
		text=new JTextField(10);
		text.setActionCommand("ADD");
		add=new JButton("ADD");
		remove=new JButton("REMOVE");
		clear=new JButton("CLEAR");
		
		add(text,SOUTH);
		add(add,SOUTH);
		add(remove,SOUTH);
		add(clear,SOUTH);
		text.addActionListener(this);
		addActionListeners();
		addMouseListeners();
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		
		if(e.getActionCommand().equals("ADD"))
		{
			String str =(String) text.getText();
			
			GObject obj=new GLabelledBox(str);
			
			boxes.put(str, obj);
			
			add(boxes.get(str),getWidth()/2,getHeight()/2);
		}
		
		else if(e.getActionCommand().equals("REMOVE")){
			
			String str =(String) text.getText();
			
			GObject toberemoved=boxes.get(str);
			
			if(toberemoved!=null)
				
			remove(boxes.get(str));
			
		}
		else{
			
			removeAll();
			
		}
		
	}
	
	
	public void mousePressed(MouseEvent e){
		
		lp=new GPoint(e.getPoint());
		
		tobemoved=getElementAt(lp);

		
		
	}
	
	public void mouseDragged(MouseEvent e){
		
		
		if(tobemoved!=null){
			tobemoved.move(e.getX()-lp.getX(),e.getY()-lp.getY());
		
			lp=new GPoint(e.getPoint());
		}
	}
	
	
	
	
	
	private HashMap<String,GObject> boxes=new HashMap<String,GObject>();
	
	JTextField text;
	JButton add,remove,clear;
	GPoint lp;
	GObject tobemoved;
}
