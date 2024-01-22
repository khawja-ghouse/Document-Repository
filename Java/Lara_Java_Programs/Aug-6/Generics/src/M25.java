class A < X >
{
	X obj;
}
class M25 
{
	public static void main(String[] args) 
	{
		A< ? extends Number> a1 = null;	
		//now a1 reference ill accept only the Number or subclass of Number 
		a1 = new A<Number>();
		a1 = new A<Integer>();
		a1 = new A<Byte>();
		
		System.out.println("Hello World!");
	}
}
