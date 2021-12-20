package CSV_Test;
import java.io.*;
import com.opencsv.*;
public class Collatz_CSV_Print
{
	public static void main(String args[]) throws IOException
	{
		int terms=10;
		System.out.println("Program Start: "+String.valueOf(System.nanoTime()));
		for(int i=2;i<=terms;i++)
		{
			String File_Path="C:\\Users\\Janeway\\Dropbox\\Github\\Collatz_Learning_And_Testing\\CSVOutTest\\"+String.valueOf(i)+".csv";
			File file = new File(File_Path);
			System.out.println("Create File");
			try
			{
				//Create FileWriter object with file as parameter
				FileWriter OutputFile = new FileWriter(file);
				System.out.println("Create FileWriter Object with file as parameter");
				
				//Create CSVWriter object with filewriter object as parameter
				CSVWriter writer = new CSVWriter(OutputFile);
				System.out.println("Create CSVWriter object with filewriter as parameter");
				
				//Add Header to CSV
				String[] header = {"Intermediary Value","nanoTime"};
				writer.writeNext(header);
				System.out.println("Write headers to file");
				
				int This_Term=i;
				String[] Seed_Data_Temp={String.valueOf(i),String.valueOf(System.nanoTime())};
				writer.writeNext(Seed_Data_Temp);
				System.out.println("Write initial seed data to file ");
				String[] Intermediary_Data_Temp={"",""};
				while(This_Term!=1)
				{
					if(This_Term%2!=0)
					{
						This_Term=(3*This_Term)+1;
						//add Intermediary number + nanoTime to CSV
						Intermediary_Data_Temp[0]=String.valueOf(This_Term);
						Intermediary_Data_Temp[1]=String.valueOf(System.nanoTime());
						writer.writeNext(Intermediary_Data_Temp);
					}
					else
					{
						This_Term=This_Term/2;
						//add Intermediary number + nanoTime to CSV
						Intermediary_Data_Temp[0]=String.valueOf(This_Term);
						Intermediary_Data_Temp[1]=String.valueOf(System.nanoTime());
						writer.writeNext(Intermediary_Data_Temp);
					}
				}
				writer.close();
			}
			catch(IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
			//add Seed number and nanoTime to CSV
			
		}
	}
}
//Name CSV with seed number
//Calculate this_Term
//Write this_term and nanoTime to String array
//Write String array to CSV
