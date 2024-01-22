class J
{
	static int x = y;//forward reference 
	static int y;
	public static void main(String[] args) 
	{
		System.out.println(x +"," +y);
	}
}
