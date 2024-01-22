class P 
{
	public static void main(String[] args) 
	{
		double d1 = 2.5;
		int i = d1;
		System.out.println(i);
	}
}
/*
F:\Aug-6\app30\src>javac -d ../classes P.java
P.java:6: error: incompatible types: possible lossy conversion from double to int
                int i = d1;
                        ^
1 error

wider is assigning to narrower
*/