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
	void test1()
	{
		System.out.println("test1");
	}
	void test2()
	{
		System.out.println("test2");
	}
}
class M9
{
	public static void main(String[] args) throws Exception
	{
		Class c1 = Class.forName("A");
		Method m1 = c1.getDeclaredMethod("test1");
		Method m2 = c1.getDeclaredMethod("test2");
		Object obj = c1.newInstance(); //new A();
		m1.invoke(obj); //obj.i =20;
		m2.invoke(obj); //obj.i =20;
		
		System.out.println("done");
	}
}
