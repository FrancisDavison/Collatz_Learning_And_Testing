package Se1_Co3_Config_Test;
import java.util.*;
public class Seed_Array_Maker
{
	public static void main(String args[])
	{
		Scanner Input_Nodes = new Scanner(System.in);
		Scanner Input_Seeds = new Scanner(System.in);
		System.out.print("Input number of compute nodes: ");
		int Compute_Nodes = Input_Nodes.nextInt();
		System.out.println("");
		System.out.print("Input number of seeds: ");
		int Seeds = Input_Seeds.nextInt();
		
		String[] Node_Names = new String[Compute_Nodes];
		Node_Names[0]="Node1";
		System.out.println(Node_Names[0]);
		
		
		
		
		
		
	
		HashMap<String,int[]> arraynames = new HashMap<String,int[]>();
		arraynames.put("fruits", new int[10]);

		// then simply access it with
		arraynames.get("fruits")[0] = 100;
		
		System.out.println(Arrays.toString(arraynames.get("fruits")));
		
		Input_Nodes.close();
		Input_Seeds.close();
	}
	
}