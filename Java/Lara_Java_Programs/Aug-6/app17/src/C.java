class C
{
	static int i = test1();
	static int j = test2();
	public static int test1()
	{
		System.out.println("from test1:" + i + "," + j);
		i += j+1;
		j += i+2;
		return i + j + 3;
	}
	public static int test2()
	{
		System.out.println("from test2:" + i + "," + j);
		i += j + 2;
		j += i + 1;
		return i + j - 3 + test1();
	}
	public static void main(String[] args) 
	{
		System.out.println("from main"+ i + "," + j);
		System.out.println("................");
		System.out.println(test1());
		System.out.println("................");
		System.out.println(test1()+test2());
		
	}
}
