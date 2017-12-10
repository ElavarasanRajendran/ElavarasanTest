/**
 * @author Elavarasan
 *
 */
public class Ticket 
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
public Ticket()
{
	RandomNumberGeneration rand=new RandomNumberGeneration();
	this.setTicketPrice(rand.randomNumberGenerationMethod(1.00, 500.0));
}
}
