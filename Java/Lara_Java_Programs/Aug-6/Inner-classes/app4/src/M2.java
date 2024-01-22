interface A
{
	void test();
}
class  M2
{
	public static void main(String[] args) 
	{


		A a2 = () -> { 
						System.out.println("from test");
						System.out.println("from test");
						System.out.println("from test");
						System.out.println("from test");
					 };	
		a2.test();
	}
}
//single method interfaces are also  called as functional interfaces