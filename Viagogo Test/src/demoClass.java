import java.util.Scanner;
/**
 * @author Elavarasan
 *
 */
public class demoClass			//Demo class to stimulate the overall program 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		eventGenerator e=new eventGenerator();
		e.addEventsoRealWorld();
		e.printRealWorld();
		int xcord,ycord;
		System.out.println("Enter the X and Y Cordinates");
		Scanner sc=new Scanner(System.in);
		xcord=sc.nextInt();
		ycord=sc.nextInt();
		e.searchNearestEvent(xcord, ycord);
		e.printNreatestDistances();
		if((xcord>10)||(xcord<-10))				//if the user location is greater than -10 or +1- it is considered as a invalid input
		{
			System.out.println("Invalid X co ordinates Input");
			System.exit(1);
		}
		if((ycord>10)||(ycord<-10))
		{
			System.out.println("Invalid Y co ordinates Input");
		System.exit(1);
		}
		sc.close();
	}
}
