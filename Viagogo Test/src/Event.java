/**
 * @author Elavarasan
 *
 */
public class Event 
{
private int numberofTickets;
public int getNumberofTickets() 
{
	return numberofTickets;
}
public void setNumberofTickets(int numberofTickets) 
{
	this.numberofTickets = numberofTickets;
}
public Event()
{
	RandomNumberGeneration rand=new RandomNumberGeneration();
	Ticket ticket=new Ticket();
	this.setNumberofTickets((int) rand.randomNumberGenerationMethod(1, 500));
	System.out.println("The number of tickets are"+this.getNumberofTickets());
	System.out.println("The Price of Each Ticket is"+ticket.getTicketPrice());
}
}
