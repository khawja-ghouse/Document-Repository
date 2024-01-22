/*
    A
   CBA
  EDCBA
 GFEDCBA
IHGFEDCBA

*/



class  Z7
{
	public static void main(String[] args) 
	{
		char c1 = 'A' - 2;
		for (int i=1 ; i<=5; i++ )
		{
			for (int k = 1 ;k <= (5 - i) ;k++ )
			{
				System.out.print(" ");
			}
			c1 += 2;
			char c2 = c1;			
			for (int  j=2;j <=(2*i) ;j++ ,c2--)//for( int j = 1;j< = (2*i) - 1); i++)
			{
				System.out.print(c2);
			}
			System.out.println();
		}
		
	}
}