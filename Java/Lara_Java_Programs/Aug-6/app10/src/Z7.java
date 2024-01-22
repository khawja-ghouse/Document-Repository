class Z7

{
	public static void main(String[] args) 
	{	
		
		System.out.println("main begin");
		for (int i = 1;i <= 10 ;i++ );//cmp error bec for loop is ending at line number 8 and at line number 9 we using i that is outside the loop
			System.out.println("loop begin"+ i);
			System.out.println("loop end"); 
		System.out.println("main end");
			
	}
}
