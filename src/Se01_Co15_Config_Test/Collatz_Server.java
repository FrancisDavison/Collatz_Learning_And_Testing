package Se01_Co15_Config_Test;
import java.io.*;
import java.net.*;
public class Collatz_Server
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket Control_Socket=null; //Declare ControlSocket and set to null, allows the control node to
		boolean listening=true; //Declares boolean listening as true, sets Server to default always listen on ports
		String Control_Name="Control"; //Declares ControlName variable and sets equal to Control, this names the server
		int Control_Num=4545; //Declares ControlNum variable, this sets the socket number that the server will listen on
		int Rows=1;
		int Columns=1;
		int[][] Seed_Table = new int[Rows][Columns];
		//Seed Array Maker code goes here==========================================================================
		
		
		Collatz_Server_State Shared_State_Object = new Collatz_Server_State(Seed_Table);
		try
		{
			Control_Socket = new ServerSocket(Control_Num);
		}
		catch(IOException e)
		{
			System.err.println("Could not start Control_Node on port: "+Control_Num);
			System.exit(1);
		}
		System.out.println(Control_Name+" started");
		
		while(listening)
		{
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_1", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_2", Shared_State_Object).start();
			System.out.println("New control thread started");
			new Collatz_Server_Thread(Control_Socket.accept(), "Control_Thread_3", Shared_State_Object).start();
			System.out.println("New control thread started");
		}
		Control_Socket.close();
	}
}