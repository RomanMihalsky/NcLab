package com.nc.mihalsky.entities.contracts.enums;

public enum InternetTariff {
  MEGAS(75),MEGAM(100),MEGAL(250),MEGAXL(500);

  private int internetSpeed;

  private InternetTariff(int internetSpeed){
    this.internetSpeed = internetSpeed;
  }

  public int getInternetSpeed() {
    return internetSpeed;
  }

  @Override
  public String toString() {
    return "InternetTariff{" +
            "internetSpeed=" + internetSpeed +
            '}';
  }
}
