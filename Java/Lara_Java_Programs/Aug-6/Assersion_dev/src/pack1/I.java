package pack1;
class  I
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		assert true : test();//you can give anything after : here its method but the method return type should not be void 
		System.out.println(2);
	}
	static int test()
	{
		return 10;
	}
}