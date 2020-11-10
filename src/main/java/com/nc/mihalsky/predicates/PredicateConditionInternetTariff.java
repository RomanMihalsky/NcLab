package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.contracts.InternetContract;
import com.nc.mihalsky.entities.contracts.enums.InternetTariff;

import java.util.function.Predicate;

public class PredicateConditionInternetTariff {
  private InternetTariff internetTariff;

  public PredicateConditionInternetTariff(InternetTariff internetTariff){
    this.internetTariff = internetTariff;
  }

  public Predicate<Contract> internetTariffPredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      if(contract instanceof InternetContract){
        InternetContract internetContract = (InternetContract)contract;
        return internetContract.getTariff().equals(internetTariff);
      }
      return false;
    }
  };

  public void setInternetTariff(InternetTariff internetTariff) {
    this.internetTariff = internetTariff;
  }
}
