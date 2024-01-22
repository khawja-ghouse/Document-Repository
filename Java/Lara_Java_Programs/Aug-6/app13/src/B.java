class B
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int i = 1;
		do
		{
			System.out.println("do while-body begin" + i);
			i++;
		}
		while (i<=5)//cmp error bec do while loop shuld end with the semicolon that is part of the syntax
		System.out.println("main end"+ i);
	}
}
