class A < T >
{
	T obj;

}
class  M60
{
	public static void main(String[] args) 
	{
		A<Integer> a1 = new A<>();//JDK 1.7
		a1.obj = 2000;
		A<?> a2 = new A<>();//JDK 1.7
		A<? extends Number > a3 = new A<>(); //JDK 1.7
		A<? super Number > a4 = new A<>(); //JDK 1.7
		System.out.println("Hello World!");
	}
}
//in jdk 1.7 if the object is empty then the object is by default taken as same as left hand side