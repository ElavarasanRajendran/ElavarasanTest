/**
 * @author Elavarasan
 *
 */
public class Ticket 		//Class to hold the details of the tickets
{
private double ticketPrice;
public double getTicketPrice() 
{
	return ticketPrice;
}
public void setTicketPrice(double ticketPrice) 
{
	this.ticketPrice = ticketPrice;
}
public Ticket()			//Constructor to generate the ticket price
{
	RandomNumberGeneration rand=new RandomNumberGeneration();
	this.setTicketPrice(rand.randomNumberGenerationMethod(1.00, 500.0));
}
}
