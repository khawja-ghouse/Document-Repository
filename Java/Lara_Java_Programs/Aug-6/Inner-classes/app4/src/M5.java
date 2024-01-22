interface A
{
	void test(int i,double j);
}
class  M5
{
	public static void main(String[] args) 
	{


		A a2 = (x,y) -> { 
						System.out.println("from test" + x);
						System.out.println("from test"+y);
						System.out.println("from test");
						System.out.println("from test");
					};	
		a2.test(20,30.3);
	}
}// as there is only one method there is no need of specifying datatype
//single method interfaces are also  called as functional interfaces