import java.util.*;

/**
 * @author Elavarasan
 *
 */
public class Event 
{
private int numberofTickets;
private int eventNumber;
private int Xcordinate;
public int getXcordinate() {
	return Xcordinate;
}
public void setXcordinate(int xcordinate) {
	Xcordinate = xcordinate;
}
public int getYcordinate() {
	return Ycordinate;
}
public void setYcordinate(int ycordinate) {
	Ycordinate = ycordinate;
}
private int Ycordinate;
private ArrayList<Ticket> ticketArray;
public int getEventNumber() 
{
	return eventNumber;
}
public void setEventNumber(int eventNumber) 
{
	this.eventNumber = eventNumber;
}
public int getNumberofTickets() 
{
	return numberofTickets;
}
public void setNumberofTickets(int numberofTickets) 
{
	this.numberofTickets = numberofTickets;
}
public Event(int number)
{
	RandomNumberGeneration rand=new RandomNumberGeneration();
	this.setNumberofTickets(number);
	ticketArray=new ArrayList(this.getNumberofTickets());
	for(int i=0;i<this.getNumberofTickets();i++)
	{
		Ticket ticket=new Ticket();
		ticketArray.add(ticket);
	}
}
public Event() 
{
	eventNumber=0;
	numberofTickets=0;
	// TODO Auto-generated constructor stub
}
}
