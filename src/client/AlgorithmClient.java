package client;
import sortable.*;

public class AlgorithmClient {
	public static void main(String[] args) {
		SortableArray myArray = new SortableArray(SortableArray.SIZE,SortableArray.RANGE);
		myArray.PrintArray();
		myArray.BubbleSort();
		myArray.InsertionSort();
		myArray.SelectionSort();
		myArray.CountSort();
		myArray.PrintArray();
	}

}
