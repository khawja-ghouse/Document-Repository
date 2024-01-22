class B
{
	public static void main(String[] args) 
	{
		System.out.println("main Begin");
		int[] elements = {10,20,40,80,15};
		int element;
		for( element : elements)//cmp error
		{
			System.out.println("loop body"+ element);
		}
		System.out.println("main end");
	}
}
