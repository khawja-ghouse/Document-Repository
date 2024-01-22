class  D
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int  i = 1;
		while(i <= 50)
		{
			System.out.println("loop body "+ i );
			i += 10;
		}
		System.out.println("main end"+i);
	}
}
