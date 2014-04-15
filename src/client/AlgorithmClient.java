package client;

import java.util.Arrays;

import sortable.SortableArray;

public class AlgorithmClient {

	public static void main(String[] args) {
		SortableArray tab = new SortableArray(SortableArray.SIZE, SortableArray.RANGE);
		/*tab.PrintArray();
		tab.InsertionSort();*/
		/*tab.PrintArray();
		tab.SelectionSort();
		tab.PrintArray();
		tab.PrintArray();
		tab.BubbleSort();
		tab.PrintArray();
		tab.PrintArray();
		tab.CountSort();
		tab.PrintArray();*/
		
		int [] tablica1 = {1,4,4,5,8};
		int [] tablica2 = {1,2};
		int [] tablica3 = merge(tablica1, tablica2);
		/*for(int i=0;i<tablica3.length;i++){
			System.out.println(tablica3[i]);
		}
		int [] tablica4 = {3232,4,34,234,43,32,1,4,123,9000,77, 654, 67876, 8383, 900, 1,2, 3, 2454};
		tablica4 = MergeSort(tablica4);
		for(int i=0;i<tablica4.length;i++){
			System.out.println(tablica4[i]);
		}*/
		tab.MergeSort();
		tab.PrintArray();
		
	}
	public static int[] merge(int []tab1, int[] tab2) {
		int[] wynik = new int [tab1.length + tab2.length];
		int size = tab1.length + tab2.length;
		int l =0;
		int r = 0;
		int w = 0;
		while(l<tab1.length && r<tab2.length){
			if(tab1[l] <tab2[r]){
				wynik[w] = tab1[l];
				l++;
			}
			else{
				wynik[w] = tab2[r];
				r++;
			}
			w++;
				
				
		}
		if(l==tab1.length){
			for(int i = r;i<tab2.length;i++){
				wynik[w]= tab2[i];
				w++;
			}
			
		}
		else {
			for(int i = l;i<tab1.length;i++){
				wynik[w]= tab1[i];
				w++;
			}
			
		}		
		return wynik;
	}
	public static int[] MergeSort(int[]tab1){
		if(tab1.length>1){
			int q = tab1.length/2;
			int [] left = Arrays.copyOfRange(tab1, 0, q);
			int [] right = Arrays.copyOfRange(tab1, q, tab1.length);
			left = MergeSort(left);
			right = MergeSort(right);
			tab1 = merge(left, right);
			
			
		}
		return tab1;
	}
}
