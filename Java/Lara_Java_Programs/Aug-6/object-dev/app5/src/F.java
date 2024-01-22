class A
{
	int x;
	A(int x)
	{
		this.x =x;
	}
}
class F implements Cloneable 
{
	int i;
	A a1;
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		F obj1 = new F();
		obj1.i = 61;
		obj1.a1 = new A(17);

		F obj2 = (F) obj1.clone();
		System.out.println(obj2.i);
		System.out.println(obj2.a1.x);
		obj1.i = 16;
		obj2.a1.x = 20;
		System.out.println(obj2.i);
		System.out.println(obj2.a1.x);
	}
}
//if the attribute are atleast one derive type then object class clone operation is
//giving shallocopy cloning

//v can make deepcopy even though its is shallocopy