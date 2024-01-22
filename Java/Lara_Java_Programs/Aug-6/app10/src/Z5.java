class Z5

{
	public static void main(String[] args) 
	{	
		
		System.out.println("main begin");
		for (int i = 1;i <= 10 ;i++ )
		{
			System.out.println("loop begin"+ i);
			if (i == 5)
			{
				System.out.println("if block:"+i);
				continue;break;//cmp error break  and continue shu be the last statement in the current block 
				System.out.println("something ");
			}
		}
		System.out.println("main end");
	}
}
