class T
{
	T()
	{
		
	}	
	T(int i)
	{
		System.out.println("T(int)");
		this();
	}	
	
	public static void main(String[] args) 
	{
		System.out.println("main-begin");
		
	}
}