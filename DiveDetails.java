package nauiTables;

import java.util.Arrays;

public class DiveDetails {
	private int duration;
	private int maxDepth;
	private int avgDepth;
	private int temp;
	private int visibility;
	private int pressureStart;
	private int pressureEnd;
	private char pressureGroup;
	private int airType;
	private String[] diveConditions;
	private String[] diveActivities;
	
	//diveConditions and diveActivities would be provided from fixed selection lists that creates a string array to pass in
	//setPressureGroup called automatically to attach pressure group assignment from NauiDiveTables
	DiveDetails(int duration, int maxDepth, int avgDepth, int temp, int visibility, int pressureStart,
			int pressureEnd, String[] diveConditions, String[] diveActivities) {
		setDuration(duration);
		setMaxDepth(maxDepth);
		setAvgDepth(avgDepth);
		setTemp(temp);
		setVisibility(visibility);
		setPressureStart(pressureStart);
		setPressureEnd(pressureEnd);
		setAirType(21);
		setDiveConditions(diveConditions);
		setDiveActivities(diveActivities);
		setPressureGroup();
	}
	
	DiveDetails(int duration, int maxDepth, int avgDepth, int temp, int visibility, int pressureStart,
			int pressureEnd, int airType, String[] diveConditions, String[] diveActivities) {
		setDuration(duration);
		setMaxDepth(maxDepth);
		setAvgDepth(avgDepth);
		setTemp(temp);
		setVisibility(visibility);
		setPressureStart(pressureStart);
		setPressureEnd(pressureEnd);
		setAirType(airType);
		setDiveConditions(diveConditions);
		setDiveActivities(diveActivities);
		setPressureGroup();
	}
	
	public String[] getDiveConditions() {
		String[] temp = new String[diveConditions.length];
		for(int i = 0; i < temp.length; i++)
			temp[i] = diveConditions[i];
		return temp;
	}


	private void setDiveConditions(String[] diveConditions) {
		this.diveConditions = diveConditions;
	}


	public String[] getDiveActivities() {
		String[] temp = new String[diveActivities.length];
		for(int i = 0; i < temp.length; i++)
			temp[i] = diveActivities[i];
		return temp;
	}


	private void setDiveActivities(String[] diveActivities) {
		this.diveActivities = diveActivities;
	}
	
	public int getDuration() {
		int temp = duration;
		return temp;
	}
	
	private void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getMaxDepth() {
		int temp = maxDepth;
		return temp;
	}
	
	private void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}
	
	public int getAvgDepth() {
		int temp = avgDepth;
		return temp;
	}
	
	private void setAvgDepth(int avgDepth) {
		this.avgDepth = avgDepth;
	}
	
	public int getTemp() {
		int tem = temp;
		return tem;
	}
	
	private void setTemp(int temp) {
		this.temp = temp;
	}
	
	public int getVisibility() {
		int temp = visibility;
		return temp;
	}
	
	private void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	
	public int getPressureStart() {
		int temp = pressureStart;
		return temp;
	}
	
	private void setPressureStart(int pressureStart) {
		this.pressureStart = pressureStart;
	}
	
	public int getPressureEnd() {
		int temp = pressureEnd;
		return temp;
	}
	
	private void setPressureEnd(int pressureEnd) {
		this.pressureEnd = pressureEnd;
	}
	
	public int getAirType() {
		int temp = airType;
		return temp;
	}
	
	private void setAirType(int airType) {
		this.airType = airType;
	}
	
	public char getPressureGroup() {
		char temp = pressureGroup;
		return temp;
	}

	private void setPressureGroup() {
		this.pressureGroup = new NauiDiveTable(NauiDiveTable.calcEAD(airType, maxDepth), duration, 0).getPG();
	}

	public String toString() {
		return "DiveDetails [duration=" + duration + ", maxDepth=" + maxDepth + ", avgDepth=" + avgDepth + ", temp="
				+ temp + ", visibility=" + visibility + ", pressureStart=" + pressureStart + ", pressureEnd="
				+ pressureEnd + ", airType=" + airType + ", diveConditions=" + Arrays.toString(diveConditions)
				+ ", diveActivities=" + Arrays.toString(diveActivities) + "]";
	}
	
	
}
