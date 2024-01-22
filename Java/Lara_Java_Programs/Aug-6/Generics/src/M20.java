class A < X extends Number >
{
	X obj;
}
class M20
{
	public static void main(String[] args) 
	{
		A< Number > a1 = new A<Number>();
		A< Byte > a2 = new A<Byte>();
		A< Short > a3 = new A<Short>();
		A< Integer > a4 = new A<Integer>();
		A< Long > a5 = new A<Long>();
		A< Float > a6 = new A<Float>();
		A< Double > a7 = new A<Double>();
		System.out.println("Hello World!");
	}
}