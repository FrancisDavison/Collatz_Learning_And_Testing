package Remote_Call;
import java.io.*;
import com.opencsv.*;
public class Remote_Seed_Input
{
	public static boolean Remote_Seed_Compute(int Seed)
	{
		Seed=10;
		String FilePath=".\\CSVOutTest\\"+String.valueOf(Seed)+".CSV";
		System.out.println(Seed+" "+FilePath);
		return true; //return true if computation succeeded, false if failed
		//true at end of computation
		//fail in IOException section
	}
}