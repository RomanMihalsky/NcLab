package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import com.nc.mihalsky.entities.persons.Client;
import org.joda.time.LocalDate;

public class InternetContract extends Contract{
  private InternetTariff tariff;

  public InternetContract (){
    this.dateStartOfUse = new LocalDate(1900,1,1);
    this.dateEndOfUse = new LocalDate(1900,1,1);
    this.client = new Client();
    this.tariff = InternetTariff.MEGAS;
  }

  public InternetContract(
          long id,
          LocalDate dateStartOfUse,
          LocalDate dateEndOfUse,
          Client client,
          InternetTariff tariff){
    this.id = id;
    this.dateStartOfUse = dateStartOfUse;
    this.dateEndOfUse = dateEndOfUse;
    this.client = client;
    this.tariff = tariff;
  }

  public InternetTariff getTariff() {
    return tariff;
  }

  public void setTariff(InternetTariff tariff) {
    this.tariff = tariff;
  }

  @Override
  public String toString() {
    return "InternetContract{" +
            "tariff=" + tariff +
            ", id=" + id +
            ", dateStartOfUse=" + dateStartOfUse +
            ", dateEndOfUse=" + dateEndOfUse +
            ", client=" + client.getId() +
            '}';
  }
}
