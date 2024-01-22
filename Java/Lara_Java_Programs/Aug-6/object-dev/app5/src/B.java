class B implements Cloneable 
{
	int i;
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		B obj1 = new B();
		obj1.i = 7;

		B obj2 = (B) obj1.clone();
		System.out.println(obj2.i);
		obj2.i= 61;
		System.out.println(obj2.i);
		System.out.println(obj1.i);
		obj1.i = 8;
		System.out.println(obj2.i);
		System.out.println(obj1.i);
	}
}
/*
F:\Aug-6\object-dev\app5\src>java -cp ../classes B
7
61
7
*/
