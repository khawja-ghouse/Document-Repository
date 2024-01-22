class A < X >
{
	X obj;
}
class M26 
{
	public static void main(String[] args) 
	{
		A< ? extends Number> a1 = null;	
		//now a1 reference ill accept only the Number or subclass of Number 
		a1 = new A<P>();
		a1 = new A<String>();
		a1 = new A<Object>();
		//CTE
		System.out.println("Hello World!");
	}
}
