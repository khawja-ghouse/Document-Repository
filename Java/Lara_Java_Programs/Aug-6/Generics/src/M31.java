class A < X >
{
	X obj;
}
class M31 
{
	public static void main(String[] args) 
	{
		A< ? super Number> a1 = null;	
		a1 = new A<Object>();		
		a1 = new A<Number>();		
		System.out.println("Hello...ADC");
	}
}
