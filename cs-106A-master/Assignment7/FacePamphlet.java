/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

public class FacePamphlet extends Program 
					implements FacePamphletConstants {

	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	
	FacePamphletDatabase db=new FacePamphletDatabase();
	
	public FacePamphlet(){
		canvas=new FacePamphletCanvas();
		add(canvas);
		
	}
	
	public void init() {
		
		mainTextField=new JTextField(TEXT_FIELD_SIZE);
		changeStatus=new JTextField(TEXT_FIELD_SIZE);
		changePicture=new JTextField(TEXT_FIELD_SIZE);
		addFriend=new JTextField(TEXT_FIELD_SIZE);
		add=new JButton("Add");
		delete=new JButton("Delete");
		lookup=new JButton("Look Up");
		changePictureB=new JButton("Change Picture");
		changeStatusB=new JButton("Change Status");
		addFriendB=new JButton("Add Friend");
		
		addFriend.setActionCommand("Add Friend");
		addFriend.addActionListener(this);
		
		changeStatus.addActionListener(this);
		changeStatus.setActionCommand("Change Status");
		
		changePicture.addActionListener(this);
		changePicture.setActionCommand("Change Picture");
		
		add(new JLabel("Name"),NORTH);
		add(mainTextField,NORTH);
		add(add,NORTH);
		add(lookup,NORTH);
		add(delete,NORTH);
		
		add(changeStatus,WEST);
		add(changeStatusB,WEST);
		
		
		add(new JLabel(EMPTY_LABEL_TEXT),WEST);
		
		add(changePicture,WEST);
		add(changePictureB,WEST);
		
		add(new JLabel(EMPTY_LABEL_TEXT),WEST);
		
		add(addFriend,WEST);
		add(addFriendB,WEST);
		
		
		addActionListeners();
		
    }
    
  
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
		
    	
    	
    	if(e.getActionCommand().equals("Add")){
    		
    		String text=mainTextField.getText();
    		if( !(text.equals("")) ) {
    			
    			if(db.containsProfile(text)){
    				
    				canvas.showMessage("Profile with the name "+text +" already exists.");
    				
    			}
    			else{
	    			FacePamphletProfile pro=new FacePamphletProfile(text);
	    			
	    			db.addProfile(pro);
	    		
	    			canvas.displayProfile(pro);
	    			
	    			canvas.showMessage("New Profile Created");
	    			
	    			currentProfile=pro;
	    		
	    		}
    		}
    	}
    	else if(e.getActionCommand().equals("Delete")){
    		
    		String text=mainTextField.getText();
    		if( !(text.equals("")) ) {
    		
    			if(db.containsProfile(text)){
    				db.deleteProfile(text);
    				canvas.showMessage("Profile with the name "+text+" deleted.");
    				canvas.displayProfile(null);
    				currentProfile=null;
    				
    			}
    			else{
    				
    				canvas.showMessage("Profile with the name "+text +" doesn't exist.");
    			}
    		
    			
    		}
    	}
    
    	else if(e.getActionCommand().equals("Look Up")){
    		
    		String text=mainTextField.getText();
    		if( !(text.equals("")) ){
    			
    			if(db.containsProfile(text)){

        			FacePamphletProfile pro=db.getProfile(text);	
    			
        			canvas.displayProfile(pro);
        			canvas.showMessage("Displaying "+text);
        			currentProfile=pro;
    		
    			}
    			else{

        			
    				canvas.showMessage("Profile with the name "+text +" doesn't exist.");
    			}
    	
    		}
    	}
    	
    	else if(e.getActionCommand().equals("Add Friend")){
    		
    		String text=addFriend.getText();
    		if( !(text.equals(""))  ){ //1if
    		
    			if(currentProfile!=null){//2if
    				
    				if(!(text.equals(currentProfile.getName()))){//3if
    				
	    				if(db.containsProfile(text)){//4if
	    					
	    					boolean friendsThere =currentProfile.addFriend(text);
	    					
	    					if(friendsThere){//5if
		    					
		    					FacePamphletProfile reciprocalFriend=db.getProfile(text);
		    					
		    					reciprocalFriend.addFriend(currentProfile.getName());
		    				
		    					canvas.displayProfile(currentProfile);
		    					
		    					canvas.showMessage(text+" added as friend");
	    					
	    					}//5ifends
	    					else{//5else
	    						canvas.showMessage(currentProfile.getName()+" has already "+text+" as a friend");
	    						
	    					}//5else ends
	    					
	    				}//4ifends
	    				
	    				else{//4else
	    					
	    					canvas.showMessage("You cannot add youself as friend");
	    					
	    				}//4else ends
    				}//3if ends
    				else{//3else
    					canvas.showMessage( text+" doesn't exist");
    				}//3 else ends
    					
    			}//2 if ends
    			else{//2else
    				
    				canvas.showMessage( "Please select a profile to add friend");
    			}//2else ends
    		}//1if ends
    	}//else if ends
    	else if(e.getActionCommand().equals("Change Status")){
    		
    		String text=changeStatus.getText();
    		if( !(text.equals("")) ) {
    			
    			if(currentProfile!=null){
    				currentProfile.setStatus(currentProfile.getName()+" is "+text);
    				canvas.displayProfile(currentProfile);
    				canvas.showMessage( "Status updated to "+text);
    			}
    			else{
    				canvas.showMessage( "Please select a profile to change status");
    			}
    				
    	
    		}
    	}
    	else{
    		
    		String text=changePicture.getText();
    		if( !(text.equals("")) ) {
    			
    			GImage img=null;
    			try{
    				img=new GImage(text);
    				

        			if(currentProfile!=null){
        				currentProfile.setImage(img);
        				canvas.displayProfile(currentProfile);
        				canvas.showMessage("Profile picture updated");
        				
        			}
        			else{
        				canvas.showMessage("Select a profile to update picture");
        				
        			}
    				
    				
    			}
    			catch(ErrorException ex){
    				canvas.showMessage("Unable to open "+text);
    			}
    			
    		}
    		
    	}//for changing picture
    }

    private FacePamphletCanvas canvas;
    
    private JTextField mainTextField,addFriend,changeStatus,changePicture;
    private JButton add,delete,lookup,changeStatusB,changePictureB,addFriendB;
    private FacePamphletProfile currentProfile;
}
