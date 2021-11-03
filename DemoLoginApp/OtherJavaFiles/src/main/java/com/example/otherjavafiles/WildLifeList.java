package com.example.otherjavafiles;

import java.util.Arrays;

public class WildLifeList {
    private WildLife[] wlList;

    public WildLifeList(WildLife[] wlList) {
        setWlList(wlList);
    }

    public WildLife[] getWlList() {
        WildLife[] temp = new WildLife[wlList.length];
        for(int i = 0; i < temp.length; i++)
            temp[i] = wlList[i];
        return temp;
    }

    public void setWlList(WildLife[] wlList) {
        this.wlList = wlList;
    }

    public String toString() {
        return "WildlifeList [getWlList()=" + Arrays.toString(getWlList()) + "]";
    }
}
