class A < X >
{
	X obj;
}
class M29 
{
	public static void main(String[] args) 
	{
		A< ? super Q> a1 = null;	
		
		a1 = new A<Q>();
		a1 = new A<P>();
		a1 = new A<Object>();		
		System.out.println("Hello...ADC");
	}
}
