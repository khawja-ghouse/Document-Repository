class E implements Cloneable 
{
	int i;
	String s1;
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		E obj1 = new E();
		obj1.i = 61;
		obj1.s1 = "six plus one";

		E obj2 = (E) obj1.clone();
		System.out.println(obj2.i);
		System.out.println(obj2.s1);

		obj2.i = 17;
		obj2.s1 = "one plus six";
		System.out.println(obj1.i);
		System.out.println(obj1.s1);
		System.out.println("-------------");
		System.out.println(obj2.i);
		System.out.println(obj2.s1);
	}
}
//changes in the original not reflecting in the duplicate == 
//changes in the duplicate not reflecting in the original this type of cloning is 
//called Deepcopy cloning 
//if attributes are  primitives or immutable then v ill b geting  is Deepcopy 