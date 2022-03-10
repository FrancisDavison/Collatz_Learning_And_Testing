package Se01_Co03_Config_Test;
import java.io.*;
import java.net.*;
public class Collatz_Compute_01
{
	public static void main(String args[]) throws IOException
	{
		Socket Compute_Socket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		int Control_Socket_Num=4545;
		String Control_Name="localhost";
		String Compute_Node_Id="Collatz_Compute_01";
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
		String From_User; //Need new name for this variable obvs
		String Raw_Node_Id="";
		String Raw_Seed_Status="";
		String Raw_Current_Seed="";
		int Node_Id=0;
		int Seed_Status=0;
		int Current_Seed=0;
		System.out.println("Initialised "+Compute_Node_Id+" I/O connections");
		
		while(true)
		{
			From_User=stdIn.readLine();
			if(From_User!=null)
			{
				//Send To Server
				System.out.println(Compute_Node_Id+" sending "+From_User+" to Control Node");
				out.println(From_User);
			}
			From_Server=in.readLine();
			//Process seed here
			
			for(int a=0;a<=2;a++)
			{
				Raw_Node_Id+=From_User.charAt(a);
			}
			Node_Id=Integer.valueOf(Raw_Node_Id);
			
			for(int b=3;b<=5;b++)
			{
				Raw_Seed_Status+=From_User.charAt(b);
			}
			Seed_Status=Integer.valueOf(Raw_Seed_Status);
			
			for(int c=6;c<=14;c++)
			{
				Raw_Current_Seed+=From_User.charAt(c);
			}
			Current_Seed=Integer.valueOf(Raw_Current_Seed);
			
			if(Seed_Status==900)
			{
				
			}
			
			System.out.println(Compute_Node_Id+" recieved "+From_Server+" from Control Node");
		}
	}
}