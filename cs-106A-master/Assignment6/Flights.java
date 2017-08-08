import acm.program.*;
import java.io.*;
import acm.util.*;
import java.util.*;
public class Flights extends ConsoleProgram{
	
	public void run(){
		
		println("Welcome to Flight Planner!");
		
		loadInventory();
		
		displayFlights();
		
		planRoundTrip();
		
		
	}
	
	
	private void loadInventory(){
		
		try{
			BufferedReader rd=new BufferedReader(new FileReader("flight.txt"));
			
			String ln;
			
			while(true){
				
				ln=rd.readLine();
				
				if(ln==null)break;
				
				if(ln.equals("")){
					
					
					possibleFlight="";
				
				}
				
				
				
				if(!ln.equals(""))
				parseLn(ln);
				
				
				
			}
			
		}
		catch(IOException ex){
			
			throw new ErrorException(ex);
		
		}
		
		
	}//ends LoadInventory
	
	
	private void parseLn(String ln){
		
		addCityAndPossibleFlight(ln);
	
		
	}
	
	private void addCityAndPossibleFlight(String ln){
		
		int a=ln.indexOf("-");
		
		String city=ln.substring(0,a-1);
		
		
		
		if(cityCount==0|| !prevCity.equals(city)){
			
			cities.add(cityCount, city);
			
			prevCity=city;
			
			cityCount++;
		}
		
		int b=ln.indexOf(">");
		
		possibleFlight+=ln.substring(b+2)+"*";
		
		citiesReferer.put(city, possibleFlight);
		
	}
	
	
	private void displayFlights(){
		
		println("Here's list of all cities in our database:");
		
		for(String nameOfCity:cities){
			
			println(nameOfCity);
			
		}
		
	}
	
	
	
	private void planRoundTrip(){
		
		println("Let's plan a round-trip route!");
		
		String startCity=readLine("Enter the starting city: ");
		
		if(citiesReferer.get(startCity)==null){
			
			while(citiesReferer.get(startCity)==null)
			startCity=readLine("Enter the starting city from above list: ");
			
		}
		
		
		
		String city=startCity;
		
		String route=startCity;
		
		while(true){
			
			
			
			if(citiesReferer.get(city)==null){
				
						println("You can't get to that city by direct flight!");
						
						println("From "+prevCity+" you can fly directly to:");
						
		
						String ln=citiesReferer.get(prevCity);
						
						StringTokenizer token=new StringTokenizer(ln,"*");
						
						while(token.hasMoreTokens()){
							
							println(token.nextElement());
							
						}
				
				
			}
			else{
					println("From "+city+" you can fly directly to:");	
					prevCity=city;
				
					String ln=citiesReferer.get(city);
					
					StringTokenizer token=new StringTokenizer(ln,"*");
					
						while(token.hasMoreTokens()){
							
							println(token.nextElement());
							
						}
					
					
					
			}
				
			 city=readLine("Where do you want to go from "+city+"? ");
			 
			 if(citiesReferer.get(city)!=null)
			 route=route+" -> "+city;
			 if(city.equals(startCity))break;
			 
		}//ends main while loop
		

		println("The route you have chosen is: \n"+route);
		
		
	}//ends planRoundTrip
	
	private String prevCity="";
	
	private int cityCount=0;
	
	private String possibleFlight="";
	
	private ArrayList<String> cities= new ArrayList<String>();
	
	private HashMap<String,String> citiesReferer=new HashMap<String,String>();
}
