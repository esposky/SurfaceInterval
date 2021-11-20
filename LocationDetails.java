package com.example.otherjavafiles;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.*;

public class LocationDetails implements Serializable {
    private String location;
    private GregorianCalendar date;
    private String siteName;
    private  String dateString;

    public LocationDetails(String location, int year, int month, int day, int hour, int minute, String siteName) {
        setLocation(location);
        setSiteName(siteName);
        setDate(new GregorianCalendar(year, month, day, hour, minute));
    }

    // Only used to return date from database
    public LocationDetails(String location, String dateString, String siteName) {
        this.location = location;
        this.dateString = dateString;
        setDBDate();
        this.siteName = siteName;
    }

    public String getLocation() {
        return location;
    }

    private void setLocation(String location) {
        this.location = location;
    }

    //Clean formatting for date values to String output
    public String getDate() {
        int year;
        String month;
        int day;
        String[] months = { "Jan", "Feb", "Mar",
                "Apr", "May", "Jun",
                "Jul", "Aug", "Sep",
                "Oct", "Nov", "Dec"};
        year = date.get(GregorianCalendar.YEAR);
        month = months[date.get(GregorianCalendar.MONTH)-1];
        day = date.get(GregorianCalendar.DAY_OF_MONTH);
        return (month + " " + day + ", " + year);
    }

    public String saveDBdate(){
        int year = date.get(GregorianCalendar.YEAR);
        int month = date.get(GregorianCalendar.MONTH);
        int day = date.get(GregorianCalendar.DAY_OF_MONTH);
        int hour = date.get(Calendar.HOUR);
        int minute = date.get(Calendar.MINUTE);
        int ampm = date.get(Calendar.AM_PM);
        String res = year + "," + month + "," + day + "," + hour + "," + minute + "," + ampm;
        return res;
    }
    public void setDBDate(){
        String[] dateVals = dateString.split(",");
        date = new GregorianCalendar(Integer.parseInt(dateVals[0]), Integer.parseInt(dateVals[1]),
                                     Integer.parseInt(dateVals[2]), Integer.parseInt(dateVals[3]),
                                     Integer.parseInt(dateVals[4]), Integer.parseInt(dateVals[5]));
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
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
        return siteName;
    }

    private void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    //Default toString for testing
    @NonNull
    public String toString() {
        return "LocationDetails [location=" + location + ", date=" + getDate() + ", time=" + getTime()
                + ", siteName=" + siteName + "]";
    }
}
