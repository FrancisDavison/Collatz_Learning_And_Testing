package CSV_Test;
import java.io.*;
import com.opencsv.*;
public class Collatz_CSV_Print
{
	public static void main(String args[])
	{
		int terms=100;
		for(int i=2;i<=terms;i++)
		{
			String File_Path=".\\CSVOutTest\\"+String.valueOf(i)+".csv";
			File file = new File(File_Path); //Create new file object with File_Path as parameter
			try
			{
				FileWriter OutputFile = new FileWriter(file); //Create FileWriter object with file as parameter
				
				CSVWriter writer = new CSVWriter(OutputFile); //Create CSVWriter object with filewriter object as parameter
				
				String[] header = {"Intermediary Value","nanoTime"}; //Define Headers
				writer.writeNext(header); //Add Header to CSV
				
				int This_Term=i; //Create and initialise This_Term variable for tracking current seed number
				String[] Seed_Data_Temp={String.valueOf(i),String.valueOf(System.nanoTime())}; //Create Seed_Data_Temp array and add current seed value and nanoTime to array
				writer.writeNext(Seed_Data_Temp); //Write Seed_Data_Temp array to CSV
				String[] Intermediary_Data_Temp={"",""}; //Create Intermediary_Data_Temp array and leave empty so it can be used for all intermediary values later
				while(This_Term!=1)
				{
					if(This_Term%2!=0) //If This_Term is odd:
					{
						This_Term=(3*This_Term)+1; //Multiply This_Term by 3 and add 1
						Intermediary_Data_Temp[0]=String.valueOf(This_Term); //Add This_Term to Intermediary_Data_Temp array at position 0
						Intermediary_Data_Temp[1]=String.valueOf(System.nanoTime()); //Add nanoTime to Intermediary_Data_Temp at position 1
						writer.writeNext(Intermediary_Data_Temp); //Write Intermediary_Data_Temp to CSV
					}
					else //Else (If This_Term is even)
					{
						This_Term=This_Term/2; //Devide This_Term by 2
						Intermediary_Data_Temp[0]=String.valueOf(This_Term); //Add This_Term to Intermediary_Data_Temp array at position 0
						Intermediary_Data_Temp[1]=String.valueOf(System.nanoTime()); //Add nanoTime to Intermediary_Data_Temp at position 1
						writer.writeNext(Intermediary_Data_Temp); ///Write Intermediary_Data_Temp to CSV
					}
				}
				writer.close(); //Close Writer Object
			}
			catch(IOException e) //Catch IOException as e
			{
				e.printStackTrace(); //Print Exception for debug
			}
		}
	}
}