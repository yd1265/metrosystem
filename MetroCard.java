package pkg;
import java.util.Scanner;
public class MetroCard {
static Scanner scanner=new Scanner(System.in);
private int metroNumber;
private float price;
private static float balance=0;

public MetroCard() {
	
}
public MetroCard(int metroNumber, float price) {
	this.metroNumber = metroNumber;
	this.price = price;
	balance+=price;
}

public float getBalance() {
	return balance;
}

public static void displayPrice() {
	System.out.println("NYC SUBWAY prices are");
	System.out.print(" $ 2.75 for 1-way | ");
	System.out.print("  $ 5.5 for 2-way  |");
	System.out.print("  $ 32 for 1-week  |");
	System.out.println(" $ 120 for 1-month ");
	System.out.println("Choose your ticket ?");
}

public static float purchase(Passenger p) {
	displayPrice();
	int ageUser=p.getAge();
	float  price=scanner.nextFloat();
	if(ageUser < 20) {
		balance+=price*0.75;
		System.out.println(" you have 25 % off because your under 20 ");
		   System.out.println(p.getPassengerName() +" your  account is recharged  $" +price*0.75 );

	}else {
	 balance+=price;
	   System.out.println(p.getPassengerName() +" your  account is recharged  $" +price +" ");
	}
	  
	    return price;
}

public int getMetroNumber() {
	return metroNumber;
}
public void setMetroNumber(int metroNumber) {
	this.metroNumber = metroNumber;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}


}
