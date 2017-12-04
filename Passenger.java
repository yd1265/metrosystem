package pkg;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Passenger {
private int passengerId;
private String passengerName;
private int pasengerCardNumber;
private int tin;
private int age;
private MetroCard metro;

public Passenger() {
}

public Passenger(int passengerId, String passengerName, int pasengerCardNumber, int tin,int age) {
	this.passengerId = passengerId;
	this.passengerName = passengerName;
	this.pasengerCardNumber = pasengerCardNumber;
	this.tin = tin;
	this.age=age;
}

public int getPassengerId() {
	return passengerId;
}

public void setPassengerId(int passengerId) {
	this.passengerId = passengerId;
}

public String getPassengerName() {
	return passengerName;
}

public void setPassengerName(String passengerName) {
	this.passengerName = passengerName;
}

public int getPasengerCardNumber() {
	return pasengerCardNumber;
}



public MetroCard getMetro() {
	return metro;
}

public void setMetro(MetroCard metro) {
	this.metro = metro;
}

public void setPasengerCardNumber(int pasengerCardNumber) {
	this.pasengerCardNumber = pasengerCardNumber;
}

public int getTin() {
	return tin;
}

public void setTin(int tin) {
	this.tin = tin;
}


public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public void displayRecord() {
System.out.println(passengerName +", your id is : "+passengerId +", and Acount number is:"+ +pasengerCardNumber);	
}
@Override
public String toString() {
	return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", pasengerCardNumber="
			+ pasengerCardNumber + ", tin=" + tin + "]";
}

public Passenger [] passangerrecord() throws IOException {

	int i=0;
	String line="";

	BufferedReader file=new BufferedReader(new FileReader("passenger.txt"));
	line=file.readLine();
	Passenger tab []=new Passenger [6];

	while(line!=null) {
		StringTokenizer st=new StringTokenizer(line, ",");
		String id=st.nextToken();
		passengerId=Integer.parseInt(id);
		passengerName=st.nextToken();
		String pString=st.nextToken();
		 pasengerCardNumber=Integer.parseInt(pString);
		 String gString=st.nextToken();
		 tin=Integer.parseInt(gString);	
		 String aget=st.nextToken();
		 age=Integer.parseInt(aget);
		 Passenger p=new Passenger(passengerId, passengerName ,pasengerCardNumber,tin,age);
		 tab[i]=p;
		 i++;
		 line=file.readLine();
		
	}
	file.close();
	return tab;

}




}
