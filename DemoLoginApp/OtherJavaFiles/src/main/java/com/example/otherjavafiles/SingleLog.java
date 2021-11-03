package com.example.otherjavafiles;

public class SingleLog {
    DiveDetails dive;
    DivePartner buddy;
    LocationDetails location;
    EquipmentList equip;
    WildLifeList wildlife;
    Equipment equipment;
    WildLife wildLife;

    //Constructor to create log object using broken down class definitions for easier readability,
    //each object would be created in its own page in app
    public SingleLog(LocationDetails loc, DiveDetails dive, DivePartner buddy, EquipmentList equip, WildLifeList wlList){
        setLocation(loc);
        setDive(dive);
        setBuddy(buddy);
        setEquip(equip);
        setWildlife(wlList);
    }
    // Using Equipment and Wildlife instead of list versions
    public SingleLog(LocationDetails loc, DiveDetails dive, DivePartner buddy, Equipment equip, WildLife wildLife){
        setLocation(loc);
        setDive(dive);
        setBuddy(buddy);
        setEquipment(equip);
        setWildLife(wildLife);
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

    public WildLifeList getWildlife() {
        return wildlife;
    }

    public void setWildlife(WildLifeList wildlife) {
        this.wildlife = wildlife;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public WildLife getWildLife() {
        return wildLife;
    }

    public void setWildLife(WildLife wildLife) {
        this.wildLife = wildLife;
    }

    //default toString for testing
    public String toString() {
        return "SingleLog [getDive()=" + getDive() + ", getBuddy()=" + getBuddy() + ", getLocation()=" + getLocation()
                + ", getEquip()=" + getEquip() + ", getWildlife()=" + getWildlife() + "]";
    }
}

