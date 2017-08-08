/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {
	
	
	
	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
		//	 You fill in the rest //
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		
		displayedGraphs.clear();
		nog=1;
		update();
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
			if(entry!=null){
			name=entry.getName();
			
			
			
			
			if(!displayedGraphs.containsKey(name)){
			displayedGraphs.put(name,entry);
			colorog.put(name, nog%4);
			nog++;}
			update();
		 }
	
	}
	
	
	public void removeGraph(String strr){
		
		strr=(strr.substring(0,1)).toUpperCase()+(strr.substring(1)).toLowerCase();
		
		if(displayedGraphs.get(strr)!=null){//note case of letters input
			displayedGraphs.remove(strr);
			update();
	
		}
	
	}
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		
		removeAll();
		
		addVerticalLines();
		
		addHorizontalLines();
		
		addYear();
		
		addGraphs();
		
		

	}
	
	private void addVerticalLines(){
		
		double height=getHeight();
		double width=getWidth();
		double interval=width/11;
		double lineInterval=interval;
		for(int i=1;i<=11;i++){
			
			GLine line=new GLine(lineInterval,0,lineInterval,height);
			add(line);
			lineInterval=i*interval;
		}
	}
	
	private void addHorizontalLines(){

		double height=getHeight();
		double width=getWidth();
		
		add(new GLine(0,20,width,20));
		add(new GLine(0,height-20,width,height-20));
	}
	
	
	private void addYear(){
		
		double interval=getWidth()/11;
		double lineInterval=interval;
		for(int i=0;i<=10;i++){
			
			GLabel year=new GLabel(Integer.toString(START_DECADE+(i*10)));
			add(year,4+(i*lineInterval),getHeight()-2);
			
		}
		
		
	}
	
	private void addGraphs(){
			
		for( String str:displayedGraphs.keySet()){
			
			putGraph(displayedGraphs.get(str),str);
			
		}
		
		
		
		
	}
	
	private void putGraph(NameSurferEntry entry,String str){
		
		
	if(str!=null){
		
		double height=getHeight();
		double width=getWidth();
		double interval=width/11;
		double lineInterval=interval;

		int decadeNo=0;
		
		
		
		
		
		for(int i=1900;i<2000;i+=10){
		
			lineInterval=decadeNo*interval;
			double responsiveHeightStart;
			double responsiveHeightEnd;
			int startrank=entry.getRank(i);
			int endrank=entry.getRank(i+10);
			if(startrank!=0)
			 responsiveHeightStart=(startrank/1000.0)*(height-40)+20;//to make point above and between those horizontal lines uniformly.
			else
				responsiveHeightStart=getHeight()-20;
			if(endrank!=0)
			responsiveHeightEnd=((endrank)/1000.0)*(height-40)+20;//to make point above and between those horizontal lines uniformly.
			else
				responsiveHeightEnd=getHeight()-20;
			if(startrank!=0)
			add(new GLabel(str+" "+startrank),lineInterval,responsiveHeightStart);
			else
				add(new GLabel(str+"*"+startrank),lineInterval,responsiveHeightStart);
			if(endrank!=0)	
			add(new GLabel(str+" "+endrank),lineInterval+interval,responsiveHeightEnd);
			else
				add(new GLabel(str+"*"+endrank),lineInterval+interval,responsiveHeightEnd);	
			GLine line=new GLine(lineInterval,responsiveHeightStart,lineInterval+interval,responsiveHeightEnd);
			
			
		line.setColor(getcolor(str));
			
			add(line);
			
			decadeNo++;
			
			
			
		}//endsForloop
		
		
	}//end if
		
	}
	
	
	private Color getcolor(String str){
		
		
		if(colorog.get(str)==0){
			return Color.BLUE;
			
		}
		else if(colorog.get(str)==1){
			return Color.RED;
			
		}
		else if(colorog.get(str)==2){
			
			return Color.GREEN;
		}
		else if(colorog.get(str)==3){
			return Color.BLACK;
			
		}
	
		
		else{
			
			return Color.MAGENTA;
		}
	}
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }



	/*private instance variables*/


private HashMap<String,NameSurferEntry> displayedGraphs=new HashMap<String,NameSurferEntry>();
private HashMap<String,Integer> colorog=new HashMap<String,Integer>();//keeps track of color.

private String name;
private int nog=1;
}
