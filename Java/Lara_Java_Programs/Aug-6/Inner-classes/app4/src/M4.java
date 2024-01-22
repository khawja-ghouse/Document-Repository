interface A
{
	void test(int i);
}
class  M4
{
	public static void main(String[] args) 
	{


		A a2 = (x) -> { 
						System.out.println("from test" + x);
						System.out.println("from test");
						System.out.println("from test");
						System.out.println("from test");
					};	
		a2.test(20);
	}
}// as there is only one method there is no need of specifying datatype
//single method interfaces are also  called as functional interfaces