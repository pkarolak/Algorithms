package sortable;

import java.util.Arrays;
import java.util.Random;

import performance_measure_tools.*;

public class SortableArray {
	public static final int SIZE = 5;
	public static final int RANGE = 100;
	
	private int[] tab;
	private int[] tabRaw;
	private int size;
	private int range;
	private boolean countSortEnable;
	
	public SortableArray(int[] tab) {
		this.tabRaw = tab;
		this.size = tab.length;
		this.countSortEnable = false;
		ArrayRewrite();
	}
	
	public SortableArray(int size, int mod) {
		GenerateArray(size, mod);
		this.countSortEnable = true;
		
	}
	
	private void GenerateArray(int size, int mod) {
		this.tabRaw = new int[size];
		this.size = size;
		this.range = mod - 1; 
		Random generator = new Random();
		for(int i = 0; i < size ; ++i) {
			tabRaw[i] = generator.nextInt(mod);
		}
		ArrayRewrite();
	}
	
	public long BubbleSort() {
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
		return t.Time();
	}
	
	public long InsertionSort() {
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
		return t.Time();
	}
	
	public long SelectionSort() {
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
		return t.Time();
	}
	
	public long CountSort() {
		ArrayRewrite();
		int min = 0;
		int max = this.range;
		if(!this.countSortEnable) {
			min = this.ArrayMin();
			max = this.ArrayMax();
		}
		int counterSize = max - min + 1;
		int [] counter = new int[counterSize];
		Arrays.fill(counter, 0);
		Timer t = new Timer();
		System.out.println("\nPerforming CountSort()");
		t.Start();
		for(int i = 0; i < tab.length; ++i) {
			counter[tab[i] - min]++;
		}
		int j = 0;
		for (int i = 0; i < counter.length; ++i) {
			while(counter[i] > 0) {
				this.tab[j] = i + min;
				++j;
				--counter[i];
			}
	    }
		t.Stop();
		t.PrintTime("CountSort()");
		return t.Time();
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
	
	@SuppressWarnings("unused")
	private void PrintArray(int[] tab) {
		for(int i = 0; i < tab.length; ++i) {
			System.out.println(tab[i]);
		}
	}
	
	private void ArrayRewrite() {
		this.tab = new int[this.size];
		for(int i = 0; i < this.tabRaw.length; ++i) {
			this.tab[i] = this.tabRaw[i];
		}
	}
	
	private int ArrayMax() {
		int max = this.tab[0];
		for(int i = 1 ; i < this.tab.length; ++i) {
			if(this.tab[i] > max) {
				max = this.tab[i];
			}
		}
		return max;
	}
	
	private int ArrayMin() {
		int min = this.tab[0];
		for(int i = 1 ; i < this.tab.length; ++i) {
			if(this.tab[i] < min) {
				min = this.tab[i];
			}
		}
		return min;
	}
}
