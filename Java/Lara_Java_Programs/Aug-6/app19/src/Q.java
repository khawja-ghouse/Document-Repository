class Q
{
	static 
	{
		System.out.println("sib"+Q.i);//indirect usage if we are using through class name
	}
	static int i = 10;
	public static void main(String[] args) 
	{
		System.out.println("main"+i);
	}
}
