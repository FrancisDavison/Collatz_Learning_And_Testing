//Lifted From https://www.homeandlearn.co.uk/java/write_to_textfile.html

import java.io.IOException;

import CSV_Test.WriteFile;

public class FileData
{
	public static void main(String args[]) throws IOException
	{
		String file_name="C:\\Users\\Janeway\\Dropbox\\Github\\Collatz_Learning_And_Testing\\FileOutputTest\\Test_File.txt";
		WriteFile data = new WriteFile(file_name, true);
		data.WriteToFile("Test Line");
		System.out.println("File Written To");
	}
}