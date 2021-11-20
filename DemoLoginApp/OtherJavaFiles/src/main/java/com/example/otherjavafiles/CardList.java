package com.example.otherjavafiles;

import java.io.Serializable;

public class CardList implements Serializable {
    private CertCard[] list;

    CardList(CertCard[] list){
        setCardList(list);
    }

    private void setCardList(CertCard[] list){
        this.list = list;
    }

    public CertCard[] getCardList() {
        return list;
    }
}
