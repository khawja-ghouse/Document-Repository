
class A < T >
{
	T obj;
}

class M53
{

	public static void main(String[] args) 
   {
		A<? super Number> a1 = null;
			a1 = new A<Number>();
			a1 = new A<Object>();
			a1.obj = 100;
		System.out.println("done:");
	}

}