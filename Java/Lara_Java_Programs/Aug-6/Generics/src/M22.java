class A < X extends Number >
{
	X obj;
}
class M22
{
	public static void main(String[] args) 
	{
		A< P > a1 = new A<P>();// not a subclass to Number
		A< Q > a2 = new A<Q>();// not a subclass to Number
		System.out.println("Hello World!");
	}
}