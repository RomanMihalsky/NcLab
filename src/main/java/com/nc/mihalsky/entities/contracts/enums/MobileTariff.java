package com.nc.mihalsky.entities.contracts.enums;

public enum MobileTariff {
    CHEAP(4,15),MEDIUM(20,100),EXPENSIVE(40,200);

    private int gigabytes;
    private int smsAmount;

    private MobileTariff(int gigabytes,int smsAmount){
        this.gigabytes = gigabytes;
        this.smsAmount = smsAmount;
    }

    public int getGigabytes() {
        return gigabytes;
    }

    public int getSmsAmount() {
        return smsAmount;
    }

    @Override
    public String toString() {
        return "MobileTariff{" +
                "gigabytes=" + gigabytes +
                ", smsAmount=" + smsAmount +
                '}';
    }
}
