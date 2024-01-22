class Z3
	{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		int i = 10;
		int  j = test(i++);
		System.out.println("main end ->" +i+" , " +j );
	}
	public static int  test(int i)
	{
		System.out.println("from test:" + i);
		return i++;
	}
}
