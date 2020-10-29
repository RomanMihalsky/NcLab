package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.persons.Client;
import org.joda.time.LocalDate;

public class MobileContract extends Contract{
    private MobileTariff tariff;

    public MobileContract (){
        this.dateStartOfUse = new LocalDate(1900,1,1);
        this.dateEndOfUse = new LocalDate(1900,1,1);
        this.client = new Client();
        this.tariff = MobileTariff.CHEAP;
    }

    public MobileContract(
            long id,
            LocalDate dateStartOfUse,
            LocalDate dateEndOfUse,
            Client client,
            MobileTariff tariff) {
        this.id = id;
        this.dateStartOfUse = dateStartOfUse;
        this.dateEndOfUse = dateEndOfUse;
        this.client = client;
        this.tariff = tariff;
    }

    public MobileTariff getTariff() {
        return tariff;
    }

    public void setTariff(MobileTariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public String toString() {
        return "MobileContract{" +
                "tariff=" + tariff +
                ", id=" + id +
                ", dateStartOfUse=" + dateStartOfUse +
                ", dateEndOfUse=" + dateEndOfUse +
                ", client=" + client.getId() +
                '}';
    }
}
