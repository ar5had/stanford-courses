
import acm.graphics.*;

public class man extends GCompound {


/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 72;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

	
	public man(){
		
		GLine scaffold= new GLine(0,0,0,SCAFFOLD_HEIGHT );
		
		GLine beam= new GLine(0,0,BEAM_LENGTH,0);
		
		GLine rope= new GLine(0,0,0,ROPE_LENGTH );
		
		GOval head=new GOval(2*HEAD_RADIUS,2*HEAD_RADIUS);
		
		GLine body= new GLine(0,0,0,BODY_LENGTH);
		
		GLine lupperarm= new GLine(0,0,-UPPER_ARM_LENGTH,0);
		
		GLine rupperarm= new GLine(0,0,UPPER_ARM_LENGTH,0);
		
		GLine llowerarm= new GLine(0,0,0,LOWER_ARM_LENGTH);
		
		GLine rlowerarm= new GLine(0,0,0,LOWER_ARM_LENGTH);
		
		GLine hip= new GLine(0,0,HIP_WIDTH,0 );
		
		GLine lleg= new GLine(0,0,0,LEG_LENGTH);
		
		GLine lfoot= new GLine(0,0,-FOOT_LENGTH,0 );
		
		GLine rleg= new GLine(0,0,0,LEG_LENGTH);
		
		GLine rfoot= new GLine(0,0,FOOT_LENGTH,0 );
		
		double sX=getWidth()/2-BEAM_LENGTH;
			
		double sY=getHeight()/2- getHeight()/5;
			
		scaffold.setLocation(sX,sY);
		
		beam.setLocation(sX,sY);
		
		rope.setLocation(sX+BEAM_LENGTH,sY);
		
		head.setLocation(sX+BEAM_LENGTH-HEAD_RADIUS,sY+ROPE_LENGTH);
		
		body.setLocation(sX+BEAM_LENGTH,sY+ROPE_LENGTH+2*HEAD_RADIUS);
		
		lupperarm.setLocation(sX+BEAM_LENGTH,sY+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
		
		rupperarm.setLocation(sX+BEAM_LENGTH,sY+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
		
		llowerarm.setLocation(sX+BEAM_LENGTH-UPPER_ARM_LENGTH,sY+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
		
		rlowerarm.setLocation(sX+BEAM_LENGTH+UPPER_ARM_LENGTH,sY+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
		
		hip.setLocation(sX+BEAM_LENGTH-HIP_WIDTH/2,sY+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		
		lleg.setLocation(sX+BEAM_LENGTH-HIP_WIDTH/2,sY+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		
		rleg.setLocation(sX+BEAM_LENGTH+HIP_WIDTH/2,sY+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		
		lfoot.setLocation(sX+BEAM_LENGTH-HIP_WIDTH/2,sY+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
		
		rfoot.setLocation(sX+BEAM_LENGTH+HIP_WIDTH/2,sY+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
		
		
		add( scaffold  );	
		
		add( beam  );		
		
		add( rope  );
		
		add(head  );		
		
		add( body );
		
		add( lupperarm );		
		
		add( rupperarm);
		
		add(  llowerarm );		
		
		add( rlowerarm  );
		
		add(  hip  );		
		
		add( lleg  );
		
		add( rleg  );		
		
		add( lfoot   );
		
		add( rfoot ) ;
		
	}
}