class R
{
	static int  i= j+100;// cmp error bec state of j is still in indirect read 
	static int j = 10;
	public static void main(String[] args) 
	{
		System.out.println("main"+i+","+j);
	}
}
