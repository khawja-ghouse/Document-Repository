//Double linked list
class Node
{
	int data;
	Node next;
	Node prev;
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
			last.next = new Node(data);
			last.next.prev = last;
			last = last.next;
		}
		//last.next = first;//clock wise
		first.prev = last;//anti -clock wise
	}

	void read()
	{
		Node element = first;
		if (element != null)
		{
			System.out.println(element.data+", ");
		}
		element = element.next;
		while (element != null && element != first)
		{
			System.out.println(element.data+", ");
			element = element.next;
		}
		System.out.println();
	}

	void ReadInReverse()
	{
		Node element = last;
		if (element != null)
		{
			System.out.println(element.data+", ");
		}
		element = element.prev;
		while (element != null && element != last)
		{
			System.out.println(element.data+", ");
			element = element.prev;
		}
		System.out.println();
	}
}


class M16
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.add(21);
		list.add(10);
		list.add(40);
		list.add(35);
		list.add(245);
		list.add(312);
		list.read();
		list.ReadInReverse();
	}
}