package com.example.entities;

public enum CategoryForWorker {

    FREE(1),
    BUSY(2),
    DIED(3);

    private final int index;
    CategoryForWorker (int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
