package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import com.nc.mihalsky.entities.contracts.enums.MobileTariff;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.factories.FactoryClient;
import org.joda.time.LocalDate;

import java.util.Objects;

public class MobileContract extends Contract{
    private MobileTariff tariff;

    public MobileContract (){
        this.dateStartOfUse = new LocalDate(1900,1,1);
        this.dateEndOfUse = new LocalDate(1900,1,1);
        this.client = FactoryClient.createClient();
        this.tariff = MobileTariff.CHEAP;
    }

    public MobileContract(
            long id,
            LocalDate dateStartOfUse,
            LocalDate dateEndOfUse,
            Client client,
            MobileTariff tariff) {
        this.id = id;

        if(dateStartOfUse != null) {
            this.dateStartOfUse = dateStartOfUse;
        }else {
            this.dateStartOfUse = new LocalDate(1900,1,1);
        }
        if(dateEndOfUse != null) {
            this.dateEndOfUse = dateEndOfUse;
        }else {
            this.dateEndOfUse = new LocalDate(1900,1,1);
        }

        if(client != null) {
            this.client = client;
        }else {
            this.client = FactoryClient.createClient();
        }

        if(tariff != null) {
            this.tariff = tariff;
        }else {
            this.tariff = MobileTariff.CHEAP;
        }
    }

    public MobileTariff getTariff() {
        return tariff;
    }

    public void setTariff(MobileTariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MobileContract that = (MobileContract) o;
        return tariff == that.tariff;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tariff);
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
