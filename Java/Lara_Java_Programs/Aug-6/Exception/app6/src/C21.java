class C21 extends A 
{
	void test2() throws InterruptedException
	{
		System.out.println("Hello World!");
	}
}
/*
C21.java:3: error: test2() in C21 cannot override test2() in A
        void test2() throws InterruptedException
             ^
  overridden method does not throw InterruptedException
1 error
*/