package nauiTables;

public class SingleLog {
	DiveDetails dive;
	DivePartner buddy;
	LocationDetails location;
	EquipmentList equip;
	WildlifeList wildlife;
	
	//Constructor to create log object using broken down class definitions for easier readability, 
	//each object would be created in its own page in app
	SingleLog(LocationDetails loc, DiveDetails dive, DivePartner buddy, EquipmentList equip, WildlifeList wlList){
		setLocation(loc);
		setDive(dive);
		setBuddy(buddy);
		setEquip(equip);
		setWildlife(wlList);
	}

	public DiveDetails getDive() {
		return dive;
	}

	private void setDive(DiveDetails dive) {
		this.dive = dive;
	}

	public DivePartner getBuddy() {
		return buddy;
	}

	private void setBuddy(DivePartner buddy) {
		this.buddy = buddy;
	}

	public LocationDetails getLocation() {
		return location;
	}

	private void setLocation(LocationDetails location) {
		this.location = location;
	}
	
	public EquipmentList getEquip() {
		return equip;
	}

	private void setEquip(EquipmentList equip) {
		this.equip = equip;
	}

	public WildlifeList getWildlife() {
		return wildlife;
	}

	public void setWildlife(WildlifeList wildlife) {
		this.wildlife = wildlife;
	}

	//default toString for testing
	public String toString() {
		return "SingleLog [getDive()=" + getDive() + ", getBuddy()=" + getBuddy() + ", getLocation()=" + getLocation()
				+ ", getEquip()=" + getEquip() + ", getWildlife()=" + getWildlife() + "]";
	}
}
