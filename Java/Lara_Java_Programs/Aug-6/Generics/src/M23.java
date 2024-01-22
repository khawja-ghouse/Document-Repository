class A < X >
{
	X obj;
}
class M23 
{
	public static void main(String[] args) 
	{
		A< ? > a1 = null;
		//if reference variable having question mark then object can be any type
		// ? is treated as whildcard character
		
		a1 = new A<Integer>();
		a1 = new A<Object>();
		a1 = new A<P>();
		a1 = new A<String>();
		a1 = new A<Thread>();
		System.out.println("Hello World!");
	}
}
