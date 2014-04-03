package sortable;

import java.util.Random;
import performance_measure_tools.*;

public class SortableArray {
	public static final int SIZE = 5;
	public static final int RANGE = 10000;
	
	private int[] tab;
	private int[] tabRaw;
	private int size;
	public SortableArray(int[] tab) {
		this.tabRaw = tab;
		this.size = tab.length;
		ArrayRewrite();
	}
	public SortableArray(int size, int mod) {
		GenerateArray(size, mod);
	}
	private void GenerateArray(int size, int mod) {
		this.tabRaw = new int[size];
		this.size = size;
		Random generator = new Random();
		for(int i = 0; i < size ; ++i) {
			tabRaw[i] = generator.nextInt(mod);
		}
		ArrayRewrite();
	}
	public void BubbleSort() {
		ArrayRewrite();
		Timer t = new Timer();
		System.out.println("\nPerforming BubbleSort()");
		t.Start();
		int size = tab.length - 1;
		for(int i = 0; i < tab.length; ++i) {
			for(int j = 0; j < size; ++j) {
				if(this.tab[j] > this.tab[j+1]) {
					int tmp = this.tab[j];
					this.tab[j] = this.tab[j+1];
					this.tab[j+1] = tmp;
				}
			}
			--size;
		}
		t.Stop();
		t.PrintTime("BubbleSort()");		
	}
	public void InsertionSort() {
		ArrayRewrite();
		Timer t = new Timer();
		System.out.println("\nPerforming InsertionSort()");
		t.Start();
		int j, tmp;
		for(int i = 1; i < tab.length; ++i) {
			j = i;
			tmp = tab[i];
			while((j > 0) && (tab[j-1] > tmp)) {
				tab[j] = tab[j-1];
				--j;
			}
			tab[j] = tmp;
		}
		t.Stop();
		t.PrintTime("InsertionSort()");
	}
	public void SelectionSort() {
		ArrayRewrite();
		Timer t = new Timer();
		System.out.println("\nPerforming SelectionSort()");
		t.Start();
		int minIndex, tmp;
		for(int i = 0; i < tab.length; ++i) {
			minIndex = i;
			for(int j = i; j < tab.length; ++j) {
				if(tab[minIndex] > tab[j]) {
					minIndex = j;
				}
			}
			tmp = tab[minIndex];
			tab[minIndex] = tab[i];
			tab[i] = tmp;
		}
		t.Stop();
		t.PrintTime("SelectionSort()");
	}
	public boolean IsSorted() {
		for(int i = 0; i < tab.length-1; ++i) {
			if( tab[i] > tab[i+1]) {
				return false;
			}
		}
		return true; 
	}
	public void PrintArray() {
		for(int i = 0; i < this.tab.length; ++i) {
			System.out.println(this.tab[i]);
		}
	}
	private void ArrayRewrite() {
		this.tab = new int[this.size];
		for(int i = 0; i < this.tabRaw.length; ++i) {
			this.tab[i] = this.tabRaw[i];
		}
	}

}
