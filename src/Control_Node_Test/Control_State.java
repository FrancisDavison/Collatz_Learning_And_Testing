package Control_Node_Test;

public class Control_State
{
	private Control_State Shared_Objecct;
	private String Thread_Name;
	private boolean Current_Access=false;
	private int Waiting=0;
	private int[][] Seed_Table;
	//Construcor
	Control_State(int[][] Seed_Table_In)
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
}