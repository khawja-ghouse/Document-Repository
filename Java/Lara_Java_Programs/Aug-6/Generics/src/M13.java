class A < X >
{
	X obj;
	X test()
	{
		return obj;
	}
}
class M13
{
	public static void main(String[] args) 
	{
		A<Integer> a1 = new A<Integer>();
		A<String> a3 = new A<String>();
		A<Double> a2 = new A<Double>();
		Integer obj1 = a1.test();
		Double obj2 = a2.test();
		String obj3 = a3.test();
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println("done");
	}
}