
class ArrList
{
	private int size, maxLength;
	private int[] array;

	public ArrList()
	{
		size = 0;
		maxLength = 10;
		array = new int[maxLength];
	}

	public int size()
	{
		return size;
	}

	public void removeFromFront()
	{
		for (int i = 1; i < size; i++)
		{
			array[i-1] = array[i];
		}
		size--;
	}

	public void remove(int i)
	{
		if (i < 0 || i >= size)
		{
			System.out.println("\nError: index out of bounds of the array. Try again.\n");
			return;
		}

		for (int j = i + 1; j < size; j ++)
		{
			array[j - 1] = array[j];
		}

		size--;
	}

	public void arrayResizeHelper()
	{
		maxLength *= 2;
		int[] placeholderArr = array;
		array = new int [maxLength];

		for (int i = 0 ; i < size; i++)
		{
			array[i] = placeholderArr[i];
		}
	}

	public void insert(int itemToInsert)
	{

		if (size + 1 > maxLength)
		{
			arrayResizeHelper();
		}
		array[size] = itemToInsert;
		size++;
	}



	public void printArray()
	{
		System.out.print("[");
		for (int i = 0; i < size; i++)
		{
			if (i == size - 1)
				System.out.print(array[i]);
			else
				System.out.print(array[i] + ", ");
		}
		System.out.println("]\n");
	}

	public static void main(String[] args)
	{
		ArrList a = new ArrList();
		a.printArray();
		System.out.println(a.size());
		for (int i = 0; i < 50; i++)
		{
			a.insert((int) 5.4* i *10);
		}
		a.printArray();
		a.removeFromFront();
		a.printArray();
		a.remove(3);
		a.printArray();		
		System.out.println(a.size());
		System.out.println("This is a test");
	}
}