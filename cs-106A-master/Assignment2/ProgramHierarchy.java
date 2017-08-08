/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	public void run() {
		
		double WIDTH;
		double HEIGHT;
		
		
		GLabel lab1= new GLabel("Program");
		GLabel lab2= new GLabel("GraphicsProgram");
		GLabel lab3= new GLabel("ConsoleProgram");
		GLabel lab4= new GLabel("DialogProgram");
		WIDTH=2*lab2.getWidth();
		HEIGHT=2*lab2.getAscent();
		GRect r1= new GRect(getWidth()/2-.5*WIDTH,getHeight()/2-2.5*HEIGHT,WIDTH,HEIGHT);
		GRect r2= new GRect(getWidth()/2-1.7*WIDTH,getHeight()/2+1.5*HEIGHT,WIDTH,HEIGHT);
		GRect r3= new GRect(getWidth()/2-.5*WIDTH,getHeight()/2+1.5*HEIGHT,WIDTH,HEIGHT);
		GRect r4= new GRect(getWidth()/2+.7*WIDTH,getHeight()/2+1.5*HEIGHT,WIDTH,HEIGHT);
		add(r1);
		add(r2);
		add(r3);
		add(r4);
		add(lab1,getWidth()/2-.5*WIDTH+lab2.getWidth()-lab1.getWidth()*.5,getHeight()/2-2.5*HEIGHT+1.5*lab2.getAscent());
		add(lab2,getWidth()/2-1.7*WIDTH+.5*lab2.getWidth(),getHeight()/2+1.5*HEIGHT+1.5*lab2.getAscent());
		add(lab3,getWidth()/2-.5*WIDTH+lab2.getWidth()-lab3.getWidth()*.5,getHeight()/2+1.5*HEIGHT+1.5*lab2.getAscent());
		add(lab4,getWidth()/2+.7*WIDTH+lab2.getWidth()-lab4.getWidth()*.5,getHeight()/2+1.5*HEIGHT+1.5*lab2.getAscent());
		
		
		GLine l1= new GLine(getWidth()/2-1.2*WIDTH,getHeight()/2+1.5*HEIGHT,getWidth()/2,getHeight()/2-1.5*HEIGHT);
		GLine l2= new GLine(getWidth()/2,getHeight()/2+1.5*HEIGHT,getWidth()/2,getHeight()/2-1.5*HEIGHT);
		GLine l3= new GLine(getWidth()/2+1.2*WIDTH,getHeight()/2+1.5*HEIGHT,getWidth()/2,getHeight()/2-1.5*HEIGHT);
		
		
		add(l1);
		add(l2);
		add(l3);
		
		
		
		
	
	}
}

