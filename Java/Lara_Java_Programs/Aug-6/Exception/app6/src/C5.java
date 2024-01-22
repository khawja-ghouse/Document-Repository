class C5 extends A 
{
	void test5() throws CloneNotSupportedException
	{
		System.out.println("Hello World!");
	}
}/*
F:\Aug-6\Exception\app6\src>javac -d ../classes C5.java
C5.java:3: error: test5() in C5 cannot override test5() in A
        void test5() throws CloneNotSupportedException
             ^
  overridden method does not throw CloneNotSupportedException
1 error
*/