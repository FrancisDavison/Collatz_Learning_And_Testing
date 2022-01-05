package Se1_Co3_Config_Test;
import java.util.*;
public class Seed_Array_Maker
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
		
		//String[] Node_Names = new String[Compute_Nodes]; //Setting up String array to store Compute Node hostnames
		//Node_Names[0]="Node1"; //Adding test hostname to array
		//System.out.println(Node_Names[0]);//Print array, just for testing
		
		int Rows = Compute_Nodes; //Sets the number of rows in Seed_Table array to number of compute nodes, so each node has one row and all seeds for that node are stored only in that row
		int Seeds_Remainder = Seeds%Compute_Nodes; //Calculating Seeds_Remainder
		System.out.println("Seeds&Compute_Nodes: "+Seeds_Remainder);
		int Columns = ((Seeds+Seeds_Remainder)/(Compute_Nodes))+2; //Calculating number of columns using seeds+seeds remainder, this allows there to always be an integer number of columns and prevents the code from exploding
		int[][] Seed_Table = new int[Rows][Columns]; //Create Seed_Table array of integers, this will store all seeds needed in the computation, will need to test maximum size
		
		//Backfill final row with -1
		for(int i=0;i<Rows;i++)
		{
			Seed_Table[i][Columns-1]=-1;
		}
		
		int Current_Seed=2;
		for(int w=0;w<(Columns-1);w++)
		{
			for(int x=0;x<Rows;x++)
			{
				if(Current_Seed==Seeds+1)
				{
					break;
				}
				Seed_Table[x][w]=Current_Seed;
				Current_Seed+=1;
			}
		}
		
		for(int a=0;a<Rows;a++) //This snippet will just print the Seed_Table out in a more understandable format, only for testing
		{
			System.out.println(Arrays.toString(Seed_Table[a]));
		}
		
		Input_Nodes.close();
		Input_Seeds.close();
	}
	
}