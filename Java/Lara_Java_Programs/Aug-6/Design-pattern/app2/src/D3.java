class D3 
{
	public static void main(String[] args) 
	{
		char c1 = 'D' -1;
		for (int i = 3; i >= 0 ;i-- )
		{
			c1 += 1;
			char c2 = c1;
			for (int j= 3;j >= i ;j-- )
			{
				System.out.print(c2);
			}
			System.out.println();
		}
		
		for (int i = 1; i <= 3 ;i++ )
		{
			//char c1 = 'D';
			for (int j= 3;j >= i ;j--,c1-- )
			{
				System.out.print(c1);
			}
			System.out.println();
		}
	}
}
