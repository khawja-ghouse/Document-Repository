class C4 extends A 
{
	void test4() throws InterruptedException
	{
		System.out.println("Hello World!");
	}
}
/*
C3.java:3: error: test3() in C3 cannot override test3() in A
        void test3() throws InterruptedException
             ^
  overridden method does not throw InterruptedException
1 error

*/