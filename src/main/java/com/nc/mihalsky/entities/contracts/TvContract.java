package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.TvTariff;
import com.nc.mihalsky.entities.persons.Client;
import org.joda.time.LocalDate;

public class TvContract extends Contract{
  private TvTariff tariff;

  public TvContract (){
    this.dateStartOfUse = new LocalDate(1900,1,1);
    this.dateEndOfUse = new LocalDate(1900,1,1);
    this.client = new Client();
    this.tariff = TvTariff.SMALL;
  }

  public TvContract (
          long id,
          LocalDate dateStartOfUse,
          LocalDate dateEndOfUse,
          Client client,
          TvTariff tariff){
    this.id = id;
    this.dateStartOfUse = dateStartOfUse;
    this.dateEndOfUse = dateEndOfUse;
    this.client = client;
    this.tariff = tariff;
  }

  public TvTariff getTariff() {
    return tariff;
  }

  public void setTariff(TvTariff tariff) {
    this.tariff = tariff;
  }

  @Override
  public String toString() {
    return "TvContract{" +
            "tariff=" + tariff +
            ", id=" + id +
            ", dateStartOfUse=" + dateStartOfUse +
            ", dateEndOfUse=" + dateEndOfUse +
            ", client=" + client.getId() +
            '}';
  }
}
