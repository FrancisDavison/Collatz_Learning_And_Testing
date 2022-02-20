package Seed_Array_Testing;
import java.util.*;
public class Seed_Array_Maker_Fixed
{
	public static void main(String args[])
	{
		Scanner Input_Nodes = new Scanner(System.in); //Starting input scanner to get number of Input Nodes from user
		Scanner Input_Min_Seed = new Scanner(System.in); //Starting input scanner to get minimum seed value from from user
		Scanner Input_Max_Seed = new Scanner(System.in); //Starting input scanner to get maximum seed value from user
		System.out.print("Input number of compute nodes: "); //Asking user
		int Compute_Nodes = Input_Nodes.nextInt(); //Saving user input for number of compute nodes as Compute_Nodes
		System.out.println(); //Adding a line, just makes it look a little nicer
		System.out.print("Input Minimum Seed: "); //Asking user
		int Min_Seed = Input_Min_Seed.nextInt(); //Saving user input for number of seeds as Seeds
		while(Min_Seed<=1) //Minimum seed value must be 2 or higher
		{
			System.out.println("Minimum Seed value must be >= 2, please input minimum seed value: "); //Asking user for input
			Min_Seed = Input_Min_Seed.nextInt(); //Saving user input
		}
		System.out.println("Input Maximum Seed: "); //Asking user
		int Max_Seed = Input_Max_Seed.nextInt(); //Saving user input for Max seed value
		while(Max_Seed<=Min_Seed) //Max seed must be larger that min seed
		{
			System.out.println("Maximum seed value must be larger than minimum seed value, please input maximum seed value: "); //Asking for user input
			Max_Seed = Input_Max_Seed.nextInt(); //Saving user input
		}
		int Seeds = Max_Seed - Min_Seed; //Creating the seeds variable and setting equal to Max_Seed - Min_Seed
		int Rows = Compute_Nodes; //Sets the number of rows in Seed_Table array to number of compute nodes, so each node has one row and all seeds for that node are stored only in that row
		int Seeds_Remainder = Seeds%Compute_Nodes; //Calculating Seeds_Remainder
		System.out.println("Seeds&Compute_Nodes: "+Seeds_Remainder);//int Columns = ((Seeds+Seeds_Remainder)/(Compute_Nodes))+2; //Calculating number of columns using seeds+seeds remainder, this allows there to always be an integer number of columns and prevents the code from exploding
		int Columns; //creating the Columns variable to dictate the number of columns in the Seed_Array
		if((Seeds-1)%Compute_Nodes==0||Seeds%Compute_Nodes==0) //If  ==0, then only add one extra column to array
		{
			Columns=((Seeds-(Seeds%Compute_Nodes))/Compute_Nodes)+1; //Calculates number of columns needed for given number of seeds
		}
		else //otherwise add two extra columns
		{
			Columns=((Seeds-(Seeds%Compute_Nodes))/Compute_Nodes)+2; //Calculates number of columns needed for given number of seeds
		}
		int[][] Seed_Table = new int[Rows][Columns]; //Create Seed_Table array of integers, this will store all seeds needed in the computation, will need to test maximum size
		//Backfill final row with -1
		for(int i=0;i<Rows;i++) //Counter
		{
			Seed_Table[i][Columns-1]=-1; //Setting each cell from Top row to bottom row, in final column to -1
		}
		int Current_Seed=Min_Seed; //Sets starting seed to 2, as using start seed of 1 will not produce any sequence
		for(int w=0;w<(Columns-1);w++) //Counts Columns
		{
			for(int x=0;x<Rows;x++) //Counts Rows
			{
				if(Current_Seed==Seeds+1) //breaks loop at Current_Seed=Seeds+1 as Current_Seed is increased at end of loop
				{
					break; //break loop if ^ true
				}
				Seed_Table[x][w]=Current_Seed; //Sets cell to value of Current_Seed counter
				Current_Seed+=1; //Increments Current_Seed counter
			}
		}
		for(int a=0;a<Rows;a++) //This snippet will just print the Seed_Table out in a more understandable format, only for testing
		{
			System.out.println(Arrays.toString(Seed_Table[a]));
		}
		Input_Nodes.close(); //Close input scanner for Input_Nodes
		Input_Min_Seed.close(); //Close input scanner for Input_Min_Seed
		Input_Max_Seed.close(); //Close input scanner for Input_Max_Seed
	}
}