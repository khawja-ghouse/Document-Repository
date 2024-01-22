class  N
{
	public static void main(String[] args) 
	{
		for (char i= 'A'; i <= 'E' ; i++ )
		{
			for (char j = 'E' ; j >= i ;j-- )//for (char j = 'E' ; j >=('E' + 'A' - i) ;j-- )
			{
				System.out.print(i);
			}
			System.out.println();
		}
		
	}
}