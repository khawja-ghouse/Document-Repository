class Q
{
	Q(int i)
	{
		this();
		System.out.println("Q(int)");
	}	
	Q()
	{
		
		System.out.println("Q()");
	}
	public static void main(String[] args) 
	{
		System.out.println("main-begin");
		Q obj1 = new Q();
		System.out.println("............");
		Q obj2 = new Q(10);
		System.out.println("main-end");
	}
}