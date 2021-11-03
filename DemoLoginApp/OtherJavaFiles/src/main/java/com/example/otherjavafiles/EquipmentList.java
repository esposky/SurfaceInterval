package com.example.otherjavafiles;

import java.util.Arrays;

public class EquipmentList {
    private Equipment[] equipList;

    public EquipmentList(Equipment[] equipList){
        setEquipList(equipList);
    }

    public Equipment[] getEquipList() {
        Equipment[] temp = new Equipment[equipList.length];
        for(int i = 0; i < temp.length; i++)
            temp[i] = equipList[i];
        return temp;
    }

    public void setEquipList(Equipment[] equipList) {
        this.equipList = equipList;
    }

    public String toString() {
        return "EquipmentList [getEquipList()=" + Arrays.toString(getEquipList()) + "]";
    }

}
