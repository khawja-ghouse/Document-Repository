/*
    A
   BBB
  CCCCC
 DDDDDDD
EEEEEEEEE
*/



class  Z2
{
	public static void main(String[] args) 
	{
		char c1 = 'A';
		for (int i=1 ; i<=5; i++,c1++ )
		{
			for (int k = 1 ;k <= (5 - i) ;k++ )
			{
				System.out.print(" ");
			}
			for (int  j=2;j <=(2*i) ;j++ )//for( int j = 1;j< = (2*i) - 1); i++)
			{
				System.out.print(c1);
			}
			System.out.println();
		}
		
	}
}