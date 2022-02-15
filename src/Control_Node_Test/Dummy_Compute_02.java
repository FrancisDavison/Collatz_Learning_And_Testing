package Control_Node_Test;
import java.io.*;
import java.net.*;
public class Dummy_Compute_02
{
	public static void main(String args[]) throws IOException
	{
		Socket Compute_Socket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		int Control_Socket_Num=4545;
		String Control_Name="localhost";
		String Compute_Node_Id="Dummy_Compute2";
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
		String From_Server;
		String From_User;
		
		System.out.println("Initialised "+Compute_Node_Id+" I/O connections");
		
		while(true)
		{
			From_User=stdIn.readLine();
			if(From_User!=null)
			{
				System.out.println(Compute_Node_Id+" sending "+From_User+" to Control Node");
				out.println(From_User);
			}
			From_Server=in.readLine();
			System.out.println(Compute_Node_Id+" recieved "+From_Server+" from Control Node");
		}
	}
}