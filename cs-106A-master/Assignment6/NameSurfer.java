/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;


public class NameSurfer extends Program implements NameSurferConstants {

	
	public static void main(String[] args){
		
		new NameSurfer().start(args);
		
	}
	
	private NameSurferDataBase database=new NameSurferDataBase("names-data.txt");
/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
	    
		
		
		text=new JTextField(10);
		graph=new JButton("Graph");
		text.setActionCommand("Graph");
		remove=new JButton("Remove");
		clear=new JButton("Clear");
		nsgraph=new NameSurferGraph();
		add(nsgraph);
		add(text,SOUTH);
		add(graph,SOUTH);
		add(clear,SOUTH);
		add(remove,SOUTH);
		text.addActionListener(this);
		addActionListeners();
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		
		String name=(String)text.getText();
		
		
		
		if(e.getActionCommand().equals("Graph")){
			NameSurferEntry entry=database.findEntry(name);
			nsgraph.addEntry(entry);
		}
		else if(e.getActionCommand().equals("Clear")){
			nsgraph.clear();
			
		}
		else if(e.getActionCommand().equals("Remove")){
			
			nsgraph.removeGraph(name);
			
		}
	}
	
	/*private instance vars*/
	private NameSurferGraph nsgraph;
	private JTextField text;
	private JButton remove,graph,clear;
	
}


