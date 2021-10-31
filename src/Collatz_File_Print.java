import java.io.IOException;

public class Collatz_File_Print
{
	public static void main(String args[]) throws IOException
	{
		int terms=10;
		String file_name="C:\\Users\\Janeway\\Dropbox\\Github\\Collatz_Learning_And_Testing\\FileOutputTest\\Collatz_Out.txt";
		WriteFile data = new WriteFile(file_name, true);
		data.WriteToFile("Program Start: "+String.valueOf(System.currentTimeMillis()));
		for(int i=2;i<=terms;i++)
		{
			data.WriteToFile("Seed: "+i);
			data.WriteToFile("Seed Start: "+String.valueOf(System.currentTimeMillis()));
			int this_term=i;
			while(this_term!=1)
			{
				if(this_term%2!=0)
				{
					this_term=(3*this_term)+1;
					data.WriteToFile(String.valueOf(this_term)+", "+String.valueOf(System.currentTimeMillis()));
				}
				else
				{
					this_term=this_term/2;
					data.WriteToFile(String.valueOf(this_term)+", "+String.valueOf(System.currentTimeMillis()));
				}
			}
			data.WriteToFile("Seed End: "+String.valueOf(System.currentTimeMillis()));
		}
		data.WriteToFile("Program End: "+String.valueOf(System.currentTimeMillis()));
	}
}