#include <iostream>
#include "C:\Users\sshowalter\Desktop\ExcludeFromBackup\Coding_Practice\CPP\ArrayList\ArrayList.cpp"
using namespace std;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//CCI Problem #1 -- Determine if an array has unique elements

//Version that requires O(n^2) runtime
bool isUnique(int* arr)
{
	int[] (*arr)  = &arr;
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



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
int main()
{
	ArrayList a = ArrayList();

	for (int i = 0; i < 10; i++)
	{
		a.insert(20*i);
		a.insert(i*11);
	}

	

	a.toString();
	cout << isUnique(a.getArray()) << endl;
	a.removeFromFront();

	a.toString();
	cout << "Hello World" << endl;
	return 0;
}