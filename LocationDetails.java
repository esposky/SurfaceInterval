package nauiTables;
import java.util.*;

public class LocationDetails {
	private String location;
	private GregorianCalendar date;
	private String siteName;

	public LocationDetails(String location, int year, int month, int day, int hour, int minute, String siteName) {
		setLocation(location);
		setSiteName(siteName);
		date = new GregorianCalendar(year, month, day, hour, minute);
	}

	public String getLocation() {
		String temp = location;
		return temp;
	}

	private void setLocation(String location) {
		this.location = location;
	}
	
	//Clean formatting for date values to String output
	public String getDate() {
		String months[] = { "Jan", "Feb", "Mar", 
							"Apr", "May", "Jun", 
							"Jul", "Aug", "Sep", 
							"Oct", "Nov", "Dec"};
		int year = date.get(Calendar.YEAR);
		String month = months[date.get(Calendar.MONTH)-1];
		int day = date.get(Calendar.DAY_OF_MONTH);
		String res = (month + " " + day + ", " + year);
		return res;
	}
	
	//Clean formatting for time values to String output
	public String getTime() {
		int hour = date.get(Calendar.HOUR);
		int minute = date.get(Calendar.MINUTE);
		int ampm = date.get(Calendar.AM_PM);
		String res = (hour==0?12:hour) + ":" + minute + " " + (ampm==0?"AM":"PM");
		return res;
	}

	public String getSiteName() {
		String temp = siteName;
		return temp;
	}

	private void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	//Default toString for testing
	public String toString() {
		return "LocationDetails [location=" + location + ", date=" + getDate() + ", time=" + getTime()
				+ ", siteName=" + siteName + "]";
	}
}
