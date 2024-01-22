class D
{
	public static void main(String[] args) 
	{
		System.out.println("main Begin");
		int[] elements = {10,20,40,80,15};
		for(int element : elements)//for-each or enhanced for loop
		{
			System.out.println("loop body"+ element);
		}
		System.out.println("main end"+element);
	}
}
