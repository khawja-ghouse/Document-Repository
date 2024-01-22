class J
{
	J(int x,int j)
	{		
		System.out.println("J(int,int)");
	}
	J(int i,double j)
	{		
		System.out.println("j(int,double)");
	}
	public static void main(String[] args) 
	{
		
		System.out.println("main begin");		
		J j1 = new J(20,20);
		System.out.println("......");	
		J j2 = new J(20,10.5);
	}
}
