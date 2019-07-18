package test;

import java.text.ParseException;
import Elements.Train;

public class TrainTest {
	public static void main(String[] args) throws ParseException{
        Train t1 = new Train("09:20:00","09:30:00");
        Train t2 = new Train("11:00:00","11:30:00");
        Train t3 = new Train("12:10:00","12:30:00");
        Train t4 = new Train("11:20:00","11:40:00");
        Train t5 = new Train("11:25:00","12:15:00");
        Train t6 = new Train("09:30:00","09:45:00");
        Train t7 = new Train("11:20:00","11:55:00");
        Train t8 = new Train("11:55:00","12:10:00");
        
        Train trainArr[] = {t1,t2,t3,t4,t5,t6,t7,t8};
        noOfPlatform(trainArr);
    }
	
	public static int noOfPlatform(Train[] trainArr) {
		int minCount=1;
		System.out.println("No of trains: "+trainArr.length);
		for(int i=0;i<trainArr.length;i++) {
			trainArr[i].print();
			int count = 1;
			for(int j=0;j<trainArr.length; j++) {
				if((trainArr[i].arrival.compareTo(trainArr[j].arrival) > 0 && trainArr[i].arrival.compareTo(trainArr[j].departure)<0)&&(i!=j)) {
					count++;
				}
			}
			if(minCount < count) {
				minCount = count;
			}
		}
		System.out.println("no. of platform: "+minCount);
		return minCount;
	}
}
