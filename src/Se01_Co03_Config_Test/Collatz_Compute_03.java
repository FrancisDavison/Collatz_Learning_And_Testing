package Se01_Co03_Config_Test;
import java.io.*;
import java.net.*;
public class Collatz_Compute_03
{
	public static void main(String args[]) throws IOException, InterruptedException
	{
		Socket Compute_Socket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		int Control_Socket_Num=4545;
		String Control_Name="localhost";
		String Compute_Node_Id="Collatz_Compute_03";
		try
		{
			Compute_Socket=new Socket(Control_Name,Control_Socket_Num);
			out=new PrintWriter(Compute_Socket.getOutputStream(), true);
			in=new BufferedReader(new InputStreamReader(Compute_Socket.getInputStream()));
		}
		catch(UnknownHostException e)
		{
			System.err.println("Don't know about host: localhost");
			System.exit(1);
		}
		catch(IOException e)
		{
			System.err.println("Couldn't get the I/O connection to: "+Control_Socket_Num);
			System.exit(1);
		}
		
		BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
		String From_Server="903933900000000";
		String From_Compute=null;
		
		System.out.println("Initialised "+Compute_Node_Id+" I/O connections");
		Thread.sleep(20000);
		while(true)
		{
			From_Compute=Seed_Compute_01.Compute_Engine_01(From_Server);
			if(From_Compute!=null)
			{
				//check formatting here
				System.out.println(Compute_Node_Id+" sending "+From_Compute+" to Control Node");
				out.println(From_Compute);
			}
			From_Server=in.readLine();
			System.out.println(Compute_Node_Id+" recieved "+From_Server+" from Control Node");
		}
	}
}