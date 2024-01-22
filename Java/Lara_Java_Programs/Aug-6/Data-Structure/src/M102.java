class Node
{
	int data;
	Node ref;

	Node(int data)
	{
		this.data = data;
	}
}

class LinkedList
{
	Node first,last;

	void add(int data)
	{
		if (first == null)
		{
			first = new Node(data);
			last = first;
		}
		else
		{
			last.ref = new Node(data);
			last = last.ref;
		}
	}

	void read()
	{
		Node element = first;
		while (element != null)
		{
			System.out.println(element.data+", ");
			element = element.ref;
		}
	}

	void size()
	{
		int count = 0;
		Node element = first;
		while (element != null)
		{
			count++;
			element = element.ref;
		}
		System.out.println("the size of the DS is::"+count);
	}

	void contains(int data)
	{
		
		Node element = first;
		while (element != null)
		{
			if (data == element.data)
			{
				System.out.println("element exits in DS");
			}
			element = element.ref;
		}
	}
}


class M102
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.add(21);
		list.add(10);
		list.add(40);
		list.add(35);
		list.read();
		list.size();
		list.contains(40);
	}
}