/*
    1
   333
  55555
 7777777
999999999
*/



class  Z1
{
	public static void main(String[] args) 
	{
		for (int i=1 ; i<=5; i++ )
		{
			for (int k = 1 ;k <= (5 - i) ;k++ )
			{
				System.out.print(" ");
			}
			for (int  j=2;j <=(2*i) ;j++ )//for( int j = 1;j< = (2*i) - 1); i++)
			{
				System.out.print((2*i)-i);
			}
			System.out.println();
		}
		
	}
}