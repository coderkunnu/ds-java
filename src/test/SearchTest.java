package test;
import java.lang.Math;
public class SearchTest {

	public static void main(String[] args) {
		int[] arr = {10,15,25,30,45,50,55,65,70,85,90,95};
		System.out.println("Linear Search: "+linearSearch(arr, 70));
		System.out.println("Binary Search: "+binarySearch(arr, 95, 0 ,arr.length-1));
		System.out.println("Jump Search: "+jumpSearch(arr, 15, 0,arr.length - 1, 3));
		System.out.println("Interpolation Search: "+interpolationSearch(arr, 70, 0 ,arr.length-1));
		System.out.println("Exponential Search: "+exponentialSearch(arr, 45, 0 ,arr.length-1));
	}
	
	public static int linearSearch(int[] arr, int value) {
		int index = -1;
		for(int i=0; i < arr.length; i++) {
			if(arr[i] == value) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static int binarySearch(int[] arr, int value, int start, int end) {
		if(start>=end ) {
			if(arr[start]== value) {
				return start;
			}else {
				return -1;
			}
		}
		int midIndex = (start+end-1)/2;
		if (value == arr[midIndex]) {
			return midIndex;
		}else if(value < arr[midIndex]) {
			return binarySearch(arr, value, start, midIndex - 1);
		}else{
			return binarySearch(arr, value, midIndex + 1, end);
		}
	}
	
	public static int jumpSearch(int[] arr, int value, int start, int end, int m) {
		for(int k=0; k < end; k=k+m) {
			if(value >= arr[k] && (value < arr[k+m] || value <= arr[end])) {
				for(int i=k; i< k+m || i <= end; i++) {
					if(arr[i]==value) {
						return i;
					}
				}
			}
		}
		return -1;
	}
	
	public static int interpolationSearch(int[] arr, int value, int start, int end) {
		if(start >= end) {
			if(arr[start] == value) {
				return start;
			}else {
				return  -1;
			}
		}
		
		int pos = start + (value-arr[start])*(end-start) / (arr[end]-arr[start]); 
		if(value == arr[pos]) {
			return pos;
		}else if(value < arr[pos]){
			return interpolationSearch(arr, value, start, pos-1);
		}else {
			return interpolationSearch(arr, value, pos + 1, end);
		}
	}
	
	public static int exponentialSearch(int[] arr, int value, int start, int end) {
		if(arr[start]==value) {return start;}
		int k = 1;
		while (k < end && arr[k] <= value) {
				k = k*2;
		}
		return binarySearch(arr, value, k/2, Math.min(k,end));
	}
}

