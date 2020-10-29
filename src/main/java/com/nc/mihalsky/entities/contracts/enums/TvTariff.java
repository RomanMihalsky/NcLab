package com.nc.mihalsky.entities.contracts.enums;

public enum TvTariff {
  SMALL(10),MEDIUM(20),BIG(30);

  private int channelsAmount;

  private  TvTariff(int channelsAmount){
    this.channelsAmount = channelsAmount;
  }

  public int getChannelsAmount() {
    return channelsAmount;
  }

  @Override
  public String toString() {
    return "TvTariff{" +
            "channelsAmount=" + channelsAmount +
            '}';
  }
}
