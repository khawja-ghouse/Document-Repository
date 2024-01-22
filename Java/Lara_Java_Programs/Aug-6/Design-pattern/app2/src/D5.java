class D5
{
	public static void main(String[] args) 
	{
		for (int i = 1;i <= 4 ;i++ )
		{
			for (int j = 4; j >= i ;j-- )
			{
				System.out.print(" ");
			}
			int s = 3;
			for (int k = 1;k <= i ;k++,s-- )
			{
				System.out.print(s);
			}
			System.out.println();
		}
		for (int i = 3; i >= 1 ;i-- )
		{
			for (int j = 4;  j >= i ;j-- )
			{
				System.out.print(" ");
			}
			int s = 3;
			for (int j= 1;j <= i ;j++ )
			{
				System.out.print(s--);
			}
			System.out.println();
		}
		
	}
}
