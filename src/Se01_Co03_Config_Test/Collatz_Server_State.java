package Se01_Co03_Config_Test;
public class Collatz_Server_State
{
	//private Collatz_Server_State Shared_Objecct;
	//private String Thread_Name;
	private boolean Current_Access=false;
	private int Waiting=0;
	private int[][] Seed_Table;
	//Constructor
	Collatz_Server_State(int[][] Seed_Table_In)
	{
		Seed_Table=Seed_Table_In;
	}
	//Attempt to acquire lock
	public synchronized void AcquireLock() throws InterruptedException
	{
		Thread  me=Thread.currentThread(); //====Need a better name than me====
		System.out.println(me.getName()+" is attempting to acquire a lock");
		Waiting+=Waiting;
		while(Current_Access)
		{
			System.out.println(me.getName()+" waiting to get a lock, someone else is accessing...");
			wait();
		}
		//nobody currently has a lock, so assign lock to current thread
		Waiting-=Waiting;
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
	public synchronized String ProcessInput(String Input_From_Compute)
	{
		String Output_To_Compute=null;
		String Raw_Node_Id="";
		String Raw_Seed_Status="";
		String Raw_Current_Seed="";
		int Node_Id=0;
		int Seed_Status=0;
		int Current_Seed=0;
		int[] Live_Index=new int[16]; //use 16 as that is how many Pi's I have available
		
		for(int a=0;a<=2;a++)
		{
			Raw_Node_Id+=Input_From_Compute.charAt(a);
		}
		Node_Id=Integer.valueOf(Raw_Node_Id);
		
		for(int b=3;b<=5;b++)
		{
			Raw_Seed_Status+=Input_From_Compute.charAt(b);
		}
		Seed_Status=Integer.valueOf(Raw_Seed_Status);
		
		for(int d=6;d<=14;d++)//Might not need this for input
		{
			Raw_Current_Seed+=Input_From_Compute.charAt(d);
		}
		Current_Seed=Integer.valueOf(Raw_Current_Seed);
		
		if(Seed_Status==900)
		{
			//Previous compute failed, re-issue same seed again
			Output_To_Compute=Input_From_Compute;
			return Output_To_Compute;
		}
		
		if(Seed_Status==911||Seed_Status==933)
		{
			//Previous compute passed, issue next seed
			if(Seed_Status==933)
			{
				Seed_Status=911;
			}
			Current_Seed=Seed_Table[Node_Id-1][Live_Index[Node_Id-1]];
			Live_Index[Node_Id-1]+=1;
			Output_To_Compute=(String.valueOf(Node_Id))+(String.valueOf(Seed_Status))+(String.valueOf(Current_Seed));
			return Output_To_Compute;
		}
		
		if(Seed_Status==922)
		{
			//Invalid message received, request same message again
			Output_To_Compute=Input_From_Compute;
			return Output_To_Compute;
		}
		
		else
		{
			//Unknown error, return error message to compute node
			System.err.println("Unknown error occured");
			Output_To_Compute="UnknownError";
			return Output_To_Compute;
		}
	}
}