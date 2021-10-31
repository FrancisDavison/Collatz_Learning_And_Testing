public class Collatz_File_Print
{
	public static void main(String args[])
	{
		int terms=100;
		for(int i=2;i<=terms;i++)
		{
			int this_term=i;
			while(this_term!=1)
			{
				if(this_term%2!=0)
				{
					this_term=(3*this_term)+1;
					//Print term to text file //////////////////////
				}
				else
				{
					this_term=this_term/2;
					//Print term to text file
				}
			}
		}
	}
}