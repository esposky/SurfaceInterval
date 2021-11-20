package com.example.otherjavafiles;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class WildLifeList implements Serializable {
    //private WildLife[] wlList;
    private List<WildLife> wildLifeList;

    public WildLifeList(List<WildLife> wildLifeList) {
        this.wildLifeList = wildLifeList;
    }

    public List<WildLife> getWildLifeList() {
        return wildLifeList;
    }

    public void setWildLifeList(List<WildLife> wildLifeList) {
        this.wildLifeList = wildLifeList;
    }

    @Override
    public String toString() {
        return "WildLifeList{" +
                "wildLifeList=" + wildLifeList +
                '}';
    }

//    public WildLifeList(WildLife[] wlList) {
//        setWlList(wlList);
//    }
//
//    public WildLife[] getWlList() {
//        WildLife[] temp = new WildLife[wlList.length];
//        for(int i = 0; i < temp.length; i++)
//            temp[i] = wlList[i];
//        return temp;
//    }
//
//    public void setWlList(WildLife[] wlList) {
//        this.wlList = wlList;
//    }

}
