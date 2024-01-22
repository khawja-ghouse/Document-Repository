class A < X >
{
	X obj;
}
class M11
{
	public static void main(String[] args) 
	{
		A<Integer> a1 = new A<Integer>();
		A<String> a2 = new A<String>();
		A<Double> a3 = new A<Double>();
		A a4 = new A();
		a1.obj = 40;
		a2.obj = "abc";
		a3.obj = 4.5;
		a4.obj = new Object();
		System.out.println("done");
	}
}
//when ever v are creating an object to A v can specify the type of the data for the obj
//if v dont specify then it coms under Object type 
//here X datatype is generics 