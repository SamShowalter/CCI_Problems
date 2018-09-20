import java.util.*;

class CCI_Singly_Linked_List_Probs
{
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 1. Remove duplicates from a singly linked list
	
	//Remove duplicates using a HashSet reference
	public static void removeDups(SinglyLinkedList s)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		Node runner = s.start;

		if (s.start == null)
			return;

		set.add(s.start.data);

		while (runner.next != null)
		{
			if (set.contains(runner.next.data))
			{
				runner.next = runner.next.next;
			}

			else
			{
				set.add(runner.next.data);

				//Only increment when you find a unique element. 
				//Otherwise you might skip something important
				runner = runner.next;
			}
		}
	}

	//Remove duplicates in place O(n^2) runtime though
	public static void removeDupsInPlace(SinglyLinkedList s)
	{
		if (s.start == null || s.start.next == null)
			return;

		Node runner = s.start;
		Node lag = s.start;

		while (lag.next != null)
		{
			while (runner.next != null)
			{
				//System.out.print(lag.data);
				//System.out.println(" " + runner.next.data);
				if (lag.data == runner.next.data)
				{
					//System.out.println("HI");
					runner.next = runner.next.next;
				}

				else
					runner = runner.next;
			}

			lag = lag.next;
			runner = lag;
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 2. Find Kth to last element in a linked list

	//Use a runner and a chaser
	public static int kthToLast(SinglyLinkedList s, int k)
	{
		if (k == 0)
		{
			System.out.println("Error: Invalid k index");
			return -1; //Error case
		}


		Node runner = s.start;
		Node chaser = s.start;

		if (k == 1) // treated as last element
		{
			while (runner.next != null)
				runner = runner.next;
			return runner.data;
		}


		

		while (k > 0)
		{
			if (runner == null)
			{
				System.out.println("Error: Invalid k index");
				return -1; //Another error case
			}
			runner = runner.next;
			k--;
		}

		while (runner != null)
		{
			runner = runner.next;
			chaser = chaser.next;
		}

		return chaser.data;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 3. Remove Node in a linked list by only having access to that node

	//Node will not be first or last
	public static void removeNode(Node n)
	{

		while (n.next != null)
		{
			n.data = n.next.data;
			
			if (n.next.next == null)
			{
				n.next = null;
				return;
			}

			n = n.next;
		}

	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 4. Move all items to right and left of partition

	//Rest of code is in Singly linked list implementation
	public static void moveToEnd(Node beforeEnd, Node last)
	{
		last.next = beforeEnd.next;
		beforeEnd.next = beforeEnd.next.next;
		last.next.next = null;
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 5. Sum two lists based on their linked list values

	public static Node sumLists(Node l1, Node l2, int carry)
	{
		if (l1 == null && l2 == null && carry ==0 )
			return null;

		Node n = new Node();

		int value = carry;

		if (l1 != null)
			value += l1.data;

		if (l2 != null)
			value += l2.data;

		n.data = value % 10;

		if (l1 != null || l2 != null)
		{
			Node more = sumLists(l1 == null ? null: l1.next,
								 l2 == null ? null: l2.next,
								 value/10);

			n.setNext(more);
		}

		return n;
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 6. Palindrome linked list

	public static boolean isEvenLength(SinglyLinkedList lst)
	{
		int count = 0;
		Node runner = lst.start;

		if (lst == null)
			return false;

		while(runner != null)
		{
			runner = runner.next;
			count++;
		}

		return (count % 2 == 0);

	}

	public static Node findMiddle(SinglyLinkedList lst)
	{
		Node runner = lst.start;
		Node skipper = lst.start;

		while (skipper != null && skipper.next != null)
		{
			runner = runner.next;
			skipper = skipper.next.next;
		}

		return runner;
	}

	public static boolean isPalindrome(SinglyLinkedList lst)
	{
		boolean isEven = isEvenLength(lst);
		Node middle = findMiddle(lst);
		Stack<Integer> stack = new Stack<Integer>();
		Node runner = lst.start;

		if (lst == null || lst.start.next == null)
			return true;

		

		while(runner != middle)
		{
			stack.push(runner.data);
			runner = runner.next;
		}

		if (!isEven)
			runner = runner.next;

		while(runner != null)
		{
			if (runner.data == stack.peek())
			{
				stack.pop();
				runner = runner.next;
			}
			else
				return false;

		}

		return true;
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 7. Two singly linked lists have a node that intersect

	public static boolean listIntersect(SinglyLinkedList l1, SinglyLinkedList l2)
	{
		HashSet<Node> set = new HashSet<Node>();
		Node runner = l1.start;

		while(runner != null)
		{
			set.add(runner);
			runner = runner.next;
		}

		runner = l2.start;

		while (runner != null)
		{
			if (set.contains(runner))
				return true;
			runner = runner.next;
		}

		return false;
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 8. Contains a loop in the linked list

	public static Node loopStart(SinglyLinkedList l1)
	{
		HashSet<Node> set = new HashSet<Node>();

		Node runner = l1.start;

		while (runner != null)
		{
			if (set.contains(runner))
				return runner;
			else
			{
				set.add(runner);
				runner = runner.next;
			}
		}

		return null;

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 9.


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 10.


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args)
	{
		Node n = new Node(909);
		SinglyLinkedList list1 = new SinglyLinkedList(4);
		SinglyLinkedList list2 = new SinglyLinkedList(3);
		list1.insertStart(n);
		//list2.insertStart(n);
		list2.insertStart(909);

		

		list1.insertStart(9);
		list1.insertStart(7);
		list1.insertStart(17);
		list2.insertStart(3);
		list1.insertStart(9);
		list1.insertStart(4);
		list2.insertStart(2);
		list1.insertStart(n);
		list2.insertStart(6);

		// list.insertStart(61);
		// list.insertStart(13);
		// list.insertStart(4);
		// list.insertStart(11);
		// list.insertStart(22);
		// list.insertStart(55);
		// list.insertEnd(3);

		// Node ref = list.start; 
		// Node last = list.start;

		// while (last.next != null)
		// 	last = last.next;

		// for (int i = 0; i < 7; i ++)
		// {
		// 	ref = ref.next;
		// }

		// System.out.println(ref.data);


		// System.out.println(list.toString());
		// //removeDupsInPlace(list);
		// System.out.println(list.toString());
		// System.out.println(kthToLast(list,8));
		// System.out.println(ref.data);
		// //removeNode(ref);
		// moveToEnd(ref, last);
		// System.out.println(list.toString());

		//System.out.println(isPalindrome(list1));
		System.out.println(list2.toString());

		//System.out.println(list1.start.data);

		//list1.start = sumLists(list1.start, list2.start, 0);

		System.out.println(loopStart(list1).data);

		//System.out.println(listIntersect(list1,list2));

		
	}
}