package Se01_Co03_Config_Test;
import java.io.*;
import java.net.*;
import java.util.*;
public class Collatz_Compute_01
{
	public static void main(String args[]) throws IOException, InterruptedException
	{
		boolean Compute_Started=false;
		boolean Initial_Message=true;
		int Control_Socket_Num=4545;
		int Node_Id=0;
		int Seed_Status=0;
		int Current_Seed=0;
		int User_In=0;
		Socket Compute_Socket=null;
		String Control_Name="localhost";
		String Compute_Node_Id="Collatz_Compute_01";
		String Raw_User_In;
		String Raw_Node_Id="";
		String Raw_Seed_Status="";
		String Raw_Current_Seed="";
		String From_Server;
		String Initial_To_Server="901933900000000";
		String To_Server="";
		PrintWriter out=null;
		BufferedReader in=null;
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
		System.out.println("Initialised "+Compute_Node_Id+" I/O connections");
		
		BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
		while(!Compute_Started)
		{
			System.out.println("Start?: ");
			Raw_User_In=stdIn.readLine();
			User_In=Integer.valueOf(Raw_User_In);
			if(User_In==0)
			{
				System.out.println("Quitting in 5 seconds");
				System.exit(5);
			}
			if(User_In==1)
			{
				Compute_Started=true;
			}
		}
		
		while(Compute_Started)
		{
			if(Initial_Message==true)
			{
				To_Server=Initial_To_Server;
				Initial_Message=false;
				System.out.println(Compute_Node_Id+" sending initial "+To_Server+" to Control Node");
				out.println(To_Server);
			}
			else
			{
				System.out.println(Compute_Node_Id+" sending "+To_Server+" to Control Node");
				out.println(To_Server);
			}
			From_Server=in.readLine();
			System.out.println(Compute_Node_Id+" recieved "+From_Server+" from Control Node");
			Thread.sleep(1000);
			for(int a=0;a<=2;a++)
			{
				Raw_Node_Id+=From_Server.charAt(a);
			}
			Node_Id=Integer.valueOf(Raw_Node_Id)-900;
			if(Node_Id!=1)
			{
				To_Server=From_Server;
				out.println(To_Server);
				break;
			}
			
			for(int b=3;b<=5;b++)
			{
				Raw_Seed_Status+=From_Server.charAt(b);
			}
			Seed_Status=Integer.valueOf(Raw_Seed_Status)-900;
			
			for(int d=6;d<=14;d++)
			{
				Raw_Current_Seed+=From_Server.charAt(d);
			}
			try
			{
				Current_Seed=Integer.valueOf(Raw_Current_Seed)-900000000;
			}
			catch(NumberFormatException e)
			{
				System.err.println(e);
			}
			
			if(Seed_Compute_01.Seed_Compute(Current_Seed))
			{
				//Compute success, new seed
				Seed_Status=11;
				To_Server=(String.valueOf(Node_Id+900))+(String.valueOf(Seed_Status+900))+(String.valueOf(Current_Seed+900000000));
				Thread.sleep(1);
			}
			
			else
			{
				//Compute fail, same seed
				Seed_Status=0;
				To_Server=(String.valueOf(Node_Id+900))+(String.valueOf(Seed_Status+900))+(String.valueOf(Current_Seed+900000000));
				Thread.sleep(1);
			}
		}
	}
}