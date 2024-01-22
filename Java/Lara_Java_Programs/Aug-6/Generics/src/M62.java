class A < T >
{
	T obj;

}
class  M62
{
	public static void main(String[] args) 
	{
		A<Integer> a1 = new A<>();
		A a2  =  new A();
		a1 = a2;
		a2 = a1;
		a1.obj = 1000;
		a2.obj = 2000;
		int i = a1.obj;
		//int j = a2.obj;
		int j = (Integer)a2.obj;
		System.out.println("Hello World!");
	}
}