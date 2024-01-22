class Q3 
{
	public static void main(String[] args) 
	{
		int a = 1;int x = 1;
		int b = 6;int y = 6;
		for (int i = 2;i <  10 ;i++)
		{

				if (i % 2 == 0)
				{
					
					for (int j = 1;j <= (8-i)   ;j++ )
					{
						System.out.print(x++);
					}
					x = ++a;
				}
				else
				{
					for (int j = 1;j <=(8-i)   ;j++ )
					{
					System.out.print(b--);
					}
					b = --y;
				}
			System.out.println();

		}
		
	}
}
