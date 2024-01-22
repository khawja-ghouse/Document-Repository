/* 
    1
   121
  12321
 1234321
123454321
*/



class  Z10
{
	public static void main(String[] args) 
	{
		for (int i=1 ; i<=5; i++ )
		{
			for (int k = 1 ;k <= (5 - i) ;k++ )
			{
				System.out.print(" ");
			}
			
			for( int j = 1,k = 1; j<= ((2*i) - 1); j++)
			{
				if (j < i)
				{
					System.out.print(k++);
				}
				else
				{
					System.out.print(k--);
				}
			}
			System.out.println();
		}
		
	}
}