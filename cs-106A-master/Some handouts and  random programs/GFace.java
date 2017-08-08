
import acm.graphics.*;

public class GFace extends GCompound{
	
	private static final  double EYES_HEIGHT= .15;
	
	private static final  double  EYES_WIDTH= .15;
	
	private static final  double NOSE_HEIGHT= .1;
	
	private static final  double NOSE_WIDTH= .09;
	
	private static final  double MOUTH_HEIGHT= .1;
	
	private static final  double MOUTH_WIDTH= .5; 
	
	public GFace(double width,double height){
		
		face=new GOval(	width,height );
		
		lefteye=new GOval(EYES_WIDTH*width,EYES_HEIGHT*height);
		
		righteye=new GOval(EYES_WIDTH*width,EYES_HEIGHT*height);
		
		nose=createNose(NOSE_WIDTH*width,NOSE_HEIGHT*height);
		
		mouth= new GRect(MOUTH_WIDTH*width,MOUTH_HEIGHT*height);
		
		add(face,0,0);
		
		add(lefteye,width/4-EYES_WIDTH*width/2,height/5);
		
		add(righteye,3*width/4-EYES_WIDTH*width/2,height/5);
		
		add(mouth,width*(1-MOUTH_WIDTH)/2,3*height/4);
		
		add(nose,width/2,height/2);
		
		
	}
	
	private GPolygon createNose(double width,double height){
		
		GPolygon poly = new GPolygon();
		
		poly.addVertex(0,-height*2/3);
		
		poly.addVertex(-width/2,height*1/3);
		
		poly.addVertex(width/2,height*1/3);
		
		return poly;
	}
	
	private GRect mouth;
	private GOval face;
	private GOval lefteye,righteye;
	private GPolygon nose;
}
