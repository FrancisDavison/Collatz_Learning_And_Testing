package Remote_Call;
public class Remote_Seed_Control
{
	public static void main(String args[])
	{
		int Seed=10; //Sets the value of the seed to be computed by Remote_Seed_Compute
		if(Remote_Seed_Input.Remote_Seed_Compute(Seed))
		{
			System.out.println("Completed Succesfully");
		}
		else
		{
			System.out.println("Failed");
		}
	}
}