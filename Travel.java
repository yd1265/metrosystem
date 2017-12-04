package pkg;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Travel implements InterfaceTravel {
	private static String company;
	private Passenger []passengers;
	private Train [] trains;
	private int countCard=0;
	private float sales=0;
	
	public Travel() {
		
	}
	
	public Travel(String c) {
		company=c;
	}
	public Travel(Passenger[] passengers, Train[] trains, int countCard, int sales, String c) {
		super();
		this.passengers = passengers;
		this.trains = trains;
		this.countCard = countCard;
		this.sales = sales;
		company=c;
		
	}
	
	public void writSales() {
		
	}
	
	
	public Passenger getP(int index) {
		Passenger passenger=null;
		for(int i=0; i<passengers.length;i++) {
			if(i==index) {
			 passenger=passengers[i];
			}
		}
	
		return passenger;
	}
	
	
	public int login() {
		int index=-1; // not found
		
		System.out.println(" Welcome to "+company);
		   System.out.println(LocalTime.now());
		
		  System.out.println(" Give me your Id");
		   int id=scanner.nextInt();
		   System.out.println(" Give me your Password");
		   int tin=scanner.nextInt();
		for( int i=0; i< passengers.length; i++) {
			if(passengers[i].getPassengerId()!=id || passengers[i].getTin()!=tin) {
	          
			}else {
				System.out.println(" Welcome " +passengers[i].getPassengerName() );
				  index=i;
				  return index;
			}
		}
		 
			System.out.println(" You are not in the system !");
			System.exit(0);
		
		
		 return index;
		
	}
	
	
	public int displaymenu() {
		int choice = 0;
		int tantative=3;
		boolean flag=true;
		while( flag) {
			if(tantative > 0 ) {
		System.out.println("Enter 1 to process a travelPlan ");
		System.out.println("Enter 2 to purchase a metrocard ");
		System.out.println("Enter  3 to exit the program");
		System.out.println("Please enter a valid number ");
		choice=scanner.nextInt();	
		 tantative--;
		if( choice == 1 ||   choice == 2 || choice == 3) {
		flag=false;
		 break;
		  
		}			
 }else {
				System.out.println(" Your tantative expire");
				 System.exit(0);
			}
		}
		return choice;
		

	}
	
	public void findTravel() {
		System.out.println(" Enter your Depature time");
		String dep=scanner.nextLine();
		 String depx=dep.replaceAll(" ", "");
		for( int i=0; i<trains.length; i++) {
			  String depart=trains[i].getDepTime().replaceAll(" ", "");
			if(depart.equalsIgnoreCase(depx)) {
				
				Train t=trains[i];
				t.displayRecord();
			}
		}
				
			
	}

	public String getArrival(String depTime, String arrTime, String usertime) {
	
	int colon=depTime.indexOf(":");
	String heureDep=depTime.substring(0, colon);
	String muniteDep=depTime.substring(colon+1, 4);
	int timeDepart=Integer.parseInt(heureDep)*60+ Integer.parseInt(muniteDep);

	
	int colon1=arrTime.indexOf(":");
	String heureArrive=arrTime.substring(0, colon1);
	String munitArrive=arrTime.substring(colon1+1,5);

	int timeArrival=Integer.parseInt(heureArrive)*60+ Integer.parseInt(munitArrive);
	
	
	
	int colon2=usertime.indexOf(":");
	String heureUser=usertime.substring(0, colon2);

	String muniteUser=usertime.substring(colon2 + 1,usertime.length());
	

	int timeUser=Integer.parseInt(heureUser)*60+ Integer.parseInt(muniteUser);
	
	String heuree="";
	int diff=timeUser-timeDepart;

	
	if(diff%15 !=0) {
		timeUser=timeUser+(15-(timeUser%15));
		int netTime=timeUser+(timeArrival-timeDepart);
		int h=netTime/60;
		int m=netTime%60;
	 heuree=String.valueOf(h)+":"+String.valueOf(m);
	}else {
		int netmunite=timeUser+(timeArrival-timeDepart);
		int h=netmunite/60;
		int m=netmunite%60;
	 heuree=String.valueOf(h)+":"+String.valueOf(m);
	}
	   

	
	
	return heuree;
	
	}
	
	public void findRout()  {
    
     char id1=' ';
     char id2=' ';
     Train t1=null;
     Train t=null;
    System.out.println(" Give departure station");
    String dep=scanner.nextLine();
	 String depx=dep.replaceAll(" ", ""); 
	 for( int i=0; i<trains.length; i++) {
		  String depart=trains[i].getDepStation().replaceAll(" ", "");
		  String arrival=trains[i].getAvStation().replaceAll(" ", "");
		if(depart.equalsIgnoreCase(depx)) {
			 t=trains[i];
	       id1=t.getTrainId();
	        t.displayRecord();
			
		}
	 }
	 
    System.out.println(" Give arrival station");
    String arv=scanner.nextLine();
	 String arvx=arv.replaceAll(" ", ""); 
	
	 for(int i=0; i<trains.length; i++) {
		 String arrival=trains[i].getAvStation().replaceAll(" ", "");
		 if(arrival.equalsIgnoreCase(arvx)) {
			 t1=trains[i];
			  id2=t1.getTrainId();
			  t1.displayRecord();
		 }
	 }
	 
	 System.out.println(" what time do you want to leave ?");
	 String timedep=scanner.next();
	 String g=getArrival(t1.getDepTime(), t1.getAvTime(), timedep);
	     
	 if(id1==id2) {
		 System.out.println(" Take the " + id1 +" train" + " to "+ t1.getAvStation()+ " and you arrive at "+g);
	 }else {
		System.out.println("Take the "+id1+ " train to "+t1.getAvStation()+
				" and change to " +id2 ); 
	 }
	 }
	

	public void processTravel(int index)  {
		System.out.print(" Welcome " );
		
		passengers[index].displayRecord();
		 
		System.out.println(" List of pick up station");
	
         for(int i=0; i<trains.length; i++ ) {
        	System.out.println( trains[i].getDepStation() +", "); 
         }
         
         	findRout();
		    System.out.println(" Do you want to purchase Metrocard ? ");
		    String response=scanner.nextLine();
		    if(response.equalsIgnoreCase("yes")){
		    	MetroCard.purchase(passengers[index]);
		    }
		System.out.println(" ");
	}
	
	
	public void displayTravelPlan(int index) {
		System.out.println(LocalDateTime.now());
		Train t=trains[index];
		 Passenger p=passengers[index];
		 p.displayRecord();
		 t.displayRecord();
		 System.out.println(" Do you want to purchase a Metrocard ");
		 String rep=scanner.next();
		 if(rep.equalsIgnoreCase("yes")) {
			 calculateSales(MetroCard.purchase(p));  
		 }else if(rep.equalsIgnoreCase("no")) {
			 System.exit(0);
		 }
	
	}
	
	
	public void calculateSales(float price) {
		sales=sales+price;
		countCard++;
		
	}
	public void loadPassengers()throws IOException {
			int i=0;
			String line="";

			BufferedReader file=new BufferedReader(new FileReader("passenger.txt"));
			line=file.readLine();
			passengers=new Passenger [6];

			while(line!=null) {
				StringTokenizer st=new StringTokenizer(line, ",");
				Passenger p=new Passenger();
				String id=st.nextToken();
				p.setPassengerId(Integer.parseInt(id));
				p.setPassengerName(st.nextToken());
				String pString=st.nextToken();
				 p.setPasengerCardNumber(Integer.parseInt(pString));
				 String gString=st.nextToken();
				 p.setTin(Integer.parseInt(gString));	
				 String age=st.nextToken();
				 p.setAge(Integer.parseInt(age));
				 passengers[i]=p;
				 i++;
				 line=file.readLine();
			}
			file.close();
			
}


	public  void loadTrains() throws IOException {
		int i=0;
		String line="";

		BufferedReader file=new BufferedReader(new FileReader("train.txt"));
		line=file.readLine();
		 trains=new Train [10];

		while(line!=null) {
			Train t =new Train();
			StringTokenizer st=new StringTokenizer(line, ",");
			String id=st.nextToken();
			t.setTrainId(id.charAt(0));
			t.setDepStation(st.nextToken());
			t.setAvStation(st.nextToken());
			 String code = st.nextToken();
		     t.setBoroughId(Integer.parseInt(code));
		   t.setDepTime(st.nextToken());
			t.setAvTime(st.nextToken());
	
			 trains[i]=t;
			 i++;
			 line=file.readLine();
			
 }
		file.close();
	

	}

	Scanner scanner=new Scanner(System.in);
	public static String getCompany() {
		return company;
	}
	public static void setCompany(String company) {
		Travel.company = company;
	}
	public Passenger[] getPassengers() {
		return passengers;
	}
	public void setPassengers(Passenger[] passengers) {
		this.passengers = passengers;
	}
	public Train[] getTrains() {
		return trains;
	}
	public void setTrains(Train[] trains) {
		this.trains = trains;
	}
	public int getCountCard() {
		return countCard;
	}
	public void setCountCard(int countCard) {
		this.countCard = countCard;
	}
	public float getSales() {
		return sales;
	}
	public void setSales(float sales) {
		this.sales = sales;
	}
	public Scanner getScanner() {
		return scanner;
	}
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	
	
	
}
