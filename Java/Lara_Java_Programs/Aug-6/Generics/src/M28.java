class A < X >
{
	X obj;
}
class M28 
{
	public static void main(String[] args) 
	{
		A< ? extends Q> a1 = null;	
		
		a1 = new A<P>();
		a1 = new A<Object>();
		a1 = new A<String>();		
		System.out.println("Hello...ADC");
	}
}
