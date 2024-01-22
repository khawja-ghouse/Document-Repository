import java.util.Scanner;
class A
{
	int data;
	A ref;
	A last;
 	A(int data)
	{
		this.data = data;
	}
	void add(int data)
	{
		if (ref  == null)
		{
			ref = new A(data);
			last = ref;
		}
		else
		{
			last.ref = new A(data);
			last = last.ref;
		}
	}
}

	void read()
	{
		A element = this;
		while (element != null)
		{
			System.out.println(element.data + ", ");
			element = element.ref;

		}
	}
}
class M8
{
	public static void main(String[] args) 
	{
		A a1 = new A(222);
		a1.add(2);
		a1.add(120);
		a1.add(210);
		a1.add(2022);
		a1.add(2011);
		a1.read();
	}
}


