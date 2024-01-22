package pack1;
class  F
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		int i = 10;
		assert i == 10: ;
		System.out.println(2);
	}
}
/*

F:\Aug-6\Assersion_dev\src>javac -d ../classes pack1/F.java
pack1\F.java:8: error: illegal start of expression
                assert i == 10: ;
                                ^
1 error
after colon there should be something it should not be empty
*/