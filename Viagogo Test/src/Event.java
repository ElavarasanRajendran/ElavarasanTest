import java.util.*;

/**
 * @author Elavarasan
 *
 */
public class Event 				//Class hold the details of the events
{
private int numberofTickets;
private int eventNumber;
private int Xcordinate;
private int Ycordinate;
private double lowestTicketPrice=500.0;
private ArrayList<Ticket> ticketArray;
public double getLowestTicketPrice() 
{
	return lowestTicketPrice;
}
public void setLowestTicketPrice(double lowestTicketPrice) 
{
	this.lowestTicketPrice = lowestTicketPrice;
}
public int getXcordinate() 
{
	return Xcordinate;
}
public void setXcordinate(int xcordinate) 
{
	Xcordinate = xcordinate;
}
public int getYcordinate() 
{
	return Ycordinate;
}
public void setYcordinate(int ycordinate) 
{
	Ycordinate = ycordinate;
}
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
public Event(int number)			//constructor to generate the tickets for the events
{
	this.setNumberofTickets(number);
	ticketArray=new ArrayList(this.getNumberofTickets());
	for(int i=0;i<this.getNumberofTickets();i++)
	{
		Ticket ticket=new Ticket();
		ticketArray.add(ticket);			//The tickets are added to the Array List of tickets
		if(lowestTicketPrice>ticketArray.get(i).getTicketPrice())
		lowestTicketPrice=ticketArray.get(i).getTicketPrice();
	}
	
	
}
public Event() 
{
	eventNumber=0;
	numberofTickets=0;
	// TODO Auto-generated constructor stub
}
}
