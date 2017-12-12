import java.util.*;
/**
 * @author Elavarasan
 *
 */

/*Assumtions made:
 * The User location is converted into positive values to work on the array of objects,
 * since the array of objects can only be created or iterated for the positive Intergers
 * The final result is again convert into the 4 Quadrant values.
 * The Array of objects 21*21 is divided into 4 Quadrants and searched for the nearest event using the box search technique,
 * where a Box is built around the user location and searched for the events
 * if the event number is 0, then there are no events found at the location or the location does not host any events
 */
public class eventGenerator
{
	private static int numberOfEvents;					//Number of Events
	Event eventArray[][]=new Event[21][21];				//Event Array of size 21x21
	ArrayList<Event> nearest=new ArrayList<Event>();	//ArrayList to hold Nearest 5 events
	private int userXLocation,userYLocation;			//User's X and Y CoOrdinates
	public int getNumberOfEvents() 
	{
		return numberOfEvents;
	}

	public void setNumberOfEvents(int numberOfEvents) 
	{
		this.numberOfEvents = numberOfEvents;
	}
	
	public eventGenerator()								//Constructor to generate the events using the random number generation
	{
		RandomNumberGeneration random=new RandomNumberGeneration();
		this.setNumberOfEvents((int) random.randomNumberGenerationMethod(1,441));
		System.out.println("The Number of events are " +getNumberOfEvents());
		for(int i=0;i<21;i++)
		{
			for(int j=0;j<21;j++)
			{
				eventArray[i][j]=new Event();			//Initialising the event array
			}
		}
	}
	
	public void addEventsoRealWorld()					//generating the events and storing them randomly in a location
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
	
	public void printRealWorld()					//printing the real world
	{
		System.out.println("Printing the real world");
		for(int i=0;i<21;i++)
	       {
	           for(int j=0;j<21;j++)
	           {
	               System.out.print(i+"-"+j+"-"+eventArray[i][j].getEventNumber()+" * "+eventArray[i][j].getNumberofTickets()+ "\t");
	           }
	           System.out.println();
	       }
		
	}
	public void searchNearestEvent(int x,int y)			//method to search the nearest event from the user location
	{
		this.userXLocation=x;
		this.userYLocation=y;
		int i=0;
			if((x<=20)&&(x>=0)&&(y<=20)&&(y>=0))
			{
				int j=0,k=0,reverseXPoint,reverseYPoint,forwardXPoint,forwardYPoint;
				if(x!=0)
				{
					reverseXPoint =x-1;
				}
				else
				{
					reverseXPoint =x;
				}
				if(y!=0)
				{
					reverseYPoint =y-1;
				}
				else
				{
					reverseYPoint =y;
				}
				if(x!=20)
				{
					forwardXPoint=x+1;
				}
				else
				{
					forwardXPoint=20;
				}
				if(y!=20)
				{
					forwardYPoint=y+1;
				}
				else
				{
					forwardYPoint=20;
				}
				while(i<5)
				{
					for( j=reverseXPoint;j<=forwardXPoint;j++)
					{
						for( k=reverseYPoint;k<=forwardYPoint;k++)
						{
							if((j==reverseXPoint || k==reverseYPoint||k==forwardYPoint||j==forwardXPoint) )
							{
								//System.out.print(j+"*"+k+"\t");
								if(eventArray[j][k].getEventNumber()!=0)
								{
	
									i++;
									nearest.add(eventArray[j][k]);
									
								}
							}
							else
							{
								if(eventArray[j][k].getEventNumber()!=0)
								{
								nearest.add(eventArray[j][k]);
								i++;
								}
								//System.out.print("--*--\t");
							}
						}
						}
					//The user's location is plotted in a graph using the four quadrants
					if(reverseXPoint==0 && reverseYPoint==0)	//Search in the B Quadrant
					{
						quadrantBSearch(forwardXPoint+1,forwardYPoint+1,i);
						break;
					}
					else if(reverseXPoint==0 && forwardYPoint==20) 	//Search in the A Quadrant
					{
						quadrantASearch(forwardXPoint+1,reverseYPoint-1,i);
						break;
					}
					else if(reverseYPoint==0 && forwardXPoint==20)	//Search in the C Quadrant
					{
						quadrantCSearch(forwardYPoint+1,reverseXPoint-1,i);
						break;
					}
					else if(forwardYPoint==20 && forwardXPoint==20)
					{
						quadrantDSearch(reverseXPoint-1,reverseYPoint-1,i);		//Search in the D Quadrant
						break;
					}else if(reverseXPoint ==0 && reverseYPoint!=0 && forwardYPoint!=20 && forwardXPoint!=20)
					{
						blendSearchAB(reverseYPoint-1,forwardYPoint+1,forwardXPoint+1,i); 		//Search in AB Quadrant
						break;
					}
					else if(reverseYPoint ==0 && reverseXPoint!=0 && forwardYPoint!=20 && forwardXPoint!=20)
					{
						blendSearchBC(reverseXPoint-1,forwardYPoint+1,forwardXPoint+1,i);		//Search in BC Quadrant
						break;
					}else if(forwardXPoint ==20 && reverseXPoint!=0 && forwardYPoint!=20 && reverseYPoint!=0)
					{
						blendSearchCD(reverseXPoint-1,forwardYPoint+1,reverseYPoint-1,i);			//Search in CD Quadrant
						break;
					}else if(forwardYPoint ==20 && reverseXPoint!=0 && forwardXPoint!=20 && reverseYPoint!=0)
					{
						blendSearchDA(reverseXPoint-1,forwardXPoint+1,reverseYPoint-1,i);		//Search in DA Quadrant
						break;
					}
					if(reverseXPoint!=0)
						reverseXPoint -= 1;
					if(reverseYPoint!=0)
						reverseYPoint -= 1;
					if(forwardXPoint!=20)
						forwardXPoint+=1;
					if(forwardYPoint!=20)
						forwardYPoint+=1;
				}
			}
		}
	
