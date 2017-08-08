
public class Song {

	public Song(String songName,String bandName,double songPrice){
		
		name=songName;
		
		band=bandName;
		
		price=songPrice;
		
		
	}
	
	
	public String getName(){
		
		
		return name;
	}
	
	
	public String getBand(){
		
		
		return band;
	}
	
	
	public double getPrice(){
		
		
		return price;
	}
	
	
	public void setPrice(double newPrice){
		
		price=newPrice;
		
	}
	
	
	public String toString(){
		
		
		return ("Song:\""+name+"\"by band:\""+band+"\"have price:"+price+"$.");
		
	}
	
	
	private String name;
	
	private String band;
	
	private double price;
	
}
