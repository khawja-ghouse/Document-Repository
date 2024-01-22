interface A
{
	int  test();
}
class  M7
{
	public static void main(String[] args) 
	{


		A a2 = () -> {
						System.out.println("from test");
						return 2000;
					 };
		int i = a2.test();
		System.out.println(i);
	}
}