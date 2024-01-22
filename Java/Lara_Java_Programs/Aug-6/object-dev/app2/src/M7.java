class A
{
	int i;
	int j;
	A(int i,int j)
	{
		this.i =i;
		this.j =j;
	}

	public boolean equals(Object obj)  
	{
		return(i == ((A)obj).i && j == ((A)obj).j); 
	}
}
class B 
{
	int m;
	int n;
	A element;// A is memebr of B , attribute of B// it is has relation
	B(int i ,int j,int m,int n)
	{
	   //element = new A(i,j); 
		this.m = m;
		this.n = n;
}
public boolean equals(Object obj) 
	{
		return element.equals(((B)obj).element) && (m == ((B)obj).m && n ==((B)obj).n); 
	}
}

class M7
{

	public static void main(String[] args) 
	{
		A a1 = new A(90,500);
		A a2 = new A(90,500);
		System.out.println(a1.equals(a2));
		B b1 = new B(90,500,30,50);
		B b2 = new B(90,500,30,50);
		b1.element = a1;
		b2.element = a2;// we are initlising from outside
		System.out.println(b1.equals(b2));
	}
}
//instead of using in constructor we are using outside mthod 