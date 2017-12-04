package pkg;

import java.io.IOException;
import java.text.ParseException;
public class Main {
	public static void main(String[] args) throws IOException, ParseException {
		Travel travel=new Travel(" MTA");
		System.out.println();
		
	
		 travel.loadPassengers();
		 travel.loadTrains();	

		 int index=travel.login();
		  if(index!=-1) {
			int menuchoice= travel.displaymenu();
			if(menuchoice==1) {
				travel.processTravel(index);
			}else if(menuchoice==2) {
				
				travel.setSales(MetroCard.purchase(travel.getP(index)));
			}else  if( menuchoice==3){
				 travel.writSales();
				System.out.println("Thank you for ridding with MTA");
			}
		  }
		 
  	
	}
	
}	

