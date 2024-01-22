class Q 
{
	static int x = 100;
	public static void main(String[] args) 
	{
		System.out.println("main1:"+x);
		int x =500;
		System.out.println("main1:"+x);
		System.out.println("main1:"+Q.x);
	}
}
