class M10 
{
	public static void main(String[] args) 
	{
		B b1 = new E();
		C c1 = b1;
		D d1 = b1;
		E e1 = d1;
		E e2 = c1;
		E e3 = b1;
		System.out.println("Hello World!");
	}
}
/*
F:\Aug-6\app31\src>javac -d ../classes M10.java
M10.java:6: error: incompatible types: B cannot be converted to C
                C c1 = b1;
                       ^
M10.java:7: error: incompatible types: B cannot be converted to D
                D d1 = b1;
                       ^
M10.java:8: error: incompatible types: D cannot be converted to E
                E e1 = d1;
                       ^
M10.java:9: error: incompatible types: C cannot be converted to E
                E e2 = c1;
                       ^
M10.java:10: error: incompatible types: B cannot be converted to E
                E e3 = b1;
                       ^
5 errors
*/
// If the right hand side is super class type then downcasting should be done explicitly