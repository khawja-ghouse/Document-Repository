class E 
{
	static void test(int i)
	{
		if( i== 11)
		{
			return;
		}
		System.out.println(i);
		i++;
		test(i);
	}
	public static void main(String[] args) 
	{
		test(1);
	}
}
