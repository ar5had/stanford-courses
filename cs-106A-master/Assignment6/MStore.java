import java.util.*;
import acm.program.*;
public class MStore extends ConsoleProgram{

	public static void main(String[] args){
		
		new MStore().start(args);
		
	}
	
	public void run(){
		
		while(true){
		
				int selection=getSelection();
				
				if(selection==QUIT){
					
					println("Thanks for visiting MStore.");
					
					break;
				}
				
				switch(selection){
				
				
						
					case LIST_SONGS:
						
						listSongs();
						
						break;
					
						
					case LIST_ALBUMS:
						
						listAlbums();
						
						break;
						
					
						
					case ADD_SONG:
						
						addSong();
						
						break;
					
						
					case ADD_ALBUM:
						
						addAlbum();
						
						break;
					
						
						
					case LIST_SONGS_ON_ALBUM:
						
						listSongsOnAlbum();
						
						break;
					
						
						
					case UPDATE_SONG_PRICE:
						
						updateSongPrice();
						
						break;
					
					default:
						
						
						println("Invalid Selection!");
				
				
				
				
				}//ends switch
		
		}//ends while loop
		
	}//ends run
	
	
	private int getSelection(){
		
		 println();   
		 println("Please make a selection (0 to quit):");   
		 println("1. List all songs");     
		 println("2. List all albums");  
		 println("3. Add a song");    
		 println("4. Add an album");  
		 println("5. List songs on an album");  
		 println("6. Update song price");    
		 int choice = readInt("Selection: ");    
		 return choice; 
		
		
	}
	
	
	
	
	private Song addSong(){
		
		
		
			
			String name=readLine("Enter Song Name(Hit only enter to quit):");
			
			if(name.equals(""))return null;
			
			
			
				String bandName=readLine("Enter Band Name:");
				
				int index=findSong(name,bandName);
				
				if(index==-1){
					
					double price=readDouble("Enter price:");
					
					Song song=new Song(name,bandName,price);
					
					songs.add(song);
					
					return song;
					
				}//ends if
				else{
					
					
					println("Song is already added");
					
					return songs.get(index);
				}
				
		
			
		
	}
	
	
	
	
	private int findSong(String name,String bandName){
		
		int index=-1;
		
		for(int i=0;i<songs.size();i++){
			
			if(songs.get(i).getName().equals(name) && songs.get(i).getBand().equals(bandName) )
				
				return i;
			
		}
		
		return index;
	}
	
	
	private void addAlbum(){
		
		
			
			String name=readLine("Enter Album Name!(Hit only enter to quit):");

			if(albums.containsKey(name)){
				
				println("That album already existed");
				
				
			}
			else{
				String band=readLine("Enter band name:");
				
				Album album =new Album(name,band);
				
				albums.put(name, album);
			
				while(true){
					
					Song song=addSong();
					
					if(song==null)break;
					
					album.addSong(song);
					
				}
				
			}//ends else
		
	}
	
	
	private void listSongs(){
		
		for(Song allSong:songs){
			
			println(allSong.toString()+"\n\n");
			
			
		}
		
		
	}
	
	
	private void listAlbums(){
		
		for(String allAlbum:albums.keySet()){
			
			println(albums.get(allAlbum).toString());
			
		}
		
		
	}
	
	private void listSongsOnAlbum(){
		
		String albumName=readLine("Enter the album name(Hit only enter to quit):");
		
		if(albums.containsKey(albumName)){
		
			
			Iterator<Song> allSongs=albums.get(albumName).getSongs();
		
			while(allSongs.hasNext()){
				
				Song song=allSongs.next();
				
				println(song.toString());
				
			}
			
			
		}
		
		else{
			
			println("Album does not exist!");
			
		}
		
		
	}
	
	
	private void updateSongPrice(){
		
		String songName=readLine("Enter Song Name:");
		
		String bandName=readLine("Enter Band Name:");
		
		int index=findSong(songName,bandName);
		
		if(index==-1){
			
			println("Such song does not exist!");
			
		}
		else{
			
			Song song=songs.get(index);
			
			double price=readDouble("Enter new price:");
			
			song.setPrice(price);
			
			println("\""+song.getName()+"\" 's price has been updated.");
			
		}
		
	}
	
	
	
/* Constants */   
private static final int QUIT = 0;  
private static final int LIST_SONGS = 1;
private static final int LIST_ALBUMS = 2; 
private static final int ADD_SONG = 3;  
private static final int ADD_ALBUM = 4;  
private static final int LIST_SONGS_ON_ALBUM = 5;  
private static final int UPDATE_SONG_PRICE = 6; 
	
private ArrayList<Song>	songs=new ArrayList<Song>();

private HashMap<String,Album> albums= new HashMap<String,Album>();


}
