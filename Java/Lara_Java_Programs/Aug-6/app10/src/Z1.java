class Z1

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
				break;	// comes out of the loop no matter how many iterations are there,should be use with in the loop body ,it shu be the last statement in the current block		
			}
			System.out.println("loop end"+ i);
		}
		System.out.println("main end");
	}
}//we can't use both break and continue in the same block
