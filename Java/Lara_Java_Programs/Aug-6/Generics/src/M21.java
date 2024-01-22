class A < X extends Number >
{
	X obj;
}
class M21
{
	public static void main(String[] args) 
	{
		A< String > a1 = new A<String>();// not a subclass to number
		A< Thread > a2 = new A<Thread>();// not a subclass to number
		System.out.println("Hello World!");
	}
}