package dataStr;

/*
 * Tēma: Kaudze
 * Veidojam šo ar masīviem
 */
public class MyHeap<T> {
	
	private T[] elements;
	private final int DEFAULT_ARRAY_SIZE = 10;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	//constructors
	//no-args
	public MyHeap() {
		elements = (T[])new Object[arraySize];
	}
	
	//args
	public MyHeap(int inputArraySize) {
		if(inputArraySize > 0) {
			arraySize = inputArraySize;
		}
		elements = (T[]) new Object[arraySize];
	}
	
	public boolean isEmpty() {
		return (elementCounter == 0);
	}
	
	public boolean isFull() {
		return (elementCounter == arraySize);
	}
	
	public int howManyElements() {
		return elementCounter;
}

	private void increaseArray() {
		int newArraySize = (arraySize > 100) ? (int)(arraySize * 1.5) : arraySize * 2;
		T[] newElements = (T[])new Object[newArraySize];
		for(int i = 0; i < elementCounter; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		arraySize = newArraySize;
	}

	public void add(T newElement) {
		//1.verify if heap is full
		if(isFull()) {
		//1.2.increase size and copy elements	
			increaseArray();
		}
		//2.add new elements
		elements[elementCounter] = newElement;
		//3.increase element counter
		elementCounter++;
		reheapUp(elementCounter - 1);
		
	}
	
	public T remove() throws Exception {
		if(isEmpty()) {
			throw (new Exception("Heap is empty, it is not possible root element"));
		}
		T element = elements[0];
		elements[0] = elements[elementCounter - 1];
		elements[elementCounter] = null;
		elementCounter--;
		reheapDown(0);
		return element;
	}
	
	private void reheapUp(int indexOfElements) {
		
		//rigthChildIndex - parentIndex * 2 + 2;
		//leftChildIndex - parentIndex * 2 + 1;
		
		//(rightChildIndex - 2) / 2 = parentIndex
		//(leftChildIndex - 1) / 2 = parentIndex
		
		//(4 - 2) / 2 = 1	-> (4 - 1) / 2 = 3 / 2 = 1.5 -> (int)1.5 = 1
		//(3 - 1) / 2 = (int)1 -> 1
		
		int indexOfParent = (int)((indexOfElements - 1) / 2);	//чтобы было целое число
		
		if(indexOfElements >= 0) {
			//if(elements[indexOfElements] > elements[indexOfParent]) {
			if(((Comparable)(elements[indexOfElements])).compareTo(elements[indexOfParent]) > 0) {
				swap(indexOfElements, indexOfParent);
				reheapUp(indexOfParent);
			}
		}
	}
	
	private void swap(int index1, int index2) {
		T temp = elements[index1];
		elements[index1] = elements[index2];
		elements[index2] = temp;
	}
	
	private void reheapDown(int indexOfElement) {
		//0.find out both children indexes
		int rightChIndex = indexOfElement * 2 + 2;	//3*2+2 = 8
		int leftChIndex = indexOfElement * 2 + 1;	//3*2+1 = 7
		//1.only left child
		if(leftChIndex < elementCounter && rightChIndex >= elementCounter) {
		//1.1.compare element with left child, if necessary try to swap
			if(((Comparable)(elements[leftChIndex])).compareTo(elements[indexOfElement]) > 0){
				swap(leftChIndex, indexOfElement);
			}
		}
		//2.has two children
		else if(leftChIndex < elementCounter && rightChIndex < elementCounter) {
		//2.1.find out the largest child
			//left child is bigger than right
			if(((Comparable)(elements[leftChIndex])).compareTo(elements[rightChIndex]) > 0){
				if(((Comparable)(elements[leftChIndex])).compareTo(elements[indexOfElement]) > 0){
					swap(leftChIndex, indexOfElement);
					reheapDown(leftChIndex);
				}
			}
		
			//right child is bigger than left child
			else {
				if(	((Comparable)(elements[leftChIndex])).compareTo(elements[indexOfElement]) > 0){
		//2.2.compare element with the largest child, if necessary try to swap
					swap(rightChIndex, indexOfElement);
		//2.3.call this function recursive			
					reheapDown(rightChIndex);
				}
		}
	}
}	
	
	//TODO makeEmpty
	public void makeEmpty() {
		arraySize = DEFAULT_ARRAY_SIZE;
		elementCounter = 0;
		elements = (T[])new Object[arraySize];
		System.gc();	//garbage collector
	}
	
	//TODO print using for loop
	public void print() throws Exception{
		if(isEmpty()) {
			throw (new Exception("Heap is empty ad it is not possible to print elements"));
		}
		else {
			for(int i = 0; i < elementCounter; i++) {
			System.out.print(elements[i] + " ");
	}
			System.out.println();
		}
	}
	
	//TODO print using prefix
	public void printByPrefix() throws Exception {
		if(isEmpty()) {
			throw (new Exception("Heap is empty ad it is not possible to print elements"));
		}
		else {
			printByPrefixHelper(0);
		}
	}
	
	public void printByPrefixHelper(int indexOfElement) {
		int rightChIndex = indexOfElement * 2 + 2;	//3*2+2 = 8
		int leftChIndex = indexOfElement * 2 + 1;	//3*2+1 = 7
		
		// ROOT - LEFT - RIGHT
		
		//ROOT
		System.out.println("-->Parent: " + elements[indexOfElement]);
		
		//LEFT
		if(leftChIndex < elementCounter) {
			System.out.println(" Left child: " + elements[leftChIndex]);
			printByPrefixHelper(leftChIndex);
		}
		
		//RIGHT
		if(rightChIndex < elementCounter) {
			System.out.println(" Right child: " + elements[rightChIndex]);
			printByPrefixHelper(rightChIndex);
	}
		//System.out.println();
}
	//TODO print using postfix
	//TODO print using inorder
}

