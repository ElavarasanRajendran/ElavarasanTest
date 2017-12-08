import java.util.Scanner;

public class demoClass {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		eventGenerator event=new eventGenerator();
		event.addEventsoRealWorld();
		event.printRealWorld();
		int xcord,ycord;
		System.out.println("Enter the X and Y Cordinates");
		Scanner sc=new Scanner(System.in);
		xcord=sc.nextInt();
		ycord=sc.nextInt();
		/*if((xcord>10)||(xcord<-10))
		{
			System.out.println("Invalid X co ordinates Input");
			System.exit(1);
		}
		if((ycord>10)||(ycord<-10))
		{
			System.out.println("Invalid Y co ordinates Input");
		System.exit(1);
		}*/
		event.searchNearestEvent(xcord,ycord);
	}
}
