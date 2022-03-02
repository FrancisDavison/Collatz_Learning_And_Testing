package Se01_Co15_Config_Test;
import java.util.*;
public class Collatz_Server_State
{
	private Collatz_Server_State Shared_Objecct;
	private String Thread_Name;
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
		
		for(int d=13;d<=21;d++)//Might not need this for input
		{
			Raw_Current_Seed+=Input_From_Compute.charAt(d);
		}
		Current_Seed=Integer.valueOf(Raw_Current_Seed);
		
		if(Seed_Status==900)
		{
			//Previous compute failed, re-issue seed
			Output_To_Compute=Input_From_Compute;
			return Output_To_Compute;
		}
		
		if(Seed_Status==911||Seed_Status==933)
		{
			//Previous compute passed, issue new seed
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
			//Invalid message received, request same again
			Output_To_Compute=Input_From_Compute;
			return Output_To_Compute;
		}
		
		else
		{
			//Unknown error, exit
			System.err.println("Unknown error occured");
			Output_To_Compute="UnknownError";
			return Output_To_Compute;
		}
	}
}

//Code I need to save for reference============================
/*
int[] Seed_Cache=new int[15];
String Raw_Node_Id="";
String Raw_Seed_Status="";
String Raw_Live_Index="";
String Raw_New_Seed="";
String Output_Message=null;
System.out.println("Input Message: "+Input_Message);
//Take input of String Message and String Thread_Name as source? No
Raw_Node_Id+=Input_Message.charAt(0);
Raw_Node_Id+=Input_Message.charAt(1);
int Node_Id=Integer.valueOf(Raw_Node_Id);
Raw_Seed_Status+=Input_Message.charAt(2);
Raw_Seed_Status+=Input_Message.charAt(3);
int Seed_Status=Integer.valueOf(Raw_Seed_Status);
for(int i=4;i==11;i++)
{
	Raw_Live_Index+=Input_Message.charAt(i);
}
int Live_Index=Integer.valueOf(Raw_Live_Index);
for(int j=12;j==Input_Message.length()-1;j++)
{
	Raw_New_Seed+=Input_Message.charAt(j);
}
int New_Seed=Integer.valueOf(Raw_New_Seed);
System.out.println(Node_Id+" "+Seed_Status+" "+Live_Index+" "+New_Seed);
//System.out.println("ProcessInput Array Test: "+Arrays.deepToString(Seed_Table)); //Just for testing
if(Seed_Status==0)
{
	//re issue previous seed
	New_Seed=Seed_Cache[Node_Id];
	Seed_Status=10;
	
	return Output_Message;
}
else
{
	
	//issue new seed
	return Output_Message;
}
*/