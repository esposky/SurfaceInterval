package com.example.otherjavafiles;

import android.media.audiofx.DynamicsProcessing;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class EquipmentList implements Serializable {
    private List<Equipment> equipList;

    public EquipmentList(List<Equipment> equipList) {
        this.equipList = equipList;
    }

    public List<Equipment> getEquipList() {
        return equipList;
    }

    public void setEquipList(List<Equipment> equipList) {
        this.equipList = equipList;
    }

    @Override
    public String toString() {
        return "EquipmentList{" +
                "equipList=" + equipList +
                '}';
    }
}