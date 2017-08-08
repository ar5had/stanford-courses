import acm.graphics.*;
import javax.swing.*;
import java.awt.event.*;
import acm.program.*;
import java.awt.*;

public class InteractiveDrawFace extends GraphicsProgram {

	
	public void init(){
		
		
	
		
		add(new JButton("Clear"),SOUTH);
		
		 checkbox= new JCheckBox("Front");
		
		checkbox.setSelected(true);
		
		add(checkbox,SOUTH);
		
		

		initRadioButtons();
		
		initColorChooser();
		

		
		addActionListeners();
		
		addMouseListeners();
		
		
		
	}
	
	
	
	private void initRadioButtons(){
		
		ButtonGroup bg=new ButtonGroup ();
		 smallb=new JRadioButton("small");
		
		 mediumb=new JRadioButton("medium");
		
		 largeb=new JRadioButton("large");
		
		smallb.setSelected(true);
		
		bg.add(smallb);
		bg.add(largeb);
		bg.add(mediumb);
		
		
		add(smallb,SOUTH);	
		
		add(mediumb,SOUTH);	
		
		add(largeb,SOUTH);	
		
		
	
		
	}
	
	
	
	
	
	private void initColorChooser(){
		
		combo=new JComboBox();
		combo.addItem("red");
		combo.addItem("blue");
		combo.addItem("black");
		
		combo.setEditable(false);
		
		combo.setSelectedItem("red");
		
		add(new JLabel(" Color: "),SOUTH);
		add(combo,SOUTH);
		
		
	}
	
	
	
	
	private Color getColor(){
		
		String color=(String)combo.getSelectedItem();
		
		if(color.equals("red")){
			
			return Color.RED;
		}
		else if(color.equals("blue")){
			
			return Color.BLUE;
		}
		else if(color.equals("black")){
	
			return Color.BLACK;
		}
		
		return null;
		
	}
	
	private double getDia(){
		double dia=0;
		
		if(smallb.isSelected()){
			
			dia=SMALL_DIAM;
		}
		else if(mediumb.isSelected()){
			
			dia=MED_DIAM;
		}
		else if(largeb.isSelected()){
	
			dia=LARGE_DIAM;
		}
		return dia;
	}
	
	public void mouseClicked(MouseEvent e){
		
		GObject obj;
		
		double dia=getDia();
		
		if(checkbox.isSelected()){
			
			obj=new Gface(dia,dia);
		}
		else{
			
			obj=new GOval(dia,dia);
		}
		
		obj.setColor(getColor());
		
		add(obj,e.getX(),e.getY());
		
	}
	public void actionPerformed(ActionEvent e){
		
		if(e.getActionCommand().equals("Clear"))
			removeAll();
		
	}
	
	
	
	
	
	private static final double SMALL_DIAM = 20; 
	private static final double MED_DIAM = 40; 
	private static final double LARGE_DIAM = 60; 
	
	private JRadioButton smallb,mediumb,largeb;
	
	private JComboBox combo;
	private JCheckBox checkbox;
}
