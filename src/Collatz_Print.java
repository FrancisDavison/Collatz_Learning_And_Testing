public class Collatz_Print
{
	public static void main(String args[])
	{
		int terms = 10;
		for(int i=0;i<=terms;i++)
		{
			if(i%2==0)
			{
				System.out.println(i+"even");
			}
			else
			{
				System.out.println(i+"odd");
			}
		}
	}
}