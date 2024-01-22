class H
{
	H()
	{		
		System.out.println("H()");
	}
	H(int i)
	{		
		System.out.println("H(int)");
	}
	H(int i,int j)
	{
		System.out.println("H(int,int)");
	}
	public static void main(String[] args) 
	{
		H h1 = new H(20);
		System.out.println("......");		
		H h2 = new H(20,30);
		System.out.println("......");	
		H h3 = new H(20,30);
		System.out.println("......");		
		H h4 = new H();
		System.out.println("......");		
		H h5 = new H();
		System.out.println("......");
	}
}
