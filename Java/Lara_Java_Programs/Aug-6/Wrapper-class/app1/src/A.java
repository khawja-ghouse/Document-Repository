class A 
{
	public static void main(String[] args) 
	{
		for (int i =7;i >= 1 ;i-- )
		{
			for (int j = 7;j>=i ;j-- )
			{
				for (int k = 1;k <= (i) ;k++ )
				{
					System.out.print(" ");
				}
				System.out.print(i);
				if( i < 7)
				{
					for(int k = 1;k >= 2*i-11 ;k--)
					{
						System.out.print(" ");
					}
					System.out.print(i);
					break;
				}
			}
			System.out.println();
		}
		
	}
}
