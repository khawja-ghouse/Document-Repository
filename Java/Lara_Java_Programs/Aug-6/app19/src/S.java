class S
{
	static int  i= S.j+100;
	static int j = 10;
	public static void main(String[] args) 
	{
		System.out.println("main"+i+","+j);
	}
}
