package pack1;
class  E
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		int i = 10;
		assert i = 10;
		System.out.println(2);
	}
}
/*
F:\Aug-6\Assersion_dev\src>javac -d ../classes pack1/E.java
pack1\E.java:8: error: incompatible types: int cannot be converted to boolean
                assert i = 10;
                         ^
1 error
*/