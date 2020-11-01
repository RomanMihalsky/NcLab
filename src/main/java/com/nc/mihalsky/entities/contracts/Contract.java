package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.persons.Client;
import org.joda.time.LocalDate;

import java.util.Objects;

public abstract class Contract {
    protected long id;
    protected LocalDate dateStartOfUse;
    protected LocalDate dateEndOfUse;
    protected Client client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateStartOfUse() {
        return dateStartOfUse;
    }

    public void setDateStartOfUse(LocalDate dateStartOfUse) {
        this.dateStartOfUse = dateStartOfUse;
    }

    public LocalDate getDateEndOfUse() {
        return dateEndOfUse;
    }

    public void setDateEndOfUse(LocalDate dateEndOfUse) {
        this.dateEndOfUse = dateEndOfUse;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    abstract public String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id &&
                Objects.equals(dateStartOfUse, contract.dateStartOfUse) &&
                Objects.equals(dateEndOfUse, contract.dateEndOfUse) &&
                Objects.equals(client, contract.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateStartOfUse, dateEndOfUse, client);
    }
}
