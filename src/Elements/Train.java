package Elements;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Train {
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    public Date arrival;
    public Date departure;

	public Train(String arrival, String departure) throws ParseException {
        this.arrival = dateFormat.parse(arrival);;
        this.departure = dateFormat.parse(departure);;
    }
    
	public void print() {
		System.out.println("arrival: "+dateFormat.format(arrival)+" departure: "+dateFormat.format(departure));
	}
}
