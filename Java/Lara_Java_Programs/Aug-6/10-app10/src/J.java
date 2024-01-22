class J

{
	public static void main(String[] args) 
	{	
		
		System.out.println("main begin");
		int i ;
		for (i = 0;i <= 70 ; i += 10 )
		{
		System.out.println("loop body:");
		System.out.println("loop body:"+i);
		System.out.println("................");
		}
		System.out.println("main end"+i);
	}
}
/* compilation successful bec in for loop the i is local  to main and i is initialised in the for loop*/