	public void blendSearchDA(int reverseXPoint,int forwardXPoint,int reverseYPoint,int i)
	{
		int x=0,y=0;
		while(i<5)
		{
			y=reverseYPoint;
			for(x=forwardXPoint;x>=reverseXPoint;x--)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
					i++;
					nearest.add(eventArray[x][y]);
					}
			}
			x=reverseXPoint;
			for(y=20;y>reverseYPoint;y--)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
					i++;
					nearest.add(eventArray[x][y]);
					}
			}
			x=forwardXPoint;
			for(y=20;y>reverseYPoint;y--)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
					i++;
					nearest.add(eventArray[x][y]);
					}
			}
			i++;
			if(reverseXPoint==0)
			{
				quadrantASearch(forwardXPoint+1,reverseYPoint-1,i);
				break;
			}
			if(forwardXPoint==20){
				quadrantDSearch(reverseXPoint-1,reverseYPoint-1,i);
				break;
			}
			if(reverseYPoint!=0)
				reverseYPoint-=1;
			if(reverseXPoint!=0)
				reverseXPoint -= 1;
			if(forwardXPoint!=20)
				forwardXPoint+=1;
		}
	}
	
	public void blendSearchCD(int reverseXPoint,int forwardYPoint,int reverseYPoint,int i)
	{
		int x=0,y=0;
		 while(i<5)
		 {
			x=reverseXPoint;
			for(y=reverseYPoint;y<=forwardYPoint;y++)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
					i++;
					nearest.add(eventArray[x][y]);
					}
			}
			y=forwardYPoint;
			for(x=20;x>reverseXPoint;x--)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
					i++;
					nearest.add(eventArray[x][y]);
					}
			}
			y=reverseYPoint;
			for(x=20;x>reverseXPoint;x--)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
					nearest.add(eventArray[x][y]);
					i++;
					}
			}
			if(reverseYPoint==0)
			{
				quadrantCSearch(forwardYPoint+1,reverseXPoint-1,i);
				break;
			}
			if(forwardYPoint==20)
			{
				quadrantDSearch(reverseXPoint-1,reverseYPoint-1,i);
				break;
			}
			if(reverseYPoint!=0)
				reverseYPoint-=1;
			if(reverseXPoint!=0)
				reverseXPoint -= 1;
			if(forwardYPoint!=20)
				forwardYPoint+=1;
		}
	}

	public void blendSearchBC(int reverseXPoint,int forwardYPoint,int forwardXPoint,int i)
	{
		int x=0,y=0;
		while(i<5)
		{
			x=reverseXPoint;
			for(y=0;y<=forwardYPoint;y++)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
					nearest.add(eventArray[x][y]);
					i++;
					}
			}
			x=forwardXPoint;
			for(y=0;y<=forwardYPoint;y++)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
				nearest.add(eventArray[x][y]);
				i++;
				}
			}
			y=forwardYPoint;
			for(x=forwardXPoint-1;x>reverseXPoint;x--)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
				nearest.add(eventArray[x][y]);
				i++;
				}
			}
			if(reverseXPoint==0)
			{
				quadrantBSearch(forwardXPoint+1,forwardYPoint+1,i);
				break;
			}
			if(forwardXPoint==20)
			{
				quadrantCSearch(forwardYPoint+1,reverseXPoint-1,i);
				break;
			}
			if(forwardXPoint!=20)
				forwardXPoint+=1;
			if(reverseXPoint!=0)
				reverseXPoint -= 1;
			if(forwardYPoint!=20)
				forwardYPoint+=1;
		}
	}

	public void blendSearchAB(int reverseYPoint,int forwardYPoint,int forwardXPoint,int i)
	{
		int x=0,y=0;
		while(i<5)
		{
			y=reverseYPoint;
			for(x=0;x<=forwardXPoint;x++)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
					nearest.add(eventArray[x][y]);
					i++;
					}
			}
			y=forwardYPoint;
			for(x=0;x<=forwardXPoint;x++)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
					nearest.add(eventArray[x][y]);i++;
					}
			}
			x=forwardXPoint;
			for(y=reverseYPoint+1;y<forwardYPoint;y++)
			{
				if(eventArray[x][y].getEventNumber()!=0)
				{
				nearest.add(eventArray[x][y]);i++;
				}
			}
			if(forwardYPoint==20)
			{
				quadrantASearch(forwardXPoint+1,reverseYPoint-1,i);
				break;
			}
			if(reverseYPoint==0)
			{
				quadrantBSearch(forwardXPoint+1,forwardYPoint+1,i);
				break;
			}
			if(forwardXPoint!=20)
				forwardXPoint+=1;
			if(reverseYPoint!=0)
				reverseYPoint -= 1;
			if(forwardYPoint!=20)
				forwardYPoint+=1;
		}
	}
		public void quadrantDSearch(int reverseXPoint,int reverseYPoint,int i)
		{
			int x=0,y=0;
			while(i<5)
			{
				y=reverseYPoint;
				for(x=20;x>=reverseXPoint;x--)
				{
					if(eventArray[x][y].getEventNumber()!=0)
					{
					nearest.add(eventArray[x][y]);i++;
					}
				}
				x=reverseXPoint;
				for(y=20;y>reverseYPoint;y--)
				{
					if(eventArray[x][y].getEventNumber()!=0)
					{
						i++;
						nearest.add(eventArray[x][y]);}
				}
				if(reverseXPoint ==0 && reverseYPoint!=0)
				{	
					linearSearchY(0,reverseYPoint-1,i);
				}
				else if(reverseYPoint == 0 && reverseXPoint!=20)
				{	
					linearSearchX(0,reverseXPoint-1,i);
				}
				if(reverseXPoint!=0)
					reverseXPoint-=1;
				if(reverseYPoint!=0)
					reverseYPoint -= 1;
			}
		}
		
		public void quadrantCSearch(int forwardYPoint,int reverseXPoint,int i)
		{
			int x=0,y=0;
			while(i<5)
			{
				x=reverseXPoint;
				for(y=0;y<=forwardYPoint;y++)
				{
					if(eventArray[x][y].getEventNumber()!=0)
					{
						nearest.add(eventArray[x][y]);i++;
						}
				}
				y=forwardYPoint;
				for(x=20;x>reverseXPoint;x--)
				{
					if(eventArray[x][y].getEventNumber()!=0)
					{
						nearest.add(eventArray[x][y]);i++;
						}
				}
				 if(forwardYPoint ==20 && reverseXPoint!=0)
				{	
					 linearSearchX(0,reverseXPoint-1,i);
				}
				else if(reverseXPoint == 0 && forwardYPoint!=20)
				{	
					linearSearchY(forwardYPoint+1,20,i);
				}
				if(forwardYPoint!=20)
					forwardYPoint+=1;
				if(reverseXPoint!=0)
					reverseXPoint -= 1;
			}
		}
		
		public void quadrantASearch(int forwardXPoint,int reverseYPoint,int i)
		{
			int x=0,y=0;
			while(i<5)
			{
				y=reverseYPoint;
				for(x=0;x<=forwardXPoint;x++)
				{
					if(eventArray[x][y].getEventNumber()!=0)
					{
						nearest.add(eventArray[x][y]);i++;
						}
				}
				x=forwardXPoint;
				for(y=reverseYPoint;y<=20;y++)
				{
					if(eventArray[x][y].getEventNumber()!=0)
					{
						nearest.add(eventArray[x][y]);i++;
						}
				}
				 if(forwardXPoint ==20 && reverseYPoint!=0)
				{	
					 linearSearchY(0,reverseYPoint-1,i);
				}
				else if(reverseYPoint == 0 && forwardXPoint!=20)
				{	
					linearSearchX(forwardXPoint+1,20,i);
				}
				if(forwardXPoint!=20)
					forwardXPoint+=1;
				if(reverseYPoint!=0)
					reverseYPoint -= 1;
			}
		}
	
		public void quadrantBSearch(int forwardXPoint,int forwardYPoint,int i)
		{
			int x=0,y=0;
			while(i<5)
			{
				y=forwardYPoint;
				for(x=0;x<=forwardXPoint;x++)
				{
					if(eventArray[x][y].getEventNumber()!=0)
					{
						nearest.add(eventArray[x][y]);i++;
						}
				}
				x=forwardXPoint;
				for(y=0;y<forwardYPoint;y++)
				{
					if(eventArray[x][y].getEventNumber()!=0)
					{
						nearest.add(eventArray[x][y]);i++;}
				}
				 if(forwardXPoint ==20 && forwardYPoint!=20)
				 {	
					 linearSearchY(forwardYPoint+1,20,i);
				}
				else if(forwardYPoint == 20 && forwardXPoint!=20)
				{	
					linearSearchY(forwardXPoint+1,20,i); 
				}
				if(forwardXPoint!=20)
					forwardXPoint+=1;
				if(forwardYPoint!=20)
					forwardYPoint+=1;
			}
		}
		
		public void linearSearchX(int reverseXPoint,int forwardXPoint,int i)
		{
			int x=0,y=0;
			while(i<5)
			{
				for(x=reverseXPoint;x<=forwardXPoint;x++)
				{
					for(y=0;y<=20;y++)
						if(eventArray[x][y].getEventNumber()!=0)
						{
							nearest.add(eventArray[x][y]);
							i++;
							}
				}
			}
		}
		public void linearSearchY(int reverseYPoint,int forwardYPoint,int i)
		{
			int x=0,y=0;
			while(i<5)
			{
				for(y=reverseYPoint;y<=forwardYPoint;y++)
				{
					for(x=0;x<=20;x++)
						if(eventArray[x][y].getEventNumber()!=0)
						{
							nearest.add(eventArray[x][y]);
							i++;
							}
				}
		}
		}
	
	public int calculatedistance(int x1,int y1, int x2,int y2)		//Method to calculate the Manhattan distance
	{
		int distance=0;
		distance=Math.abs(x1-x2)+Math.abs(y1-y2);					//Manhattan Distance d=|x1-x1|+|y1-y2|
		return distance;
	}
	public void printNreatestDistances()							//Method to print the nearest Event values
	{
		System.out.println("The Nearest event from the user location (X="+(userXLocation-10)+") and (Y="+(userYLocation-10)+") are:");
		Iterator itr=nearest.iterator();
		while(itr.hasNext())
		{
			Event e=(Event) itr.next();
			System.out.println("The event number is"+e.getEventNumber());
			System.out.println("The event is at x="+(e.getXcordinate()-10)+" and y="+(e.getYcordinate()-10));
			System.out.println("The distance from the user location is"+calculatedistance(userXLocation, userYLocation, e.getXcordinate(), e.getYcordinate()));
			System.out.println("the Number of tickets in the events are"+e.getNumberofTickets());
			if(e.getNumberofTickets()!=0)
			{
			System.out.println("The lowest ticket price in the event is "+e.getLowestTicketPrice()+"USD");
			}
			else
			{
				System.out.println("The tickets are sold out");
			}
			System.out.println();
		}
	}
	}