class  K
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int  i = 1;
		while(i <=  5)
		{
			System.out.println("loop begin "+ i );
			if (i == 3)
			{
				break;				
			}
			i++;
			System.out.println("loop end "+ i );
			
		}
		System.out.println("main end"+i);
	}
}
