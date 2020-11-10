package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.contracts.MobileContract;
import com.nc.mihalsky.entities.contracts.enums.MobileTariff;

import java.util.function.Predicate;

public class PredicateConditionMobileTariff {
  private MobileTariff mobileTariff;

  public PredicateConditionMobileTariff(MobileTariff mobileTariff){
    this.mobileTariff = mobileTariff;
  }

  public Predicate<Contract> mobileTariffPredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      if(contract instanceof MobileContract){
        MobileContract mobileContract = (MobileContract)contract;
        return mobileContract.getTariff().equals(mobileTariff);
      }
      return false;
    }
  };

  public void setMobileTariff(MobileTariff mobileTariff) {
    this.mobileTariff = mobileTariff;
  }
}
