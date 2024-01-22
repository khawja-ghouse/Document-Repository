class Z14
{
	public static void main(String[] args) 
	{
		int rows = 4;
		char c1 = 'G';
		for(int i = 1;i <= rows;i++ , c1 -= 2)
		{
			for(int j = 1;j<= (i - 1);j++)
			{
				System.out.print(" ");
			}
			for(int k = 1;k <= (((rows - i)*2)+1) ; k++ )
			{
				System.out.print(c1);
			}
			System.out.println();
		}
	}
}