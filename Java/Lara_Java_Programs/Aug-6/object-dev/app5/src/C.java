class C implements Cloneable 
{
	int i;
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		C obj1 = new C();
		obj1.i = 61;

		C obj2 = (C) obj1.clone();
		System.out.println(obj2.i);
		obj1.i = 617;
		System.out.println(obj2.i);
		System.out.println(obj1.i);

	}
}
//once the cloning is done the obj1 and obj2 are acting as the two independent object