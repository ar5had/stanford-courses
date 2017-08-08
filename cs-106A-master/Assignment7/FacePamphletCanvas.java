/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;
import java.util.*;

public class FacePamphletCanvas extends GCanvas 
					implements FacePamphletConstants {
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public FacePamphletCanvas() {
		// You fill this in
	}

	
	/** 
	 * This method displays a message string near the bottom of the 
	 * canvas.  Every time this method is called, the previously 
	 * displayed message (if any) is replaced by the new message text 
	 * passed in.
	 */
	public void showMessage(String msg) {
		
		
		GLabel message=new GLabel(msg);
		
		message.setFont(MESSAGE_FONT);
		
		GObject label=getElementAt(getWidth()/2,getHeight()-BOTTOM_MESSAGE_MARGIN);
		
		if(label!=null)
		remove(label);
		
		add(message,getWidth()/2-message.getWidth()/2,getHeight()-BOTTOM_MESSAGE_MARGIN);
		
	}
	
	
	/** 
	 * This method displays the given profile on the canvas.  The 
	 * canvas is first cleared of all existing items (including 
	 * messages displayed near the bottom of the screen) and then the 
	 * given profile is displayed.  The profile display includes the 
	 * name of the user from the profile, the corresponding image 
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		
		removeAll();
		
		if(profile!=null){
			addName(profile);
			
			addImage(profile);
			
			addStatus(profile);
			
			addFriendsList(profile);
		}
	}

	private void addName(FacePamphletProfile profile){
		
		name=new GLabel(profile.getName());
		
		name.setFont(PROFILE_NAME_FONT);
		
		name.setColor(Color.blue);
		
		add(name,LEFT_MARGIN,TOP_MARGIN +name.getAscent());
		
	}
	
	private void addImage(FacePamphletProfile profile){
		
		GImage dp=profile.getImage();
		
		if(dp!=null){
			
			dp.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
			add(dp,LEFT_MARGIN,IMAGE_MARGIN+TOP_MARGIN +name.getAscent());
		}
		else{
			GRect rect=new GRect(IMAGE_WIDTH,IMAGE_HEIGHT);
			
			GLabel profileImageText=new GLabel("NO IMAGE");
			
			profileImageText.setFont(PROFILE_IMAGE_FONT);
			
			add(rect,LEFT_MARGIN,IMAGE_MARGIN+TOP_MARGIN +name.getAscent());
			
			add(profileImageText,LEFT_MARGIN+IMAGE_WIDTH/2-profileImageText.getWidth()/2,TOP_MARGIN +name.getAscent()+IMAGE_MARGIN+IMAGE_HEIGHT/2+profileImageText.getAscent()/2);
			
		}
		
		
		
	}
	
	
	private void addStatus(FacePamphletProfile profile){
		
		GLabel status=new GLabel(profile.getStatus());
		
		status.setFont(PROFILE_STATUS_FONT);
		
		add(status,LEFT_MARGIN,TOP_MARGIN +name.getAscent()+IMAGE_WIDTH+IMAGE_MARGIN+STATUS_MARGIN+status.getAscent());
		
	}
	
	private void addFriendsList(FacePamphletProfile profile){
		
		GLabel lab=new GLabel("Friends:");
		
		lab.setFont(PROFILE_FRIEND_LABEL_FONT);
		
		add(lab,getWidth()/2,TOP_MARGIN +name.getAscent()+IMAGE_MARGIN+lab.getHeight());
		
		
		
		Iterator<String> it=profile.getFriends();
		
		double height=TOP_MARGIN +name.getAscent()+IMAGE_MARGIN+lab.getHeight();
		
		if(it!=null){
		
				while(it.hasNext()){
					
					GLabel friend=new GLabel(it.next());
					
					friend.setFont(PROFILE_FRIEND_FONT);
					
					height=height+friend.getAscent();
					
					add(friend,getWidth()/2,height);
					
				}
				
		}
	}
	
	GLabel name;
}
