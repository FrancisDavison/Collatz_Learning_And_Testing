package CSV_Test;
import java.io.*;
import com.opencsv.*;
public class CSV_Write_Int_Array
{
	public static void main(String args[])
	{
		String File_Path="C:\\Users\\Janeway\\Dropbox\\Github\\Collatz_Learning_And_Testing\\FileOutputTest\\CSVTest.csv";
		String[] Seed_Data={"17890",String.valueOf(System.nanoTime())};
		WriteCSVIntArray(File_Path,Seed_Data);
	}
	
	public static void WriteCSVIntArray(String File_Path, String[] Seed_Data)
	{
		//create file object for file placed at location specified by File_Path
		File file = new File(File_Path);
		try
		{
			//Create FileWriter object with file as parameter
			FileWriter OutputFile = new FileWriter(file);
			
			//Create CSVWriter object with filewriter object as parameter
			CSVWriter writer = new CSVWriter(OutputFile);
			
			//Add Header to CSV
			String[] header = {"Intermediary Value","nanoTime"};
			writer.writeNext(header);
			
			//Add data to CSV
			writer.writeNext(Seed_Data);
			
			writer.close();
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}