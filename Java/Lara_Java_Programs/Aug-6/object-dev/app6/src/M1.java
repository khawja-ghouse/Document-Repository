class A
{

}
class  M1
{

	public static void main(String[] args) 
	{
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		Class c1 = a1.getClass();
		Class c2 = a2.getClass();
		Class c3 = a3.getClass();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c1 == c2);
		System.out.println(c2 == c3);
	}
}

//getClass() returns reference of class object
//while A loading to the memory one Class object is created
//when ever String loading into the memory one Class object is created
//for every class one Class object is created
//==> that Class object can be taken by calling getClass() 