import java.io.*;

public class Collatz_File_Print
{
	public static void main(String args[]) throws IOException
	{
		int terms=100;
		String file_name=".\\FileOutputTest\\Collatz_Out.txt";
		WriteFile data = new WriteFile(file_name, true);
		data.WriteToFile("Program Start: "+System.nanoTime());
		for(int i=2;i<=terms;i++)
		{
			System.out.println("Seed: "+i);
			data.WriteToFile("Seed: "+i);
			data.WriteToFile("Seed Start: "+System.nanoTime());
			int this_term=i;
			while(this_term!=1)
			{
				if(this_term%2!=0)
				{
					this_term=(3*this_term)+1;
					data.WriteToFile(String.valueOf(this_term)+", "+System.nanoTime());
				}
				else
				{
					this_term=this_term/2;
					data.WriteToFile(String.valueOf(this_term)+", "+System.nanoTime());
				}
			}
			data.WriteToFile("Seed End: "+System.nanoTime());
		}
		data.WriteToFile("Program End: "+System.nanoTime());
	}
}