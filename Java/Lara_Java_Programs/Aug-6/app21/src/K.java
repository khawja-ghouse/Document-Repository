class K
{
	K(int x)
	{		
		System.out.println("K(int)");
	}
	K(int j)
	{		
		System.out.println("K(int j)");
		System.out.println("K(int j)");
		System.out.println("K(int j)");
	}
	public static void main(String[] args) 
	{
		System.out.println("done");		
	}
}
//cmp error bec we are over loading the two constructor having the same signature 