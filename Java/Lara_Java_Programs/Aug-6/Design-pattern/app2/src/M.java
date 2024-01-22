class  M
{
	public static void main(String[] args) 
	{
		for (char i= 'A'; i <= 'E' ; i++ )
		{
			for (char j = 'E' ; j >= i ;j-- )//for (char j = 'E' ; j >=('E' + 'A' - i) ;j-- )
			{
				System.out.print(j);
			}
			System.out.println();
		}
		
	}
}
/*
EDCBA
EDCB
EDC
ED
E*/