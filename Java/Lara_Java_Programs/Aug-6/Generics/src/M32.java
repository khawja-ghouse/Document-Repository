class A < X >
{
	X obj;
}
class M32 
{
	public static void main(String[] args) 
	{
		A< ? super Number> a1 = null;	
		a1 = new A<Integer>();		
		a1 = new A<String>();		
		System.out.println("Hello...ADC");
	}
}
