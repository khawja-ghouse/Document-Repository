/*  0
   101
  21012
 3210123
432101234
*/



class  Z8
{
	public static void main(String[] args) 
	{
		for (int i=1 ; i<=5; i++ )
		{
			for (int k = 1 ;k <= (5 - i) ;k++ )
			{
				System.out.print(" ");
			}
			
			for( int j = 1,k = (i - 1); j<= ((2*i) - 1); j++)
			{
				if (j < i)
				{
					System.out.print(k--);
				}
				else
				{
					System.out.print(k++);
				}
			}
			System.out.println();
		}
		
	}
}