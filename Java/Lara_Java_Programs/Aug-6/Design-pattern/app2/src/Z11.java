/*
*********
 *******
  *****
   ***
    *
*/


/*
class  Z11
{
	public static void main(String[] args) 
	{
		for (int i=1 ; i<=5; i++ )
		{
			for (int  j=9;j >= (2*i)-1;j-- )
			{
				System.out.print("*");
			}
			System.out.println();
			for (int k = 4 ;k >= (5 - i) ;k-- )
			{
				System.out.print(" ");
			}
		}
	
	}
}*/
class Z11
{
	int row = 5;
	for (int i = 1;i <= rows ;i++ )
	{
		for (int j = 1;j<=(i - 1);j++ )
		{
			System.out.println(" ");
		}
		for (int k = 1;k <= (((rwos - i)*2)+1) ;j++ )
		{
			System.out.println("*");
		}
		System.out.println();
	}
}