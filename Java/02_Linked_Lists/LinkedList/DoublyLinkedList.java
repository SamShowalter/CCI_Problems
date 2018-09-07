//Code logic for Node object
class Node
{
	public int data;
	public Node next, prev;

	public Node(int data)
	{
		this.data = data;
		next = null;
		prev = null;
	}
}

class DoublyLinkedList
{
	public Node start;
	public Node end;

	public DoublyLinkedList()
	{
		start = null;
		end = null;
	}

	public DoublyLinkedList(int data)
	{
		start = new Node(data);
		end = start;
	}

	public void insertFront(int data)
	{
		Node item = new Node(data);
		if (start == null)
		{
			start = item;
			end = item;
		}
		else		
		{
			item.next = start;
			start.prev = item;
			start = item;
		}
		
	}

	public void insertEnd(int data)
	{
		Node item = new Node(data);

		if (end == null)
		{
			end = item;
			start = item;
		}
		else
		{
			end.next = item;
			item.prev = end;
			end = end.next;
		}

	}

	public void deleteFront()
	{
		start = start.next;
		start.prev = null;
	}

	public void deleteEnd()
	{
		end = end.prev;
		end.next= null;
	}

	public String toString()
	{
		StringBuilder finalS = new StringBuilder("null <-> ");
		Node runner = start;
		while (runner != null)
		{
			finalS.append(runner.data + " <-> ");
			runner = runner.next;
		}
		finalS.append("null");

		return finalS.toString();


	}

	public static void main(String[] args)
	{
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertFront(25);
		list.insertFront(5);
		list.insertFront(21);
		list.insertFront(27);
		list.insertFront(5);
		list.insertFront(15);
		list.insertEnd(101);
		list.insertEnd(201);

		System.out.println(list.toString());
		list.deleteEnd();
		list.deleteFront();
		System.out.println(list.toString());

	}
}