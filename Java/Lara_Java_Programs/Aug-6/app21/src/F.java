class F
{
	int i;
	F(int i)
	{		
		System.out.println("F(int)");
	}
	F()
	{		
		System.out.println("F()");
	}
	public static void main(String[] args) 
	{
		F f1 = new F(20);
		
		System.out.println("......");
		F f2 = new F();
		System.out.println(".......");
	}
}
