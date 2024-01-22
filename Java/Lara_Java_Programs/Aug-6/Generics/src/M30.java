class A < X >
{
	X obj;
}
class M30 
{
	public static void main(String[] args) 
	{
		A< ? super Q> a1 = null;	
		
		a1 = new A<R>();
		a1 = new A<S>();
		a1 = new A<String>();		
		a1 = new A<Number>();		
		System.out.println("Hello");
	}
}
