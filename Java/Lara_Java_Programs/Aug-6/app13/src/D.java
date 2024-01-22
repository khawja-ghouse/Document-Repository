class D
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int i = 10;
		do
		{
			
			System.out.println("do while-body begin" + i);
			i -= 2;
		}
		while (i >= 1);
		System.out.println("main end"+ i);
	}
}
