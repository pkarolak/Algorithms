package client;
import sortable.*;

public class AlgorithmClient {
	public static void main(String[] args) {
		SortableArray myArray = new SortableArray(SortableArray.SIZE,SortableArray.RANGE);
		myArray.PrintArray();
<<<<<<< HEAD
		/*myArray.BubbleSort();
		myArray.InsertionSort();
		myArray.SelectionSort();
		myArray.CountSort();*/
		myArray.MergeSort();
=======
		myArray.BubbleSort();
		myArray.InsertionSort();
		myArray.SelectionSort();
		myArray.CountSort();
>>>>>>> dbee1ed85eb7f955e5107c8987908e7e76892195
		myArray.PrintArray();
	}

}
