class A < X >
{
	X obj;
}
class M38
{
	public static void main(String[] args) 
	{
		A< ? extends P> a1 = null;	
		a1 = new A<P>();
		a1.obj = new P();//ambiguity bec it can be P or any subclass to P
		System.out.println("done...");
	}
}
