class A < T >
{
	T obj;

}
class  M61
{
	public static void main(String[] args) 
	{
		A<Integer> a1 = new A<>();
		A a2  =  new A();
		a1 = a2;
		a2 = a1;
		a1.obj = 1000;
		a2.obj = 2000;
		System.out.println("Hello World!");
	}
}
//we can assign non generic for a generic object or viceversa is also possible