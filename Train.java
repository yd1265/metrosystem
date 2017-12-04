package pkg;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Train {	
private char trainId;
private String depStation;
private String avStation;
private int boroughId;
private String  depTime;
private String avTime;
private int frequence;


public Train() {
	
}


public String getDepTime() {
	return depTime;
}


public void setDepTime(String depTime) {
	this.depTime = depTime;
}


public String getAvTime() {
	return avTime;
}


public void setAvTime(String avTime) {
	this.avTime = avTime;
}


//this overloaded constructor
public Train(char trainId, String depStation, String avStation, int boroughId, String depTime, String avTime) {
	this.trainId = trainId;
	this.depStation = depStation;
	this.avStation = avStation;
	this.boroughId = boroughId;
	this.depTime = depTime;
	this.avTime = avTime;
}

// generated getters and setters
public char getTrainId() {
	return trainId;
}


public void setTrainId(char trainId) {
	this.trainId = trainId;
}


public String getDepStation() {
	return depStation;
}


public void setDepStation(String depStation) {
	this.depStation = depStation;
}


public String getAvStation() {
	return avStation;
}


public void setAvStation(String avStation) {
	this.avStation = avStation;
}


public int getBoroughId() {
	return boroughId;
}


public void setBoroughId(int boroughId) {
	this.boroughId = boroughId;
}





public int getFrequence() {
	return frequence;
}


public void setFrequence(int frequence) {
	this.frequence = frequence;
}



public void map() {
	
}

public Train[] loadTrain() throws IOException {
		int i=0;
		String line="";

		BufferedReader file=new BufferedReader(new FileReader("train.txt"));
		line=file.readLine();
		Train tab []=new Train [8];

		while(line!=null) {
			StringTokenizer st=new StringTokenizer(line, ",");
			String id=st.nextToken();
			trainId=id.charAt(0);
			depStation=st.nextToken();
			 avStation=st.nextToken();
			 String code = st.nextToken();
			 boroughId = Integer.parseInt(code);
			  depTime = st.nextToken();
			 avTime=st.nextToken();
			 Train t =new Train(trainId, depStation ,  avStation , boroughId, depTime, avTime);
			 tab[i]=t;
			 i++;
			 line=file.readLine();
			
 }
		file.close();
		return tab;

	}
	
public void displayRecord() {
System.out.println(" Train "+trainId+", Departure Station  "+depStation+ ", Arrival Station   " +avStation +" , "+boroughId + " , Departure time   "+ depTime + " , Arrival time   "+avTime );	
}
}





