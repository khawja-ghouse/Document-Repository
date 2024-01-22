class I
{
	I(double x)
	{		
		System.out.println("I(double)");
	}
	I(int i)
	{		
		System.out.println("I(int)");
	}
	public static void main(String[] args) 
	{
		
		System.out.println("main begin");		
		I obj1 = new I(20);
		System.out.println("......");	
		I obj2 = new I(20.5);
	}
}
