package Seed_Array_Testing;
import java.util.*;

public class Seed_Array_Alternate
{
	public static void main(String args[])
	{
		Scanner Input_Nodes = new Scanner(System.in); //Starting input scanner to get number of Input Nodes from user
		Scanner Input_Seeds = new Scanner(System.in); //Starting input scanner to get number of Input Seeds from user
		System.out.print("Input number of compute nodes: "); //Asking user
		int Compute_Nodes = Input_Nodes.nextInt(); //Saving user input for number of compute nodes as Compute_Nodes
		System.out.println(""); //Adding a line, just makes it look a little nicer
		System.out.print("Input number of seeds: "); //Asking user
		int Seeds = Input_Seeds.nextInt(); //Saving user input for number of seeds as Seeds
		int Rows = Compute_Nodes; //Sets the number of rows in Seed_Table array to number of compute nodes, so each node has one row and all seeds for that node are stored only in that row
		int Columns;
		if(Seeds%Compute_Nodes==0)
		{
			Columns=((Seeds-(Seeds%Compute_Nodes))/Compute_Nodes)+1;
		}
		else
		{
			Columns=((Seeds-(Seeds%Compute_Nodes))/Compute_Nodes)+2;
		}
		int[][] Seed_Table = new int[Rows][Columns]; //Create Seed_Table array of integers, this will store all seeds needed in the computation, will need to test maximum size
		for(int a=0;a<Rows;a++) //This snippet will just print the Seed_Table out in a more understandable format, only for testing
		{
			System.out.println(Arrays.toString(Seed_Table[a]));
		}
	}
}