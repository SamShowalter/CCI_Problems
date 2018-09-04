import java.util.*;

class CCI_Array_Probs
{
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Determine if all array elements are unique

	//Done in place, O(n^2) runtime
	public static boolean isUniqueSlow(int[] arr)
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			for (int j = i+1; j < arr.length; j++)
			{
				if (arr[i] == arr[j])
				{
					return false;
				}
			}
		}
		return true;
	}

	//Done in O(n) runtime with a HashSet
	public static boolean isUniqueFast(int[] arr)
	{
		HashSet<Integer> hash = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++)
		{
			if (hash.contains(arr[i]))
			{
				return false;
			}

			hash.add(arr[i]);
		}

		return true;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Check if one string is a permutation of the other

	//Done with a hashtable, and the helper function below
	private static Hashtable<Character,Integer> stringToHash(String s)
	{
		Hashtable<Character, Integer> hash = new Hashtable<Character,Integer>();
		for (int i = 0; i < s.length(); i ++)
		{
			Character temp = s.charAt(i);
			if (temp.equals(' '))
				continue;
			if (hash.containsKey(temp))
			{
				int currCount = hash.get(temp);
				hash.put(temp, currCount + 1);
			}
			else
			{
				hash.put(temp, 1);
			}
		}

		return hash;
	}

	public static boolean isPermutation(String s, String l)
	{
		if (s.length() != l.length())
			return false;

		//Convert to hashtables
		Hashtable<Character, Integer> hashS = stringToHash(s);
		Hashtable<Character, Integer> hashL = stringToHash(l);

		//System.out.println(hashS.toString());
		//System.out.println(hashL.toString());

		//System.out.println(hashS.equals(hashL));

		for (Character key: hashS.keySet())
		{

			//Counts and type of key must be the same
			if (!hashS.containsKey(key))
			{
				System.out.println("This is the key " + key);
				return false;
			}
				

			else if(hashL.get(key) != hashS.get(key))
			{
				return false;
			}
		}

		return true;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	//URLify

	// public static char[] URLify(String s, int num)
	// {

	// }

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Is the String a permutation of a palindrome

	public static boolean palindromePerm(String s)
	{
		Hashtable<Character, Integer> hash = stringToHash(s);

		int oddCount = 0;

		for (Character c: hash.keySet())
		{
			if (hash.get(c) % 2 != 0)
			{
				oddCount += 1;
			}
		}

		if (s.length() % 2 == 0)
			return oddCount % 2 == 0;
		else 
			return oddCount%2 == 1;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	//One away implementation

	public static boolean oneAway(String s, String l)
	{
		if (Math.abs(s.length() - l.length()) > 1)
		{
			return false;
		}

		Hashtable<Character,Integer> hashS = stringToHash(s);
		Hashtable<Character,Integer> hashL = stringToHash(l);

		int changeCount = 0;

		for (char key: hashS.keySet())
		{
			if (!hashL.containsKey(key))
			{
				changeCount++;
			}
			else
			{
				changeCount += Math.abs(hashS.get(key) - hashL.get(key));
			}

		}
		return changeCount <= 1;


	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// String compression

	public static String stringCompression(String s)
	{
		String compressed = "";

		int count = 0;
		

		while(count < s.length())
		{
			char item = s.charAt(count);
			int letterCount = 0;
			//System.out.println("HI");

			while (s.charAt(count) == item)
			{
				//System.out.println(s.charAt(count));
				
				count++;
				letterCount++;

				//System.out.println(letterCount);

				if (count == s.length())
					break;

			}

			compressed  = compressed + item + letterCount;
		}

		if (compressed.length() >= s.length())
			return s; 
		return compressed;

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Rotate matrix



	////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Zero matrix

	public static void rowToZero(int[][] matrix, int rowNum)
	{
		for (int i = 0; i < matrix[0].length; i++)
			matrix[rowNum][i] = 0;

		//matrixToString(matrix);
	}

	public static void colToZero(int[][] matrix, int colNum)
	{
		for (int i = 0; i < matrix.length; i++)
			matrix[i][colNum] = 0;
		//matrixToString(matrix);
	}

	public static void matrixToString(int[][] arr)
	{
		for (int i = 0; i < arr.length; i ++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
	

	public static void zeroMatrix(int[][] matrix)
	{
		matrixToString(matrix);
		System.out.println();
		HashSet<Integer> rows = new HashSet<Integer>();
		HashSet<Integer> cols = new HashSet<Integer>();

		for (int i = 0; i < matrix.length; i ++)
		{
			if (rows.contains(i))
					continue;
			for (int j = 0; j < matrix[0].length; j ++)
			{
				if (rows.contains(i))
					break;

				if (cols.contains(j))
					continue;

				if (matrix[i][j] == 0)
				{
					rows.add(i);
					cols.add(j);

					rowToZero(matrix, i);
					colToZero(matrix, j);
				}

			}
		}

		matrixToString(matrix);
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args)
	{
		int[][] arr = {{1,2,5,6,7,8,5,3,2,1,0,6,3},
						{1,2,5,6,7,8,5,3,2,1,0,6,3},
						{1,2,0,6,7,8,5,3,2,1,1,6,3},
						{1,2,5,6,7,8,5,3,2,1,3,6,3},
						{1,2,5,6,0,8,5,3,2,1,3,6,3},
						{1,2,5,6,7,8,5,3,2,1,3,6,3},
						{1,2,5,6,7,8,5,3,0,1,3,6,3}};
		zeroMatrix(arr);

		String a = "pale";
		String b = "bake";

		//System.out.println(oneAway(a,b));

		//System.out.println(stringCompression("samsssssssiiiiikkkkkk"));
		//System.out.println(palindromePerm(t));

		//System.out.println(isPermutation(a,s));
		//System.out.println(isUniqueFast(arr));
	}
}