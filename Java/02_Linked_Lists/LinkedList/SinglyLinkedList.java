import java.util.*;

class Node
{
	public int data;
	public Node next;

	public Node(int data)
	{
		this.data = data;
		next = null;
	}

	public Node()
	{
		this.data = 0;
		next = null;
	}

	public void setNext(Node n)
	{
		this.next = n;
	}
}

class SinglyLinkedList
{
	public Node start;


	public SinglyLinkedList()
	{
		start = null;
	}

	public SinglyLinkedList(Node n)
	{
		start = n;
		start.next = null;
	}

	public SinglyLinkedList(int data)
	{
		start = new Node(data);
		start.next = null;
	}

	public void insertStart(int data)
	{
		Node placeholder = start;
		start = new Node(data);
		start.next = placeholder;
	}

	public void insertFromEnd(int data, int index)
	{
		Node runner = start;
		Node lag = start;

		for (int i = 0 ;  i < index; i ++)
		{
			if (runner == null)
			{
				System.out.println("ERROR: Invalid index");
				return;
			}
			runner = runner.next;
		}

		while (runner != null)
		{
			runner = runner.next;
			lag = lag.next;
		}

		Node placeholder = lag.next;
		lag.next = new Node(data);
		lag.next.next = placeholder;
	}

	public void insertEnd(int data)
	{
		Node runner = start;
		while(runner.next != null)
		{
			runner = runner.next;
		}

		runner.next = new Node(data);

	}

	public void removeStart()
	{
		start = start.next;
	}

	public void removeEnd()
	{
		Node runner = start;
		while (runner.next.next != null)
		{
			runner = runner.next;
		}

		runner.next = null;
	}

	public void moveToEnd(Node beforeEnd, Node last)
	{
		if (beforeEnd.next == last)
			return;

		last.next = beforeEnd.next;
		beforeEnd.next = beforeEnd.next.next;
		last.next.next = null;
	}

	public void moveToStart(Node node)
	{
		Node startHold = start;
		start = node.next;
		node.next = node.next.next;
		start.next = startHold;
	}

	public void partition( int partition)
	{
		Node runner = start;

		while (runner.next != null)
		{
			//System.out.println(runner.next.data);
			if (runner.next.data < partition)
			{
				Node placeholder = runner;
				moveToStart(runner);
				runner = placeholder;
			}
			else
				runner = runner.next;

		}

	}

	// public void insertFromBeg(int data, int index)
	// {
	// 	if (index == 0)
	// 		insertStart(data);
	// 	else
	// 	{

	// 	}
	// 		Node runner = start;
	// 		for (int i = 0; i < index - 1; i++)
	// 		{
	// 			runner = runner.next;
	// 		}

	// 		Node placeholder = 
	// }

	public String toString()
	{
		StringBuilder finalS = new StringBuilder();
		Node runner = start;
		while (runner != null)
		{
			finalS.append(runner.data + " -> ");
			runner = runner.next;
		}
		finalS.append("null");

		return finalS.toString();


	}


	public static void main(String[] args)
	{
		SinglyLinkedList list = new SinglyLinkedList(11);

		list.insertStart(1);
		list.insertStart(9);
		list.insertStart(6);
		list.insertStart(945);
		list.insertStart(95);
		list.insertStart(85);
		list.insertStart(65);
		list.insertStart(55);
		list.insertStart(4001);
		list.insertEnd(2525);


		// Node last = list.start;
		// Node ref = list.start;

		// while (last.next != null)
		// 	last = last.next;

		// for (int i = 0; i < 3; i ++)
		// {
		// 	ref = ref.next;
		// }

		// System.out.println(ref.data);

		// Node st = list.start;

		//System.out.println(list.toString());
		//list.insertFromEnd(301, 9);
		System.out.println(list.toString());
		list.partition(85);
		System.out.println(list.toString());
	}
}