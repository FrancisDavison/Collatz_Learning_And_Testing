public class Collatz_Print
{
	public static void main(String args[])
	{
		int terms = 1000000;
		System.out.println(terms+": ");
		for(int i=2;i<=terms;i++)
		{
			System.out.println("");
			System.out.println("seed = "+i+": ");
			int this_term = i;
			while(this_term!=1)
			{
				if(this_term%2!=0)
				{
					this_term=(3*this_term)+1;
					System.out.print(this_term+", ");
				}
				else
				{
					this_term=this_term/2;
					System.out.print(this_term+", ");
				}
			}
		}
	}
}