class A < X >
{
	X obj;
}
class M33 
{
	public static void main(String[] args) 
	{
		A< Number > a1 = null;	
		a1 = new A< Integer>();		
		//a1 = new A<String>();	
		a1.obj = 30;
		System.out.println("Hello...ADC");
	}
}
