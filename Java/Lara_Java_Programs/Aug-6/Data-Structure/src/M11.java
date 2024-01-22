//Circular linked list
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
			//last.ref = first;
		}
		else
		{
			last.ref = new Node(data);
			 last = last.ref;	 
		}

		last.ref = first;
	}

	void read()
	{
		Node element = first;
		if (element != null)
		{
			System.out.println(element.data+", ");
		}
		element = element.ref;
		while (element != null && (element != first))
		{
			System.out.println(element.data+", ");
				element = element.ref;
		}
		System.out.println();
	}
}


class M11
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.add(21);
		list.add(10);
		list.add(40);
		list.add(35);
		list.read();
	}
}