class A 
{
	public static void main(String[] args) 
	{
		final int i = 10;
		int j = 20;
		System.out.println(i);
		System.out.println(j);
		i = 10;
		j =20;
		System.out.println(i);
		System.out.println(j);
	}
}
/*
A.java:9: error: cannot assign a value to final variable i
                i = 10;
                ^
1 error
*/