class O
{
	O(int i)
	{
		System.out.println("o(int)");
	}	
	O()
	{
		System.out.println("o()");
	}
	public static void main(String[] args) 
	{
		System.out.println("main-begin");
		O obj1 = new O();
		O obj2 = new O(10);
		System.out.println("main-end");
	}
}