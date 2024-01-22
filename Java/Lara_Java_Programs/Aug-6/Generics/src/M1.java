class A
{
	int i;
}
class M1 
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		a1.i = 10;

		A a2 = new A();
		a2.i = 30;
		System.out.println("Hello World!");
	}
}
//for every object of A only int type of data is only allowed
//v cant keep double type of data for i ;