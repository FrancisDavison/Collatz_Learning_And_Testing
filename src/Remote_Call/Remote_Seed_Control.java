package Remote_Call;
public class Remote_Seed_Control
{
	public static void main(String args[])
	{
		int Seed=10; //Sets the value of the seed to be computed
		String FilePath=".\\CSVOutTest\\"+String.valueOf(Seed)+".CSV"; //Sets the file path for the CSV Output
		//System.out.println(FilePath); //Test Output Line --REMOVE--
		Remote_Seed_Compute(Seed, FilePath);
	}
}