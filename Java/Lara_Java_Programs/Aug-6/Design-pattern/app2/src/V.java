/*
12345
 1234
  123
   12
    1
*/
class  V
{
	public static void main(String[] args) 
	{
		for (int i=1 ; i<=5; i++ )
		{
			for (int  j=1;j <= (6 - i) ;j++ )
			{
				System.out.print(j);
			}
			System.out.println();
			for (int k = 4 ;k >= (5 - i) ;k-- )
			{
				System.out.print(" ");
			}
		}
		
	}
}