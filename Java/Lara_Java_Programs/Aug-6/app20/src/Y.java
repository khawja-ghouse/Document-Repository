class Y
{
	int i;
	void test()
	{
		System.out.println("test:"+this.i);
		this.i =20;
	}
	public static void main(String[] args)
	{
		Y y1 = new Y();
		y1.i = 10;
		System.out.println("main1:"+y1.i);
		y1.test();
		System.out.println("main2:"+y1.i);
		
	}
} 