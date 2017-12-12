import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class eventGenerator implements Comparator<Event> {
		private static int numberOfEvents;
		private Event eventArray[][]=new Event[21][21];
		ArrayList<Event> NearestEventLists=new ArrayList<Event>();
		public int getNumberOfEvents() 
		{
			return numberOfEvents;
		}
		public void setNumberOfEvents(int numberOfEvents) 
		{
			this.numberOfEvents = numberOfEvents;
		}
		
		eventGenerator()				//Constructor to generate number of events
		{
			RandomNumberGeneration random=new RandomNumberGeneration();
			this.setNumberOfEvents((int) random.randomNumberGenerationMethod(1,440));
			System.out.println("The Number of events are " +getNumberOfEvents());
			for(int i=0;i<21;i++)
			{
				for(int j=0;j<21;j++)
				{
					eventArray[i][j]=new Event();
				}
			}
		}
		
		public void addEventsoRealWorld()			//Generate events and stor them in the array of objects
		{
			RandomNumberGeneration random=new RandomNumberGeneration();
			int i=0;
			while(i<getNumberOfEvents())
			{
				int xcordinate=(int) random.randomNumberGenerationMethod(0,20.9);
				int ycordinate=(int) random.randomNumberGenerationMethod(0,20.9);
				if(eventArray[xcordinate][ycordinate].getEventNumber()==0)
				{
					int numberOftickets=(int) random.randomNumberGenerationMethod(0, 100);
					eventArray[xcordinate][ycordinate]=new Event(numberOftickets);
					eventArray[xcordinate][ycordinate].setEventNumber(i+1);
					eventArray[xcordinate][ycordinate].setXcordinate(xcordinate);
					eventArray[xcordinate][ycordinate].setYcordinate(ycordinate);
					i++;
				}
			}
		}
		public void printRealWorld()			//Printing the real world
		{
			System.out.println("Printing the real world");
			for(int i=0;i<21;i++)
		       {
		           for(int j=0;j<21;j++)
		           {
		               System.out.print(+eventArray[i][j].getEventNumber()+" * "+eventArray[i][j].getNumberofTickets()+ "\t");
		           }
		           System.out.println();
		       }
			
		}
		public void calculateDistance(int xcord,int ycord)
		{
			for(int i=0;i<21;i++)
			{
				for(int j=0;j<21;j++)
				{
					if(eventArray[i][j].getEventNumber()!=0)
					{
					eventArray[i][j].distanceFromUserLocation=calculateManhattanDistance(xcord, ycord, eventArray[i][j].getXcordinate(),eventArray[i][j].getYcordinate());
					NearestEventLists.add(eventArray[i][j]);
					}
				}
			}
			
			Collections.sort(NearestEventLists, this);
		}
		public int calculateManhattanDistance(int xcord,int ycord,int x,int y)
		{
			int d=Math.abs(xcord-x)+Math.abs(ycord-y);
			return d;
		}

		@Override
		public int compare(Event event1, Event event2) 
		{
			// TODO Auto-generated method stub
			return event1.distanceFromUserLocation-event2.distanceFromUserLocation;
		}
		public void printnearestevent()
		{
			for(int i=0;i<5;i++)
			{
				System.out.println("The event Number is"+NearestEventLists.get(i).getEventNumber());
				System.out.println("The distance from the user location is"+NearestEventLists.get(i).distanceFromUserLocation);
			}
		}
}