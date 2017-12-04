package pkg;
import java.io.IOException;
public interface InterfaceTravel {
	public void writSales() ;
	public Passenger getP(int index) ;
	public int login();
	public int displaymenu();
	public void findTravel();
	public void processTravel(int index) ;
	public void displayTravelPlan(int index);
	public void loadPassengers()throws IOException;
	public  void loadTrains()throws IOException;
}
