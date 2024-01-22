class S
{
	S()
	{
		//super calling stmt
		//all iib stms
		System.out.println("S()");
	}
	{
		System.out.println("S-IIB");
	}
	S(int i)
	{
		this();
		System.out.println("S(int)");
	}
}
class T extends S
{
	T()
	{
		System.out.println("T()");
	}
	{
		System.out.println("T IIB");
	}
	T(int i)
	{
		this();
		System.out.println("T(int)");
	}
}
class U extends T
{
	U()
	{
		super(90);
		System.out.println("U()");
	}
	{
		System.out.println("U IIB");
	}
	U(int i)
	{
		
		System.out.println("U(int)");
	}
}
class V extends U
{
	{
		System.out.println("V IIB");
	}
	V(int i)
	{
		
		System.out.println("V(int)");
	}
	public static void main(String[] args)
	{
		S s1 = new S();
			System.out.println("...................");	
		S s2 = new S(10);
			System.out.println("...................");
		T t1 = new T(10);
			System.out.println("...................");	
		T t2 = new T();
			System.out.println("...................");
		U u1 = new U(10);
			System.out.println("...................");	
		U u2 = new U();
			System.out.println("...................");
		V V1 = new V(10);
			System.out.println("...................");	
	}
}