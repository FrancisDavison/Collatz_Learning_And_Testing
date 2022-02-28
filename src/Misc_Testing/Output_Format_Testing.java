package Misc_Testing;
public class Output_Format_Testing
{
	public static void main(String args[])
	{
		String Input_From_Compute="";
		String Output_To_Compute=null;
		String Raw_Node_Id="";
		String Raw_Seed_Status="";
		String Raw_Current_Seed="";
		int Node_Id=914;
		int Seed_Status=933;
		int Current_Seed=964732891;
		int[] Live_Index=new int[16]; //use 16 as that is how many Pi's I have available
		
		Output_To_Compute=(String.valueOf(Node_Id))+(String.valueOf(Seed_Status))+(String.valueOf(Current_Seed));
		System.out.println(Output_To_Compute);
	}
}