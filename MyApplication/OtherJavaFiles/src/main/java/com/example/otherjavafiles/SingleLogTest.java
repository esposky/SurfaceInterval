package com.example.otherjavafiles;

import java.io.Serializable;

public class SingleLogTest implements Serializable {
    DiveDetails dive;
    DivePartner buddy;
    LocationDetails location;
    EquipmentList equipmentList;
    WildLifeList wildLifeList;
    Equipment equipment;
    WildLife wildLife;


    // Using Equipment and Wildlife instead of list versions
    public SingleLogTest(LocationDetails loc, DiveDetails dive, DivePartner buddy, EquipmentList equipmentList, WildLifeList wildLifeList){
        setLocation(loc);
        setDive(dive);
        setBuddy(buddy);
        setEquipmentList(equipmentList);
        setWildLifeList(wildLifeList);
    }

    @Override
    public String toString() {
        return "SingleLogTest{" +
                "dive=" + dive +
                ", buddy=" + buddy +
                ", location=" + location +
                ", equipmentList=" + equipmentList +
                ", wildLifeList=" + wildLifeList +
                '}';
    }

    public DiveDetails getDive() {
        return dive;
    }

    public void setDive(DiveDetails dive) {
        this.dive = dive;
    }

    public DivePartner getBuddy() {
        return buddy;
    }

    public void setBuddy(DivePartner buddy) {
        this.buddy = buddy;
    }

    public LocationDetails getLocation() {
        return location;
    }

    public void setLocation(LocationDetails location) {
        this.location = location;
    }

    public EquipmentList getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(EquipmentList equipmentList) {
        this.equipmentList = equipmentList;
    }

    public WildLifeList getWildLifeList() {
        return wildLifeList;
    }

    public void setWildLifeList(WildLifeList wildLifeList) {
        this.wildLifeList = wildLifeList;
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
}