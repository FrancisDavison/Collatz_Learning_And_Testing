package Se01_Co15_Config_Test;

public class Collatz_Server_State
{
	private Collatz_Server_State Shared_Objecct;
	private String Thread_Name;
	private boolean Current_Access=false;
	private int Waiting=0;
	private int[][] Seed_Table;
	//Construcor
	Collatz_Server_State(int[][] Seed_Table_In)
	{
		Seed_Table=Seed_Table_In;
	}
	//Attempt to acquire lock
	public synchronized void AcquireLock() throws InterruptedException
	{
		Thread  me=Thread.currentThread(); //====Need a better name than me====
		System.out.println(me.getName()+" is attempting to acquire a lock");
		++Waiting;
		while(Current_Access)
		{
			System.out.println(me.getName()+" waiting to get a lock, someone else is accessing...");
			wait();
		}
		//nobody currently has a lock, so assign lock to current thread
		--Waiting;
		Current_Access=true;
		System.out.println(me.getName()+" got a lock!");
	}
	//Release the lock when thread has finished
	public synchronized void ReleaseLock()
	{
		Current_Access=false;
		notifyAll();
		Thread me=Thread.currentThread();
		System.out.println(me.getName()+" released a lock");
	}
	//Issue seed to thread that currently has lock
	public synchronized String ProcessInput(String Input_Message)
	{
		String Node_Id="";
		String Seed_Status="";
		String New_Seed="";
		System.out.println("Input Message: "+Input_Message);
		//Take input of String Message and String Thread_Name as source?
		String Output_Message=Input_Message;
		Node_Id+=Input_Message.charAt(0);
		Node_Id+=Input_Message.charAt(1);
		Seed_Status+=Input_Message.charAt(2);
		Seed_Status+=Input_Message.charAt(3);
		New_Seed+=Input_Message.charAt(4);
		New_Seed+=Input_Message.charAt(5);
		
		
		System.out.println(Node_Id+" "+Seed_Status+" "+New_Seed);
		
		return Output_Message; //Just placeholder. Will sit inside else statements and not needed when code complete
	}
}