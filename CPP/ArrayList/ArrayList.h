#ifndef ARRAYLIST_H
#define ARRAYLIST_H


class ArrayList
{
private:
	//Variables
	int size, maxLength;
	int* array;

	//Functions
	void arrayResizeHelper();


public:
	ArrayList();
	void toString();
	int length();
	int pop();
	int* getArray();
	int peek();
	void push(int);
	void removeFromFront();
	void insert(int itemToReturn);

};
#endif