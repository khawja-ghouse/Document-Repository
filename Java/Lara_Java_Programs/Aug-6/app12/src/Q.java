class  Q
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int  i = 1;
		while(i <=  5)
		{
			System.out.println("loop begin "+ i++);
			for(int j = 10; j <= 13 ; j++)
			{
				System.out.println("inner loop begin " +i+","+ j );
				System.out.println("inner loop end " +i+","+ j );
			}
			System.out.println("loop end "+ i );
			i++;
		}
		System.out.println("main end"+i);
	}
}
