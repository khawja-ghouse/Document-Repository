class Z4

{
	public static void main(String[] args) 
	{	
		
		System.out.println("main begin");
		for (int i = 1;i <= 10 ;i++ )
			System.out.println("loop begin"+ i);
			System.out.println("loop end"+ i);//cmp error bec only one statement is taken as loop body ,here i is used out side the body 
		System.out.println("main end"+ i);
			
	}
}
