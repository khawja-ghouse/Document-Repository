class P 
{
	static int x = 100;
	public static void main(String[] args) 
	{
		System.out.println("main1:"+x);//no local variable before this so global 100
		int x = 500;
		System.out.println("main2:"+x);// both local and global are there but local is having more preference so 500
	}
}
