package com.example.otherjavafiles;

import java.io.Serializable;

public class WildLife implements Serializable {
    private String userID;
    private int wildlifeID;
    private String type;
    private String species;

    public WildLife(String userID, int wildlifeID, String ty, String sp){
        setUserID(userID);
        setWildlifeID(wildlifeID);
        setType(ty);
        setSpecies(sp);
    }

    public String getType() {
        String temp = type;
        return temp;
    }

    private void setType(String type) {
        this.type = type;
    }

    public String getSpecies() {
        String temp = species;
        return temp;
    }

    private void setSpecies(String species) {
        this.species = species;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getWildlifeID() {
        return wildlifeID;
    }

    public void setWildlifeID(int wildlifeID) {
        this.wildlifeID = wildlifeID;
    }

    @Override
    public String toString() {
        return "WildLife{" +
                "userID='" + userID + '\'' +
                ", wildlifeID=" + wildlifeID +
                ", type='" + type + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
