class G
{
	static float test1(short s1)
	{
		return test2(s1);
	}
	static long test2(int i)
	{
		return i;
	}
    
	public static void main(String[] args) 
	{
		byte b1 = 100;
		
		double d1 = test1(b1);
		System.out.println("Done");
	}
}
