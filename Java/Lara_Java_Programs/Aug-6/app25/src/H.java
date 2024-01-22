class A
{
	private  int x;
}
class H extends A
{
	public static void main(String[] args) 
	{
		H h1 =new H();
		System.out.println(h1.x);
	}
}
/*

H.java:10: error: x has private access in A
                System.out.println(h1.x);
                                     ^
1 error


private members of one class cannot be inherited to another class

*/