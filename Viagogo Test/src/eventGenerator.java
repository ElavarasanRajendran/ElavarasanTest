/**
 * @author Elavarasan
 *
 */
public class eventGenerator 
{
	private int numberOfEvents;
	public int getNumberOfEvents() {
		return numberOfEvents;
	}
	public void setNumberOfEvents(int numberOfEvents) {
		this.numberOfEvents = numberOfEvents;
	}
	public void generateNumberOfEvents()
	{
		RandomNumberGeneration rand=new RandomNumberGeneration();
		this.setNumberOfEvents((int) rand.randomNumberGenerationMethod(1, 441));
		System.out.println("The Number of Events are"+getNumberOfEvents());
		for(int i=0;i<this.getNumberOfEvents();i++)
		{
			Event e=new Event();
		}
	}
}
