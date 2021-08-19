package test;

public class SortTest {
	public static void main(String[] args) {
		int[] arr = {1,5,3,67,45,75,34,21,44,5};
		mergeSort(arr,0,arr.length-1);
//		quickSort(arr, 0, arr.length-1);
//		bubbleSort(arr);
		
		printArr(arr);
	}
	
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int pi = partition(arr, start, end);
			
			quickSort(arr, start, pi-1);
			quickSort(arr, pi+1, end);
		}
	}
	
	public static int partition(int[] arr,int start,int end) {
		int pivot = arr[end];
		int i = start - 1;
		
		for(int j = start; j <= end; j++) {
			if(arr[j] < pivot) {
				i++;
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp;
		
		return(i+1);
	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		if(start<end) {
			int m =(start+end)/2;
			mergeSort(arr,start,m);
			mergeSort(arr,m+1,end);
			merge(arr,m,start,end);
		}
	}
	
	public static void merge(int[] arr,int m,int start,int end){
		int l1 = m-start+1;
		int l2 = end-m;
		
		int[] L = new int[l1];
		int[] R = new int[l2];
		
		for(int i=0; i<l1; i++) {
			L[i] = arr[start+i];
		}
		
		for(int j=0; j<l2; j++) {
			R[j] = arr[m+1+j];
		}
		
		int i = 0;
		int j = 0;
		int count = start;
		while(i < l1 && j < l2) {
			if(L[i] <= R[j]) {
				arr[count]=L[i];
				i++;
			}else {
				arr[count]=R[j];
				j++;
			}
			count++;
		}
		
		while(i < l1) {
			arr[count] = L[i];
			i++;
			count++;
		}
		
		while(j < l2) {
			arr[count] = R[j];
			j++;
			count++;
		}
	}
	
	public static void printArr(int[] arr) {
		String printStr="";
				
		for(int i=0; i<arr.length;i++) {
			if(i==0) {
				printStr=arr[i]+"";
			}else {
				printStr=printStr+","+arr[i];
			}
		}
		System.out.println(printStr);
	}
}
