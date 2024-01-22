class Z
{
	int i;
	void test()
	{
		System.out.println("test:"+i);//System.out.println("test:"+this.i)
		i =20;//this.i = 20
	}
	public static void main(String[] args)
	{
		Z z1 = new Z();
		z1.i = 10;
		System.out.println("main1:"+z1.i);
		z1.test();
		System.out.println("main2:"+z1.i);
		
	}
}