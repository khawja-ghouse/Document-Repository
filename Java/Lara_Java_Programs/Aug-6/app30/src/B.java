// byte < short < int < long < float < double

class B
{
	public static void main(String[] args) 
	{
		byte b1 = 100;
		short s1 = (short) b1;
		int i =(int) s1;
		double d1 =  (double)i;
		double d2 =(double) s1;
		double d3 = (double)b1;
		//all the above explicitly conversion is optional no problem if v provid then the compiler ill be don automatically
		System.out.println("Done");
	}
}
