class M6
{
	public static void main(String[] args) 
	{
		A a1 = null , a2 = new A(),a3  = null;
		C c1 = new C() , c2 = null, c3  = new  C();
		E e1 = new E(), e2 = new E(),e3 = new E();
		a1 = c1;
		a2 = e3;
		c2 = e1;
		a3 = c3; // a3 = (A) c3
		c3 = e2;
		c1 = e3; //c1 = (C) e3
		System.out.println("done");
	
	}
}
