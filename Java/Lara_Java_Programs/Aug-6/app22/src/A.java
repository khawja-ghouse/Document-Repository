/*class A 
{
	A()
	{
		System.out.println("A()");
	}
	{
		System.out.println("A - IIB!");
	}
	public static void main(String[] args) 
	{
		A a1 = new A();
		System.out.println("..............");
		A a2 = new A();
		System.out.println("..............");
	} 
}
*/
class JBT {

		void methodOne()
		{
			System.out.println("Inside Method ONE");
		}
		void methodTwo()
		{
			System.out.println("Inside Method TWO");
			this.methodOne();// same as calling methodOne()
		}
		public static void main(String[] args) 
		{
			JBT obj = new JBT();
			obj.methodTwo();
		}
}