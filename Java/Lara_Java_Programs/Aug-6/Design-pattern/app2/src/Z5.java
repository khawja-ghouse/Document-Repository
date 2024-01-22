/*
    1
   123
  12345
 1234567
123456789

*/



class  Z5
{
	public static void main(String[] args) 
	{
		
		for (int i=1 ; i<=5; i++)
		{
			for (int k = 1 ;k <= (5 - i) ;k++ )
			{
				System.out.print(" ");
			}
			for( int j = ((2*i) - 1);j >= 1 ; j--)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		
	}
}