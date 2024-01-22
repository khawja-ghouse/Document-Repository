class P
{
	P(int i)
	{
		System.out.println("P(int)");
	}	
	P()
	{
		this(90);//calling statement
		System.out.println("P()");
	}
	public static void main(String[] args) 
	{
		System.out.println("main-begin");
		P obj1 = new P();
		System.out.println("............");
		P obj2 = new P(10);
		System.out.println("main-end");
	}
}