class A
{
}
class  M2
{

	public static void main(String[] args)  throws Exception
	{
		A a1 = new A();
		Class c1 = a1.getClass();
		Class c2 = A.class;
		Class c3 = Class.forName("A");
		System.out.println(c1 == c2);
		System.out.println(c2 == c3);
	}
}
//v can retrive the Class object in three ways 
/*		Class c1 = a1.getClass();
		Class c2 = A.class;
		Class c3 = Class.forName("A");
*/
