package com.example.otherjavafiles;

public class Equipment {
    private String userID;
    private int equipmentID;
    private String type;
    private String make;
    private String model;
    private boolean rental = false;
    private double price = 0;

    //Constructor for owned equipment
    public Equipment(String userID, int equipmentID, String ty, String ma, String mo){
        setUserID(userID);
        setEquipmentID(equipmentID);
        setType(ty);
        setMake(ma);
        setModel(mo);
    }

    //Constructor for rented equipment
    public Equipment(String userID, int equipmentID, String ty, String ma, String mo, boolean rent, double pr){
        setUserID(userID);
        setEquipmentID(equipmentID);
        setType(ty);
        setMake(ma);
        setModel(mo);
        setRental(rent);
        setPrice(pr);
    }

    public String getType() {
        String temp = type;
        return temp;
    }

    private void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        String temp = make;
        return temp;
    }

    private void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        String temp = model;
        return temp;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public boolean isRental() {
        boolean temp = rental;
        return temp;
    }

    private void setRental(boolean rental) {
        this.rental = rental;
    }

    public double getPrice() {
        double temp = price;
        return temp;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String toString() {
        String res =  "Type: " + getType() + ", Make: " + getMake() + ", Model: " + getModel();
        if(isRental())
            res += ", Rental: "+ isRental() +", Price: " + getPrice();
        return res;
    }
}
