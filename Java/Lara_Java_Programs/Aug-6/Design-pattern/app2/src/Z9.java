/* 
	A
   BAB
  CBABC
 DCBABCD
EDCBABCDE

*/



class  Z9
{
	public static void main(String[] args) 
	{
		char a1 = 'A';//char c1 = 'A'
		for (int i=1 ; i<=5; i++ )
		{
			for (int k = 1 ;k <= (5 - i) ;k++ )
			{
				System.out.print(" ");
			}
			//char c2 = c1++;
			for( int j = 1; j<= ((2*i) - 1); j++)
			{
				if (j < i)
				{
					System.out.print(a1--);//c2--
				}
				else
				{
					System.out.print(a1++);//c1++
				}
			}
			System.out.println();
		}
		
	}
}