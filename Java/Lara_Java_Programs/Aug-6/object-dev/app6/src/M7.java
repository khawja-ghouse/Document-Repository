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
class M7
{
	public static void main(String[] args) throws Exception
	{
		Class c1 = Class.forName("A");
		Field field = c1.getDeclaredField("i");
		Object obj = c1.newInstance(); //new A();
		field.setInt(obj,20); //obj.i =20;
		
		System.out.println(field.getInt(obj));
	}
}
