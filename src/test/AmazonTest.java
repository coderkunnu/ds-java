package test;

import java.util.*;

public class AmazonTest {
	public static void main(String[] args) {
		List<String> arrToy = new ArrayList<>(Arrays.asList("ball","bat","gun"));
		List<String> arrQuotes = new ArrayList<>(Arrays.asList("There is ball and a bat","The gun is used to fire","Hit the ball with the bat","gun ball ball gun"));
		int k = 2;
		System.out.println(getKToys(k,arrToy,arrQuotes));
		
	}
	
	private static class ListSort implements Comparator<String> {
		Map<String,Integer> valueMap;
		
		ListSort(Map<String,Integer> valueMap){
			this.valueMap = valueMap;
		}
		
		@Override
		public int compare(String o1, String o2) {
			if(this.valueMap.get(o1) > this.valueMap.get(o2)) {
				return -1;
			}else if(this.valueMap.get(o1) < this.valueMap.get(o2)) {
				return 1;
			}else {
				return 0;
			}
		}
		
	}
	
	private static List<String> getKToys(int k, List<String> toys, List<String> quotes) {
		List<String> result = new ArrayList<>();
		Map<String,Integer> toysCount = new HashMap<>();
		String quoteString = "";
		
		for(String quote: quotes) {
			quoteString = quoteString+" "+quote;
		}
		
		String[] quoteArr = quoteString.split(" ");
		
		for(int i = 0; i < quoteArr.length; i++) {
			if(toysCount.containsKey(quoteArr[i])) {
				toysCount.put(quoteArr[i], toysCount.get(quoteArr[i]) + 1);
			}else {
				toysCount.put(quoteArr[i],1);
			}
		}
		
		ListSort list = new ListSort(toysCount);
		toys.sort(list);
		
		for(int i=0;i<k;i++) {
			result.add(toys.get(i));
		}
		
		return result;
	}
}
