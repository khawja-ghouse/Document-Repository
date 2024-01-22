class I
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int i = 1;
		do
		{
			
			System.out.println("do while-body begin" + i);
			
		}
		while (i++ <= 5);
		System.out.println("main end"+ i);
	}
}
