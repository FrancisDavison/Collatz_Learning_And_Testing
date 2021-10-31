import java.io.IOException;

public class Collatz_File_Print
{
	public static void main(String args[]) throws IOException
	{
		int terms=1000;
		String file_name="C:\\Users\\Janeway\\Dropbox\\Github\\Collatz_Learning_And_Testing\\FileOutputTest\\Collatz_Out.txt";
		WriteFile data = new WriteFile(file_name, true);
		for(int i=2;i<=terms;i++)
		{
			data.WriteToFile("Seed: "+String.valueOf(i));
			int this_term=i;
			while(this_term!=1)
			{
				
				if(this_term%2!=0)
				{
					this_term=(3*this_term)+1;
					data.WriteToFile(String.valueOf(this_term));
				}
				else
				{
					this_term=this_term/2;
					data.WriteToFile(String.valueOf(this_term));
				}
			}
		}
	}
}