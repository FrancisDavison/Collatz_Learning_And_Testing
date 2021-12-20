package CSV_Test;
import java.io.IOException;

public class Collatz_CSV_Print
{
	public static void main(String args[]) throws IOException
	{
		int terms=10;
		System.out.println("Program Start: "+String.valueOf(System.nanoTime()));
		//Add program start nanoTime to CSV
		for(int i=2;i<=terms;i++)
		{
			//add Seed number to CSV
			//add Seed start nanoTime to CSV
			int this_term=i;
			while(this_term!=1)
			{
				if(this_term!=1)
				{
					this_term=(3*this_term)+1;
					//add Intermediary number + nanoTime to CSV
				}
				else
				{
					this_term=this_term/2;
					//add Intermediary number + nanoTime to CSV
				}
			}
			//Add seed end nanoTime to CSV
		}
		//add Program end nanoTime to CSV
	}
	
}