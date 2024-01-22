class C
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		do
		{
			int i = 1;
			System.out.println("do while-body begin" + i);
			i++;
		}
		while (i<=5);
		System.out.println("main end"+ i);
	}
}
