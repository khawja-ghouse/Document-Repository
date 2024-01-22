class U
{
	int i;
	public static  U test(U arg1,U arg2)
	{
		System.out.println("test:"+arg1.i+","+arg2.i);
		U ref = new U();
		ref.i = arg1.i +  arg2.i;
		return ref;
	}
	public static void main(String[] args) 
	{
		U u1 = new U();
		U u2 = new U();
		u1.i = 10;
		u2.i = 20;
		U obj = test(u1,u2);
		System.out.println("main1:"+obj.i);
	}
}
