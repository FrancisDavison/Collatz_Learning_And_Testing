//Lifted From: https://www.homeandlearn.co.uk/java/write_to_textfile.html

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteFile
{
	private String path;
	private boolean append_to_file = false;
	
	public WriteFile(String file_path)
	{
		path = file_path;
	}
	
	public WriteFile(String file_path, boolean append_value)
	{
		path = file_path;
		append_to_file=append_value;
	}
	
	public void WriteToFile (String textline) throws IOException
	{
		FileWriter write = new FileWriter(path, append_to_file);
		PrintWriter print_line = new PrintWriter(write);
		
		print_line.printf("%s"+"%n", textline);
		print_line.close();
	}
}