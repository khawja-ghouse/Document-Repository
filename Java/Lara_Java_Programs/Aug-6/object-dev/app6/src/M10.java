import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
class A
{
	int i;
	double j;
	A()
	{
		System.out.println("A()");
	}
	A(int i)
	{
		System.out.println("A(int i)");
	}
	void test1(int i)
	{
		System.out.println("test1" + i );
	}
	void test2(double j,String s1)
	{
		System.out.println("test2" + j + ",," + s1);
	}
}
class M10
{
	public static void main(String[] args) throws Exception
	{
		Class c1 = Class.forName("A");
		Method m1 = c1.getDeclaredMethod("test1",int.class);
		Method m2 = c1.getDeclaredMethod("test2",double.class, String.class);
		Object obj = c1.newInstance(); //new A();
		m1.invoke(obj,26); //obj.i =20;
		m2.invoke(obj,6.4,"sabiha"); //obj.i =20;
		
		System.out.println("done");
	}
}
