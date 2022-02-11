package Control_Node_Test;
import java.io.*;
import java.net.*;
public class Control_Thread extends Thread
{
	private Socket Control_Socket=null;
	private Control_State Control_State_Object;
	private String My_Control_Server_Thread_Name;
	//private double MySharedVariable;
	
	//Set up the thread
	public Control_Thread(Socket Control_Socket, String Control_Server_Thread_Name, Control_State Shared_Object)
	{
		this.Control_Socket=Control_Socket;
		Control_State_Object=Shared_Object;
		My_Control_Server_Thread_Name=Control_Server_Thread_Name;
	}
	
	public void run()
	{
		try
		{
			System.out.println(My_Control_Server_Thread_Name+"  initializing");
			PrintWriter out=new PrintWriter(Control_Socket.getOutputStream(), true);
			BufferedReader in=new BufferedReader(new InputStreamReader(Control_Socket.getInputStream()));
			String InputLine, OutputLine;
			
			while((InputLine=in.readLine())!=null)
			{
				try
				{
					Control_State_Object.AcquireLock();
					OutputLine=Control_State_Object.ProcessInput(My_Control_Server_Thread_Name, InputLine);
					out.println(OutputLine);
					My_Control_Server_Thread_Name.ReleaseLock();
				}
				catch(InterruptedException e)
				{
					System.err.println("Failed to get lock when reading: "+e);
				}
			}
			out.close();
			in.close();
			Control_Socket.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}