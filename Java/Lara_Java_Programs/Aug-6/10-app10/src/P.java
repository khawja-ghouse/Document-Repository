class P

{
	public static void main(String[] args) 
	{	
		
		System.out.println("main begin");
		
		for (int i = 1, j = 50;i<=10 ;i++,j -= 4)
		{

		System.out.println("loop body:"+i+","+j);
		}
		System.out.println("main end :");
	}
}