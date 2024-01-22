class C1 extends A 
{
	void test1() throws ClassNotFoundException
	{
		System.out.println("Hello World!");
	}
}
/*
F:\Aug-6\Exception\app6\src>javac -d ../classes C1.java
C1.java:3: error: test1() in C1 cannot override test1() in A
        void test1() throws ClassNotFoundException
             ^
  overridden method does not throw ClassNotFoundException
1 error

*/