class A
{
	int i;
}
class M2
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		a1.i = 10;
		A a2 = new A();
		a2.i = 10;
		System.out.println(a1);
		//the state of the object is not printed rather the memory add is printing
		System.out.println(a2);
	}
}