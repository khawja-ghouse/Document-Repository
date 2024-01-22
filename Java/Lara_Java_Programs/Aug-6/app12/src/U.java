class  U
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int  i = 1;
		while(i <=  5)
		{
			System.out.println("loop begin "+ i++);
			int j = 10;
			abc:while (j <= 13)
			{
				System.out.println("inner loop begin " +i+","+ j );
				if (j == 11)
				{
					j++;
					break abc;
				}
				System.out.println("inner loop end " +i+","+ j );
				j++;
			}
			System.out.println("loop end "+ i );
			i++;
		}
		System.out.println("main end"+i);
	}
}
