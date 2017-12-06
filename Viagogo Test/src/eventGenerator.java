import java.util.ArrayList;

/**
 * @author Elavarasan
 *
 */
public class eventGenerator 
{
	private int numberOfEvents;
	private ArrayList<ArrayList<Event>> eventArray = new ArrayList<ArrayList<Event>>();
	public ArrayList<ArrayList<Event>> getEventArray() 
	{
		return eventArray;
	}
	public void setEventArray(ArrayList<ArrayList<Event>> eventArray) 
	{
		this.eventArray = eventArray;
	}
	public int getNumberOfEvents() {
		return numberOfEvents;
	}
	public void setNumberOfEvents(int numberOfEvents) 
	{
		this.numberOfEvents = numberOfEvents;
	}
	public void generateNumberOfEvents()
	{
		RandomNumberGeneration rand=new RandomNumberGeneration();
		this.setNumberOfEvents((int) rand.randomNumberGenerationMethod(1, 441));
		System.out.println("The Number of Events are"+getNumberOfEvents());
		for(int i=0;i<getNumberOfEvents();i++)
		{
			Event e=new Event();
			System.out.println("HI");
		}
	}
}
