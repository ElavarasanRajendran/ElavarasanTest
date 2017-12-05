/**
 * @author Elavarasan
 *
 */
public class Event 
{
int numberofTickets;
public Event()
{
	RandomNumberGeneration rand=new RandomNumberGeneration();
	Ticket ticket=new Ticket();
	numberofTickets=(int) rand.randomNumberGenerationMethod(1, 4000);
	System.out.println("The number of tickets are"+numberofTickets);
	System.out.println("The Price of Each Ticket is"+ticket.getTicketPrice());
}
}
