class A
{
	int x;
	A(int x)
	{
		this.x =x;
	}
}
class G implements Cloneable 
{
	int i;
	A a1;
	protected Object clone() throws CloneNotSupportedException 
	{
		G obj = (G) super.clone();
		obj.a1 = new A(a1.x);
		return obj;
	}
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		G obj1 = new G();
		obj1.i = 61;
		obj1.a1 = new A(17);

		G obj2 = (G) obj1.clone();
		System.out.println(obj2.i);
		System.out.println(obj2.a1.x);
		obj1.i = 16;
		obj1.a1.x = 20;
		System.out.println(obj2.i);
		System.out.println(obj2.a1.x);

		System.out.println(obj1.i);
		System.out.println(obj1.a1.x);
	}
}