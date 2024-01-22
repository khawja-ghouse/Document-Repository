class D implements Cloneable 
{
	int i;
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		D obj1 = new D();
		obj1.i = 61;

		D obj2 = (D) obj1.clone();
		System.out.println(obj2.i);
		obj2.i = 617;
		System.out.println(obj2.i);
		System.out.println(obj1.i);

	}
}
//changes in the original not reflecting in the duplicate == 
//changes in the duplicate not reflecting in the original this type of cloning is 
//called "Deepcopy cloning "