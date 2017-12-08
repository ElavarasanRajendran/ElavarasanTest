import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Elavarasan
 *
 */
public class eventGenerator
{
	private static int numberOfEvents;
	private Event eventArray[][]=new Event[21][21];
	public int getNumberOfEvents() 
	{
		return numberOfEvents;
	}

	public void setNumberOfEvents(int numberOfEvents) 
	{
		this.numberOfEvents = numberOfEvents;
	}
	
	public eventGenerator()
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
	
	public void addEventsoRealWorld()
	{
		RandomNumberGeneration random=new RandomNumberGeneration();
		int i=0;
		while(i<getNumberOfEvents())
		{
			int xcordinate=(int) random.randomNumberGenerationMethod(0,20.9);
			int ycordinate=(int) random.randomNumberGenerationMethod(0,20.9);
			if(eventArray[xcordinate][ycordinate].getEventNumber()==0)
			{
				System.out.println("Iteration Time"+(i+1));
				int numberOftickets=(int) random.randomNumberGenerationMethod(0, 100);
				eventArray[xcordinate][ycordinate]=new Event(numberOftickets);
				eventArray[xcordinate][ycordinate].setEventNumber(i+1);
				eventArray[xcordinate][ycordinate].setXcordinate(xcordinate);
				eventArray[xcordinate][ycordinate].setYcordinate(ycordinate);
				i++;
			}
		}
	}
	
	public void printRealWorld()
	{
		System.out.println("Printing the real world");
		for(int i=0;i<21;i++)
	       {
	           for(int j=0;j<21;j++)
	           {
	               System.out.print(eventArray[i][j].getNumberofTickets()+ "\t");
	           }
	           System.out.println();
	       }
		
	}
	public void searchNearestEvent(int xcord,int ycord)
	{
		Event NearestEvent[]=new Event[5];
		int i=0;
		//boolean found=false;
		int minusx=-1,minusy=-1,plusx=1,plusy=1;
		int x=xcord;
		int y=ycord;
		while(i<5)
		{
			//System.out.println("The x and y value at the start of loop is"+x+"and"+y);
			if((x<=20)&&(x>=0)&&(y<=20)&&(y>=0))
			{
		if(eventArray[x][y].getEventNumber()!=0)
		{
			NearestEvent[i]=eventArray[x][y];
			System.out.println("The nearest Event's ticket price is"+NearestEvent[i].getNumberofTickets()+"\t"+NearestEvent[i].getXcordinate()+"\t"+NearestEvent[i].getYcordinate());
			i++;
			//x-=1;y-=2;
			continue;
		}
		else
		{
			if((x+plusx)<=20){
			if(eventArray[x+plusx][y].getEventNumber()!=0)
			{
				NearestEvent[i]=eventArray[x][y+plusy];
				System.out.println("The nearest Event's ticket price is"+NearestEvent[i].getNumberofTickets()+"\t"+NearestEvent[i].getXcordinate()+"\t"+NearestEvent[i].getYcordinate());
				i++;
				//x+=1;
				//continue;
			}}
			if((y+plusy)<=20){ 
				if(eventArray[x][y+plusy].getEventNumber()!=0)
				{
				NearestEvent[i]=eventArray[x][y+plusy];
				System.out.println("The nearest Event's ticket price is"+NearestEvent[i].getNumberofTickets()+"\t"+NearestEvent[i].getXcordinate()+"\t"+NearestEvent[i].getYcordinate());
				//y+=1;
				i++;
				//continue;
				}}
			if((y+minusy)>=0){ 
				if(eventArray[x][y+minusy].getEventNumber()!=0)
				{
				NearestEvent[i]=eventArray[x][y+minusy];
				System.out.println("The nearest Event's ticket price is"+NearestEvent[i].getNumberofTickets()+"\t"+NearestEvent[i].getXcordinate()+"\t"+NearestEvent[i].getYcordinate());
				//y-=1;
				//found=true;
				i++;
				//continue;
				}}
			if((x+minusx)>=0){
				if(eventArray[x+minusx][y].getEventNumber()!=0)
				{
					NearestEvent[i]=eventArray[x+minusx][y];
					System.out.println("The nearest Event's ticket price is"+NearestEvent[i].getNumberofTickets()+"\t"+NearestEvent[i].getXcordinate()+"\t"+NearestEvent[i].getYcordinate());
					i++;
					//x-=1;
					//found=true;
					//continue;
				}
			  }
			 }
		 plusx+=1;
		 plusy+=1;
		 minusx-=1;
		 minusy-=1;
			}
		  }
		}
	}