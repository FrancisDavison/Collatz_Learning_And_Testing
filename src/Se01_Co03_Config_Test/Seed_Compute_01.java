package Se01_Co03_Config_Test;
import java.io.*;
import com.opencsv.*;
public class Seed_Compute_01
{
	public static String Compute_Engine_01(String Message) throws InterruptedException
	{
		Thread.sleep(3000);
		int Current_Seed=0;
		String File_Path=".\\Se1_Co03_Config_Output_Test\\"+String.valueOf(Current_Seed)+".csv";
		File file = new File(File_Path);
		try
		{
			FileWriter OutputFile = new FileWriter(file); //Create FileWriter object with file as parameter
			CSVWriter writer = new CSVWriter(OutputFile,',',CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END); //Create CSVWriter object with filewriter object as parameter, comma as seperator, no quotes on data, and default escape characters and line ends
			String[] header = {"Intermediary Value","nanoTime"}; //Define Headers
			writer.writeNext(header); //Add Header to CSV
			
			int This_Term=Current_Seed; //Create and initialise This_Term variable for tracking current seed number
			String[] Seed_Data_Temp = {String.valueOf(Current_Seed),String.valueOf(System.nanoTime())}; //Create Seed_Data_Temp array and add current seed value and nanoTime to array
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
					This_Term=This_Term/2; //Divide This_Term by 2
					Intermediary_Data_Temp[0]=String.valueOf(This_Term); //Add This_Term to Intermediary_Data_Temp array at position 0
					Intermediary_Data_Temp[1]=String.valueOf(System.nanoTime()); //Add nanoTime to Intermediary_Data_Temp at position 1
					writer.writeNext(Intermediary_Data_Temp); //Write Intermediary_Data_Temp to CSV
				}
			}
			writer.close();
			//Re-construct message here
			return Message;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			//Re-construct message here
			return Message;
		}
	}
}