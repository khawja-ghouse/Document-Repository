/*
    A
   ABC
  ABCDE
 ABCDEFG
ABCDEFGHI
*/



class  Z6
{
	public static void main(String[] args) 
	{
		
		for (int i=1 ; i<=5; i++ )
		{
			for (int k = 1 ;k <= (5 - i) ;k++ )
			{
				System.out.print(" ");
			}
			char c1 = 'A';
			for (int  j=2;j <=(2*i) ;j++ ,c1++)//for( int j = 1;j< = (2*i) - 1); i++)
			{
				System.out.print(c1);
			}
			System.out.println();
		}
		
	}
}