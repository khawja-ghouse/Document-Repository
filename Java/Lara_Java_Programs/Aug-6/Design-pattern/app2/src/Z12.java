class Z12
{
	public static void main(String[] args) 
	{
		int rows = 4;
		for(int i = 1;i <= rows ;i++ )
		{
			for(int j = 1;j<= (i - 1);j++)
			{
				System.out.println(" ");
			}
			for(int k = 1;k <= (((rows - i)*2)+1) ; k++ )
			{
				System.out.print((rows-i+1));
			}
			System.out.println();
		}
	}
}