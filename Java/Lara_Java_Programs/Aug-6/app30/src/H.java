class H 
{
	public static void main(String[] args) 
	{
		int i = 100;
		byte b1 = i;
		System.out.println("Hello World!");
	}
}
/*
F:\Aug-6\app30\src>javac -d ../classes H.java
H.java:6: error: incompatible types: possible lossy conversion from int to byte
                byte b1 = i;
                          ^
1 error
*/