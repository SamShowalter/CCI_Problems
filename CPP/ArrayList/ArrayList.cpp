//#include <iostream>
#include "C:\Users\sshowalter\Desktop\ExcludeFromBackup\Coding_Practice\CPP\ArrayList\ArrayList.h"
using namespace std;

	
void ArrayList::arrayResizeHelper()
{
	int* arrayPlaceholder = array;

	array = new int[maxLength*2];
	maxLength*=2;

	for (int i = 0; i < size; i++)
	{
		array[i] = arrayPlaceholder[i];
	}

}

int* ArrayList::getArray()
{
	return array;
}

ArrayList::ArrayList()
{
	size = 0;

	//Initialize array to size 10
	maxLength = 10;
	array = new int[10];
}

void ArrayList::removeFromFront()
{
	for (int i =1; i < size; i++)
	{
		array[i-1] = array[i];
	}
	size--;
}

void ArrayList::insert(int itemToInsert)
{
	if ((size + 1) == maxLength)
	{
		//Resize the array
		arrayResizeHelper();
	}
	array[size] = itemToInsert;
	size++;
}

int ArrayList::pop()
{
	int returnVal = array[size-1];
	size--;

	return returnVal;
}

//See what is at the end of the stack without removing
int ArrayList::peek()
{
	return array[size];
}

void ArrayList::push(int newVal)
{
	array[size] = newVal;
	size++;
}

void ArrayList::toString()
{
	//Keep formatting nice
	cout << "[";
	for (int i = 0; i < size; i++)
	{
		if (i < size - 1)
			cout << array[i] << ", ";
		else
			cout << array[i] << "]\n";
	}
}

