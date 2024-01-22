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

	int leftTo(int data)
	{
		Node element = first;
		Node prev = first;
		Node current;
	
		if (data == element.data)
		{
			throw new ArithmeticException("first element does not exist prev");
		}
		

		while (element != null)
		{
			current = element.ref;
			if (data == current.data )
			{
				return prev.data;
			}
			prev = current;
		}
		return 0;
	}
}


class M12
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.add(21);
		list.add(10);
		list.add(40);
		list.add(35);
		list.read();
		System.out.println(list.leftTo(21));
	}
}