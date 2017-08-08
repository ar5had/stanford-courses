import java.util.*;
public class Album {

	public Album(String name,String band){
		
		albumName=name;
		
		bandName=band;
		
	}
	
	public String getAlbumName(){
		
		
		return albumName;
		
	}
	
	public String getBandName(){
		
		
		
		return bandName;
	}
	
	public Iterator<Song> getSongs(){
		
		Iterator<Song> it=songs.iterator();
		
		return it;
		
	}
	
	public void addSong(Song song){
		
		songs.add(song);
		
		
	}
	
	public String toString(){
		
		
		
		return("Album Name:\""+albumName+"\"by ban:\""+bandName+"\".");
	}
	

	private String albumName;
	
	private String bandName;
	
	private ArrayList<Song> songs=new ArrayList<Song>();
	
}
