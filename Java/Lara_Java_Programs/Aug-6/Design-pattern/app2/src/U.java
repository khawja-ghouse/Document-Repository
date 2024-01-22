/*
55555
 4444
  333
   22
    1
*/
class  U
{
	public static void main(String[] args) 
	{
		for (int i=1 ; i<=5; i++ )
		{
			for (int  j=1;j <= (6 - i) ;j++ )
			{
				System.out.print((6-i));
			}
			System.out.println();
			for (int k = 4 ;k >= (5 - i) ;k-- )
			{
				System.out.print(" ");
			}
		}
		
	}
}