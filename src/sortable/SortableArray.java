package sortable;

import java.util.Arrays;
import java.util.Random;

import performance_measure_tools.Timer;

public class SortableArray {

	public static final int SIZE = 10;
	public static final int RANGE = 5;
	
	int [] tab;
	int [] tabRaw;
	private int size;
	
	public SortableArray(int size, int mod){
		tabRaw = new int [size];
		Random generator = new Random();
		for(int i= 0; i<size; i++) {
			tabRaw[i]= generator.nextInt(mod);
			this.size = size;
		}
		Rewrite();
	}
	public void PrintArray(){
		for(int i=0; i<tab.length; i++){
			System.out.print(tab[i] + " " );
		}
	}
	private void Rewrite(){
		tab = new int [size];
		for(int i=0;i<size;i++){
			tab[i]=tabRaw[i];
		}
	}
	public void InsertionSort(){
		Rewrite();
		Timer czas = new Timer();
		System.out.println("\nPerforming InsertionSort()");
		czas.Start();
		for(int i=1; i<size; i++){
			int j =i;
			int tmp = tab[j];
			while((j>0)&&(tab[j-1]>tmp)){
				tab[j]= tab[j-1];
				j--;
			
			}
			tab[j]=tmp;
		}
		czas.Stop();
		czas.PrintTime();
	}
	
	public void SelectionSort() {
		Rewrite();
		Timer time = new Timer();
		System.out.println("\nperforming SelectionSort()");
		time.Start();
		for(int i= 0; i<size-1 ;i++){
			int min = i;
		
			for(int j = i+1; j<size; j++){
				if(tab[j]<tab[min]){
				min =j;
				}
			
			}	
			if(min != i){
				int tmp = tab[i];
				tab[i] = tab[min];
				tab[min] = tmp;
				}
		}
		time.Stop();
		time.PrintTime();
	
	}
	public void BubbleSort(){
		Rewrite();
		Timer time = new Timer();
		System.out.println("\nperforming BubbleSort()");
		time.Start();
		for(int i = 0; i<size - 1; i++){
			for(int j = 0; j < size - i - 1; j++)
				if(tab[j]>tab[j+1]){
					int tmp = tab[j];
					tab[j] = tab[j+1];
					tab[j+1]= tmp;
							
				}
		}
		
		time.Stop();
		time.PrintTime();
	}
	
	public void CountSort(){
		Rewrite();
		int [] tabp = new int [SortableArray.RANGE];
		Arrays.fill(tabp,0);
		Timer time = new Timer();
		System.out.println("\nperforming CountSort()");
		time.Start();
		
		
	
		for(int i = 0;i<size;i++){
			tabp[tab[i]]++;
		}
		this.PrintArray(tabp);
		int i = 0;
		for(int j=0; j<tabp.length;j++){
			while(tabp[j]>0){
				tab[i]=j;
				i++;
				tabp[j]--;
			}
				
		}
			
		time.Stop();
		time.PrintTime();
	}
	private void PrintArray(int[] tabp) {
		for(int i = 0 ; i < tabp.length; ++i) {
			System.out.print(tabp[i]+" ");
		}
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

	

	public int[] MergeSort() {
		Rewrite();
		Timer time = new Timer();
		System.out.println("\nperforming MargeSort()");
		time.Start();
		
		if(size>1){
			int q = size/2;
			int [] left = Arrays.copyOfRange(tab, 0, q);
			int [] right = Arrays.copyOfRange(tab, q, size);
			left = MergeSort();
			right =MergeSort();
			tab = merge(left, right);
			
		}
		time.Stop();
		time.PrintTime();
		return tab;
		
	}
	
}

