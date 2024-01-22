class  K
{
	public static void main(String[] args) 
	{
		for (char i= 'A' ; i <= 'E'; i++)
		{
			for (char j = 'A';j <= ('A' + 'E' - i) ;j++ )
			{
				System.out.print(j);
			}
			System.out.println();
		}
		
	}
}
/*
ABCDE
ABCD
ABC
AB
A
*/