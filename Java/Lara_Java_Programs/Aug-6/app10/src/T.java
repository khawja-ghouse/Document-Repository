class T

{
	public static void main(String[] args) 
	{	
		
		System.out.println("main begin");
		
		for (int i = 1, j = 50, k =100;
			i<=10 && j>=1 && k >= 90;
			i++,j -= 4,k -= 2,i += 2)
		{

		System.out.println("loop body:"+ i + "," + j + "," +  k);
		}
		System.out.println("main end :");
	}
}