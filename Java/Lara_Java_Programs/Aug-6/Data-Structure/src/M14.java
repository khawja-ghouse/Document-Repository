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
	}

	void read()
	{
		Node element = first;
		while (element != null)
		{
			System.out.println(element.data+", ");
			element = element.next;
		}
		System.out.println();
	}
}


class M14
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
	}
}