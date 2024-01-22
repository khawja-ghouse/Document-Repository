class R
{
	R(int i)
	{
		this();
		System.out.println("R(int)");
	}	
	R()
	{
		this(10,20);
		System.out.println("R()");
	}	
	R(int i,int j)
	{
		this(true);
		System.out.println("R(int,int)");
	}
	R(boolean b1)
	{
		
		System.out.println("R(boolean)");
	}	
	public static void main(String[] args) 
	{
		System.out.println("main-begin");
		R obj1 = new R();
		System.out.println("............");
		R obj2 = new R(10);
		System.out.println("............");
		R obj3 = new R(10,20);
		System.out.println("............");
		R obj4 = new R(true);

		System.out.println("main-end");
	}
}