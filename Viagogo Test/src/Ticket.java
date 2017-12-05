/**
 * @author Elavarasan
 *
 */
public class Ticket 
{
private double ticketPrice;
public double getTicketPrice() {
	return ticketPrice;
}
public void setTicketPrice(double ticketPrice) {
	this.ticketPrice = ticketPrice;
}
public Ticket()
{
	RandomNumberGeneration rand=new RandomNumberGeneration();
	ticketPrice=rand.randomNumberGenerationMethod(1.00, 500.0);
	//System.out.println("The Price of the ticket is"+ticketPrice);
}
}
